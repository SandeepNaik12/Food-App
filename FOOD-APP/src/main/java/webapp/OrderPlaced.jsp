<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Order Placed</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bodymovin/5.7.6/lottie.min.js"></script>
    <style>
        body {
            margin: 0;
            font-family: 'Segoe UI', sans-serif;
            background-color: #f0f8ff;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            text-align: center;
        }
        h1 {
            color: #28a745;
            font-size: 2.5rem;
            margin-bottom: 20px;
        }
        p {
            font-size: 1.2rem;
            color: #555;
            margin-bottom: 30px;
        }
        .btn-home {
            padding: 12px 24px;
            font-size: 1rem;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            text-decoration: none;
        }
        .btn-home:hover {
            background-color: #0056b3;
        }
        #animation-container {
            width: 300px;
            height: 300px;
            margin-bottom: 30px;
        }
    </style>
</head>
<body>

    <div id="animation-container"></div>

    <h1>Order Placed Successfully!</h1>
    <p>Your delicious food is on its way. Thank you for ordering with us!</p>
    <a href="RestaurantServlet" class="btn-home">Go to Home</a>

    <script>
        // Lottie animation loading
        var animation = lottie.loadAnimation({
            container: document.getElementById('animation-container'),
            renderer: 'svg',
            loop: true,
            autoplay: true,
            path: 'https://assets10.lottiefiles.com/packages/lf20_pprxh53t.json' // delivery animation JSON
        });
    </script>
</body>
</html>
