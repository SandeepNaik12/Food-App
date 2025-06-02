package Com.Sandy.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Com.Sandy.Dao.MenuDao;
import Com.Sandy.Database.Dbconnection;
import Com.Sandy.Models.Menu;

public class MenuDaoImpl implements MenuDao{

	@Override
	public List<Menu> getMenuById(int restaurantid) {
		
		String displayMenu="select * from menu where restaurantid=?";
		Connection con = Dbconnection.db();
		List<Menu> arrayList = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = con.prepareStatement(displayMenu);
			preparedStatement.setInt(1, restaurantid);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				int menuid = resultSet.getInt("menuId");
				int restid = resultSet.getInt("restaurantid");
				String itemName = resultSet.getString("itemName");
				 String description = resultSet.getString("description");
				 Float price = resultSet.getFloat("price");
				 boolean isAvailable = resultSet.getBoolean("isAvailable");
				 String imagepath = resultSet.getString("imagePath");
				 Menu menu = new Menu(menuid, restaurantid, itemName, description, price, isAvailable, imagepath);
				 arrayList.add(menu);
				
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(arrayList+"arralist");
		return arrayList;
		
	}
	
	public static List<Menu> getDistinctMenuItems() {
	    List<Menu> list = new ArrayList<>();
	    try (Connection con = Dbconnection.db();
	         PreparedStatement ps = con.prepareStatement(
	             "SELECT DISTINCT itemname, imagepath FROM menu")) {

	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            Menu m = new Menu();
	            m.setItemName(rs.getString("itemName"));
	            m.setImagePath(rs.getString("imagePath")); // Store image path in DB
	            list.add(m);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return list;
	}


}
