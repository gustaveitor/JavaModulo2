package com.comics.app.Model;

import java.util.ArrayList;
import java.util.List;

public class User {
	private int idUser;
	private String userNameUser;
	private String passwordUser;
	private List<Role> rolesUser =new ArrayList<Role>();
	public int getIdUser() {
		return idUser;
	}
	public String getUserName(){
		return userNameUser;
	}
	public String getPassword(){
		return passwordUser;
	}
	public List<Role> getRoles(){
		return rolesUser;
	}
	public void setOneRole(Role key){
		rolesUser.add(key);
	}
	public void setIdUser(Integer key) {
		idUser=key;
	}
	public void setUserName(String key){
		userNameUser = key;
	}
	public void setPassword(String key){
	passwordUser=key;
	}
	public void setRoles(List<Role> key){
	rolesUser=key;
	}	
	public User() {
		
	}	
	//Constructor para no tener que llenarlo despues con toda las cosas esas
	public User(String usname, String uspass, List<Role> usroles) {
		this.userNameUser=usname;
		this.passwordUser=uspass;
		this.rolesUser=usroles;
	}
}
