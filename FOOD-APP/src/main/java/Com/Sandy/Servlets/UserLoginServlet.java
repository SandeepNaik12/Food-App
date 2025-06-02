package Com.Sandy.Servlets;

import java.io.IOException;

import Com.Sandy.DaoImpl.UserDaoimpl;
import Com.Sandy.Models.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				String email = req.getParameter("email");
				String password = req.getParameter("password");
				UserDaoimpl userDaoimpl = new UserDaoimpl();
				 User loginUser = userDaoimpl.loginUser(email, password);
				if(loginUser!=null)
				{
					HttpSession session = req.getSession();
					session.removeAttribute("cart");
					
					session.setAttribute("user", loginUser);
					System.out.println(loginUser+"ssss");
					
					RequestDispatcher requestDispatcher = req.getRequestDispatcher("RestaurantServlet");
					requestDispatcher.forward(req, resp);
				}
				else
				{
					req.setAttribute("errorMessage", "Enter correct email and password");
					RequestDispatcher requestDispatcher = req.getRequestDispatcher("UserLogin.jsp");
					requestDispatcher.forward(req, resp);
				}
				
		}
}
