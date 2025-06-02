package Com.Sandy.Models;

import java.sql.Timestamp;

public class Order {
	int orderId;
	int userid;
	int restaurantid;
	Timestamp orderDate;
	float totalAmount;
	String status;
	String paymentMode;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(int userid, int restaurantid, Timestamp orderDate, float totalAmount, String status,
			String paymentMode) {
		super();
		this.userid = userid;
		this.restaurantid = restaurantid;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMode = paymentMode;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getRestaurantid() {
		return restaurantid;
	}

	public void setRestaurantid(int restaurantid) {
		this.restaurantid = restaurantid;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userid=" + userid + ", restaurantid=" + restaurantid + ", orderDate="
				+ orderDate + ", totalAmount=" + totalAmount + ", status=" + status + ", paymentMode=" + paymentMode
				+ "]";
	}
	
}
