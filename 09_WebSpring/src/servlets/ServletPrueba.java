package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import objetos.Mensaje;

/**
 * Servlet implementation class ServletPrueba
 */
@WebServlet("/ServletPrueba")
public class ServletPrueba extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPrueba() {
        super();
        // TODO Auto-generated constructor stub
    }

    private ApplicationContext context;
    //Se inicia una sola vez cuando se crea el servlet
    //recordar que los servlets son sigleton
	@Override
	public void init() throws ServletException {
		context = WebApplicationContextUtils
					.getRequiredWebApplicationContext
					(getServletContext());
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Mensaje mensajeSingleton = 
				context.getBean("mensajeSingleton",Mensaje.class);
		Mensaje mensajePrototype = 
				context.getBean("mensajePrototype",Mensaje.class);
		Mensaje mensajePrototype2 = 
				context.getBean("mensajePrototype",Mensaje.class);
		Mensaje mensajeRequest = 
				context.getBean("mensajeRequest",Mensaje.class);
		Mensaje mensajeRequest2 = 
				context.getBean("mensajeRequest",Mensaje.class);
		Mensaje mensajeSession = 
				context.getBean("mensajeSession",Mensaje.class);
		
		request.setAttribute("ms", mensajeSingleton);
		request.setAttribute("mp1", mensajePrototype);
		request.setAttribute("mp2", mensajePrototype2);
		request.setAttribute("mr1", mensajeRequest);
		request.setAttribute("mr2", mensajeRequest2);
		request.setAttribute("msession", mensajeSession);
		
		request.getRequestDispatcher("pagina.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
