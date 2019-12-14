package service;

import DAO.LoginDAO;

import java.util.HashMap;
import java.util.Map;



public class AuthService implements Auth {
  Map<String, String> data = new HashMap<>();


  @Override
  public int check(String email, String paswd) {
    User user = new User();
    user.setEmail(email);
    user.setPassword(paswd);
    final int user_id = LoginDAO.checkLogin(user);
    return user_id;
  }

}
