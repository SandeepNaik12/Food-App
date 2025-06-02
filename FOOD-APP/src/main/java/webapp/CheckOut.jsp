<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <title>Checkout</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
        }
        .checkout-container {
            max-width: 600px;
            margin: 50px auto;
            background-color: #fff;
            border-radius: 12px;
            box-shadow: 0 8px 20px rgba(0,0,0,0.1);
            padding: 30px;
        }
        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 30px;
        }
        .payment-section {
            margin-bottom: 25px;
        }
        .payment-option {
            display: flex;
            align-items: center;
            margin-bottom: 15px;
            padding: 12px;
            border: 1px solid #ddd;
            border-radius: 8px;
            cursor: pointer;
            transition: background-color 0.2s, border-color 0.2s;
        }
        .payment-option:hover {
            background-color: #f1f1f1;
            border-color: #007bff;
        }
        .payment-option input[type="radio"] {
            margin-right: 12px;
        }
        .place-order-btn {
            width: 100%;
            padding: 14px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 1.1em;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .place-order-btn:hover {
            background-color: #0056b3;
        }
        .summary {
            border-top: 1px solid #ddd;
            padding-top: 20px;
            margin-top: 20px;
        }
        .summary p {
            display: flex;
            justify-content: space-between;
            margin: 8px 0;
            font-size: 1em;
        }
    </style>
</head>
<body>

<div class="checkout-container">
    <h2>Checkout</h2>
	
    <form action="OrderServlet" method="post">
        <div class="payment-section">
            <h3>Select Payment Method</h3>
            <label class="payment-option">
                <input type="radio" name="paymentMethod" value="CreditCard" required>
                Credit Card
            </label>
            <label class="payment-option">
                <input type="radio" name="paymentMethod" value="DebitCard">
                Debit Card
            </label>
            <label class="payment-option">
                <input type="radio" name="paymentMethod" value="NetBanking">
                Net Banking
            </label>
            <label class="payment-option">
                <input type="radio" name="paymentMethod" value="UPI">
                UPI / Google Pay / PhonePe
            </label>
            <label class="payment-option">
                <input type="radio" name="paymentMethod" value="CashOnDelivery">
                Cash on Delivery
            </label>
        </div>

        <div class="summary">
            
            <p><strong>Shipping:</strong> ₹0.00</p>
            <p><strong>Total:</strong> ₹<%= session.getAttribute("cartTotal") != null ? session.getAttribute("cartTotal") : "0.00" %></p>
        </div>

        <button type="submit" class="place-order-btn">Place Order</button>
    </form>
</div>

</body>
</html>
