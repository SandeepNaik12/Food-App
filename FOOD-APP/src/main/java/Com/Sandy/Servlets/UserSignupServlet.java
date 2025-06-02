package Com.Sandy.Servlets;

import java.io.IOException;
import java.sql.Timestamp;

import Com.Sandy.DaoImpl.UserDaoimpl;
import Com.Sandy.Models.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UserSignupServlet")
public class UserSignupServlet extends HttpServlet{
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String name = req.getParameter("username");
			String password = req.getParameter("password");
			String email = req.getParameter("email");
			String phone = req.getParameter("phone");
			String address = req.getParameter("address");
			User user = new User();
			user.setName(name);
			user.setPassword(password);
			user.setEmail(email);
			user.setPhone(phone);
			user.setAddress(address);
			user.setCreated_login_date(new Timestamp(System.currentTimeMillis()));
			UserDaoimpl userDaoimpl = new UserDaoimpl();
			int success = userDaoimpl.addUser(user);
			if(success==1)
			{
			resp.sendRedirect("RestaurantServlet");
			}
			else
			{
				req.setAttribute("errorMesage", "sign up failed please try again");
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("UserSignUp.jsp");
				requestDispatcher.forward(req, resp);
				
			}
		}
}
