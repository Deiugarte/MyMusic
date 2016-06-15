package myfan.heroku;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import myfan.domain.FacadeLogic;
import myfan.resources.base.RegisterNewArtistRequest;
import myfan.resources.base.RegisterNewFanaticRequest;
import myfan.resources.base.util.Member;


/**
 * This class launches the web application in an embedded Jetty container. This is the entry point to your application. The Java
 * command that is used for launching should fire this main method.
 */
public class Main {

    public static void main(String[] args) throws Exception{
    	 RegisterNewArtistRequest newArtistRequest= new RegisterNewArtistRequest();
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
    	 
    	 ArrayList<Member> members = new ArrayList<>();
    	 Member member1= new Member();
    	 member1.setName("Jean Paul");
    	 member1.setInstrument("guitarra");
    	 
		newArtistRequest.setBirthDate(fecha);
		newArtistRequest.setCountryLocation("Costa Rica");
		newArtistRequest.setLogin("Vale1");
		newArtistRequest.setMusisicalGenres(generos);
		newArtistRequest.setNameUser("Valeriass");
		newArtistRequest.setPassword("algo");
		newArtistRequest.setMembers(members);
	
		
		
		FacadeLogic facadeLogic= new FacadeLogic();
		facadeLogic.registerNewArtist(newArtistRequest,null,null);
		
		
		System.out.println("Soy un puto amo");
    	
    	
    }
    
}
