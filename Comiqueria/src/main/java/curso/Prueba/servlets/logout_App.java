package curso.Prueba.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class logout_App
 */
@WebServlet("/logout_App")
public class logout_App extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logout_App() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Boolean adm = (Boolean) request.getSession().getAttribute("esAdmin");
		if (adm != null && adm) {
			request.getRequestDispatcher("cuerpo/seguridad/logout.jsp").forward(request, response);
			return;
		} else {
			response.sendRedirect("/Comiqueria/login_App");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    request.getSession().invalidate();
	    response.sendRedirect("/Comiqueria/login_App");
	
	}

}
