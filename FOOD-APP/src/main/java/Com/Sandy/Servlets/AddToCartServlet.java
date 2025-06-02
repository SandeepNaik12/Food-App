package Com.Sandy.Servlets;

import java.io.IOException;

import Com.Sandy.Models.Cart;
import Com.Sandy.Models.CartItem;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AddToCartServlet")
public class AddToCartServlet  extends HttpServlet{
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

		 String action = request.getParameter("action");
		 String name = request.getParameter("name");
		 int quantity=0;
		
	        int menuId = Integer.parseInt(request.getParameter("menuId"));
	        if(!action.equals("remove"))
	        {
	         quantity = Integer.parseInt(request.getParameter("quantity"));
	        }
	      
	       

	        HttpSession session = request.getSession();
	        Cart cart = (Cart) session.getAttribute("cart");
	       
	        int oldresturantId =session.getAttribute("restaurantId")==null?0:(Integer)session.getAttribute("restaurantId");
	        
	        
	        if(action.equals("add"))
	        {
	        	int restaurantId = Integer.parseInt(request.getParameter("restaurantId"));
	        	
	        	if (cart == null || oldresturantId != restaurantId) {
		            cart = new Cart();
		            session.setAttribute("cart", cart);
		            session.setAttribute("restaurantId", restaurantId);
		           
		        }
	        	
	        	String url = request.getParameter("url");
	        	
	        	float price = Float.parseFloat(request.getParameter("price"));
	        	CartItem cartItem = new CartItem(menuId, name, quantity, price);
	        	cart.addItem(cartItem);
	        	 float total = cart.getTotal();
			        session.setAttribute("cartTotal", total);
			        
	        	RequestDispatcher requestDispatcher = request.getRequestDispatcher("Menuservlet");
	        	
	        	requestDispatcher.forward(request, response);
	        }
	        else if(action.equals("update"))
	        {
	        	cart.updateItem(menuId, quantity);
	        	response.sendRedirect("Cart.jsp");
	        	 float total = cart.getTotal();
			        session.setAttribute("cartTotal", total);
			        System.out.println(total);
	        }else if(action.equals("remove"))
	        {
	        	cart.removeItem(menuId);
	        	response.sendRedirect("Cart.jsp");
	        	 float total = cart.getTotal();
			        session.setAttribute("cartTotal", total);
			        System.out.println(total);
	        }

	       
	    }
}
