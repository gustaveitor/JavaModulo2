package com.comics.app.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.comics.app.Model.Comic;
import com.comics.app.Model.Role;

public class roleDao  implements genericDao<Role> {

	private final String SQL_INSERT = "INSERT INTO roles (nameRole) VALUES (?)";
	private final String SQL_DELETE = "DELETE FROM roles WHERE idRole = ?";
	private final String SQL_UPDATE = "UPDATE roles SET nameRole = ? WHERE idRole = ? ";
	private final String SQL_GET_ALL = "SELECT * FROM roles";
	private final String SQL_GET = "SELECT * FROM roles WHERE ( idRole = ?)";
	private final connectionDB conn = connectionDB.getConnection();
	
	@Override
	public boolean add(Role c) {
		try {
			PreparedStatement ps;
			ps = conn.getConn().prepareStatement(SQL_INSERT);
			
			ps.setString(1, c.getNameRole());
		
			if(ps.executeUpdate() > 0) {
				return true;
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.closeConnection();
		}
		return false;
	}

	@Override
	public boolean update(Role c) {
	PreparedStatement ps;
		
		try {
			ps = conn.getConn().prepareStatement(SQL_UPDATE);
			ps.setString(1, c.getNameRole());
			ps.setInt(2, c.getIdRole());
			if(ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.closeConnection();
		}
		return false;
	}

	@Override
	public boolean delete(int key) {
		PreparedStatement ps;
		
		try {
			ps = conn.getConn().prepareStatement(SQL_DELETE);
			ps.setInt(1, (Integer)key);
			
			if(ps.executeUpdate() > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.closeConnection();
		}
		return false;
	}

	@Override
	public Role get(int key) {
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
			e.printStackTrace();
		} finally {
			conn.closeConnection();
		}
		return c;
	}

	@Override
	public List<Role> getAll() {
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
			e.printStackTrace();
		} finally {
			conn.closeConnection();
		}
		return list;
	}

	

}
