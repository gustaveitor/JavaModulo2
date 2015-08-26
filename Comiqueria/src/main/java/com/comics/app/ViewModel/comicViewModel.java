package com.comics.app.ViewModel;

public class comicViewModel {
	
	int idComic;
	int quantityComic;
	String nameComic;
	String companyComic;
	String reviewComic;
	private Boolean deletable;
	
	
	/*
	 * Getters and Setters.
	 */
	public int getIdComic() {
		return idComic;
	}
	
	public void setIdComic(int idComic) {
		this.idComic = idComic;
	}
	
	public String getNameComic() {
		return nameComic;
	}
	
	public void setNameComic(String nameComic) {
		this.nameComic = nameComic;
	}
	
	public String getCompanyComic() {
		return companyComic;
	}
	
	public void setCompanyComic(String companyComic) {
		this.companyComic = companyComic;
	}
	
	public String getReviewComic() {
		return reviewComic;
	}
	
	public void setReviewComic(String reviewComic) {
		this.reviewComic = reviewComic;
	}
	
	public int getQuantityComic() {
		return quantityComic;
	}

	public void setQuantityComic(int quantityComic) {
		this.quantityComic = quantityComic;
	}
	public Boolean getDeletable() {
		return deletable;
	}
	public void setDeletable(Boolean _deletable) {
		this.deletable = _deletable;
	}
	/*
	 * Builders.
	 */
	public comicViewModel () {
		
	}
	
	public comicViewModel (int _id,String name, String company, String review, int quantity, Boolean _deletable) {
		this.idComic=_id;
		this.nameComic = name;
		this.companyComic = company;
		this.reviewComic = review;
		this.quantityComic = quantity;
		this.deletable=_deletable;
	}
}
