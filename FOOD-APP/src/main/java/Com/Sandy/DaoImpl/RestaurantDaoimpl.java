package Com.Sandy.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import Com.Sandy.Dao.RestaurantDao;
import Com.Sandy.Database.Dbconnection;
import Com.Sandy.Models.Restaurant;
import Com.Sandy.Models.User;

public class RestaurantDaoimpl implements RestaurantDao{


	
	@Override
	public void addRestaurant(Restaurant restaurant) {
		String Insert="insert into restaurant( name, cuisinetype, deliverytime, address, rating, isactive, imagepath,opening_time,closing_time)values(?,?,?,?,?,?,?,?,?)";
		Connection con = Dbconnection.db();
		try {
			PreparedStatement preparedStatement = con.prepareStatement(Insert);
			preparedStatement.setString(1, restaurant.getName());
			preparedStatement.setString(2, restaurant.getCuisinetype());
			preparedStatement.setString(3, restaurant.getDeliverytime());
			preparedStatement.setString(4, restaurant.getAddress());
			preparedStatement.setFloat(5, restaurant.getRating());
			preparedStatement.setBoolean(6, restaurant.isIsactive());
			preparedStatement.setString(7, restaurant.getImagepath());
			preparedStatement.setTime(8, restaurant.getOpening_time());
			preparedStatement.setTime(9, restaurant.getClosing_time());
			int executeUpdate = preparedStatement.executeUpdate();
			System.out.println(executeUpdate);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public User getRestaurant(int restaurantid) {
		return null;
		
	}

	@Override
	public void updateRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRestaurant(int Restaurant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
	    List<Restaurant> arrayList = new ArrayList<>();  // ✅ initialized, good
	    
	    String getRestaurant = "select * from restaurant";
	    Connection con = Dbconnection.db();
	    try {
	        PreparedStatement preparedStatement = con.prepareStatement(getRestaurant);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        while (resultSet.next()) {
	            int restaurantId = resultSet.getInt("restaurantid");
	            String name = resultSet.getString("name");
	            String cuisinType = resultSet.getString("cuisinetype");
	            String deliverTime = resultSet.getString("deliverytime");  // ✅ watch spelling here
	            String address = resultSet.getString("address");
	            float rating = resultSet.getFloat("rating");
	            boolean active = resultSet.getBoolean("isactive");
	            String imagePath = resultSet.getString("imagepath");
	            int admin_user_id = resultSet.getInt("admin_user_id");
	            Time openingtime = resultSet.getTime("opening_time");
	            Time closingtime = resultSet.getTime("closing_time");
	            

	            Restaurant restaurant = new Restaurant(restaurantId, name, cuisinType, deliverTime, address, rating, active, imagePath, admin_user_id, openingtime, closingtime);
	            
	            arrayList.add(restaurant);
	            
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        // IMPORTANT: log or handle errors but still return the arrayList (even if empty)
	    }
	    return arrayList;  // ✅ never return null
	}

	public static List<Restaurant> getRestaurantsByMenuItem(String itemName) {
	    List<Restaurant> restaurants = new ArrayList<>();
	    String sql = "SELECT DISTINCT r.* FROM restaurant r " +
	                 "JOIN menu m ON r.restaurantid = m.restaurantid " +
	                 "WHERE m.itemName = ?";

	    try (Connection conn = Dbconnection.db();
	         PreparedStatement ps = conn.prepareStatement(sql)) {

	        ps.setString(1, itemName);
	        ResultSet rs = ps.executeQuery();
	        System.out.println("from restDao"+rs);
	        while (rs.next()) {
	            Restaurant r = new Restaurant();
	            r.setRestaurantid(rs.getInt("restaurantid"));
	            r.setName(rs.getString("name"));
	            r.setAddress(rs.getString("address"));
	            r.setRating(rs.getFloat("rating"));
	            r.setImagepath(rs.getString("imagepath"));
	            r.setOpening_time(rs.getTime("opening_time"));
	            r.setClosing_time(rs.getTime("closing_time"));
	            restaurants.add(r);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return restaurants;
	}

	public static List<Restaurant> getRestaurantByKeyword(String keyword)
	{
		List<Restaurant> arrayList = new ArrayList();
		String searchQuery="select *from restaurant where LOWER(name) like?";
		Connection con = Dbconnection.db();
		try {
			PreparedStatement preparedStatement = con.prepareStatement(searchQuery);
			preparedStatement.setString(1, "%"+keyword.trim().toLowerCase()+"%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				Restaurant restaurant = new Restaurant();
				restaurant.setRestaurantid(resultSet.getInt("restaurantid"));
				restaurant.setName(resultSet.getString("name"));
				restaurant.setAddress(resultSet.getString("address"));
				restaurant.setImagepath(resultSet.getNString("imagePath"));
				restaurant.setRating(resultSet.getFloat("rating"));
				restaurant.setOpening_time(resultSet.getTime("opening_time"));
				restaurant.setClosing_time(resultSet.getTime("closing_time"));
				arrayList.add(restaurant);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayList;
		
	}

}
