package Com.Sandy.Servlets;

import java.io.IOException;

import Com.Sandy.DaoImpl.UserDaoimpl;
import Com.Sandy.Models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/UpdateUserSettings")
public class UpdateUserSettings extends  HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String adrress = req.getParameter("address");
		String password = req.getParameter("password");
		UserDaoimpl userDaoimpl = new UserDaoimpl();
		boolean updateSettings = userDaoimpl.updateSettings(user.getUserid(), name, password, email, phone, password);
		if(updateSettings)
		{
			user.setName(name);
			user.setEmail(email);
			user.setPhone(phone);
			user.setAddress(adrress);
			user.setPassword(password);
			session.setAttribute("user", user);
		}
		resp.sendRedirect("UserProfileServlet?section=settings");
	}
}
