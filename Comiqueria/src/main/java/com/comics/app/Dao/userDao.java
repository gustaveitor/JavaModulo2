package com.comics.app.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.comics.app.Model.Role;
import com.comics.app.Model.User;

public class userDao implements genericDao<User>{

	//Para Login
	private final String SQL_LOGIN="select (case when (select count(idUser) from comics.users where users.nameUser = ? and users.passwordUser = ? )>0 then 1 else 0 end) as verdad";

	private final String SQL_GET_ONE = "SELECT * FROM users WHERE  nameUser = ? and passwordUser= ?";
	//PARA USUARIOS
	private final String SQL_INSERT = "INSERT INTO users (nameUser,passwordUser) VALUES (?)";
	private final String SQL_DELETE = "DELETE FROM users WHERE idUser = ?";
	private final String SQL_UPDATE = "UPDATE users SET nameUser = ? , passwordUser=? WHERE idUser = ? ";
	private final String SQL_GET_ALL = "SELECT * FROM users";
	private final String SQL_GET = "SELECT * FROM users WHERE ( idUser = ?)";
	
	//PARA ROLES
	private final String SQL_ULTIMOID = "select LAST_INSERT_ID() as ultimo";
	private final String SQL_INSERTR = "insert into users_roles (Roles_idRole,Users_idUser) values(?,?)";
	private final String SQL_DELETERONE = "delete from users_roles where Roles_idRole=? and Users_idUser=?";
	private final String SQL_DELETERALL = "delete from users_roles where Users_idUser=?";
	private final String SQL_GETALLR =
   "select Users_idUser, Roles_idRole,r.nameRole from comics.users_roles inner join comics.roles as r on Roles_idRole=r.idRole where Users_idUser=?";
	
	private final connectionDB conn = connectionDB.getConnection();
	@Override
	public boolean add(User c) {
		try {
			PreparedStatement ps;
			ps = conn.getConn().prepareStatement(SQL_INSERT);
			
			ps.setString(1, c.getUserName());
			ps.setString(2, c.getPassword());
			if (ps.executeUpdate()>0){
				if (c.getRoles().size()>0){
					ps = null;
					ps = conn.getConn().prepareStatement(SQL_ULTIMOID);
			    	ResultSet res;
					res =ps.executeQuery();
					int UltimoId = 0;
					while(res.next()) {
					UltimoId=res.getInt("ultimo");
					}
					ps= null;
					ps = conn.getConn().prepareStatement(SQL_INSERTR);
					for (Role rols : c.getRoles()){
					    ps.setInt(1, rols.getIdRole());
					    ps.setInt(2, UltimoId);
					   if (ps.executeUpdate()==0) break;
					}
					if(ps.executeUpdate()>0) return true;
				}
				else {
					
						return true;
					}		
				
			}
		
			
				
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.closeConnection();
		}
		return false;
	}
	  public boolean Login(String username,String password){
		    PreparedStatement ps;
		    ResultSet rs;
			try {
				ps = conn.getConn().prepareStatement(SQL_LOGIN);
				ps.setString(1, username);
				ps.setString(2, password);
				rs = ps.executeQuery();
			    while (rs.next()){
			    	if(rs.getInt(1)==1){
			    		return true;
			    	}
			    	else{
			    		return false;
			    	}
			    }
			  return false;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			finally {
				conn.closeConnection();
			}
	  }
	@Override
	public boolean update(User c) {
	PreparedStatement ps;
		
		try {
			ps = conn.getConn().prepareStatement(SQL_UPDATE);
			//ps.setString(1, c.getNameRole());
		//	ps.setInt(2, c.getIdRole());
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
			ps = conn.getConn().prepareStatement(SQL_DELETERALL);
			ps.setInt(1, key);			
			if(ps.executeUpdate() > 0) {
				ps = conn.getConn().prepareStatement(SQL_DELETE);
				ps.setInt(1, key);
				if (ps.executeUpdate()>0) return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.closeConnection();
		}
		return false;
	}

	@Override
	public User get(int key) {
		User c = new User();
			
			try {
				
				PreparedStatement ps;
				ResultSet res;
				
				ps = conn.getConn().prepareStatement(SQL_GET);
				ps.setInt(1, key);
				
				res = ps.executeQuery();
				while(res.next()) {
					c.setIdUser(res.getInt("idUser"));
					c.setUserName(res.getString("nameUser"));
					c.setPassword(res.getString("passwordUser"));
				}
				ps=null;
				res= null;
				ps = conn.getConn().prepareStatement(SQL_GETALLR);
				ps.setInt(1, c.getIdUser());
				res = ps.executeQuery();
				while(res.next()) {
					Role r= new Role();
					r.setIdRole(res.getInt("Roles_idRole"));
					r.setNameRole(res.getString("r.nameRole"));
					c.setOneRole(r);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conn.closeConnection();
			}
			return c;
	}
	public User get(String username, String password) {
		User c = new User();
			
			try {
				
				PreparedStatement ps;
				ResultSet res;
				
				ps = conn.getConn().prepareStatement(SQL_GET_ONE);
				ps.setString(1, username);
				ps.setString(2, password);
				res = ps.executeQuery();
				while(res.next()) {
					c.setIdUser(res.getInt("idUser"));
					c.setUserName(res.getString("nameUser"));
					c.setPassword(res.getString("passwordUser"));
				}
				ps=null;
				res= null;
				ps = conn.getConn().prepareStatement(SQL_GETALLR);
				ps.setInt(1, c.getIdUser());
				res = ps.executeQuery();
				while(res.next()) {
					Role r= new Role();
					r.setIdRole(res.getInt("Roles_idRole"));
					r.setNameRole(res.getString("r.nameRole"));
					c.setOneRole(r);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conn.closeConnection();
			}
			return c;
	}

	@Override
	public List<User> getAll() {
	List<User> list = new ArrayList<User>();
		
		try {
			PreparedStatement ps;
			ResultSet res;
			
			ps = conn.getConn().prepareStatement(SQL_GET_ALL);
			res = ps.executeQuery();
			
			while(res.next()) {
				
				User c = new User();
				c.setIdUser(res.getInt("idUser"));
				c.setUserName(res.getString("nameUser"));
				c.setPassword(res.getString("passwordUser"));
				PreparedStatement ps2;
				ResultSet res2;		
				ps2 = conn.getConn().prepareStatement(SQL_GETALLR);
				res2 = ps2.executeQuery();
				while(res.next()) {
					Role r= new Role();
					r.setIdRole(res.getInt("Roles_idRole"));
					r.setNameRole(res.getString("r.nameRole"));
					c.setOneRole(r);
				}
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
