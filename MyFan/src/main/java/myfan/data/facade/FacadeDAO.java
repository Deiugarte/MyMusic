package myfan.data.facade;

import java.util.List;

import myfan.data.dao.ArtistsDao;
import myfan.data.dao.FanaticsDao;
import myfan.data.dao.GenresDao;
import myfan.data.dao.MembersDao;
import myfan.data.dao.UbicationsDao;
import myfan.data.dao.UsersDao;
import myfan.data.dao.UsersGenresDao;
import myfan.data.dao.UsersRolesDao;
import myfan.data.models.Artists;
import myfan.data.models.Fanatics;
import myfan.data.models.Genres;
import myfan.data.models.Members;
import myfan.data.models.Ubications;
import myfan.data.models.Users;
import myfan.data.models.UsersGenres;
import myfan.data.models.UsersRoles;

public class FacadeDAO {
  private final String FANATIC_ROLE_NAME = "Fanatic";
  private final String ARTIST_ROLE_NAME = "Band";
  private final String ADMINISTRATOR_ROLE_NAME = "System administrator";
  private final String DISABLE_ROLE_NAME = "Disable";
  private UsersDao usersDao;
  private UbicationsDao ubicationsDao;
  private GenresDao gendersDao;
  private FanaticsDao fanaticsDao;
  private UsersRolesDao usersRolesDao;
  private UsersGenresDao usersGenresDao;
  private ArtistsDao artistsDao;
  private MembersDao memberDao;

  public FacadeDAO() {
    usersDao = new UsersDao();
    ubicationsDao = new UbicationsDao();
    gendersDao = new GenresDao();
    fanaticsDao = new FanaticsDao();
    usersRolesDao = new UsersRolesDao();
    usersGenresDao = new UsersGenresDao();
    artistsDao    =new ArtistsDao();
    memberDao= new MembersDao();
  }

  public Users findUserByLogin(String username) {
    return usersDao.findByusername(username);
  }

  public Ubications findUbicationsById(String ubicationName) {
    return ubicationsDao.findByName(ubicationName);

  }

  public Genres findGenderByName(String genderName) {
    return gendersDao.findByName(genderName);
  }
  
 
  public List<Ubications> findAllUbications() {
    return ubicationsDao.findAll();
  }

  public void saveFanatic(Fanatics fanatic) {
    fanaticsDao.save(fanatic);
  }

  public void saveArtist(Artists artist) {
	    artistsDao.save(artist);
	  }

  public void saveUser(Users user) {
    usersDao.save(user);
  }

  public UsersRoles getFanaticRole() {
    return usersRolesDao.findByRoleName(FANATIC_ROLE_NAME);
  }
  
  public UsersRoles getArtistRole() {
	    return usersRolesDao.findByRoleName(ARTIST_ROLE_NAME);
	  }

  public void saveUsersGenres(UsersGenres usersGenres) {
    usersGenresDao.save(usersGenres);
    
  }
  
  public void saveMembersArtist(Members member){
	  memberDao.save(member);  
  }

}
