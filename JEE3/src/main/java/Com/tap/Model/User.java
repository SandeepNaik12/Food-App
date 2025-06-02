package Com.tap.Model;

public class User {
	private  int id;
	private  String name;
	private  String password;
	private  String phone_number;
	private  String email;
	private  String address;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String name, String password, String phone_number, String email, String address) {
		super();
		this.name = name;
		this.password = password;
		this.phone_number = phone_number;
		this.email = email;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", phone_number=" + phone_number
				+ ", email=" + email + ", address=" + address + "]";
	}
	
	
	
	
}
