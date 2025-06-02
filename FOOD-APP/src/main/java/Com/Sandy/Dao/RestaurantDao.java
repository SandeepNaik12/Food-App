package Com.Sandy.Dao;

import java.util.List;

import Com.Sandy.Models.Restaurant;
import Com.Sandy.Models.User;

public interface RestaurantDao {
	void addRestaurant(Restaurant restaurant);
	User getRestaurant(int restaurantid);
	void updateRestaurant(Restaurant  restaurant);
	void deleteRestaurant(int Restaurant);
	List<Restaurant> getAllRestaurants();
}
