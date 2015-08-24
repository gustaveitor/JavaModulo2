package com.comics.app.Comics;

import java.util.Scanner;

import com.comics.app.Controller.*;
import com.comics.app.Model.*;
//import Views.menues;

public class App 
{
    @SuppressWarnings("resource")
	public static void main( String[] args )
    {
    	//Controllers instances
    	comicController comicControl = new comicController();
    	personController personControl = new personController();
    	loanController loanControl = new loanController();
    	
    	//Menu instance
        //menues menu = new menues();
    	
    	//Variables
    	int action = 0;
    	int idcomic = 0;
    	int idloan = 0;
    	int idperson = 0;
    	String username, password, yn, act;
    	char exitMenu = 'n';
    	
    	//Scanner to get the inputs.
    	Scanner input = new Scanner(System.in);
    	
    	//First.
    	System.out.println("Are you Sheldon? y/n : ");
    	act = input.next();
    	
    	if(act.equals("y")) {
    	
    		System.out.println("Username: ");
        	username = input.next();
        	System.out.println("Password");
        	password = input.next();
        	if(personControl.login(username, password)) {
        		
        		System.out.println("Welcome! \n \n");
        		
        		while(exitMenu == 'n') {
            		//Show the menu with the actions.
            	//	menu.menuActions();
            		action = input.nextInt();
        	    	switch (action) {
        	    		case 1:
        	    			//Add comic
        	    			Comic cAdd = new Comic();
        	    			System.out.println("Add new comic: ");
        	    			System.out.println("Comic name: ");
        	    	    	cAdd.setNameComic(input.next());
        	    	    	
        	    	    	System.out.println("Comic company: ");
        	    	    	cAdd.setCompanyComic(input.next());
        	    	    	
        	    	    	System.out.println("Comic review: ");
        	    	    	cAdd.setReviewComic(input.next());
        	    	    	
        	    	    	System.out.println("Comic quantity: ");
        	    	    	cAdd.setQuantityComic(input.nextInt());
        	    	    	if(comicControl.add(cAdd))
        	    	    		System.out.println("Successfully added. \n \n \n \n");
        	    	    	break;
        	    		case 2:
        	    			//Get comics
        	    			System.out.println("\n \n \n \n");
        	            	System.out.println("Listing all the comics: ");
        	    			//menu.returnAllComics();
        	    			System.out.println("\n \n \n \n");
        	    			break;
        	    		case 3:
        	    			//Update comic
        	    			Comic cEdit = new Comic();
        	    			System.out.println("Comics availables to edit: ");
        	    		//	menu.returnAllComics();
        	    			System.out.println("\n \n \n \n");
        	    			System.out.println("Enter the id to edit: ");
        	    			idcomic = input.nextInt();
        	    	    	cEdit = comicControl.get(idcomic);
        	    	    	
        	    	    	System.out.println("The comic to edit is: ");
        	    	    //	menu.printComic(cEdit);
        	    	    	System.out.println("\n \n \n \n");
        	    	    	System.out.println("Enter new name: ");
        	    	    	cEdit.setNameComic(input.next());
        	    	    	
        	    	    	System.out.println("Enter new company: ");
        	    	    	cEdit.setCompanyComic(input.next());
        	    	    	
        	    	    	System.out.println("Enter new quantity: ");
        	    	    	cEdit.setQuantityComic(input.nextInt());
        	    	    	if(comicControl.update(cEdit))
        	    	    		System.out.println("Successfully updated. \n \n \n \n");
        	    	    	break;
        	    		case 4:
        	    			//Delete comic
        	    			Comic cDelete = new Comic();
        	    			System.out.println("**WARNING! - WHEN YOU DELETE A COMIC YOU DELETE THE LOANS INVOLVED**");
        	    			System.out.println("Comics availables to delete: ");
        	    		//	menu.returnAllComics();
        	    			
        	    			System.out.println("Enter the id to DELETE: ");
        	    			idcomic = input.nextInt();
        	    			cDelete = comicControl.get(idcomic);
        	    	    	
        	    	    	System.out.println("The comic to DELETE is: ");
        	    	    //	menu.printComic(cDelete);
        	    	    	
        	    	    	System.out.println("Delete? y/n: ");
        	    	    	yn = input.next();
        	    	    	if(yn.equals("y")) 
        	    	    		if(comicControl.delete(idcomic))   	    			
        	    	    			System.out.println("Successfully deleted. \n \n \n \n");
        	    	    	break;
        	    		case 5:
        	    			//Add person
        	    			Person pAdd = new Person();
        	    			System.out.println("Add new person: ");
        	    			System.out.println("Name: ");
        	    	    	pAdd.setNamePerson(input.next());
        	    	    	
        	    	    	System.out.println("Telephone: ");
        	    	    	pAdd.setTelephonePerson(input.next());
        	    	    	
        	    	    	if(personControl.add(pAdd))
        	    	    		System.out.println("Successfully added. \n \n \n \n");
        	    	    	break;
        	    		case 6:
        	    			//Get person
        	    			System.out.println("\n \n \n \n");
        	            	System.out.println("Listing all the persons: ");
        	    			//menu.returnAllPersons();
        	    			System.out.println("\n \n \n \n");
        	    			break;
        	    		case 7:
        	    			//Update person
        	    			Person pEdit = new Person();
        	    			System.out.println("Persons availables to edit: ");
        	    			//menu.returnAllPersons();
        	    			System.out.println("\n \n \n \n");
        	    			System.out.println("Enter the id to edit: ");
        	    			idperson = input.nextInt();
        	    	    	pEdit = personControl.get(idperson);
        	    	    	
        	    	    	System.out.println("The person to edit is: ");
        	    	    	//menu.printPerson(pEdit);
        	    	    	System.out.println("\n \n \n \n");
        	    	    	System.out.println("Enter new name: ");
        	    	    	pEdit.setNamePerson(input.next());
        	    	    	
        	    	    	System.out.println("Enter new telephone: ");
        	    	    	pEdit.setTelephonePerson(input.next());
        	    	    	
        	    	    	if(personControl.update(pEdit))
        	    	    		System.out.println("Successfully updated. \n \n \n \n");
        	    			break;
        	    		case 8:
        	    			//Delete person
        	    			System.out.println("**WARNING! - WHEN YOU DELETE A PERSON YOU DELETE THE LOANS INVOLVED**");
        	    			System.out.println("Persons availables to delete: ");
        	    			//menu.returnAllPersons();
        	    			
        	    			System.out.println("Enter the id to DELETE: ");
        	    			idperson = input.nextInt();
        	    	    	pEdit = personControl.get(idperson);
        	    	    	
        	    	    	System.out.println("The person to DELETE is: ");
        	    	    	//menu.printPerson(pEdit);
        	    	    	
        	    	    	System.out.println("Delete? y/n: ");
        	    	    	yn = input.next();
        	    	    	if(yn.equals("y")) 
        	    	    		if(personControl.delete(idperson))   	    			
        	    	    			System.out.println("Successfully deleted. \n \n \n \n");
        	    	    	break;
        	    		case 9:
        	    			//Add loan
        	    			Person pLoan = new Person();
        	    			Comic cLoan = new Comic();
        	    			System.out.println("Add Loan. \n \n");
        	    			System.out.println("Select a person: ");
        	    			//menu.returnAllPersons();
        	    			
        	    			System.out.println("Enter the id of the person: ");
        	    			idperson = input.nextInt();
        	    	    	pLoan = personControl.get(idperson);
        	    	    	
        	    	    	System.out.println("Comics availables: ");
        	    			//menu.returnAllComics();
        	    			
        	    			System.out.println("Enter the id of the comic: ");
        	    			idloan = input.nextInt();
        	    			cLoan = comicControl.get(idloan);
        	    			
        	    			System.out.println("Enter the date, dd-mm-yyyy: ");
        	    			String date = input.next();
        	    			
        	    			loanControl.addLoan(cLoan, pLoan, date);
        	    	    	
        	    		case 10:
        	    			//Get loans
        	    			System.out.println("\n \n \n \n");
        	            	System.out.println("Listing all the loans: ");
        	    			//menu.returnAllLoans();
        	    			System.out.println("\n \n \n \n");
        	    			break;
        	    		case 11:
        	    			//Delete loans
        	    			System.out.println("Loans availables to delete: ");
        	    			//menu.returnAllLoans();
        	    			
        	    			System.out.println("Enter the id to DELETE: ");
        	    			idloan = input.nextInt();
        	    	    	        	    	    	
        	    	    	System.out.println("Delete? y/n: ");
        	    	    	yn = input.next();
        	    	    	if(yn.equals("y")) 
        	    	    		if(loanControl.delete(idloan))   	    			
        	    	    			System.out.println("Successfully deleted. \n \n \n \n");
        	    	    	break;
        	    	}
            	}
        	} else {
        		System.out.println("Bad login");
        	}
    	} else if(act.equals("n")) {
    		System.out.println("Welcome friend! \n \n");
    		System.out.println("1. List all the comics. \n \n");
    		action = input.nextInt();
    		switch (action) {
    		case 1:
    			//Get comics
    			System.out.println("\n \n \n \n");
            	System.out.println("Listing all the comics: ");
    		//	menu.returnAllComics();
    			System.out.println("\n \n \n \n");
    			break;
    		}
    	}
    }
}