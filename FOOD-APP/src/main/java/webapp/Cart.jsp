<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="Com.Sandy.Models.Cart" %>
<%@ page import="Com.Sandy.Models.CartItem" %>

<html>
<head>
    <title>Your Cart</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: white;
            margin: 0;
        }
        .container {
            margin-top: 10px;
        }
        h1 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }
        table {
            width: 80%;
            margin: auto;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
            border-radius: 8px;
            overflow: hidden;
        }
        th, td {
            padding: 15px;
            border-bottom: 1px solid #ddd;
            text-align: center;
        }
        th {
            background-color: #f4f4f4;
        }
        .actions button {
            background-color: #28a745;
            color: white;
            border: none;
            padding: 6px 10px;
            margin: 0 4px;
            border-radius: 4px;
            cursor: pointer;
            font-size: 1em;
        }
        .actions button:hover {
            background-color: #218838;
        }
        .remove-btn {
            background-color: #dc3545;
        }
        .remove-btn:hover {
            background-color: #c82333;
        }
        .total {
            text-align: right;
            padding: 20px;
            font-size: 1.2em;
        }
        .checkout-button {
            display: block;
            margin: 30px auto;
            background-color: #007bff;
            color: white;
            border: none;
            padding: 12px 24px;
            font-size: 1.1em;
            border-radius: 6px;
            cursor: pointer;
            text-align: center;
        }
        .checkout-button:hover {
            background-color: #0056b3;
        }
        .cartimage{
        display: flex;
        flex-direction:column;
        	align-items: center;
        	justify-content: center;
        	margin-top:20px;
        }
        .cartbutton{
        	
        	border:2px solid black;
        	background-color: #EC5228;
        	border-radius: 5px;
        	margin-top:50px;
        	text-align: center;
        	 font-size:1.2em;"
        	 width:500px !important;
        }
        .cartbutton:hover{
        	cursor: pointer;
        }
    </style>
</head>
<body>
    <%@ include file="Navbar.jsp" %>

<%
    Cart cart = (Cart) session.getAttribute("cart");
    if (cart == null || cart.isEmpty()) {
%>
	<div class="cartimage">
		<img alt="" src="Images/CartImage.png" width="500px" height="400px" >
    <div class="cartbutton">
    	<a href="RestaurantServlet" style="color:white;text-decoration:none;"><p>SEE NEARBY RESTAURANT</p></a>
    </div>
		
	</div>
<%
    } else {
        Map<Integer, CartItem> items = cart.getItems();
%>
<div class="container">
    <table>
        <tr>
            <th>Item</th>
            <th>Price (₹)</th>
            <th>Quantity</th>
            <th>Subtotal (₹)</th>
            <th>Actions</th>
        </tr>
        <%
            for (CartItem item : items.values()) {
                double subtotal = item.getPrice() * item.getQuantity();
        %>
        <tr>
            <td><%= item.getName() %></td>
            <td><%= item.getPrice() %></td>
            <td><%= item.getQuantity() %></td>
            <td><%= subtotal %></td>
            <td class="actions">
                <form action="AddToCartServlet" method="post" style="display:inline;">
                    <input type="hidden" name="menuId" value="<%= item.getMenuId() %>">
                    <input type="hidden" name="quantity" value="<%= item.getQuantity() + 1 %>">
                    <input type="hidden" name="action" value="update">
                    <button type="submit">+</button>
                </form>
                <form action="AddToCartServlet" method="post" style="display:inline;">
                    <input type="hidden" name="menuId" value="<%= item.getMenuId() %>">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="quantity" value="<%= item.getQuantity() - 1 %>">
                    <button type="submit">−</button>
                </form>
                <form action="AddToCartServlet" method="post" style="display:inline;">
                    <input type="hidden" name="menuId" value="<%= item.getMenuId() %>">
                    <input type="hidden" name="action" value="remove">
                    <button type="submit" class="remove-btn">Remove</button>
                </form>
            </td>
        </tr>
        <% } %>
        <tr>
            <td colspan="3" class="total">Total:</td>
            <td colspan="2">₹<%= cart.getTotal() %></td>
        </tr>
    </table>
</div>
<% if(user==null){ %>
<form action="UserLogin.jsp" method="post">
    <button type="submit" class="checkout-button">Proceed to Checkout</button>
</form>
<%}else { %>
<!-- Proceed to Checkout Button -->
<form action="CheckOut.jsp" method="post">
    <button type="submit" class="checkout-button">Proceed to Checkout</button>
</form>

<% }} %>

</body>
</html>
