package myfan.domain;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import myfan.data.facade.FacadeDAO;
import myfan.data.models.Genres;
import myfan.data.models.Ubications;
import myfan.data.models.Users;
import myfan.data.models.UsersGenres;
import myfan.data.models.UsersRoles;
import myfan.resources.base.DisableAccountRequest;
import myfan.resources.base.LoginRequest;
import myfan.resources.base.UpdateProfileUserRequest;

public class UserLogic {

  private final String DATE_FORMAT = "yyyy-MM-dd";
  protected final String USER_IDENTIFIER_STATUS = "{\"UserId\": \"%s\", \"status\":\"%s\"}";
  protected final String DISABLE_ACCOUNT_STATUS = "{\"UserId\": \"%s\", \"status\":\"%s\"}";
  protected final String ERROR_USER_FOUND = "{\"Error \": \"User found \"}";
  protected final String ERROR_USER_ROLE_NOT_FOUND = "{\"Error \": \"UserRole not found \"}";
  protected final String ERROR_WRONG_PASSWORD = "{\"Error \": \"Wrong Password \"}";
  protected final String ERROR_USER_NOT_FOUND = "{\"Error \": \"User not found \"}";
  protected final String ROLE_IDENTIFIER_STATUS = "{\"RoleIdentifier\": \"%s\", \"status\":\"%s\"}";
  private final int ADMIN = 10;
  private final int FANATIC = 12;
  private final int BAND = 11;
  private final int DISABLE = 13;
  private Image image;

  protected FacadeDAO facadeDAO;

  /**
   * Contructor de la clase
   */
  public UserLogic() {
    facadeDAO = new FacadeDAO();
    image = new Image();

  }

  /**
   * Verifica que el usuario este registrado y auntentifica la cuenta
   * 
   * @param credentials
   *          Objeto con password y username del usuario
   * @return
   */
  public Response logIn(LoginRequest credentials) {
    String response = ROLE_IDENTIFIER_STATUS;

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
    response = determiningRole(response, userRole);
    response = String.format(response, user.getUsersRoles().getUsersRolesId(), "OK");
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
    response = String.format(response, user.getUserId(), "OK");
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
    return image.saveFile(profilePicture, fileDetail);

  }

  /**
   * Habilita la cuenta del usuario
   * 
   * @param idUser
   *          identificador de la cuenta a habilitar
   * @return
   */
  private UsersRoles enableAccount(int idUser) {
    System.out.println("Soy un puto amo" + idUser);
    if (facadeDAO.findArtistById(idUser) != null) {
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
   * Determina el tipo de Role, con el que se esta iniciando sesion
   * 
   * @param response
   * @param userRole
   * @return
   */
  private String determiningRole(String response, UsersRoles userRole) {
    switch (userRole.getUsersRolesId()) {
    case ADMIN:
      response = String.format(response, userRole.getUsersRolesId(), "OK");
      break;
    case FANATIC:
      response = String.format(response, userRole.getUsersRolesId(), "OK");
      break;
    case BAND:
      response = String.format(response, userRole.getUsersRolesId(), "OK");
      break;
    }
    return response;
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
   * Calcula la fecha actual del sistema
   * 
   * @return un tipo de fecha Date
   */
  protected Date calculateCurrentDate() {
    String currentDate;
    Date date = null;
    Calendar currentDateComputer = Calendar.getInstance();
    DateFormat dateFormatter = new SimpleDateFormat(DATE_FORMAT);
    currentDate = dateFormatter.format(currentDateComputer.getTime());
    try {
      date = dateFormatter.parse(currentDate);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return date;
  }

  /**
   * Determina y convierte a tipo Ubication la ubicacion proveniente en forma de
   * String
   * 
   * @param userUbication
   * @return
   */
  protected Ubications checkUbication(String userUbication) {
    Ubications ubication = facadeDAO.findUbicationsById(userUbication);
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
   *          fecha de cumpleaños
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
    user.setCreationDate(calculateCurrentDate());
    user.setUsername(login);
    user.setBirthday(getDateFromString(birthday));
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
    user.setName(dataUser.getNameUser());
    user.setBirthday(getDateFromString(dataUser.getBirthday()));
    user.setPassword(dataUser.getPassword());
    Ubications ubication = checkUbication(dataUser.getCountryLocation());
    user.setUbications(ubication);
    user.setImage(pathProfilePicture);
    facadeDAO.saveUser(user);
    ArrayList<Genres> genders = checkGenres(dataUser.getMusisicalGenres());
    saveGenres(user, genders);

  }

  protected Date getDateFromString(String date) {
    Date returnDate = null;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
    try {
      returnDate = simpleDateFormat.parse(date);
    } catch (ParseException ex) {
      ex.printStackTrace();
    }
    return returnDate;
  }

}
