package com.comics.app.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.comics.app.Classes.exceptionConverter;
import com.comics.app.Model.Person;

public class personDao implements genericDao<Person> {
	
	// SQL CRUD Statements.
	private final String SQL_INSERT = "INSERT INTO persons (namePerson, telephonePerson) VALUES (?, ?)";
	private final String SQL_DELETE = "DELETE FROM persons WHERE idPerson = ?";
	private final String SQL_UPDATE ="UPDATE persons SET namePerson=? , telephonePerson=? WHERE idPerson=?";
	private final String SQL_GET_ALL = "SELECT * FROM persons";
	private final String SQL_GET = "SELECT * FROM persons WHERE ( idPerson = ?)";
	
	// SQL VALIDADOR
		private final String SQL_CHECK = "select (case when (select count(Persons_idPerson) from comics.loans where Persons_idPerson = ?)>0 then 1 else 0 end) as verdad";

	
	private final connectionDB conn = connectionDB.getConnection();
	
	public boolean add(Person c) throws Exception {
		try {
			PreparedStatement ps;
			ps = conn.getConn().prepareStatement(SQL_INSERT);
			
			ps.setString(1, c.getNamePerson());
			ps.setString(2, c.getTelephonePerson());
			
			if(ps.executeUpdate() > 0) {
				return true;
			}			
			
		} catch (SQLException e) {
			new exceptionConverter();
			throw exceptionConverter.getException("Problemas en la base de datos Personas", e) ;
		} finally {
			conn.closeConnection();
		}
		return false;
	}
	public boolean check(int key) throws Exception{
	    PreparedStatement ps;
	    ResultSet rs;
		try {
			ps = conn.getConn().prepareStatement(SQL_CHECK);
			ps.setInt(1, key);
			rs = ps.executeQuery();
			  while(rs.next()){
				if (rs.getInt(1)==1){
					return true;
					
				}
				else{
					return false;
				}
			
			  }
		  return false;
		} catch (SQLException e) {
			new exceptionConverter();
			throw exceptionConverter.getException("Problemas en la base de datos Personas", e) ;
		}
		finally {
			conn.closeConnection();
		}
   }
	public boolean update(Person c) throws Exception{
	PreparedStatement ps;
		
		try {
			ps = conn.getConn().prepareStatement(SQL_UPDATE);
			ps.setString(1, c.getNamePerson());
			ps.setString(2, c.getTelephonePerson());
			ps.setInt(3, c.getIdPerson());
			if(ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			new exceptionConverter();
			throw exceptionConverter.getException("Problemas en la base de datos Personas", e) ;
		} finally {
			conn.closeConnection();
		}
		return false;
	}

	public boolean delete(int key) throws Exception {
		PreparedStatement ps;
		
		try {
			ps = conn.getConn().prepareStatement(SQL_DELETE);
			ps.setInt(1, key);
			
			if(ps.executeUpdate() > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			new exceptionConverter();
			throw exceptionConverter.getException("Problemas en la base de datos Personas", e) ;
		} finally {
			conn.closeConnection();
		}
		return false;
	}

	public Person get(int key) throws Exception {
		Person p = new Person();
		
		try {
			
			PreparedStatement ps;
			ResultSet res;
			
			ps = conn.getConn().prepareStatement(SQL_GET);
			ps.setInt(1, key);
			
			res = ps.executeQuery();
			while(res.next()) {
				p.setIdPerson(res.getInt("idPerson"));
				p.setNamePerson(res.getString("namePerson"));
				p.setTelephonePerson(res.getString("telephonePerson"));
			}
					
		} catch (SQLException e) {
			new exceptionConverter();
			throw exceptionConverter.getException("Problemas en la base de datos Personas", e) ;
		} finally {
			conn.closeConnection();
		}
		return p;
	}

	public List<Person> getAll() throws Exception{
		List<Person> list = new ArrayList<Person>();
		
		try {
			PreparedStatement ps;
			ResultSet res;
			
			ps = conn.getConn().prepareStatement(SQL_GET_ALL);
			res = ps.executeQuery();
			
			while(res.next()) {
				
				Person c = new Person();
				c.setIdPerson(res.getInt("idPerson"));
				c.setNamePerson(res.getString("namePerson"));
				c.setTelephonePerson(res.getString("telephonePerson"));
				
				list.add(c);
			}
			
		} catch (SQLException e) {
			new exceptionConverter();
			throw exceptionConverter.getException("Problemas en la base de datos Personas", e) ;
		} finally {
			conn.closeConnection();
		}
		return list;
	}
	
}