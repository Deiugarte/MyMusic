package myfan.data.models;
// Generated Jun 17, 2016 12:28:37 AM by Hibernate Tools 5.1.0.Alpha1

/**
 * UsersGenres generated by hbm2java
 */
public class UsersGenres implements java.io.Serializable {

  private int usersGenresId;
  private Genres genres;
  private Users users;

  public UsersGenres() {
  }

  public UsersGenres(int usersGenresId, Genres genres, Users users) {
    this.usersGenresId = usersGenresId;
    this.genres = genres;
    this.users = users;
  }

  public int getUsersGenresId() {
    return this.usersGenresId;
  }

  public void setUsersGenresId(int usersGenresId) {
    this.usersGenresId = usersGenresId;
  }

  public Genres getGenres() {
    return this.genres;
  }

  public void setGenres(Genres genres) {
    this.genres = genres;
  }

  public Users getUsers() {
    return this.users;
  }

  public void setUsers(Users users) {
    this.users = users;
  }

}
