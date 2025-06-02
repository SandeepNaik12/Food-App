package Com.Sandy.Models;

import java.sql.Timestamp;

public class User {
	int userid;
	String name;
	String password;
	String email;
	String phone;
	String address;
	String role;
	Timestamp created_login_date;
	Timestamp last_login_date;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String name, String password, String email, String phone, String address, String role,
			Timestamp created_login_date, Timestamp last_login_date) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.role = role;
		this.created_login_date = created_login_date;
		this.last_login_date = last_login_date;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Timestamp getCreated_login_date() {
		return created_login_date;
	}
	public void setCreated_login_date(Timestamp created_login_date) {
		this.created_login_date = created_login_date;
	}
	public Timestamp getLast_login_date() {
		return last_login_date;
	}
	public void setLast_login_date(Timestamp last_login_date) {
		this.last_login_date = last_login_date;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", name=" + name + ", password=" + password + ", email=" + email + ", phone="
				+ phone + ", address=" + address + ", role=" + role + ", created_login_date=" + created_login_date
				+ ", last_login_date=" + last_login_date + "]";
	}
	
	
}
