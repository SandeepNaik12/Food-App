<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="Com.Sandy.Models.Menu" %>
<%@ page import="Com.Sandy.Models.Cart" %>
<%@ page import="Com.Sandy.Models.CartItem" %>

<!DOCTYPE html>
<html>
<head>
    <title>Menu Page</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f7f7f7;
        }

        h1 {
            text-align: center;
            margin-top: 20px;
            font-size: 2em;
            color: #222;
        }

        .menu-container {
            max-width: 900px;
            margin: auto;
            padding: 20px;
        }

        .menu-item {
            display: flex;
            justify-content: space-between;
            align-items: flex-start;
            background-color: #fff;
            border-radius: 12px;
            padding: 16px;
            margin-bottom: 20px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.05);
        }

        .menu-details {
            flex: 1;
            padding-right: 20px;
        }

        .menu-details h3 {
            margin: 0;
            font-size: 1.2em;
            color: #222;
        }

        .menu-details p {
            margin: 8px 0;
            color: #555;
            font-size: 0.95em;
        }

        .menu-details .price {
            font-weight: bold;
            margin-top: 4px;
        }

        .menu-img {
            width: 120px;
            height: 120px;
            border-radius: 10px;
            overflow: hidden;
            flex-shrink: 0;
        }

        .menu-img img {
            width: 100%;
            height: 100%;
            object-fit: cover;
        }

        .add-btn, .added-btn {
            display: inline-block;
            padding: 8px 20px;
            font-size: 0.95em;
            font-weight: bold;
            border-radius: 6px;
            margin-top: 10px;
            border: none;
            cursor: pointer;
        }

        .add-btn {
            background-color: #ff9933; /* orange like swiggy */
            color: white;
        }

        .add-btn:hover {
            background-color: #ff8000;
        }

        .added-btn {
            background-color: #28a745;
            color: white;
            cursor: default;
        }

    </style>
</head>
<body>
<%@ include file="Navbar.jsp" %>
<h1>Our Menu</h1>

<div class="menu-container">
    <%
        List<Menu> menuItems = (List<Menu>) request.getAttribute("menus");
        Cart cart = (Cart) session.getAttribute("cart");
        Map<Integer, CartItem> cartItems = (cart != null) ? cart.getItems() : null;

        if (menuItems != null) {
            for (Menu item : menuItems) {
                boolean isInCart = cartItems != null && cartItems.containsKey(item.getMenuId());
                String currentURL = request.getRequestURL().toString();
                String queryString = request.getQueryString();
                if (queryString != null) {
                    currentURL += "?" + queryString;
                }
    %>
        <div class="menu-item">
            <div class="menu-details">
                <h3><%= item.getItemName() %></h3>
                <p><%= item.getDescription() %></p>
                <p class="price">₹<%= item.getPrice() %></p>

                <% if (!isInCart) { %>
                <form action="AddToCartServlet" method="post">
                    <input type="hidden" name="menuId" value="<%= item.getMenuId() %>">
                    <input type="hidden" name="restaurantId" value="<%= item.getRestaurantid() %>">
                    <input type="hidden" name="quantity" value="1">
                    <input type="hidden" name="price" value="<%= item.getPrice() %>">
                    <input type="hidden" name="name" value="<%= item.getItemName() %>">
                    <input type="hidden" name="action" value="add">
                    <input type="hidden" name="url" value="<%= currentURL %>">
                    <button type="submit" class="add-btn">ADD</button>
                </form>
                <% } else { %>
                    <button class="added-btn" disabled>ADDED</button>
                <% } %>
            </div>
            <div class="menu-img">
                <img src="<%= item.getImagePath() %>" alt="<%= item.getItemName() %>">
            </div>
        </div>
    <%
            }
        } else {
    %>
        <p style="text-align:center;">No menu items available.</p>
    <%
        }
    %>
</div>
</body>
</html>
