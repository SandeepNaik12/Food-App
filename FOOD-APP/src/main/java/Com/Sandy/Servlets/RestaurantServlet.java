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

@WebServlet("/RestaurantServlet")
public class RestaurantServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RestaurantDaoimpl restaurantDaoimpl = new RestaurantDaoimpl();
        List<Restaurant> allRestaurants = restaurantDaoimpl.getAllRestaurants();
        MenuDaoImpl menuDaoImpl = new MenuDaoImpl();
        List<Menu> distinctMenuItems = menuDaoImpl.getDistinctMenuItems();
        req.setAttribute("UniqueMenuItems", distinctMenuItems);
        
        // Set correct attribute name to match JSP
        req.setAttribute("allrestaurant", allRestaurants);
        req.setAttribute("currentTime", new java.sql.Time(System.currentTimeMillis()));
        

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Restaurant.jsp");
        requestDispatcher.forward(req, resp);
    }
}

