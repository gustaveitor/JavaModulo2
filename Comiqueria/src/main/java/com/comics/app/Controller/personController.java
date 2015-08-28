package com.comics.app.Controller;

import java.util.ArrayList;
import java.util.List;

import com.comics.app.Model.Person;
import com.comics.app.ViewModel.personViewModel;
import com.comics.app.Dao.personDao;

public class personController {
	
	personDao persondao = new personDao();
	
	
	public boolean add(Person c)  throws Exception {
		boolean rta = persondao.add(c);
		return rta;
	}
	
	public Person get(int key) throws Exception {
		Person p = persondao.get(key);		
		return p;
	}
	
	public List<personViewModel> getAll() throws Exception {
		List<personViewModel> list =new ArrayList<personViewModel>();
		for(Person person : persondao.getAll()){
			list.add(new personViewModel(
					person.getIdPerson(),
					person.getNamePerson(),
					person.getTelephonePerson(),
					persondao.check(person.getIdPerson())
					));
		}
		return list;
	}
	
	public boolean delete(int key) throws Exception {
		boolean rta = persondao.delete(key);		
		return rta;
	}
	
	public boolean update(Person p) throws Exception  {
		boolean rta = persondao.update(p);
		return rta;
	}
}