package com.comics.app.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.comics.app.Model.Role;
import com.comics.app.Classes.exceptionConverter;

public class roleDao  implements genericDao<Role> {

	private final String SQL_INSERT = "INSERT INTO roles (nameRole) VALUES (?)";
	private final String SQL_DELETE = "DELETE FROM roles WHERE idRole = ?";
	private final String SQL_UPDATE = "UPDATE roles SET nameRole = ? WHERE idRole = ? ";
	private final String SQL_GET_ALL = "SELECT * FROM roles";
	private final String SQL_GET = "SELECT * FROM roles WHERE ( idRole = ?)";
	private final connectionDB conn = connectionDB.getConnection();
	
	@Override
	public boolean add(Role c) throws Exception {
		try {
			PreparedStatement ps;
			ps = conn.getConn().prepareStatement(SQL_INSERT);
			
			ps.setString(1, c.getNameRole());
		
			if(ps.executeUpdate() > 0) {
				return true;
			}			
			
		} catch (SQLException e) {
			new exceptionConverter();
			throw exceptionConverter.getException("Problemas en la base de datos ROLES", e) ;
		} finally {
			conn.closeConnection();
		}
		return false;
	}

	@Override
	public boolean update(Role c) throws Exception {
	PreparedStatement ps;
		
		try {
			ps = conn.getConn().prepareStatement(SQL_UPDATE);
			ps.setString(1, c.getNameRole());
			ps.setInt(2, c.getIdRole());
			if(ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			new exceptionConverter();
			throw exceptionConverter.getException("Problemas en la base de datos ROLES", e) ;
		
		} finally {
			conn.closeConnection();
		}
		return false;
	}

	@Override
	public boolean delete(int key) throws Exception {
		PreparedStatement ps;
		
		try {
			ps = conn.getConn().prepareStatement(SQL_DELETE);
			ps.setInt(1, (Integer)key);
			
			if(ps.executeUpdate() > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			new exceptionConverter();
			throw exceptionConverter.getException("Problemas en la base de datos ROLES", e) ;
		
		} finally {
			conn.closeConnection();
		}
		return false;
	}

	@Override
	public Role get(int key) throws Exception {
     Role c = new Role();
		
		try {
			
			PreparedStatement ps;
			ResultSet res;
			
			ps = conn.getConn().prepareStatement(SQL_GET);
			ps.setInt(1, (Integer)key);
			
			res = ps.executeQuery();
			while(res.next()) {
				c.setIdRole(res.getInt("idRole"));
				c.setNameRole(res.getString("nameRole"));
			}
					
		} catch (SQLException e) {
			new exceptionConverter();
			throw exceptionConverter.getException("Problemas en la base de datos ROLES", e) ;
		
		} finally {
			conn.closeConnection();
		}
		return c;
	}

	@Override
	public List<Role> getAll() throws Exception {
		List<Role> list = new ArrayList<Role>();
		
		try {
			PreparedStatement ps;
			ResultSet res;
			
			ps = conn.getConn().prepareStatement(SQL_GET_ALL);
			res = ps.executeQuery();
			
			while(res.next()) {
				
				Role c = new Role();
				c.setIdRole(res.getInt("idRole"));
				c.setNameRole(res.getString("nameRole"));
							
				list.add(c);
			}
			
		} catch (SQLException e) {
			new exceptionConverter();
			throw exceptionConverter.getException("Problemas en la base de datos ROLES", e) ;
		
		} finally {
			conn.closeConnection();
		}
		return list;
	}

	

}
