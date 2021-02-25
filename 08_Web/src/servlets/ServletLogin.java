package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.entidades.Persona;
import modelo.negocio.GestorPersonas;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Entrando en el servlet").append(request.getContextPath());
		String nombre = request.getParameter("nombre");
		GestorPersonas gp = new GestorPersonas();
		Persona p = new Persona();
		p.setNombre(nombre);
		boolean correcto = gp.validar(p);
		if(correcto) {
			RequestDispatcher rd = 
					request.getRequestDispatcher("principal.jsp");
			request.setAttribute("respuesta", "esto es una prueba");
			request.setAttribute("persona", p);
			request.getSession().setAttribute("personaSession", p);
			request.getServletContext().setAttribute("persona", p);
			rd.forward(request, response);
			
		}else {
			response.sendRedirect("index.html");
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
