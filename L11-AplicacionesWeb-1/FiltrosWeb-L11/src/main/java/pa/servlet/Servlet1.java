package pa.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pa.peliculas.*;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(name="servlet1", urlPatterns = "/servletMasVotos")
public class Servlet1 extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ListadosPeliculas lp = new ListadosPeliculas();
		String [] masVotadas = lp.peliculasMasVotadas(lp.peliculasDisponibles());
		
		request.setAttribute("primera", masVotadas[0]);
		request.setAttribute("segunda", masVotadas[1]);
		request.setAttribute("tercera", masVotadas[2]);
		request.setAttribute("votadas", "más votadas");
		
		request.getRequestDispatcher("WEB-INF/listadoPeliculas.jsp").forward(request, response);
		
		
	}

}
