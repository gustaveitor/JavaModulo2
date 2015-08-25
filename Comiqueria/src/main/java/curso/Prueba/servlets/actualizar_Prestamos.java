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

/**
 * Servlet implementation class actualizar_Prestamos
 */
@WebServlet("/actualizar_Prestamos")
public class actualizar_Prestamos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       int IdLoan;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public actualizar_Prestamos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Comic> cListado = new ArrayList<Comic>();
		IdLoan =Integer.parseInt( request.getParameter("id"));
		Loan cLoan = new loanController().get(IdLoan);
		for (Comic comiques: new comicController().getAll() ){
			if (comiques.getIdComic()==cLoan.getComic().getIdComic() || comiques.getQuantityComic() > 0){
			cListado.add(comiques);
			}
		}
		
		request.setAttribute("cListado",cListado );
		request.setAttribute("cloan",cLoan);
		request.setAttribute("pListado", new personController().getAll());
		request.getRequestDispatcher("cuerpo/loans/updateLoans.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Loan cLoan = new loanController().get(IdLoan);
		Comic cComic_old = cLoan.getComic();
		comicController lComic = new comicController();
		   int IdPersona = Integer.parseInt(request.getParameter("personaselect"));
		    int IdComic = Integer.parseInt(request.getParameter("comicselect"));
		    String fecha =request.getParameter("hasta");
			Comic cComic =  lComic.get(IdComic);
			cLoan.setComic(cComic);
			cLoan.setDate(fecha);
			cLoan.setPerson(new personController().get(IdPersona));
			if(cComic_old.getIdComic() !=cComic.getIdComic()){
				cComic_old.setQuantityComic(cComic_old.getQuantityComic()+1);
				cComic.setQuantityComic(cComic.getQuantityComic()-1);
				lComic.update(cComic);
				lComic.update(cComic_old);
			}
		   new loanController().updateLoan(cLoan);
		   response.sendRedirect("/Comiqueria/obtener_Prestamos");
	}

}
