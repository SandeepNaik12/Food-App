package Com.Sandy.Models;

public class Menu {
	int menuId;
	int restaurantid;
	String itemName;
	String description;
	float price;
	boolean isAvailable;
	String imagePath;
	
	public Menu() {
		// TODO Auto-generated constructor stub
	}
	

	public Menu(int menuId, int restaurantid, String itemName, String description, float price, boolean isAvailable,
			String imagePath) {
		super();
		this.menuId = menuId;
		this.restaurantid = restaurantid;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.isAvailable = isAvailable;
		this.imagePath = imagePath;
	}


	public Menu(int restaurantid, String itemName, String description, float price, boolean isAvailable,
			String imagePath) {
		super();
		this.restaurantid = restaurantid;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.isAvailable = isAvailable;
		this.imagePath = imagePath;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getRestaurantid() {
		return restaurantid;
	}

	public void setRestaurantid(int restaurantid) {
		this.restaurantid = restaurantid;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", restaurantid=" + restaurantid + ", itemName=" + itemName + ", description="
				+ description + ", price=" + price + ", isAvailable=" + isAvailable + ", imagePath=" + imagePath + "]";
	}
	
}
