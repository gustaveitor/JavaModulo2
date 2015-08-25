package curso.Prueba.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.comics.app.Controller.loanController;
import com.comics.app.Controller.comicController;
import com.comics.app.Controller.personController;
import com.comics.app.Model.Comic;

/**
 * Servlet implementation class insertar_Prestamos
 */
@WebServlet("/insertar_Prestamos")
public class insertar_Prestamos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertar_Prestamos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Comic> cListado = new ArrayList<Comic>();
		for (Comic comiques: new comicController().getAll() ){
			if (comiques.getQuantityComic() > 0){
			cListado.add(comiques);
			}
		}
		request.setAttribute("Id",request.getParameter("id")!=null?request.getParameter("id"):null);
		request.setAttribute("cListado",cListado );
		request.setAttribute("pListado", new personController().getAll());
		request.getRequestDispatcher("cuerpo/loans/insertLoans.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    int IdPersona = Integer.parseInt(request.getParameter("personaselect"));
	    int IdComic = Integer.parseInt(request.getParameter("comicselect"));
	    String fecha =request.getParameter("hasta");
		Comic cComic =  new comicController().get(IdComic);
	   new loanController()
	   .addLoan(
			   cComic
			   , new personController().get(IdPersona)
			   ,fecha);
	   cComic.setQuantityComic(cComic.getQuantityComic()-1);
	   new comicController().update(cComic);
	   response.sendRedirect("/Comiqueria/obtener_Prestamos");
	}

}
