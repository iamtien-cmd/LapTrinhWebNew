package vn.iotstar.dao.impl;

import java.util.List;

import vn.iotstar.entity.User;

public interface IUserDao {

	int count();

	List<User> findAll(int page, int pagesize);

	List<User> searchByName(String fullname);

	List<User> findAll();

	User findByEmail(String name) throws Exception;

	User findById(int id);

	void delete(int user) throws Exception;

	void update(User user);

}
