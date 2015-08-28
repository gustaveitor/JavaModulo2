package com.comics.app.Dao;

import java.util.List;

public interface genericDao <C> {
	
	public boolean add(C c) throws Exception;
	public boolean update(C c) throws Exception;
	public boolean delete(int key) throws Exception;
	public C get(int key) throws Exception;
	public List<C> getAll() throws Exception;
	
}