package Com.Sandy.Servlets;

import java.io.IOException;
import java.util.List;

import Com.Sandy.DaoImpl.MenuDaoImpl;
import Com.Sandy.Models.Menu;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Menuservlet")
public class MenuServlet extends HttpServlet{
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			int restaurantid = Integer.parseInt(req.getParameter("restaurantId"));
			System.out.println(restaurantid+"from menu servlet");
			req.setAttribute("restaurantId", restaurantid);
			MenuDaoImpl menuDaoImpl = new MenuDaoImpl();
			List<Menu> menuById = menuDaoImpl.getMenuById(restaurantid);
			
			req.setAttribute("menus", menuById);
			req.setAttribute("currentTime", new java.sql.Time(System.currentTimeMillis()));
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("Menu.jsp");
			requestDispatcher.forward(req, resp);
		}
}
