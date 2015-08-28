package curso.Prueba.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.comics.app.Controller.comicController;

/**
 * Servlet implementation class eliminar_Comics
 */
@WebServlet("/eliminar_Comics")
public class eliminar_Comics extends HttpServlet {
	int IdComic;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public eliminar_Comics() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Boolean adm = (Boolean) request.getSession().getAttribute("esAdmin");

		if (adm != null && adm) {
			IdComic = Integer.parseInt(request.getParameter("id"));
			try {
				request.setAttribute("libro", new comicController().get(IdComic));
			} catch (Exception e) {
				request.setAttribute("error", e);
			       request.getRequestDispatcher("/Comiqueria/muestra_Error").forward(request,response);
			
			}
			request.getRequestDispatcher("cuerpo/comics/deleteComic.jsp").forward(request, response);

		} else {
			response.sendRedirect("/Comiqueria/login_App");
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
			new comicController().delete(IdComic);
		} catch (Exception e) {
			request.setAttribute("error", e);
		       request.getRequestDispatcher("/Comiqueria/muestra_Error").forward(request,response);
		
		}
		response.sendRedirect("/Comiqueria/obtener_Comics");
	}

}
