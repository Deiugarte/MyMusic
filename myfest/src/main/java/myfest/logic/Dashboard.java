package myfest.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import myfest.facade.FacadeDB;
import myfest.models.Artists;
import myfest.models.Artistsgenres;
import myfest.models.Twittermentions;
import myfest.objects.response.MonthlyTwitterMentions;
import myfest.objects.response.ResponseDashboard;
import myfest.utils.JSonConverter;

public class Dashboard {
  private FacadeDB facadeDB;
  private JSonConverter json;

  public Dashboard() {
    facadeDB = new FacadeDB();
    json = new JSonConverter();
  }

  public String getDataArtist(int artistID) {
    ResponseDashboard artistDashboard = new ResponseDashboard();
    Artists artist = facadeDB.getArtistById(artistID);
    artistDashboard.setName(artist.getArtistName());
    artistDashboard.setFollowersAmount(artist.getFollowersAmount());
    artistDashboard.setPicture(artist.getImage());
    artistDashboard.setArtistScore(artist.getArtistsscores().getScore());
    artistDashboard.setConcertScore(artist.getConcertsscores().getScore());
    artistDashboard.setDiscScore(artist.getDiscsscores().getScore());
    artistDashboard.setTwitterMentionsAmount(getTotalOfTwitterMentions(artistID));
    artistDashboard.setArtistGenders(getGenresOfArtist(artistID));

    return json.jsonConverter(artistDashboard);
  }

  private List<String> getGenresOfArtist(int artistID) {
    List<String> artistGenres = new ArrayList<String>();

    List<Artistsgenres> genresOfArtist = facadeDB.getGenresByArtistID(artistID);
    for (int i = 0; i < genresOfArtist.size(); i++) {
      artistGenres.add(genresOfArtist.get(i).getMusicalgenres().getGenreName());
    }
    return artistGenres;
  }

  private List<MonthlyTwitterMentions> getTotalOfTwitterMentions(int artistID) {
    List<MonthlyTwitterMentions> twittermentions = new ArrayList<MonthlyTwitterMentions>();
    Random random = new Random();
    for (int i = 7; i >=0; i--) {
      MonthlyTwitterMentions mentions = new MonthlyTwitterMentions();
      mentions.setMentions(random.nextInt(10));
      mentions.setMonth(getMonth(i));
      twittermentions.add(mentions);
    }
    return twittermentions;
  }

  private String getMonth(int month) {
    String monthName = "";
    switch (month) {
    case 1:
      monthName = "January";
      break;
    case 2:
      monthName = "February";
      break;
    case 3:
      monthName = "March";
      break;
    case 4:
      monthName = "April";
      break;
    case 5:
      monthName = "May";
      break;
    case 6:
      monthName = "June";
      break;
    case 7:
      monthName = "July";
      break;
    case 8:
      monthName = "August";
      break;
    case 9:
      monthName = "September";
      break;
    case 10:
      monthName = "October";
      break;
    case 11:
      monthName = "November";
      break;
    case 12:
      monthName = "December";
      break;
    }
    return monthName;
  }

}
