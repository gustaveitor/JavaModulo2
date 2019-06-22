package com.comics.app.Controller;
import java.util.ArrayList;
import java.util.List;
import com.comics.app.Dao.comicDao;
import com.comics.app.Model.Comic;
import com.comics.app.ViewModel.comicViewModel;

public class comicController {

	comicDao comicdao = new comicDao();

	public boolean add(Comic c) throws Exception {
		boolean rta = false;
		try {
			rta = comicdao.add(c);
			return rta;

		} catch (Exception e) {
			throw e;
		}
	}

	public Comic get(int key) throws Exception {
		Comic c;
		try {
			c = comicdao.get(key);
			return c;
		} catch (Exception e) {
			throw e;
		}
	}

	public List<comicViewModel> getAll() throws Exception {
		List<comicViewModel> list = new ArrayList<comicViewModel>();

		for (Comic comic : comicdao.getAll()) {
			list.add(new comicViewModel(comic.getIdComic(), comic.getNameComic(), comic.getCompanyComic(),
					comic.getReviewComic(), comic.getQuantityComic(), comicdao.check(comic.getIdComic())));
		}
		return list;
	}

	public boolean delete(int key) throws Exception {
		boolean rta;
		try {
			rta = comicdao.delete(key);
			return rta;
		} catch (Exception e) {
			throw e;
		}
	}

	public boolean update(Comic c) throws Exception {
		boolean rta;
		try {
			rta = comicdao.update(c);
			return rta;
		} catch (Exception e) {
			throw e;
		}
	}
}