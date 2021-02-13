package beans;

/**
 * The user itself
 * @author Charles Davis
 *
 */
public class UserModel
{
	private int id = 0;
	
	private String userName = "";
	
	private String password = "";
	
	private String firstName = "";
	
	private String lastName = "";
	
	private String email = "";
	
	private String address = "";
	
	private String phoneNumber = "";
	
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

	public String toFileString()
	{
		return id + ","
			+ userName + ","
			+ password + ","
			+ firstName + ","
			+ lastName + ","
			+ email + ","
			+ address + ","
			+ phoneNumber;
				
	}
	public void setId(int id)
	{ this.id = id; }
	
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


	

}
