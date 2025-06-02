package Com.Sandy.Servlets;

import java.io.IOException;
import java.util.List;

import Com.Sandy.DaoImpl.OrdrDaoImpl;
import Com.Sandy.DaoImpl.UserDaoimpl;
import Com.Sandy.Models.Order;
import Com.Sandy.Models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/UserProfileServlet")
public class UserProfileServlet extends HttpServlet{
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String section = req.getParameter("section");
			HttpSession session = req.getSession();
			User user = (User)session.getAttribute("user");
			
			
			if("orders".equals(section))
			{
				OrdrDaoImpl ordrDaoImpl = new OrdrDaoImpl();
				List<Order> allOrdersByUserId = ordrDaoImpl.getAllOrdersByUserId(user.getUserid());
		
				session.setAttribute("orders", allOrdersByUserId);
			}
			

	        req.setAttribute("section", section);
	        req.getRequestDispatcher("UserProfileContent.jsp").forward(req, resp);
		}
}
