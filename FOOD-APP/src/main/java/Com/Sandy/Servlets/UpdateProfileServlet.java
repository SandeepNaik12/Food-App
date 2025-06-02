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

@WebServlet("/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		 UserDaoimpl userDaoimpl = new UserDaoimpl();
	        boolean updateUserEmailAndPhone = userDaoimpl.updateUserEmailAndPhone(user.getUserid(), email, phone);
	        if(updateUserEmailAndPhone)
	        {
	        	user.setEmail(email);
	        	user.setPhone(phone);
	        	session.setAttribute("user", user);
	        	System.out.println(user+"from usrprofile");
	        }
	        resp.sendRedirect("UserProfileContent.jsp");
	}
}
