<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Restaurant Registration</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #f6d365, #fda085);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .container {
            background-color: #fff;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 4px 20px rgba(0,0,0,0.1);
            width: 400px;
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        label {
            margin-bottom: 5px;
            font-weight: bold;
            color: #555;
        }

        input[type="text"],
        input[type="number"],
        input[type="time"],
        input[type="url"],
        select {
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 8px;
        }

        input[type="checkbox"] {
            margin-right: 10px;
        }

        .checkbox-group {
            display: flex;
            align-items: center;
            margin-bottom: 15px;
        }

        button {
            padding: 12px;
            background-color: #ff7e5f;
            color: white;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        button:hover {
            background-color: #eb5e28;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Restaurant Registration</h2>
    <form action="RestaurantRegisterServlet" method="post">
        <label for="name">Restaurant Name</label>
        <input type="text" id="name" name="name" required>

        <label for="cuisinetype">Cuisine Type</label>
        <input type="text" id="cuisinetype" name="cuisinetype" required>

        <label for="deliverytime">Delivery Time (in minutes)</label>
        <input type="number" id="deliverytime" name="deliverytime" required>

        <label for="address">Address</label>
        <input type="text" id="address" name="address" required>

        <label for="rating">Rating (1-5)</label>
        <input type="number" id="rating" name="rating" step="0.1" min="1" max="5" required>

        <div class="checkbox-group">
            <input type="checkbox" id="isactive" name="isactive" value="true">
            <label for="isactive">Is Active</label>
        </div>

        <label for="imagepath">Image URL</label>
        <input type="url" id="imagepath" name="imagepath" placeholder="https://example.com/image.jpg" required>

        <label for="admin_user_id">Admin User ID</label>
        <input type="number" id="admin_user_id" name="admin_user_id">

        <label for="openingtime">Opening Time</label>
        <input type="time" id="openingtime" name="openingtime" required>

        <label for="closingtime">Closing Time</label>
        <input type="time" id="closingtime" name="closingtime" required>

        <button type="submit">Register Restaurant</button>
    </form>
</div>
</body>
</html>
