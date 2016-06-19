package myfan.data.facade;

import java.util.List;

import myfan.data.dao.ArtistsCalificationsDao;
import myfan.data.dao.ArtistsDao;
import myfan.data.dao.DiscsDao;
import myfan.data.dao.EventsCalificationsDao;
import myfan.data.dao.EventsDao;
import myfan.data.dao.FanaticsArtistsDao;
import myfan.data.dao.FanaticsDao;
import myfan.data.dao.GenresDao;
import myfan.data.dao.MembersDao;
import myfan.data.dao.NewsDao;
import myfan.data.dao.SongsDao;
import myfan.data.dao.UbicationsDao;
import myfan.data.dao.UsersDao;
import myfan.data.dao.UsersGenresDao;
import myfan.data.dao.UsersRolesDao;

import myfan.data.models.Artists;
import myfan.data.models.ArtistsCalifications;
import myfan.data.models.Discs;
import myfan.data.models.Events;
import myfan.data.models.EventsCalifications;
import myfan.data.models.Fanatics;
import myfan.data.models.FanaticsArtists;
import myfan.data.models.Genres;
import myfan.data.models.Members;
import myfan.data.models.News;
import myfan.data.models.Songs;
import myfan.data.models.Ubications;
import myfan.data.models.Users;
import myfan.data.models.UsersGenres;
import myfan.data.models.UsersRoles;

public class FacadeDAO {

	private final String FANATIC_ROLE_NAME = "fanatic";
	private final String ARTIST_ROLE_NAME = "artist";
	private final String DISABLE_ROLE_NAME = "disable";
	private UsersDao usersDao;
	private UbicationsDao ubicationsDao;
	private GenresDao genresDao;
	private FanaticsDao fanaticsDao;
	private UsersRolesDao usersRolesDao;
	private UsersGenresDao usersGenresDao;
	private ArtistsDao artistsDao;
	private MembersDao memberDao;
	private NewsDao newsDao;
	private FanaticsArtistsDao fanaticsArtistsDao;
	private EventsDao eventsDao;
	private EventsCalificationsDao eventsCalificationsDao;
	private DiscsDao discsDao;
	private SongsDao songsDao;
	private ArtistsCalificationsDao artistsCalificationsDao;

	public FacadeDAO() {
		usersDao = new UsersDao();
		ubicationsDao = new UbicationsDao();
		genresDao = new GenresDao();
		fanaticsDao = new FanaticsDao();
		usersRolesDao = new UsersRolesDao();
		usersGenresDao = new UsersGenresDao();
		artistsDao = new ArtistsDao();
		memberDao = new MembersDao();
		newsDao = new NewsDao();
		fanaticsArtistsDao = new FanaticsArtistsDao();
		eventsDao = new EventsDao();
		eventsCalificationsDao = new EventsCalificationsDao();
		discsDao = new DiscsDao();
		songsDao = new SongsDao();
		artistsCalificationsDao = new ArtistsCalificationsDao();
	}

	/*-----------------------------------------FIND-------------------------------------*/
	/*-----------------------------------------FIND-------------------------------------*/

	public Users findUserByLogin(String userName) {
		return usersDao.findByusername(userName);
	}

	public Users findUserById(int idUserName) {
		return usersDao.getUsersById(idUserName);
	}

	public News findNewsById(int idNews) {
		return newsDao.getNewsById(idNews);
	}

	public Discs findDiscById(int idDisc) {
		return discsDao.getDiscsById(idDisc);
	}

	public Ubications findUbicationsById(int ubicationName) {
		return ubicationsDao.getUbicationsById(ubicationName);

	}

	public Genres findGenderByName(String genderName) {
		return genresDao.findByName(genderName);
	}

	public Genres findGenderById(int idGenero) {
		return genresDao.getGenresById(idGenero);
	}

	public UsersGenres findGenresByUserGenressId(int idUserGenre) {
		return usersGenresDao.findGenresByUserGenressId(idUserGenre);
	}

	public List<UsersGenres> findGenresByUsersId(int idUser) {
		return usersGenresDao.findGenresByUsersId(idUser);
	}

