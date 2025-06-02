package Com.Sandy.Dao;

import Com.Sandy.Models.User;

public interface UserDao {
	int addUser(User user);
	User loginUser(String email,String password);
	boolean updateSettings(int userid,String name,String password,String email,String phone,String address);
}
