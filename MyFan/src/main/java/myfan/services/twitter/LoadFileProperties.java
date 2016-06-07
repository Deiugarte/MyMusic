package myfan.services.twitter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javier
 */
public class LoadFileProperties {

    private Properties twitterPropertiesFile;

    public LoadFileProperties() {
    	
        String nameFile = "TwitterConfiguration.properties";
        LoadFile(nameFile);
    }

    private InputStream openFile(String nameFile) {
        InputStream fileInputStream =  ClassLoader.getSystemResourceAsStream("TwitterConfiguration.properties");
        return fileInputStream;
    }

    private void LoadFile(String nameFileProperties) {

        twitterPropertiesFile = new Properties();
        try {
        	InputStream fileProperties=openFile(nameFileProperties);
            twitterPropertiesFile.load(fileProperties);
        } catch (IOException ex) {
            Logger.getLogger(LoadFileProperties.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Properties getTwitterPropertiesFile() {
        return twitterPropertiesFile;
    }

    
}
