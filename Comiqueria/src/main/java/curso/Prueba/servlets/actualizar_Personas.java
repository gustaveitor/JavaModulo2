package curso.Prueba.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.comics.app.Controller.personController;
import com.comics.app.Model.Person;

/**
 * Servlet implementation class actualizar_Personas
 */
@WebServlet("/actualizar_Personas")
public class actualizar_Personas extends HttpServlet {
	private static final long serialVersionUID = 1L;
    int IdPersona;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public actualizar_Personas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		IdPersona = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("persona", new personController().get(IdPersona));
		request.getRequestDispatcher("cuerpo/people/updatePerson.jsp").forward(request, response);	
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Person cPerson = new personController().get(IdPersona);
		final String  Vacio = "";
	
		String personName =Vacio;
	    String personTelephone =Vacio;
	   
	    if (request.getParameter("personname")!=null){
	    	personName =	request.getParameter("personname");
	    }
	    if (request.getParameter("persontel") !=null)
	    {
	    	personTelephone = request.getParameter("persontel");
	    }
	
	   
	    if (personName!= Vacio){
	    	cPerson.setNamePerson(personName);
	    }
	    if (personTelephone!=Vacio)
	    {
	    	cPerson.setTelephonePerson(personTelephone);
	    }
	    new personController().update(cPerson);
		response.sendRedirect("/Comiqueria/obtener_Personas");
	}

}
