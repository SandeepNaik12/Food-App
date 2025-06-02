<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Com.Sandy.Models.Restaurant,Com.Sandy.Models.Menu" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalTime" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Restaurants</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-papZKkavGfkl6fD7l6kOE2jQZXO4CjMHi7hFMyuC8vw6WJ+jghYqqcWhcrNQYyo69DPrySt5APqObe+8klH4Kg==" crossorigin="anonymous" referrerpolicy="no-referrer" />

    <style>
        body {
            margin: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f5f5f5;
        }

        .container {
            max-width: 1200px;
            margin: 30px auto 40px;
            padding: 0 20px;
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
            gap: 25px;
        }

        .restaurant-card {
            background-color: #fff;
            border-radius: 12px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.08);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            overflow: hidden;
            display: flex;
            flex-direction: column;
            text-decoration: none;
            color: inherit;
        }

        .restaurant-card:hover {
            transform: translateY(-6px);
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
        }

        .restaurant-card img {
            width: 100%;
            height: 160px;
            object-fit: cover;
        }

        .restaurant-info {
            padding: 16px;
            flex: 1;
            display: flex;
            flex-direction: column;
        }

        .restaurant-info h3 {
            margin: 0 0 8px;
            font-size: 18px;
            color: #333;
        }

        .restaurant-info p {
            margin: 4px 0;
            font-size: 14px;
            color: #555;
        }

        .rating {
            margin-top: auto;
            color: green;
            font-weight: bold;
        }

        .rating-stars {
            float: right;
            color: #f5b301;
        }

        .address {
            color: #9b4503;
        }

        @media screen and (max-width: 768px) {
            .container {
                grid-template-columns: repeat(auto-fill, minmax(180px, 1fr));
            }
        }

        .menucard {
            margin-left:160px;
            margin-right:160px;
            overflow-x: auto;
            overflow-y: hidden;
            scrollbar-width: none;
            -ms-overflow-style: none;
        }

        .menucard::-webkit-scrollbar {
            display: none;
        }

        .headingMenu {
            margin-left:160px;
        }

        .Restaurantheading {
            margin-left:175px;
            margin-top:50px;
        }
        .restaurant-card.closed {
		    pointer-events: none;        /* Disable all clicks */
		    opacity: 0.7;                /* Make it look faded */
		    filter: grayscale(100%);     /* Optional: gray out image */
		    cursor: not-allowed;
}
        
    </style>
</head>
<body>

<%@ include file="Navbar.jsp" %>

<%
    List<Menu> menuItems = (List<Menu>) request.getAttribute("UniqueMenuItems");
    System.out.print("menuitems" + menuItems);
%>

<div class="headingMenu">
    <% if(user == null) { %>
        <h2 style="margin-left: 10px; margin-top:15px;">What's on your mind?</h2>
    <% } else { %>
        <h2 style="margin-left: 10px; margin-top:15px; margin-bottom:15px;"><%= user.getName() %> what's on your mind?</h2>
    <% } %>
</div>

<div class="menucard">
    <div style="display: flex; gap: 90px; padding: 10px 0;">
        <% 
            if (menuItems != null && !menuItems.isEmpty()) {
                for (Menu item : menuItems) { 
        %>
            <a href="FilterRestaurantServlet?itemName=<%= item.getItemName() %>" style="text-align: center; text-decoration: none; color: #000;">
                <img src="<%= item.getImagePath() %>" alt="<%= item.getItemName() %>" style="width: 100px; height: 100px; border-radius: 50%; object-fit: cover;">
                <div><%= item.getItemName() %></div>
            </a>
        <% 
                }
            } else {
        %>
            <p>No menu items available</p>
        <% 
            }
        %>
    </div>
</div>

<%
    java.sql.Time currentTimeSql = (java.sql.Time) request.getAttribute("currentTime");
    java.time.LocalTime currentTime = (currentTimeSql != null) ? currentTimeSql.toLocalTime() : java.time.LocalTime.now();
%>

<%
    List<Restaurant> allrestaurant = (List<Restaurant>) request.getAttribute("allrestaurant");
    List<Restaurant> filteredRestaurants = (List<Restaurant>) request.getAttribute("filteredRestaurants");

    List<Restaurant> displayRestaurants = (filteredRestaurants != null) ? filteredRestaurants : allrestaurant;
%>

<div class="Restaurantheading">
    <h1>Restaurants with online food Delivery</h1>
</div>

<div class="container">
<% 
    if (displayRestaurants != null && !displayRestaurants.isEmpty()) {
        for (Restaurant restaurant : displayRestaurants) {
            boolean isOpen = false;

            java.sql.Time openSql = restaurant.getOpening_time();
            java.sql.Time closeSql = restaurant.getClosing_time();

            if (openSql != null && closeSql != null) {
                LocalTime open = openSql.toLocalTime();
                LocalTime close = closeSql.toLocalTime();

                isOpen = currentTime.isAfter(open) && !currentTime.isAfter(close);
            }
%>
    <a class="restaurant-card <%= isOpen ? "open" : "closed" %>" 
       href="<%= isOpen ? "Menuservlet?restaurantId=" + restaurant.getRestaurantid() : "#" %>">
        <img src="<%= restaurant.getImagepath() %>" alt="Restaurant Image">
        <div class="restaurant-info">
            <h3><%= restaurant.getName() %></h3>
            <p><strong>Address:</strong> <%= restaurant.getAddress() %></p>
            <p class="rating">
                <%= restaurant.getRating() %>
                <span class="rating-stars">★★★★☆</span>
            </p>
            <% if (!isOpen) { %>
                <p style="color: red; font-weight: bold;">Closed Now</p>
            <% } %>
        </div>
    </a>
<% 
        }
    } else { 
%>
    <p style="text-align: center; font-size: 18px;">No restaurants available.</p>
<% } %>
</div>

</body>
</html>
