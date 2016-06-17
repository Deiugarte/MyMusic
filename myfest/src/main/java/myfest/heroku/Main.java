package myfest.heroku;


import myfest.dao.ArtistsScoresDAO;
import myfest.models.Artistsscores;

public class Main {

  public static void main(String[] args) {
    ArtistsScoresDAO artistsScoresDAO = new ArtistsScoresDAO();
    Artistsscores artistsscores = new Artistsscores();
    artistsscores.setCommentAmount(12);
    artistsscores.setScore(12);
    artistsscores.setVoters(12);
    artistsscores.setArtistScoresId(1);
    artistsScoresDAO.save(artistsscores);

  }

}
