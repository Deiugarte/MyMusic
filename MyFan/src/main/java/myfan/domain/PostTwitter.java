package myfan.domain;

import java.util.logging.Level;
import java.util.logging.Logger;

import myfan.services.twitter.TwitterConnection;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class PostTwitter implements IConstansts {
	private Twitter twitter;

	/**
	 * Contructor de la clase que crea una nueva instancia de la conexion de
	 * twitter
	 */
	public PostTwitter() {
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
			Logger.getLogger(PostTwitter.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void postStatusTwitter(String nameUser, String nameArtist, int typeInstruction){
	        	String finalStatusTwitter="";
	        	switch(typeInstruction){
	        		case STATUS_RATE: 
	        			finalStatusTwitter= "El usuario "+nameUser+" publico un nuevo comentario en el perfil del artista "+nameArtist;
	        		case STATUS_FOLLOW:
	        			finalStatusTwitter= "El usuario "+nameUser+" comenzó a seguir el perfil del artista "+nameArtist;
	        		case STATUS_RATE_AND_COMMENT:
	        			finalStatusTwitter= "El usuario "+nameUser+" comentó y calificó  el perfil del artista "+nameArtist;
	        		}		
	        	postTwitter(finalStatusTwitter);
	        }
}
