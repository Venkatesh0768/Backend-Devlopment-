import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Model {
	private String name;
	private String email;
	private String password;
	private String city;
	private Connection connect;
	private PreparedStatement pstmt;
	private int row;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public int getRegister() {
    JdbcUtil jdbc = new JdbcUtil();
    try {
        connect = jdbc.getDBConnection();

        String sql = "INSERT INTO users (full_name, email, password, city) VALUES (?, ?, ?, ?)";
        pstmt = connect.prepareStatement(sql);

        pstmt.setString(1, name);
        pstmt.setString(2, email);
        pstmt.setString(3, password);
        pstmt.setString(4, city);

        row = pstmt.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            jdbc.closeResources(connect, pstmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return row;
}

	
	

}
