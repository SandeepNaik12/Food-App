<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Com.Sandy.Models.User, java.util.List, Com.Sandy.Models.Order" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%
    User user2 = (User) session.getAttribute("user");
    String section = (String) request.getAttribute("section");

    if (user2 == null) {
        response.sendRedirect("UserLogin.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Profile</title>
    <style>
        /* your existing CSS styles (same as in your code) */
        body {
            margin: 0;
            font-family: 'Segoe UI', sans-serif;
            background-color: #2d5d72;
        }

        .header {
            background-color: #2d5d72;
            color: white;
            padding: 20px 40px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .edit-btn {
            background-color: transparent;
            border: 1px solid #fff;
            color: white;
            padding: 8px 16px;
            cursor: pointer;
            border-radius: 4px;
            font-weight: bold;
        }

        .layout {
            display: flex;
            min-height: calc(100vh - 80px);
            overflow: hidden;
        }

        .sidebar {
            width: 250px;
            background-color: #e9edf1;
            padding: 20px;
            border-right: 1px solid #ccc;
        }

        .sidebar a {
            display: block;
            padding: 10px 15px;
            margin: 5px 0;
            border-radius: 4px;
            text-decoration: none;
            color: #333;
            font-weight: 500;
        }

        .sidebar a.active,
        .sidebar a:hover {
            background-color: white;
            color: #ff5722;
            font-weight: bold;
        }

        .content {
            flex: 1;
            padding: 30px;
            background-color: #f4f4f4;
            overflow-y: auto;
            height: 100%;
            box-sizing: border-box;
            border-top-left-radius: 20px;
            border-bottom-left-radius: 20px;
        }

        .order-card {
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
            padding: 20px;
            margin-bottom: 20px;
            border-left: 5px solid #ff5722;
        }

        .empty-message {
            text-align: center;
            padding: 50px;
            color: #777;
        }

        .highlight {
            font-size: 20px;
            font-weight: bold;
            color: #ff5722;
        }

        .profile-container {
            max-width: 1000px;
            margin: 40px auto;
            background-color: white;
            border-radius: 20px;
            overflow: hidden;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
            display: flex;
            flex-direction: column;
        }

        .content form label {
            display: block;
            margin: 12px 0 5px;
            font-weight: 500;
        }

        .content form input {
            width: 100%;
            padding: 8px 10px;
            border-radius: 6px;
            border: 1px solid #ccc;
        }

        .content form button {
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #2d5d72;
            color: white;
            border: none;
            border-radius: 6px;
            cursor: pointer;
        }

        body::-webkit-scrollbar, .content::-webkit-scrollbar, .layout::-webkit-scrollbar {
            display: none;
        }
    </style>
</head>
<body>

<%@ include file="Navbar.jsp" %>

<div class="profile-container">
    <div class="header">
        <div class="user-info">
            <h2><%= user2.getName() %></h2>
            <p><%= user2.getPhone() %> &nbsp; • &nbsp; <%= user2.getEmail() %></p>
        </div>
      
    </div>

    <div class="layout">
        <div class="sidebar">
            <a href="UserProfileServlet?section=orders" class="<%= "orders".equals(section) ? "active" : "" %>">📦 Orders</a>
            <a href="UserProfileServlet?section=address" class="<%= "address".equals(section) ? "active" : "" %>">📍 Addresses</a>
            <a href="UserProfileServlet?section=settings" class="<%= "settings".equals(section) ? "active" : "" %>">⚙️ Settings</a>
        </div>

        <div class="content">
        <%
   			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
		%>
            <% if ("orders".equals(section)) {
                List<Order> orders = (List<Order>) session.getAttribute("orders");
                if (orders == null || orders.isEmpty()) {
            %>
                <div class="empty-message">
                    <img src="https://media.tenor.com/8g7h7L7XQAcAAAAC/cool-dog.gif" alt="No Orders" />
                    <p class="highlight">No Orders Found</p>
                    <p>You haven’t placed any order yet.</p>
                </div>
            <% } else { %>
                <% for (Order order : orders) { %>
                    <div class="order-card">
                        <p><strong>Order ID:</strong> <%= order.getOrderId() %></p>
                        <p><strong>Date:</strong> <%= sdf.format(order.getOrderDate()) %></p>
                        <p><strong>Amount:</strong> ₹<%= order.getTotalAmount() %></p>
                        <p><strong>Status:</strong> <span style="color:brown"><%= order.getStatus() %></span></p>
                        
                    </div>
                <% } %>
            <% } %>

            <% } else if ("address".equals(section)) { %>
                <h3>Your Address</h3>
                <p><%= user2.getAddress() %></p>

            <% } else if ("settings".equals(section)) { %>
                <h3>Account Settings</h3>
                <form action="UpdateUserSettings" method="post">
                    <label>Name:</label>
                    <input type="text" name="name" value="<%= user2.getName() %>" required>

                    <label>Email:</label>
                    <input type="email" name="email" value="<%= user2.getEmail() %>" required>

                    <label>Phone:</label>
                    <input type="text" name="phone" value="<%= user2.getPhone() %>" required>

                    <label>Address:</label>
                    <input type="text" name="address" value="<%= user2.getAddress() %>" required>
                    
                    <label>Password:</label>
                    <input type="text" name="password" value="<%= user2.getPassword() %>" required>

                    <button type="submit">Save Changes</button>
                </form>

            <% } else { %>
                <h3>Welcome to your account</h3>
            <% } %>
        </div>
    </div>
</div>

</body>
</html>
