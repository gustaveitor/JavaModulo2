package com.comics.app.ViewModel;

public class personViewModel {
	private int idPerson;
	private String namePerson;
	private String telephonePerson;
	private Boolean deletable;
	
	/*
	 * Getters and Setters
	 */
	public int getIdPerson() {
		return idPerson;
	}
	
	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}
	
	public String getNamePerson() {
		return namePerson;
	}
	
	public void setNamePerson(String namePerson) {
		this.namePerson = namePerson;
	}
	
	public String getTelephonePerson() {
		return telephonePerson;
	}
	
	public void setTelephonePerson(String telephonePerson) {
		this.telephonePerson = telephonePerson;
	}

	public Boolean getDeletable() {
		return deletable;
	}
	public void setDeletable(Boolean _deletable) {
		this.deletable = _deletable;
	}

	/*
	 * Builders
	 */
	public personViewModel () {
		
	}
	
	public personViewModel(int _id,String name, String telephone, Boolean _deletable) {
		this.idPerson=_id;
		this.namePerson = name;
		this.telephonePerson = telephone;
		this.deletable=_deletable;
	}
}
