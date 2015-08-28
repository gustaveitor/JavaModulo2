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
 * Servlet implementation class actualizar_Comics
 */
@WebServlet("/actualizar_Comics")
public class actualizar_Comics extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int IdComic;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public actualizar_Comics() {
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
			IdComic = Integer.parseInt(request.getParameter("id"));
			try {
				request.setAttribute("libro", new comicController().get(IdComic));
			} catch (Exception e) {
				request.setAttribute("error", e);
				request.getRequestDispatcher("/Comiqueria/muestra_Error").forward(request, response);
			}
			request.getRequestDispatcher("cuerpo/comics/updateComic.jsp").forward(request, response);

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
		Comic cComic = null;
		try {
			cComic = new comicController().get(IdComic);

			final String Vacio = "";
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
			new comicController().update(cComic);

			response.sendRedirect("/Comiqueria/obtener_Comics");
		} catch (Exception e) {
			request.setAttribute("error", e);
			request.getRequestDispatcher("/Comiqueria/muestra_Error").forward(request, response);
		}
	}

}
