package com.comics.app.Controller;

import java.util.List;

import com.comics.app.Dao.loanDao;
import com.comics.app.Model.Comic;
import com.comics.app.Model.Loan;
import com.comics.app.Model.Person;

public class loanController {
	
	loanDao loandao = new loanDao();
	
	public boolean addLoan(Comic c, Person p, String d) throws Exception {
		Loan l = new Loan();
		l.setComic(c);
		l.setPerson(p);
		l.setDate(d);
		boolean rta;
		
			rta = loandao.add(l);
		return rta;
		
		
	}
	public boolean updateLoan(Loan l) throws Exception{
		boolean rta = loandao.update(l);
		return rta;
	}
	public List<Loan> getAll() throws Exception {
		List<Loan> list = loandao.getAll();
		return list;
	}
	
	public boolean delete(int key) throws Exception {
		boolean rta = loandao.delete(key);		
		return rta;
	}
	
	public Loan get (int key) throws Exception {
		Loan l = new Loan();
		l = loandao.get(key);
		return l;
	}
}
