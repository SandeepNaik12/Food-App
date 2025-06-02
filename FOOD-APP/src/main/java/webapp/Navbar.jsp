<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Com.Sandy.Models.User" %>
<link rel="stylesheet" href="CSS/Navbar.css">
<link
  rel="stylesheet"
  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css"/>
<nav class="navbar">
    <div class="logo">
        <a href="RestaurantServlet">
            <img src="https://img.freepik.com/premium-vector/food-ordering-app-logo-with-points-fork-shapes-center_666184-195.jpg?w=826" alt="App Logo" />
        </a>
    </div>

    <div class="search-bar">
        <form action="SearchServlet" method="post">
            <input type="text" name="Keyword" placeholder="Search for restaurants or dishes..." />
            <button type="submit">Search</button>
        </form>
    </div>

    <div class="nav-links">
        <%
            User user = (User) session.getAttribute("user");
            if (user == null) {
        %>
            <a href="UserSignUp.jsp" class="signup-btn"><h3>Sign Up</h3></a>
            <a href="UserLogin.jsp" class="login-btn"><h3>Login</h3></a>
        <%
            } else {
                if ("superadmin".equals(user.getRole())) {
        %>
            <a href="RestaurantRegister.jsp" class="admin-login-btn"><h3>Admin</h3></a>
        <%
                }
                
        %>
            <a href="UserProfileServlet" class="profile-btn"><h3>👤 <%= user.getName() %></h3></a>
            <% System.out.println(user.getName()+"username"); %>
            <a href="UserLogOutServlet" class="logout-btn"><h3>Logout</h3></a>
        <%
            }
        %>
        <a href="Cart.jsp" class="cart-btn"><h3><i class="fa-solid fa-cart-shopping"></i>
         Cart</h3></a>
    </div>
</nav>
