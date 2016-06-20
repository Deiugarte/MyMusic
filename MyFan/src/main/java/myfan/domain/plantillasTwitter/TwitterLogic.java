package myfan.domain.plantillasTwitter;

import myfan.comunicacion.twitter.apiTwitter.TwitterConnection;
import myfan.data.models.Artists;
import myfan.data.models.Discs;
import myfan.data.models.Events;
import myfan.data.models.Fanatics;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class TwitterLogic {
	private Twitter twitter;
	public final int STATUS_RATE_AN_ARTIST = 0;
	public final int STATUS_FOLLOW = 1;
	public final int STATUS_RATE_AND_COMMENT_AN_ARTIST = 2;
	public final int STATUS_RATE_AND_COMMENT_A_DISC = 3;
	public final int STATUS_RATE_A_DISC = 4;
	public final int STATUS_RATE_AND_COMMENT_A_CONCERT = 5;
	public final int STATUS_RATE_A_CONCERT = 6;

	/**
	 * Contructor de la clase que crea una nueva instancia de la conexion de
	 * twitter
	 */
	public TwitterLogic() {
		TwitterConnection twitterConnection = new TwitterConnection();
		twitter = twitterConnection.getTwitter();

	}

	public void postTwitter(Fanatics fanatic, Artists artists, int estado) {
		String nameFanatic = fanatic.getUsers().getName();
		String nameArtist = artists.getUsers().getName();
		postStatusTwitter(nameFanatic, nameArtist, estado);
	}

	public void postTwitter(Fanatics fanatic, Discs disc, int estado) {
		String nameFanatic = fanatic.getUsers().getName();
		String nameDisc = disc.getName();
		postStatusTwitter(nameFanatic, nameDisc, estado);
	}
	public void postTwitter(Fanatics fanatic, Events concierto, int estado) {
		String nameFanatic = fanatic.getUsers().getName();
		String nameConcert = concierto.getTittle();
		postStatusTwitter(nameFanatic, nameConcert, estado);
	}

	/**
	 * Este metodo es el encargado de pubicar un nuevo estado en Twitter
	 * 
	 * @param statusTwitter:
	 *            Corresponde a un nuevo estado para twittear
	 */
	private void postTwitter(String statusTwitter) {
		try {
			twitter.updateStatus(statusTwitter);
		} catch (TwitterException ex) {
			System.out.println("Se han violado las politicas de Twitter, se ignoró la petición del nuevo post");
			// Logger.getLogger(TwitterLogic.class.getName()).log(Level.SEVERE,
			// null, ex);
		}
	}

	private void postStatusTwitter(String nameUser, String name, int typeInstruction) {
		String finalStatusTwitter = "";
		switch (typeInstruction) {
		case STATUS_RATE_AN_ARTIST:
			finalStatusTwitter = "El fánatico " + nameUser + "  calificó el perfil del artista " + name;
			break;
		case STATUS_FOLLOW:
			finalStatusTwitter = "El fánatico " + nameUser + " comenzó a seguir el perfil del artista " + name;
			break;
		case STATUS_RATE_AND_COMMENT_AN_ARTIST:
			finalStatusTwitter = "El fánatico " + nameUser + " comentó y calificó  el perfil del artista " + name;
			break;
		case STATUS_RATE_AND_COMMENT_A_DISC:
			finalStatusTwitter = "El fánatico " + nameUser + " comentó y calificó en la discografia el disco "+ name;
			break;
		case STATUS_RATE_A_DISC:
			finalStatusTwitter = "El fánatico " + nameUser + " calificó en la discografia el disco " + name;
			break;
		case STATUS_RATE_AND_COMMENT_A_CONCERT:
			finalStatusTwitter = "El fánatico " + nameUser + " comentó y calificó sobre el concierto " + name;
			break;
		case STATUS_RATE_A_CONCERT:
			finalStatusTwitter = "El fánatico " + nameUser + " calificó esobre el " + name;
			break;
		}
		postTwitter(finalStatusTwitter);
	}

}
