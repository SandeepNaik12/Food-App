package Com.Sandy.Models;

public class OrderItem {
	int orderItemId;
	int orderId;
	int menuId;
	float price;
	int quantity;
	float totalAmount;
	
	public OrderItem() {
		// TODO Auto-generated constructor stub
	}

	

	public OrderItem(int orderId, int menuId, float price, int quantity, float totalAmount) {
		super();
		this.orderId = orderId;
		this.menuId = menuId;
		this.price = price;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
	}



	public int getOrderItemId() {
		return orderItemId;
	}



	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}



	public int getOrderId() {
		return orderId;
	}



	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}



	public int getMenuId() {
		return menuId;
	}



	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}



	public float getPrice() {
		return price;
	}



	public void setPrice(float price) {
		this.price = price;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public float getTotalAmount() {
		return totalAmount;
	}



	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}



	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", orderId=" + orderId + ", menuId=" + menuId + ", price="
				+ price + ", quantity=" + quantity + ", totalAmount=" + totalAmount + "]";
	}



	
}
