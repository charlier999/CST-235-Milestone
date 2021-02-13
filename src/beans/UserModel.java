package beans;

public class UserModel
{
	private int id = 0;
	
	private String userName = "";
	
	private String password = "";
	
	public UserModel(int id, String userName, String password)
	{
		this.id = id;
		this.userName = userName;
		this.password = password;
	}

	public int getId()
	{ return id; }

	public String getUserName()
	{ return userName; }

	public String getPassword()
	{ return password; }
	

}
