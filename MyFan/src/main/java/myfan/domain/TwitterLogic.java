package myfan.domain;

import java.util.logging.Level;
import java.util.logging.Logger;

import myfan.services.twitter.TwitterConnection;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class TwitterLogic  {
	private Twitter twitter;
	private final int STATUS_RATE = 0;
	private final int STATUS_FOLLOW  = 1;
	private final int STATUS_RATE_AND_COMMENT   = 2;

	/**
	 * Contructor de la clase que crea una nueva instancia de la conexion de
	 * twitter
	 */
	public TwitterLogic() {
		TwitterConnection twitterConnection = new TwitterConnection();
		twitter = twitterConnection.getTwitter();

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
			Logger.getLogger(TwitterLogic.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void postStatusTwitter(String nameUser, String nameArtist, int typeInstruction){
	        	String finalStatusTwitter="";
	        	switch(typeInstruction){
	        		case STATUS_RATE: 
	        			finalStatusTwitter= "El usuario "+nameUser+" publico un nuevo comentario en el perfil del artista "+nameArtist;
	        			break;
	        		case STATUS_FOLLOW:
	        			finalStatusTwitter= "El usuario "+nameUser+" comenzó a seguir el perfil del artista "+nameArtist;
	        			break;
	        		case STATUS_RATE_AND_COMMENT:
	        			finalStatusTwitter= "El usuario "+nameUser+" comentó y calificó  el perfil del artista "+nameArtist;
	        			break;
	        	}		
	        	postTwitter(finalStatusTwitter);
	        }
	
}
