package com.comics.app.Dao;

import java.util.List;

public interface genericDao <C> {
	
	public boolean add(C c);
	public boolean update(C c);
	public boolean delete(int key);
	public C get(int key);
	public List<C> getAll();
	
}