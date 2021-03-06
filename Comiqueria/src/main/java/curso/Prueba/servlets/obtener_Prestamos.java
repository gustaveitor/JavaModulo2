package curso.Prueba.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.comics.app.Controller.loanController;

/**
 * Servlet implementation class obtener_Prestamos
 */
@WebServlet("/obtener_Prestamos")
public class obtener_Prestamos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public obtener_Prestamos() {
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
			Boolean adm = (Boolean) request.getSession().getAttribute("esAdmin");

			if (adm != null && adm) {
				request.setAttribute("Listado", new loanController().getAll());
				request.getRequestDispatcher("cuerpo/loans/indexLoans.jsp").forward(request, response);

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
		doGet(request, response);
	}

}
