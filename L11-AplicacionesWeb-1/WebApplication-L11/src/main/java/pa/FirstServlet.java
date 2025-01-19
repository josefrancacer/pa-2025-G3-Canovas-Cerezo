package pa;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(name = "miServlet", urlPatterns = "/UrlServlet")
public class FirstServlet extends HttpServlet{
		private static final long serialVersionUID = 1L;
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
			String contexto = request.getContextPath();
			String ruta = request.getRequestURI();
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			
			out.println ("<!DOCTYPE html>"); 
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet MiServlet</title>");
			out.println("</head>"); out.println ("<body>");
			out.println("<h1>Ejemplo de servlet</h1>");
			out.println("<p>Mi context-root es: "+contexto+" </p>");
			out.println("<p>Mi ruta de acceso es: "+ruta+" </p>");
			out.println("<p>Un servlet es una clase java</p>");
			out.println("<p> Pulsa el siguiente enlace para volver al inicio: </p>");
			out.println("<a href=paginaInicial.html>Home</a>");
			out.println("</body>");
			out.println("</html>");
		
		}
		
	}
	

