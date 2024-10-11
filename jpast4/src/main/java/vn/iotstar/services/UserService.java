package vn.iotstar.services;

import java.util.List;

import vn.iotstar.dao.impl.IUserDao;
import vn.iotstar.dao.impl.UserDao;
import vn.iotstar.entity.User;

public class UserService implements IUserService{
	IUserDao usDao = new UserDao();
	@Override
	 public List<User> findAll() {
	 return usDao.findAll();
	 }
	 @Override
	 public User findById(int id) {
	 return usDao.findById(id);
	 }
	 @Override
	 public List<User> searchByName(String keyword) {
	 return usDao.searchByName(keyword);
	 }
	
	 @Override
	 public void update(User user) {
	 usDao.update(user); 
	 }
	 @Override
	 public void delete(int id){
	 try {
	 usDao.delete(id);
	 } catch (Exception e) {
	 e.printStackTrace();
	 }
	 }
	 @Override
	 public int count() {
	 return usDao.count();
	 }
	 @Override
	 public List<User> findAll(int page, int pagesize) {
	 return usDao.findAll(page, pagesize);
	 }
	 @Override
	 public User findByEmail(String name) {
	 try {
	 return usDao.findByEmail(name);
	 } catch (Exception e) {
	 e.printStackTrace();
	 }
	 return null;
	 }
	 
	
}
