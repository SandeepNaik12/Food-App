package Com.Sandy.Models;

public class CartItem {
	int menuId;
	String name;
	int quantity;
	float price;
	public CartItem() {
		// TODO Auto-generated constructor stub
	}
	
	
	public CartItem(int menuId, String name, int quantity, float price) {
		super();
		this.menuId = menuId;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}


	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
