package myfan.heroku;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import myfan.domain.FacadeLogic;
import myfan.resources.base.RegisterNewArtistRequest;
import myfan.resources.base.util.Member;

public class MainTest {

  public static void main(String[] args) {
  RegisterNewArtistRequest newArtistRequest= new
     RegisterNewArtistRequest();
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
     members.add(member1);
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
