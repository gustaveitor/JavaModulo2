package curso.Prueba.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.comics.app.Controller.userController;
import com.comics.app.Model.User;

/**
 * Servlet implementation class login_App
 */
@WebServlet("/login_App")
public class login_App extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final userController cUser = new userController();
	private final String mensaje = "Login erroneo. Verifique usuario o contraseña";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public login_App() {
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
		if (request.getSession().getAttribute("Usuario") != null) {
			response.sendRedirect("logout_App");
		} else {
			request.getRequestDispatcher("cuerpo/login.jsp").forward(request, response);

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
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			if (cUser.login(username, password)) {
				HttpSession context = request.getSession();
				String[] rols = new String[2];
				User lUsuario = cUser.get(username, password);
				Boolean esadmin = false;
				if (lUsuario.getRoles().size() > 0) {
					for (int i = 0; i < lUsuario.getRoles().size(); i++) {
						rols[i] = lUsuario.getRoles().get(i).getNameRole();
						if (lUsuario.getRoles().get(i).getNameRole().equals("admin")) {
							esadmin = true;
						}
					}
					context.setAttribute("Roles", rols);
				}
				context.setAttribute("esAdmin", esadmin);
				request.removeAttribute("mensaje");
				context.setAttribute("Usuario", lUsuario.getUserName());
				response.sendRedirect("/Comiqueria/index_App");
			} else {
				request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("cuerpo/login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("error", e);
			request.getRequestDispatcher("/Comiqueria/muestra_Error").forward(request, response);

		}
	}

}
