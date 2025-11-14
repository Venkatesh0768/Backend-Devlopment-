

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirsrServlet")
public class FirsrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("This is the First Servlet");
		
	
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		 RequestDispatcher reqDispatcher = request.getRequestDispatcher("/SecondServlet");
//		 reqDispatcher.forward(request, response);
		 reqDispatcher.include(request, response);
		 
		 
		 PrintWriter writer = response.getWriter();
		 writer.println("<h1> This is Servlet One </h1>");
		 writer.close();
		
	}

}
