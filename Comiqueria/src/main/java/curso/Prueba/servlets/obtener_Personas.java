package curso.Prueba.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.comics.app.Controller.personController;

/**
 * Servlet implementation class obtener_Personas
 */
@WebServlet("/obtener_Personas")
public class obtener_Personas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public obtener_Personas() {
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
		try {
			request.setAttribute("Listado", new personController().getAll());
			request.getRequestDispatcher("cuerpo/people/indexPerson.jsp").forward(request, response);
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
		doGet(request, response);
	}

}
