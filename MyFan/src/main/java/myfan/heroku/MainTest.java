package myfan.heroku;

import myfan.domain.FacadeLogic;

public class MainTest {

  public static void main(String[] args) {
    FacadeLogic facadeLogic = new FacadeLogic();
    System.out.println(facadeLogic.getPersonalInformationOfUser(11));
  }
}


