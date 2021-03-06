package myfan.domain.gestion;

import java.io.InputStream;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import myfan.controller.request.DisableAccountRequest;
import myfan.controller.request.LoginRequest;
import myfan.controller.request.UpdateProfileUserRequest;
import myfan.controller.response.FanProfileResponse;
import myfan.controller.response.GenresResponse;
import myfan.controller.response.json.JSONFabrication;
import myfan.data.facade.FacadeDAO;
import myfan.data.models.Genres;
import myfan.data.models.Ubications;
import myfan.data.models.Users;
import myfan.data.models.UsersGenres;
import myfan.data.models.UsersRoles;
import myfan.domain.gestion.utils.DateFabrication;
import myfan.domain.gestion.utils.ImageFabrication;

public class UserLogic {

  protected final String USER_IDENTIFIER_STATUS = "{\"UserId\": \"%s\",\"RoleId\": \"%s\", \"status\":\"%s\"}";
  protected final String DISABLE_ACCOUNT_STATUS = "{\"UserId\": \"%s\", \"status\":\"%s\"}";
  protected final String ERROR_USER_FOUND = "{\"Error \": \"User found \"}";
  protected final String ERROR_USER_ROLE_NOT_FOUND = "{\"Error \": \"UserRole not found \"}";
  protected final String ERROR_WRONG_PASSWORD = "{\"Error \": \"Wrong Password \"}";
  protected final String ERROR_USER_NOT_FOUND = "{\"Error \": \"User not found \"}";
  protected final String LOGIN_STATUS = "{\"UserId\": \"%s\",\"RoleIdentifier\": \"%s\", \"status\":\"%s\"}";
  private final int DISABLE = 13;
  private ImageFabrication imageFabrication;
  protected JSONFabrication jSONFabrication;
  protected DateFabrication date;

  protected FacadeDAO facadeDAO;

  /**
   * Contructor de la clase
   */
  public UserLogic() {
    facadeDAO = new FacadeDAO();
    jSONFabrication = new JSONFabrication();
    imageFabrication = new ImageFabrication();
    date = new DateFabrication();

  }

  /**
   * Verifica que el usuario este registrado y auntentifica la cuenta
   * 
   * @param credentials
   *          Objeto con password y username del usuario
   * @return
   */
  public Response logIn(LoginRequest credentials) {
    String response = LOGIN_STATUS;

    Users user = facadeDAO.findUserByLogin(credentials.getLogin());

    if (!existUser(user)) {
      return responseBuilder(ERROR_USER_NOT_FOUND);
    }

    if (!isValidPassword(credentials.getPassword(), user)) {
      return responseBuilder(ERROR_WRONG_PASSWORD);
    }

    UsersRoles userRole = user.getUsersRoles();
    if (userRole.getUsersRolesId() == DISABLE) {
      user.setUsersRoles(enableAccount(user.getUserId()));
      facadeDAO.saveUser(user);
    }

    if (!existRole(userRole)) {
      return responseBuilder(ERROR_USER_ROLE_NOT_FOUND);
    }
    response = String.format(response,user.getUserId(), user.getUsersRoles().getRoleName(), "OK");
    return Response.status(Status.OK).entity(response).build();

  }

  /**
   * Desabilita la cuenta del Usuario
   * 
   * @param userProfile
   *          objeto con el userName del usuario, de la cuetna desactivar
   * @return
   */
  public Response disableAccount(DisableAccountRequest userProfile) {
    String response = DISABLE_ACCOUNT_STATUS;
    Users user = facadeDAO.findUserByLogin(userProfile.getLogin());
    if (!existUser(user)) {
      return responseBuilder(ERROR_USER_NOT_FOUND);
    }
    user.setUsersRoles(facadeDAO.getDisableRole());
    facadeDAO.saveUser(user);
    response = String.format(response, user.getUserId(), user.getUsersRoles().getUsersRolesId(), "OK");
    return Response.status(Status.OK).entity(response).build();
  }

  /**
   * Convierte y guarda de un InputStream a un tipo de imagen png o jpg en la
   * carpeta del sistema
   * 
   * @param profilePicture
   *          Imagen del usuario
   * @param fileDetail
   *          Extension de la imagen
   * @return
   */
  public String saveProfilePictureFile(InputStream profilePicture, FormDataContentDisposition fileDetail) {
    return imageFabrication.saveFile(profilePicture, fileDetail);

  }

  /**
   * Obtiene la informacion personal del usuario
   * 
   * @param idUser
   * @return
   */
  protected String getPersonalInformationOfUser(int idUser) {
    FanProfileResponse userProfileResponse = new FanProfileResponse();
    Users user = facadeDAO.findUserById(idUser);
    userProfileResponse.setAgeUser(calculadeAge(user.getBirthday()));
    Ubications ubications = user.getUbications();
    ubications = facadeDAO.findUbicationsById(ubications.getUbicationId());
    userProfileResponse.setCountryLocation(ubications.getName());
    userProfileResponse.setLoginUser(user.getUsername());
    userProfileResponse.setNameUser(user.getName());
    userProfileResponse.setMusicalGenres(getGenresByUser(idUser));
    userProfileResponse.setImageProfile(user.getImage());
    userProfileResponse.setIdentificationNumber(idUser);
    return jSONFabrication.jsonConverter(userProfileResponse);
  }

