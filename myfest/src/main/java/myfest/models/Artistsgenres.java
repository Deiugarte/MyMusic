package myfest.models;
// Generated Jun 14, 2016 9:46:17 PM by Hibernate Tools 5.1.0.Alpha1

/**
 * Artistsgenres generated by hbm2java
 */
public class Artistsgenres implements java.io.Serializable {

  private ArtistsgenresId id;
  private Artists artists;
  private Musicalgenres musicalgenres;

  public Artistsgenres() {
  }

  public Artistsgenres(ArtistsgenresId id, Artists artists, Musicalgenres musicalgenres) {
    this.id = id;
    this.artists = artists;
    this.musicalgenres = musicalgenres;
  }

  public ArtistsgenresId getId() {
    return this.id;
  }

  public void setId(ArtistsgenresId id) {
    this.id = id;
  }

  public Artists getArtists() {
    return this.artists;
  }

  public void setArtists(Artists artists) {
    this.artists = artists;
  }

  public Musicalgenres getMusicalgenres() {
    return this.musicalgenres;
  }

  public void setMusicalgenres(Musicalgenres musicalgenres) {
    this.musicalgenres = musicalgenres;
  }

}
