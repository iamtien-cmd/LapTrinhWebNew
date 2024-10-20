package vn.iotstar.service;

import vn.iotstar.model.User;

public interface UserService {
	 User login(String username, String password) ;
	 User findByUserName(String username);
	 User get(String username);
	 void insert(User user);
	 boolean register(String email, String password, String username, String fullname, String phone);
	 boolean checkExistEmail(String email);
	 boolean checkExistUsername(String username);
	 boolean checkExistPhone(String phone);
	 boolean updatePassword(String username, String newpassword);
	 boolean updateProfile(String username, String fullname, String phone, String avatar);
}