  protected ArrayList<GenresResponse> getGenresByUser(int idUser) {
    List<UsersGenres> usersGenresList = facadeDAO.findGenresByUsersId(idUser);
    ArrayList<GenresResponse> genresResponse = new ArrayList<GenresResponse>();
    for (int i = 0; i < usersGenresList.size(); i++) {
      GenresResponse genre = new GenresResponse();
      genre.setName(usersGenresList.get(i).getGenres().getName());
      genresResponse.add(genre);
    }
    return genresResponse;
  }

  /**
   * Calcula la edad del usuario
   * 
   * @param birthday
   * @return
   */
  protected String calculadeAge(Date birthday) {
    SimpleDateFormat formatNowYear = new SimpleDateFormat("yyyy");
    String birthdayYear = formatNowYear.format(birthday);
    String currentYear = formatNowYear.format(date.getCurrentDate());
    Integer age = Integer.parseInt(currentYear) - Integer.parseInt(birthdayYear);
    return age.toString();
  }

  /**
   * Habilita la cuenta del usuario
   * 
   * @param idUser
   *          identificador de la cuenta a habilitar
   * @return
   */
  private UsersRoles enableAccount(int idUser) {
    if (facadeDAO.findArtistByUserId(idUser) != null) {
      return facadeDAO.getArtistRole();
    } else {
      return facadeDAO.getFanaticRole();
    }
  }

  /**
   * Verifica que existe un role determinado
   * 
   * @param userRole
   *          tipo de role a verificar
   * @return
   */
  private boolean existRole(UsersRoles userRole) {
    return userRole != null;
  }

  /**
   * Verifica la clave del usuario de acuerdo al username
   * 
   * @param password
   *          contraseña del usuario
   * @param user
   *          username del usuario
   * @return
   */
  private boolean isValidPassword(String password, Users user) {
    return user.getPassword().equals(password);
  }

 

  /**
   * Determina el tipo de Response
   * 
   * @param response
   * @return
   */
  protected Response responseBuilder(String response) {
    return Response.status(Status.UNAUTHORIZED).entity(response).build();
  }

  /**
   * Determina si existe el usuario
   * 
   * @param user
   *          usuario
   * @return
   */
  protected boolean existUser(Users user) {
    return user != null;
  }

  /**
   * Determina y convierte a tipo Ubication la ubicacion proveniente en forma de
   * String
   * 
   * @param userUbication
   * @return
   */
  protected Ubications checkUbication(String userUbication) {
    Ubications ubication = facadeDAO.findUbicationsByName(userUbication);
    return ubication;
  }

  /**
   * Determina y convierte a tipo Genre los generos musicales proveniente en
   * forma de String
   * 
   * @param genresList
   * @return
   */
  protected ArrayList<Genres> checkGenres(ArrayList<String> genresList) {
    if (genresList != null) {
      ArrayList<Genres> genders = new ArrayList<>();
      for (int i = 0; i < genresList.size(); i++) {
        genders.add(facadeDAO.findGenderByName(genresList.get(i)));
      }
      return genders;
    } else {
      return null;
    }
  }

  /**
   * Crea un nuevo Usuario
   * 
   * @param pathProfilePicture
   *          foto de perfil
   * @param ubication
   *          pais de procedencia
   * @param usersRoles
   *          role efectuado
   * @param nameUser
   *          nombre del usario
   * @param password
   *          contraseña del usuario
   * @param login
   *          username del usuario
   * @param birthday
   *          date de cumpleaños
   */
  protected void createUser(String pathProfilePicture, Ubications ubication, UsersRoles usersRoles, String nameUser,
      String password, String login, String birthday) {
    Users user;
    user = new Users();
    user.setUsersRoles(usersRoles);
    user.setName(nameUser);
    user.setUbications(ubication);
    user.setPassword(password);
    user.setImage(pathProfilePicture);
    user.setCreationDate(date.getCurrentDate());
    user.setUsername(login);
    user.setBirthday(date.getDateFromString(birthday));
    facadeDAO.saveUser(user);
  }

  /**
   * Relacion los generos musicales con cada usuario
   * 
   * @param user
   * @param gendersList
   */
  protected void saveGenres(Users user, ArrayList<Genres> gendersList) {
    UsersGenres usersGenres = new UsersGenres();
    usersGenres.setUsers(user);
    if (gendersList != null) {
      for (int i = 0; i < gendersList.size(); i++) {
        usersGenres.setGenres(gendersList.get(i));
        facadeDAO.saveUsersGenres(usersGenres);
      }
    } else {
      facadeDAO.saveUsersGenres(null);

    }
  }

  /**
   * Actualiza los datos del perfil de un usuario
   */
  protected void updateUser(UpdateProfileUserRequest dataUser, String pathProfilePicture) {
    Users user = facadeDAO.findUserById(dataUser.getIdentificationNumber());
    if(dataUser.getNameUser()!=""){
      user.setName(dataUser.getNameUser()); 
    }
    if(dataUser.getBirthday()!=""){
      user.setBirthday(date.getDateFromString(dataUser.getBirthday()));
    }
    if(dataUser.getPassword()!=""){
      user.setPassword(dataUser.getPassword());
    }
    if(dataUser.getCountryLocation()!=""){
      Ubications ubication = checkUbication(dataUser.getCountryLocation());
      user.setUbications(ubication);
    }
    if(pathProfilePicture!=null){
      System.out.println(pathProfilePicture);
      user.setImage(pathProfilePicture);
    }    
    facadeDAO.saveUser(user);
    if(dataUser.getMusisicalGenres()!=null){
    ArrayList<Genres> genders = checkGenres(dataUser.getMusisicalGenres());
    saveGenres(user, genders);
    }
  }

}
