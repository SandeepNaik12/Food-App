package Com.tap.DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Com.tap.Dao.Dao;
import Com.tap.Model.User;

public class DaoImpl implements Dao {

	String INSERT="insert into user(name,password,phone_number,email,address)values(?,?,?,?,?)";
	@Override
	public void addUser(User user) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jee3", "root", "mysql");
			PreparedStatement preparedStatement = con.prepareStatement(INSERT);
			preparedStatement.setString(1,user.getName());
			preparedStatement.setString(2,user.getPassword());
			preparedStatement.setString(3,user.getPhone_number());
			preparedStatement.setString(4,user.getEmail());
			preparedStatement.setString(5,user.getAddress());
			int executeUpdate = preparedStatement.executeUpdate();
			
		
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

		
}
