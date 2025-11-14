

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String city = request.getParameter("city");
		
		Model model = new Model();
		model.setName(name);
		model.setEmail(email);
		model.setPassword(password);
		model.setCity(city);
		
		
		int row  = model.getRegister();
		if(row == 0) {
			response.sendRedirect("/SpringMVC/failure.jsp");
		}else {
			response.sendRedirect("/SpringMVC/success.jsp");
		}
		
		
	}

}
