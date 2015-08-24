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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		IdComic = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("libro", new comicController().get(IdComic));
		request.getRequestDispatcher("cuerpo/comics/deleteComic.jsp").forward(request, response);			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		new comicController().delete(IdComic);
		response.sendRedirect("/Comiqueria/obtener_Comics");
	}

}
