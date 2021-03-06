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
import com.comics.app.ViewModel.comicViewModel;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Boolean adm = (Boolean) request.getSession().getAttribute("esAdmin");

		try {
			if (adm != null && adm) {
				List<comicViewModel> cListado = new ArrayList<comicViewModel>();
				for (comicViewModel comiques : new comicController().getAll()) {
					if (comiques.getQuantityComic() > 0) {
						cListado.add(comiques);
					}
				}
				request.setAttribute("Id", request.getParameter("id") != null ? request.getParameter("id") : null);
				request.setAttribute("cListado", cListado);
				request.setAttribute("pListado", new personController().getAll());
				request.getRequestDispatcher("cuerpo/loans/insertLoans.jsp").forward(request, response);

			} else {
				response.sendRedirect("/Comiqueria/login_App");
			}
		} catch (Exception e) {
			request.setAttribute("error", e);
		       request.getRequestDispatcher("/Comiqueria/muestra_Error").forward(request,response);
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			int IdPersona = Integer.parseInt(request.getParameter("personaselect"));
			int IdComic = Integer.parseInt(request.getParameter("comicselect"));
			String fecha = request.getParameter("hasta");
			Comic cComic = new comicController().get(IdComic);
			new loanController().addLoan(cComic, new personController().get(IdPersona), fecha);
			cComic.setQuantityComic(cComic.getQuantityComic() - 1);
			new comicController().update(cComic);
			response.sendRedirect("/Comiqueria/obtener_Prestamos");
		} catch (NumberFormatException e) {
			request.setAttribute("error", e);
		       request.getRequestDispatcher("/Comiqueria/muestra_Error").forward(request,response);
		
		} catch (Exception e) {
			request.setAttribute("error", e);
		       request.getRequestDispatcher("/Comiqueria/muestra_Error").forward(request,response);
		
		}
	}

}
