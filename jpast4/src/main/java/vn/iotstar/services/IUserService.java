package vn.iotstar.services;

import java.util.List;

import vn.iotstar.dao.impl.IUserDao;
import vn.iotstar.dao.impl.UserDao;
import vn.iotstar.entity.User;

public interface IUserService {

	User findByEmail(String name);

	List<User> findAll(int page, int pagesize);

	int count();

	void delete(int id);

	void update(User user);

	List<User> searchByName(String keyword);

	User findById(int id);

	List<User> findAll();

	

}
