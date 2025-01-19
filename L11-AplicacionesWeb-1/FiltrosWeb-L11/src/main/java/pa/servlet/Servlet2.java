package pa.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import pa.peliculas.ListadosPeliculas;

@WebServlet(name="servlet2", urlPatterns = "/servletMenosVotos")
	public class Servlet2 extends HttpServlet {
		private static final long serialVersionUID = 1L;
		public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			ListadosPeliculas lp = new ListadosPeliculas();
			String [] menosVotadas = lp.peliculasMenosVotadas(lp.peliculasDisponibles());
			
			request.setAttribute("primera", menosVotadas[0]);
			request.setAttribute("segunda", menosVotadas[1]);
			request.setAttribute("tercera", menosVotadas[2]);
			request.setAttribute("votadas", "menos votadas");
			
			request.getRequestDispatcher("WEB-INF/listadoPeliculas.jsp").forward(request, response);
			
		}

	}

