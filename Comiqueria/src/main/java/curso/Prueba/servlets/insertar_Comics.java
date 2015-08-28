package curso.Prueba.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.comics.app.Controller.comicController;
import com.comics.app.Model.Comic;

/**
 * Servlet implementation class insertar_Comics
 */
@WebServlet("/insertar_Comics")
public class insertar_Comics extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public insertar_Comics() {
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
		if (adm != null && adm) {
			try {
				request.setAttribute("Listado", new comicController().getAll());
			} catch (Exception e) {
				request.setAttribute("error", e);
				request.getRequestDispatcher("/Comiqueria/muestra_Error").forward(request, response);

			}
			request.getRequestDispatcher("cuerpo/comics/insertComic.html").forward(request, response);
			return;
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
		final String Vacio = "";
		Comic cComic = new Comic();
		String comicName = Vacio;
		String comicPublisher = Vacio;
		String comicStock = request.getParameter("comicstock");
		String comicReview = Vacio;
		if (request.getParameter("comicname") != null) {
			comicName = request.getParameter("comicname");
		}
		if (request.getParameter("comicpub") != null) {
			comicPublisher = request.getParameter("comicpub");
		}
		if (request.getParameter("comicreview") != null) {
			comicReview = request.getParameter("comicreview");
		}
		cComic.setQuantityComic(Integer.parseInt(comicStock));
		if (comicName != Vacio) {
			cComic.setNameComic(comicName);
		}
		if (comicPublisher != Vacio) {
			cComic.setCompanyComic(comicPublisher);
		}
		if (comicReview != Vacio) {
			cComic.setReviewComic(comicReview);
		}
		try {
			new comicController().add(cComic);

			response.sendRedirect("/Comiqueria/obtener_Comics");
		} catch (Exception e) {
			request.setAttribute("error", e);
			request.getRequestDispatcher("/Comiqueria/muestra_Error").forward(request, response);

		}
	}

}
