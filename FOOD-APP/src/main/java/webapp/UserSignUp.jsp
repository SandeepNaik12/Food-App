<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>User Signup</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, sans-serif;
            background: linear-gradient(135deg, #f0f4f8, #e0eafc);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .signup-container {
            background-color: #fff;
            padding: 30px 40px;
            border-radius: 12px;
            box-shadow: 0 6px 18px rgba(0,0,0,0.1);
            width: 100%;
            max-width: 400px;
        }

        .signup-container h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        .signup-container input[type="text"],
        .signup-container input[type="password"],
        .signup-container input[type="email"],
        .signup-container input[type="tel"],
        .signup-container textarea {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 14px;
        }

        .signup-container button {
            width: 100%;
            background-color: #28a745;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 6px;
            font-size: 16px;
            cursor: pointer;
            transition: background 0.3s ease;
        }

        .signup-container button:hover {
            background-color: #218838;
        }

        .signup-container p {
            text-align: center;
            margin-top: 15px;
            font-size: 14px;
        }

        .signup-container a {
            color: #007bff;
            text-decoration: none;
        }

        .signup-container a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
	<% String errorMessage=(String)request.getAttribute("errorMesage"); %>
	<%if(errorMessage!=null)
	{%>
		<div style="color: red; text-align: center; margin-bottom: 10px;">
		<%=errorMessage %>
		</div>
	<%} %> 
<div class="signup-container">
    <h2>Create Your Account</h2>
    <form action="UserSignupServlet" method="post">
        <input type="text" name="username" placeholder="Username" required>
        <input type="password" name="password" placeholder="Password" required>
        <input type="email" name="email" placeholder="Email" required>
        <input type="tel" name="phone" placeholder="Phone Number" >
        <textarea name="address" placeholder="Address" rows="3" required></textarea>
        <button type="submit">Sign Up</button>
    </form>
    <p>Already have an account? <a href="UserLogin.jsp">Login here</a></p>
</div>

</body>
</html>
    