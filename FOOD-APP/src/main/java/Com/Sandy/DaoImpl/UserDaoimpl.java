package Com.Sandy.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import Com.Sandy.Dao.UserDao;
import Com.Sandy.Database.Dbconnection;
import Com.Sandy.Models.User;

public class UserDaoimpl implements UserDao {
	int executeUpdate;

	@Override
	public int addUser(User user) {
		String Insert="insert into user( username, password, email, phone, address, created_login_date)values(?,?,?,?,?,?)";
		Connection con = Dbconnection.db();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		String creaed_date = simpleDateFormat.format(user.getCreated_login_date());
		try {
			PreparedStatement preparedStatement = con.prepareStatement(Insert);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPhone());
			preparedStatement.setString(5, user.getAddress());
			preparedStatement.setString(6,creaed_date);
			 executeUpdate = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return executeUpdate;
		
	}

	@Override
	public User loginUser(String email, String password) {
		User user = null;
		String login="select *from user where email=? and password=?";
		Connection con = Dbconnection.db();
		
		try {
			PreparedStatement preparedStatement = con.prepareStatement(login);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
		ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				 user = new User();
				 user.setUserid(rs.getInt("userid"));
				 user.setRole(rs.getString("role"));
				 user.setName(rs.getString("username"));
				 user.setPassword(rs.getString("password"));
				 user.setEmail(rs.getString("email"));
				 user.setPhone(rs.getString("phone"));
				 user.setAddress(rs.getString("address"));
				
				 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	public static boolean updateUserEmailAndPhone(int userId, String email, String phone) {
        boolean status = false;
        try {
            Connection con =Dbconnection.db();
            String sql = "UPDATE user SET email=?, phone=? WHERE userid=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, phone);
            ps.setInt(3, userId);
            status = ps.executeUpdate() > 0;
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

	@Override
	public boolean updateSettings(int userid,String name, String password, String email, String phone,String address) {
		// TODO Auto-generated method stub
		String Update="update user set username=?,password=?,email=?,phone=?,address=? where userid=?";
		Connection con = Dbconnection.db();
		try {
			PreparedStatement preparedStatement = con.prepareStatement(Update);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, phone);
			preparedStatement.setString(5, address);
			preparedStatement.setInt(6, userid);
			return  preparedStatement.executeUpdate()>0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	

}
