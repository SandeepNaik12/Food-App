package Com.Sandy.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Com.Sandy.Dao.OrderItemDao;
import Com.Sandy.Database.Dbconnection;
import Com.Sandy.Models.OrderItem;

public class OrderItmDaoImpl implements OrderItemDao {

	@Override
	public void addOrderItem(OrderItem orderitem) {
		final String INSERT="insert into orderitem( orderId, menuId,price,quantity,totalAmount) values(?,?,?,?,?)";
		Connection con = Dbconnection.db();
		try {
			PreparedStatement preparedStatement = con.prepareStatement(INSERT);
			preparedStatement.setInt(1, orderitem.getOrderId());
			preparedStatement.setInt(2, orderitem.getMenuId());
			preparedStatement.setFloat(3, orderitem.getPrice());
			preparedStatement.setInt(4, orderitem.getQuantity());
			preparedStatement.setFloat(5, orderitem.getTotalAmount());
			int executeUpdate = preparedStatement.executeUpdate();
			System.out.println(executeUpdate+"from orderitem");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
