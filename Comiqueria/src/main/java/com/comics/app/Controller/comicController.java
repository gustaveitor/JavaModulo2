package com.comics.app.Controller;

import java.util.ArrayList;
import java.util.List;

import com.comics.app.Dao.comicDao;
import com.comics.app.Model.Comic;
import com.comics.app.ViewModel.comicViewModel;

public class comicController {
	
	comicDao comicdao = new comicDao();
	
	public boolean add(Comic c) {
		boolean rta = comicdao.add(c);
		return rta;
	}
	
	public Comic get(int key) {
		Comic c = comicdao.get(key);		
		return c;
	}
	
	public List<comicViewModel> getAll() {
		List<comicViewModel> list = new ArrayList<comicViewModel>();
		for (Comic comic : comicdao.getAll()){
			list.add(
					new comicViewModel(comic.getIdComic()
							,comic.getNameComic()
							,comic.getCompanyComic()
							,comic.getReviewComic()
							,comic.getQuantityComic(),
							comicdao.check(comic.getIdComic())));
		}
		
		return list;
	}
	
	public boolean delete(int key) {
		boolean rta = comicdao.delete(key);		
		return rta;
	}
	
	public boolean update(Comic c) {
		boolean rta = comicdao.update(c);
		return rta;
	}
}