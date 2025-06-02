package Com.Sandy.Models;

import java.sql.Time;
import java.sql.Timestamp;

public class Restaurant {
	int restaurantid;
	String name;
	String cuisinetype;
	String deliverytime;
	String address;
	float rating;
	boolean isactive;
	String imagepath;
	int admin_user_id;
	Time opening_time;


	
	

	public Restaurant() {
		super();
	}



	public Restaurant(int restaurantid, String name, String cuisinetype, String deliverytime, String address,
			float rating, boolean isactive, String imagepath, int admin_user_id, Time opening_time, Time closing_time) {
		super();
		this.restaurantid = restaurantid;
		this.name = name;
		this.cuisinetype = cuisinetype;
		this.deliverytime = deliverytime;
		this.address = address;
		this.rating = rating;
		this.isactive = isactive;
		this.imagepath = imagepath;
		this.admin_user_id = admin_user_id;
		this.opening_time = opening_time;
		this.closing_time = closing_time;
	}



	public Restaurant(String name, String cuisinetype, String deliverytime, String address, float rating,
			boolean isactive, String imagepath, int admin_user_id, Time opening_time, Time closing_time) {
		super();
		this.name = name;
		this.cuisinetype = cuisinetype;
		this.deliverytime = deliverytime;
		this.address = address;
		this.rating = rating;
		this.isactive = isactive;
		this.imagepath = imagepath;
		this.admin_user_id = admin_user_id;
		this.opening_time = opening_time;
		this.closing_time = closing_time;
	}



	public int getRestaurantid() {
		return restaurantid;
	}

	public void setRestaurantid(int restaurantid) {
		this.restaurantid = restaurantid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCuisinetype() {
		return cuisinetype;
	}

	public void setCuisinetype(String cuisinetype) {
		this.cuisinetype = cuisinetype;
	}

	public String getDeliverytime() {
		return deliverytime;
	}

	public void setDeliverytime(String deliverytime) {
		this.deliverytime = deliverytime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public boolean isIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public int getAdmin_user_id() {
		return admin_user_id;
	}

	public void setAdmin_user_id(int admin_user_id) {
		this.admin_user_id = admin_user_id;
	}

	public Time getOpening_time() {
		return opening_time;
	}
	
	public void setOpening_time(Time opening_time) {
		this.opening_time = opening_time;
	}
	
	public Time getClosing_time() {
		return closing_time;
	}
	
	public void setClosing_time(Time closing_time) {
		this.closing_time = closing_time;
	}
	
	Time closing_time;





	@Override
	public String toString() {
		return "Restaurant [restaurantid=" + restaurantid + ", name=" + name + ", cuisinetype=" + cuisinetype
				+ ", deliverytime=" + deliverytime + ", address=" + address + ", rating=" + rating + ", isactive="
				+ isactive + ", imagepath=" + imagepath + ", admin_user_id=" + admin_user_id + ", opening_time="
				+ opening_time + ", closing_time=" + closing_time + "]";
	}
	
	
	
	
	
}
