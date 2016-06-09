package myfan.services;

import java.io.IOException;
import java.util.StringTokenizer;

import org.eclipse.jetty.util.StringUtil;

import com.google.common.io.BaseEncoding;

import myfan.data.dao.UsersDao;
import myfan.data.models.Users;



public class AuthenticationService {
    public boolean authenticate(String authCredentials) {

        if (null == authCredentials)
            return false;

        final String encodedUserPassword = authCredentials.replaceFirst("Basic"
                + " ", "");
        String usernameAndPassword = null;
        try {

            byte[] decodedBytes = BaseEncoding.base64().decode(encodedUserPassword);
            usernameAndPassword = new String(decodedBytes, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        final StringTokenizer tokenizer = new StringTokenizer(
                usernameAndPassword, ":");
        final String username = tokenizer.nextToken();
        final String password = tokenizer.nextToken();

        if(StringUtil.isBlank(username) || StringUtil.isBlank(password))
            return false;
        Users userObject = findUserByLogin(username);
        System.out.println(userObject);

        boolean authenticationStatus = false;

        if(userObject != null){
            return checkPassword(userObject.getPassword(), password);
        }
        return authenticationStatus;
    }

    public Users findUserByLogin(final String username) {
      UsersDao userDao = new UsersDao();
      Users userObject = userDao.findByusername(username);
      return userObject;
    }

    private boolean checkPassword(String password, String password2) {
      System.out.println("base:"+password+"ingresada:"+password2);
        return password.equals(password2);
    }}
