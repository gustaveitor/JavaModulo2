package com.comics.app.Controller;

import java.util.List;

import com.comics.app.Dao.userDao;
import com.comics.app.Model.User;

public class userController {
	userDao userdao = new userDao();
	
	public boolean login(String username, String password) throws Exception  {
		return userdao.Login(username, password);
	}

	public boolean add(User c) throws Exception  {
		boolean rta = userdao.add(c);
		return rta;
	}
	
	public User get(int key) throws Exception  {
		User p = userdao.get(key);		
		return p;
	}
	public User get(String username, String password) throws Exception {
		return userdao.get(username, password);
	}
	
	public List<User> getAll() throws Exception  {
		List<User> list = userdao.getAll();
		return list;
	}
	
	public boolean delete(int key) throws Exception  {
		boolean rta = userdao.delete(key);		
		return rta;
	}
	
	public boolean update(User p) throws Exception  {
		boolean rta = userdao.update(p);
		return rta;
	}
}
