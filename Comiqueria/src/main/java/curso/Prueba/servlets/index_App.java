package curso.Prueba.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.comics.app.Controller.comicController;
import com.comics.app.ViewModel.comicViewModel;

/**
 * Servlet implementation class index_App
 */
@WebServlet("/index_App")
public class index_App extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public index_App() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<comicViewModel> Comiques = new ArrayList<comicViewModel>();
		try {
			for (comicViewModel p : new comicController().getAll()) {
				if (p.getQuantityComic() > 0) {
					Comiques.add(p);
				}
			}

			try {
				request.setAttribute("Listado", Comiques);
				request.getRequestDispatcher("cuerpo/index.jsp").forward(request, response);
			} catch (Exception e) {

				PrintWriter out = response.getWriter();
				out.println(e.getMessage());
			}
		} catch (Exception e1) {
			request.setAttribute("error", e1);
			request.getRequestDispatcher("/Comiqueria/muestra_Error").forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
