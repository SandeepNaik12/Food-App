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
import jakarta.servlet.http.HttpSession;
import java.time.LocalTime;
import java.sql.Time;
@WebServlet("/FilterRestaurantServlet")
public class FilterRestaurantServlet extends HttpServlet{
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			 String itemName = req.getParameter("itemName");
			 
			    RestaurantDaoimpl dao = new RestaurantDaoimpl();
			    MenuDaoImpl menuDao = new MenuDaoImpl();

			    List<Restaurant> filtered = dao.getRestaurantsByMenuItem(itemName);
			    List<Restaurant> allRestaurants = dao.getAllRestaurants();
			    List<Menu> uniqueMenuItems = menuDao.getDistinctMenuItems();

			    req.setAttribute("currentTime", new java.sql.Time(System.currentTimeMillis()));

			    
			    req.setAttribute("filteredRestaurants", filtered);
			    req.setAttribute("allrestaurant", allRestaurants);
			    req.setAttribute("UniqueMenuItems", uniqueMenuItems);

			    RequestDispatcher dispatcher = req.getRequestDispatcher("Restaurant.jsp");
			    dispatcher.forward(req, resp);
		}
}