	public List<FanaticsArtists> findArtistsByFanaticId(int fanaticId) {
		return fanaticsArtistsDao.findArtistsByFanaticId(fanaticId);
	}

	public List<Ubications> findAllUbications() {
		return ubicationsDao.findAll();
	}

	public Artists findArtistByUserId(int idUser) {
		return artistsDao.getArtistsByUserId(idUser);
	}

	public Fanatics findFanaticByUserId(int idUser) {
		return fanaticsDao.getFanaticsByUserId(idUser);
	}

	public Fanatics findFanaticById(int idFanatic) {
		return fanaticsDao.getFanaticsById(idFanatic);
	}

	public Artists findArtistById(int idArtist) {
		return artistsDao.getArtistsById(idArtist);
	}

	public List<Genres> findAllGenres() {
		return genresDao.findAll();
	}

	public Ubications findUbicationsByName(String nameUbication) {
		return ubicationsDao.findByName(nameUbication);
	}

	/*-----------------------------------------GET-------------------------------------*/
	/*-----------------------------------------GET-------------------------------------*/

	public UsersRoles getFanaticRole() {
		return usersRolesDao.findByRoleName(FANATIC_ROLE_NAME);
	}

	public UsersRoles getArtistRole() {
		return usersRolesDao.findByRoleName(ARTIST_ROLE_NAME);
	}

	public UsersRoles getDisableRole() {
		return usersRolesDao.findByRoleName(DISABLE_ROLE_NAME);
	}

	public List<News> getNewsByArtistId(int artistId, int offset) {
		return newsDao.getNewsByArtistId(artistId, offset);
	}

	public List<Events> getEventsByArtistId(int artistId, int offset) {
		return eventsDao.getEventsByArtistId(artistId, offset);
	}

	public List<News> getNewsByArtistList(List<FanaticsArtists> fanaticsArtistsList, int offset) {
		return newsDao.getNewsByArtistsList(fanaticsArtistsList, offset);
	}

	public List<Events> getEventsByArtistList(List<FanaticsArtists> fanaticsArtistsList, int offset) {
		return eventsDao.getEventsByArtistsList(fanaticsArtistsList, offset);
	}

	public List<EventsCalifications> getCalificationByConcert(int idEvent) {
		return eventsCalificationsDao.getCalificationByConcert(idEvent);

	}

	/*-----------------------------------------SAVE-------------------------------------*/
	/*-----------------------------------------SAVE-------------------------------------*/

	public void saveUsersGenres(UsersGenres usersGenres) {
		usersGenresDao.save(usersGenres);

	}

	public void saveMembersArtist(Members member) {
		memberDao.save(member);
	}

	public void saveUser(Users user) {
		usersDao.save(user);
	}

	public void saveArtist(Artists artist) {
		artistsDao.save(artist);
	}

	public void saveFanatic(Fanatics fanatic) {
		fanaticsDao.save(fanatic);
	}

	public void saveGenre(Genres genre) {
		genresDao.save(genre);
	}

	public void saveNews(News news) {
		newsDao.save(news);
	}

	public void saveEvent(Events event) {
		eventsDao.save(event);
	}

	public void saveDisc(Discs disc) {
		discsDao.save(disc);
	}

	public void saveSong(Songs song) {
		songsDao.save(song);
	}

	public void saveFanaticsArtist(FanaticsArtists fanaticsArtists) {
		fanaticsArtistsDao.save(fanaticsArtists);
	}

	public void saveCommentsForArtist(ArtistsCalifications artistsCalifications) {
		artistsCalificationsDao.save(artistsCalifications);
	}
	/*-----------------------------------------	DELETE-------------------------------------*/
	/*-----------------------------------------	DELETE-------------------------------------*/

	public void deleteNewsById(News news) {
		newsDao.deleteNews(news);
	}

	public void deleteFollowersOfArtist(int idFanatic, int idArtist) {
		fanaticsArtistsDao.deleteByIdArtistAndIdFanatic(idArtist, idFanatic);
	}
}
