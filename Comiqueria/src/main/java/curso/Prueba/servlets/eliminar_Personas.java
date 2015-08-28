package curso.Prueba.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.comics.app.Controller.personController;

/**
 * Servlet implementation class eliminar_Personas
 */
@WebServlet("/eliminar_Personas")
public class eliminar_Personas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int IdPersona;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public eliminar_Personas() {
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
			IdPersona = Integer.parseInt(request.getParameter("id"));
			try {
				request.setAttribute("persona", new personController().get(IdPersona));
			} catch (Exception e) {
				request.setAttribute("error", e);
			       request.getRequestDispatcher("/Comiqueria/muestra_Error").forward(request,response);
			
			}
			request.getRequestDispatcher("cuerpo/people/deletePerson.jsp").forward(request, response);
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
			new personController().delete(IdPersona);
		} catch (Exception e) {
			request.setAttribute("error", e);
		       request.getRequestDispatcher("/Comiqueria/muestra_Error").forward(request,response);
		
		}
		response.sendRedirect("/Comiqueria/obtener_Personas");
	}

}
