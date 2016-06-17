package myfan.heroku;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.eclipse.persistence.internal.oxm.schema.model.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import myfan.data.dao.GenresDao;
import myfan.data.models.Genres;
import myfan.domain.FacadeLogic;
import myfan.resources.base.DisableAccountRequest;
import myfan.resources.base.GenresResponse;
import myfan.resources.base.LoginRequest;
import myfan.resources.base.RegisterNewArtistRequest;
import myfan.resources.base.util.Member;

public class MainTest {

  public static void main(String[] args) throws JsonProcessingException {
    FacadeLogic facadeLogic = new FacadeLogic();
    System.out.println(facadeLogic.getAllGenders());
  }
}


