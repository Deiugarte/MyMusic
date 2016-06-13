package myfan.heroku;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import myfan.domain.FacadeLogic;
import myfan.resources.base.RegisterNewFanaticRequest;


/**
 * This class launches the web application in an embedded Jetty container. This is the entry point to your application. The Java
 * command that is used for launching should fire this main method.
 */
public class Main {

    public static void main(String[] args) throws Exception{
    	RegisterNewFanaticRequest newFanaticRequest= new RegisterNewFanaticRequest();
    	 SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
    	 String strFecha = "2007-12-25";
    	 Date fecha = null;
    	 try {

    	     fecha = formatoDelTexto.parse(strFecha);

    	 } catch (ParseException ex) {

    	     ex.printStackTrace();

    	 }
    	 
    	 ArrayList<String> generos = new ArrayList<>();
    	 generos.add("Pop");
    	 generos.add("Rock");
		newFanaticRequest.setBirthDate(fecha);
		newFanaticRequest.setCountryLocation("Costa Rica");
		newFanaticRequest.setGender(true);
		newFanaticRequest.setLogin("Vale1");
		newFanaticRequest.setMusisicalGenres(generos);
		newFanaticRequest.setNameUser("Valeria");
		newFanaticRequest.setPassword("algo");
		newFanaticRequest.setProfilePicture(null);
		
		FacadeLogic facadeLogic= new FacadeLogic();
		facadeLogic.registerNewFanatic(newFanaticRequest);
		System.out.println("Soy un puto amo");
    }
    
}
