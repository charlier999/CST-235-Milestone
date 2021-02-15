package beans;

import javax.faces.bean.ManagedBean;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ManagedBean

public class UserModel
{
	private int id = 0;
	
	@NotNull(message = "Please enter a User Name!")
	@Size(min=2, max=20)
	private String userName = "";
	
	@NotNull(message = "Please enter a Password!")
	@Size(min=2, max=20)
	private String password = "";
	
	@NotNull(message = "Please enter a First Name!")
	@Size(min=2, max=20)
	private String firstName = "";
	
	@NotNull(message = "Please enter a Last Name!")
	@Size(min=2, max=20)
	private String lastName = "";
	
	@NotNull(message = "Please enter an Email!")
	@Size(min=2, max=40)
	private String email = "";
	
	@NotNull(message = "Please enter an Address!")
	@Size(min=2, max=20)
	private String address = "";
	
	@NotNull(message = "Please enter a Phone Number (XXX-XXX-XXXX)!")
	@Size(min=12, max=12)
	private String phoneNumber = "";
	
	//Needed for making a Managed Bean
	public UserModel() {
		
	}
	
	public UserModel(int id, String userName, 
			String password, String firstName, 
			String lastName, String email,
			String address, String phoneNumber)
	{
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public int getId()
	{ return id; }

	public String getUserName()
	{ return userName; }

	public String getPassword()
	{ return password; }

	public String getFirstName()
	{ return firstName; }

	public String getLastName()
	{ return lastName; }

	public String getEmail()
	{ return email; }

	public String getAddress()
	{ return address; }

	public String getPhoneNumber()
	{ return phoneNumber; }

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
	

}