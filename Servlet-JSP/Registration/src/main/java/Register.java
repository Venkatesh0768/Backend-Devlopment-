

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
		String upassword = request.getParameter("password");
		String city = request.getParameter("city");
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/servlet";
			String user = "root";
			String password = "Realme6G90T";
			
			Connection connect = DriverManager.getConnection(url , user, password);
			PreparedStatement pstmt = connect.prepareStatement(
				    "INSERT INTO users (full_name, email, password, city) VALUES (?, ?, ?, ?)"
				);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, upassword);
			pstmt.setString(4, city);
			

			int rows = pstmt.executeUpdate();
			
			PrintWriter writer = response.getWriter();
			
			if(rows != 0 ) {
				writer.println("The user registered Successfully");
			}else {
				writer.println("The user not registered Successfully");
			}
			
			pstmt.close();
			connect.close();
			

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
