package com.comics.app.Model;

	public class Role {
	 private int idRole;
	 private String nameRole;
	 public int getIdRole(){
		 return idRole;
	 }
	 public String getNameRole(){
		 return nameRole;
	 }
	 public void setIdRole(int key){
		 idRole=key;
	 }
	 public void setNameRole(String key){
		 nameRole=key;
	 }
	 public Role(){
		 
	 }
	 public Role(String _role){
		 this.nameRole=_role;
	 }
}
