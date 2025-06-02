package Com.Sandy.Dao;


import java.util.List;

import Com.Sandy.Models.Order;

public interface OrderDao {
		int addOrder(Order order);
		List<Order> getAllOrdersByUserId(int userId);
		
}
