package Com.Sandy.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.sql.Timestamp;

import Com.Sandy.DaoImpl.RestaurantDaoimpl;
import Com.Sandy.Models.Restaurant;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RestaurantRegisterServlet")
public class RestaurantRegisterServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String cuisinetype = req.getParameter("cuisinetype");
		String deliverytime = req.getParameter("deliverytime");
		String address = req.getParameter("address");
		 float rating = Float.parseFloat(req.getParameter("rating"));
		boolean isactive = Boolean.parseBoolean(req.getParameter("isactive"));
		String imagepath = req.getParameter("imagepath");
		String optime = req.getParameter("openingtime");
		String clstime = req.getParameter("closingtime");
		
		if(optime!=null && optime.length()==5)
		{
			optime+=":00";
		}
		if(clstime!=null && clstime.length()==5)
		{
			clstime+=":00";
		}
		
		Time openingtime = Time.valueOf(optime);
		Time closingtime = Time.valueOf(clstime);
		PrintWriter out = resp.getWriter();
		out.println("hi form");
		Restaurant restaurant = new Restaurant(name, cuisinetype, deliverytime, address, rating, isactive, imagepath, 0, openingtime, closingtime);
		System.out.println(restaurant);
		RestaurantDaoimpl restaurantDaoimpl = new RestaurantDaoimpl();
		System.out.println(restaurantDaoimpl);
		restaurantDaoimpl.addRestaurant(restaurant);
	}
}
