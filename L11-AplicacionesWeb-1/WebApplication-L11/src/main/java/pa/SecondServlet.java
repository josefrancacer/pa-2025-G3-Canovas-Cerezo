package pa;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;

@WebServlet(name = "miServlet", urlPatterns = "/UrlServlet2")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("/WEB-INF/consultarHorarios.html").forward(request,  response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html;charset=UTF-8");
		String asignaturaElegida = request.getParameter("asignatura");
		if(asignaturaElegida.equals("PA")) {
			request.getRequestDispatcher("/WEB-INF/horarioPA.html").forward(request, response);
		}
		else {
			request.getRequestDispatcher("/WEB-INF/errorHorarios.html").forward(request, response);
		}
	}

}


