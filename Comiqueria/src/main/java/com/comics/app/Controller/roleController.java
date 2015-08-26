package com.comics.app.Controller;

import java.util.List;

import com.comics.app.Dao.roleDao;
import com.comics.app.Model.Role;

public class roleController {
	roleDao roledao = new roleDao();
	
	public boolean login(String username, String password) {
		if (username.equals("Sheldon") && password.equals("Bazzinga")) {
			return true;
		}
		return false;
	}
	
	public boolean add(Role c) {
		boolean rta = roledao.add(c);
		return rta;
	}
	
	public Role get(int key) {
		Role p = roledao.get(key);		
		return p;
	}
	
	public List<Role> getAll() {
		List<Role> list = roledao.getAll();
		return list;
	}
	
	public boolean delete(int key) {
		boolean rta = roledao.delete(key);		
		return rta;
	}
	
	public boolean update(Role p) {
		boolean rta = roledao.update(p);
		return rta;
	}
}
