package curso.Prueba.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.comics.app.Controller.comicController;
import com.comics.app.Controller.loanController;
import com.comics.app.Controller.personController;
import com.comics.app.Model.Comic;
import com.comics.app.Model.Loan;
import com.comics.app.ViewModel.comicViewModel;

/**
 * Servlet implementation class eliminar_Prestamos
 */
@WebServlet("/eliminar_Prestamos")
public class eliminar_Prestamos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       int IdLoan;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public eliminar_Prestamos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IdLoan =Integer.parseInt( request.getParameter("id"));
		Loan cLoan = new loanController().get(IdLoan);
		List<comicViewModel> cListado = new ArrayList<comicViewModel>();
		for (comicViewModel comiques : new comicController().getAll() ){
			if (comiques.getIdComic()==cLoan.getComic().getIdComic() || comiques.getQuantityComic() > 0){
			cListado.add(comiques);
			}
		}
		
		request.setAttribute("cListado",cListado );
		request.setAttribute("cloan",cLoan);
		request.setAttribute("pListado", new personController().getAll());
		request.getRequestDispatcher("cuerpo/loans/deleteLoans.jsp").forward(request, response);
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Loan cLoan = new loanController().get(IdLoan);
		Comic cComic = cLoan.getComic();
		cComic.setQuantityComic(cLoan.getComic().getQuantityComic() +1);
		new comicController().update(cComic) ;
		new loanController().delete(cLoan.getIdLoan());
		 
		
		 response.sendRedirect("/Comiqueria/obtener_Prestamos");
		
	}

}
