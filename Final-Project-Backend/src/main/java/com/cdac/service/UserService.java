package com.cdac.service;

import com.cdac.dto.TranspProfile;
import com.cdac.dto.User;
import java.util.List;
import java.util.Map;


public interface UserService {
  public void AddUser(User usr);
  public List<User> GetUserList();
  
  public void removeUser(int id);
  //public User findRowById(int id); 
  public void modifyPass(User usr);
  public User FindUserForLogin(String emailId,String password,String role);
}
