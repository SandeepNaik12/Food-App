package Com.Sandy.Servlets;

import java.io.IOException;
import java.util.List;

import Com.Sandy.DaoImpl.MenuDaoImpl;
import Com.Sandy.DaoImpl.RestaurantDaoimpl;
import Com.Sandy.Models.Menu;
import Com.Sandy.Models.Restaurant;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalTime;
import java.sql.Time;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Keyword = req.getParameter("Keyword");
		RestaurantDaoimpl restaurantDaoimpl = new RestaurantDaoimpl();
		List<Restaurant> restaurantByKeyword = restaurantDaoimpl.getRestaurantByKeyword(Keyword);
		
		MenuDaoImpl menuDaoImpl = new MenuDaoImpl();
		List<Menu> distinctMenuItems = menuDaoImpl.getDistinctMenuItems();

		 req.setAttribute("currentTime", new java.sql.Time(System.currentTimeMillis()));

		
		req.setAttribute("UniqueMenuItems", distinctMenuItems);
		req.setAttribute("filteredRestaurants",restaurantByKeyword);
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("Restaurant.jsp");
		requestDispatcher.forward(req, resp);
	}
}
