package com.comics.app.Classes;

public  class exceptionConverter {

	public static Exception getException(String key , Exception e){
		Exception ex = new Exception("Error: " +key , e);
    	return ex;	
	}
}
