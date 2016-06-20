package myfan.comunicacion.twitter.apiTwitter;

import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Esta clase esta encargada de realizar la conexion con la aplicacion Twitter,
 * mediante la libreria twitter4j
 *
 * @author Javier
 */
public class TwitterConnection {

    private final Twitter twitter;

    /**
     * TwitterConnection realiza la conexion con Twitter, validado los tokens y
     * llaves con la aplicacion de desarroladores
     */
    public TwitterConnection() {
        LoadFileProperties fileProperties = new LoadFileProperties();
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setDebugEnabled(true)
                .setOAuthConsumerKey(fileProperties.getTwitterPropertiesFile().getProperty("twitter.consumer.key"))
                .setOAuthConsumerSecret(fileProperties.getTwitterPropertiesFile().getProperty("twitter.secret.key"))
                .setOAuthAccessToken(fileProperties.getTwitterPropertiesFile().getProperty("twitter.access.token"))
                .setOAuthAccessTokenSecret(fileProperties.getTwitterPropertiesFile().getProperty("twitter.access.token.secret"));
        TwitterFactory twitterFactory = new TwitterFactory(configurationBuilder.build());
        twitter = twitterFactory.getInstance();

    }

    public void publicarTwitter(String statusTwitter) {
        try {
            twitter.updateStatus(statusTwitter);
        } catch (TwitterException ex) {
            Logger.getLogger(TwitterConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @return el objeto twitter
     */
    public Twitter getTwitter() {
        return twitter;
    }
    
}