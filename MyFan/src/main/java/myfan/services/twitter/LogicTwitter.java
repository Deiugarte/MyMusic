package myfan.services.twitter;


import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class LogicTwitter {
	  private Twitter  twitter;
	    /**
	     * Contructor de la clase que crea una nueva instancia de la conexion de twitter
	     */
	    public LogicTwitter() {
	        TwitterConnection twitterConnection= new TwitterConnection();
	        twitter=twitterConnection.getTwitter();
	     
	    }

	    /**
	     * Este metodo es el encargado de pubicar un nuevo estado en Twitter
	     * @param statusTwitter: Corresponde a un nuevo estado para twittear
	     */
	        public void publicarTwitter(String statusTwitter) {
	        try {
	            twitter.updateStatus(statusTwitter);
	        } catch (TwitterException ex) {
	            Logger.getLogger(LogicTwitter.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
	}


