package Com.Sandy.Servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import Com.Sandy.DaoImpl.OrderItmDaoImpl;
import Com.Sandy.DaoImpl.OrdrDaoImpl;
import Com.Sandy.Models.Cart;
import Com.Sandy.Models.CartItem;
import Com.Sandy.Models.Order;
import Com.Sandy.Models.OrderItem;
import Com.Sandy.Models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		User user = (User)session.getAttribute("user");
		
		
		if(cart!=null && user !=null && !cart.getItems().isEmpty())
		{
			String payemntMethod = req.getParameter("paymentMethod");
			Order order = new Order();
			order.setUserid(user.getUserid());
			order.setRestaurantid((int)session.getAttribute("restaurantId"));
			order.setOrderDate(new Timestamp(new Date().getTime()));
			order.setPaymentMode(payemntMethod);
			order.setStatus("pending");
			order.setTotalAmount(cart.getTotal());
			OrdrDaoImpl ordrDaoImpl = new OrdrDaoImpl();
			int genratedOrdrId = ordrDaoImpl.addOrder(order);
			
			for(CartItem item:cart.getItems().values())
			{
				int menuId = item.getMenuId();
				float price = item.getPrice();
				System.out.println(price+" orderSrvlet");
				int quantity = item.getQuantity();
				System.out.println(quantity+"ordwer servletn  q");
				float total=price*quantity;
				OrderItem orderItem = new OrderItem(genratedOrdrId, menuId, price, quantity, total);
				OrderItmDaoImpl orderItmDaoImpl = new OrderItmDaoImpl();
				orderItmDaoImpl.addOrderItem(orderItem);
			}
			session.removeAttribute("cart");
			session.setAttribute("order", order);
			resp.sendRedirect("OrderPlaced.jsp");
		}
		
	}
}
