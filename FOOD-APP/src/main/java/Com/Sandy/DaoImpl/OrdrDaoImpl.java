package Com.Sandy.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import Com.Sandy.Dao.OrderDao;
import Com.Sandy.Database.Dbconnection;
import Com.Sandy.Models.Order;

import java.sql.ResultSet;

public class OrdrDaoImpl implements OrderDao {

    @Override
    public int addOrder(Order order) {
        String insert = "INSERT INTO `order` (userid, restaurantid, orderDate, totalAmount, status, paymentMode) VALUES (?, ?, ?, ?, ?, ?)";
        Connection con = Dbconnection.db();

        try (PreparedStatement ps = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, order.getUserid());
            ps.setInt(2, order.getRestaurantid());
            ps.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            ps.setFloat(4, order.getTotalAmount());
            ps.setString(5, order.getStatus());
            ps.setString(6, order.getPaymentMode());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating order failed, no rows affected.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int orderId = generatedKeys.getInt(1);
                    order.setOrderId(orderId);  // update the Order object
                    return orderId;  // return the generated ID to the caller
                } else {
                    throw new SQLException("Creating order failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;  // indicate failure
    }

	@Override
	public List<Order> getAllOrdersByUserId(int userId) {
		String Orders="Select *from `order` where userid=?";
		List<Order> arrayList = new ArrayList();
		Connection con = Dbconnection.db();
		try {
			PreparedStatement preparedStatement = con.prepareStatement(Orders);
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				Order order = new Order();
				order.setOrderId(rs.getInt("orderId"));
				order.setUserid(rs.getInt("userid"));
				order.setRestaurantid(rs.getInt("restaurantid"));
				order.setOrderDate(rs.getTimestamp("orderDate"));
				order.setTotalAmount(rs.getFloat("totalAmount"));
				order.setStatus(rs.getString("status"));
				order.setPaymentMode(rs.getString("paymentMode"));
				arrayList.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayList;
	}

	

	
	
	
	
    
   
}
