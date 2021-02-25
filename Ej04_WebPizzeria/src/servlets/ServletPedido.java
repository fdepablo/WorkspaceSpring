package servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.entidades.Pedido;
import modelo.entidades.Pizza;
import modelo.entidades.Usuario;
import modelo.negocio.GestorPedido;

/**
 * Servlet implementation class ServletPedido
 */
@WebServlet("/ServletPedido")
public class ServletPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		String telefono = request.getParameter("telefono");
		String direccion = request.getParameter("direccion");
		
		String tamanio = request.getParameter("tamanioPizza");
		
		String[] ingredientes = request.getParameterValues("ingredientes");
		List<String> listaIngredientes = Arrays.asList(ingredientes);
		
		Usuario usuario = new Usuario(nombre, password, direccion, telefono);
		Pizza pizza = new Pizza(tamanio, listaIngredientes);
		
		GestorPedido gp = new GestorPedido();
		int precioTotal = gp.calcularPrecio(pizza);
		Pedido pedido = new Pedido(usuario, pizza, precioTotal);
		
		if (gp.validarPedido(pedido)) {
			RequestDispatcher rd = request.getRequestDispatcher("detallesPedido.jsp");
			
			request.setAttribute("pedido", pedido);
			
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("principal.jsp");
			
			request.setAttribute("error", "Telefono o direccion son obligatorios");
			
			rd.forward(request, response);
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
