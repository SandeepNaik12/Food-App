package Com.tap;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Com.tap.DaoImpl.DaoImpl;
import Com.tap.Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String phone = req.getParameter("phonenumber");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String query="select * from user where name=? and password=?";boolean islog=false;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jee3", "root", "mysql");
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, name);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				islog=true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(islog)
		{
			res.sendRedirect("INDEX.html");
			
		}else
		{
			res.sendRedirect("login.html");
			
		}
		
		
		User user = new User(name, password, phone, email, address);
		DaoImpl impl = new DaoImpl();
				impl.addUser(user);
	}
}
