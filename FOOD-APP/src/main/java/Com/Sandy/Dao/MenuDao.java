package Com.Sandy.Dao;

import java.util.List;

import Com.Sandy.Models.Menu;

public interface MenuDao {
		List<Menu> getMenuById(int restaurantid);
}
