package com.comics.app.Controller;

import java.util.List;

import com.comics.app.Dao.roleDao;
import com.comics.app.Model.Role;

public class roleController {
	roleDao roledao = new roleDao();
	
	public boolean add(Role c) throws Exception {
		boolean rta = roledao.add(c);
		return rta;
	}
	
	public Role get(int key) throws Exception {
		Role p = roledao.get(key);		
		return p;
	}
	
	public List<Role> getAll() throws Exception {
		List<Role> list = roledao.getAll();
		return list;
	}
	
	public boolean delete(int key) throws Exception {
		boolean rta = roledao.delete(key);		
		return rta;
	}
	
	public boolean update(Role p) throws Exception {
		boolean rta = roledao.update(p);
		return rta;
	}
}
