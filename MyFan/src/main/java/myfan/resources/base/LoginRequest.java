package myfan.resources.base;

public class LoginRequest {
    private String hola;
    private String password;
    
    public String getLogin() {
      return hola;
    }
    public void setLogin(String login) {
      this.hola = login;
    }
    public String getPassword() {
      return password;
    }
    public void setPassword(String password) {
      this.password = password;
    }
}
