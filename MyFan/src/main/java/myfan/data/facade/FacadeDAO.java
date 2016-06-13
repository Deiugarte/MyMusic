package myfan.data.facade;

import java.util.List;

import myfan.data.dao.FanaticsDao;
import myfan.data.dao.FanaticsGenresDao;
import myfan.data.dao.GenresDao;
import myfan.data.dao.UbicationsDao;
import myfan.data.dao.UsersDao;
import myfan.data.dao.UsersRolesDao;
import myfan.data.models.Fanatics;
import myfan.data.models.FanaticsGenres;
import myfan.data.models.Genres;
import myfan.data.models.Ubications;
import myfan.data.models.Users;
import myfan.data.models.UsersRoles;

public class FacadeDAO {
	private  final String FANATIC_ROLE_NAME = "Fanatic";
	private UsersDao usersDao;
	private UbicationsDao ubicationsDao;
	private  GenresDao gendersDao;
	private FanaticsGenresDao fanaticsGenresDao;
	private FanaticsDao fanaticsDao;
	private UsersRolesDao usersRolesDao;

	public FacadeDAO() {
		usersDao=new UsersDao();
		ubicationsDao=new UbicationsDao();
		gendersDao= new GenresDao();
		fanaticsGenresDao = new FanaticsGenresDao();
		fanaticsDao=new FanaticsDao();
		usersRolesDao= new UsersRolesDao();
	}
	
	public Users findUserByLogin (String username) {
		return usersDao.findByusername(username);
	}

	public Ubications findUbicationsById(String ubicationName){
		return ubicationsDao.findByName(ubicationName);
		
	}
	
	public Genres findGenderByName(String genderName){
		 return gendersDao.findByName(genderName);
	}
	
	public List<Ubications> findAllUbications() {
		return ubicationsDao.findAll();
	}
	
	public void saveFanaticGenre(FanaticsGenres fanaticsGenres){
		fanaticsGenresDao.save(fanaticsGenres);
	}
	
	public void saveFanatic(Fanatics fanatic) {
		fanaticsDao.save(fanatic);	
	}
	
	public void saveUser(Users user) {
		usersDao.save(user);	
	}

	public UsersRoles getFanaticRole() {
		
		return usersRolesDao.findByRoleName(FANATIC_ROLE_NAME);
	}
	
}
