package myfan.models;
// Generated May 28, 2016 11:43:26 PM by Hibernate Tools 5.1.0.Alpha1

/**
 * FanaticsGenres generated by hbm2java
 */
public class FanaticsGenres implements java.io.Serializable {

  private int fanaticGenreId;
  private Fanatics fanatics;
  private Genres genres;
  private int idGenre;

  public FanaticsGenres() {
  }

  public FanaticsGenres(Fanatics fanatics, Genres genres, int idGenre) {
    this.fanatics = fanatics;
    this.genres = genres;
    this.idGenre = idGenre;
  }

  public int getFanaticGenreId() {
    return this.fanaticGenreId;
  }

  public void setFanaticGenreId(int fanaticGenreId) {
    this.fanaticGenreId = fanaticGenreId;
  }

  public Fanatics getFanatics() {
    return this.fanatics;
  }

  public void setFanatics(Fanatics fanatics) {
    this.fanatics = fanatics;
  }

  public Genres getGenres() {
    return this.genres;
  }

  public void setGenres(Genres genres) {
    this.genres = genres;
  }

  public int getIdGenre() {
    return this.idGenre;
  }

  public void setIdGenre(int idGenre) {
    this.idGenre = idGenre;
  }

}
