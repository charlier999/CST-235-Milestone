package services;

import java.io.IOException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import beans.UserModel;

@ManagedBean
@ViewScoped


public class UserFAO
{
	private FileAccessService fas;
	
	public UserFAO()
	{
		this.fas = new FileAccessService("usersTable.txt");
	}

	/**
	 * Gets all of the users from the usersTable.txt
	 * @return UserModel ArrayList
	 */
	public ArrayList<UserModel> GetAllUsers()
	{
		// Get the row data from the File Access Service
		ArrayList<String> rows = new ArrayList<String>();
		try { rows = fas.GetRows(); }
		catch (IOException e) { e.printStackTrace(); }
		
		// Create Result ArrayList
		ArrayList<UserModel> users = new ArrayList<UserModel>();
		
		
		for(String row : rows)
		{
			// Split the row into an array
			String[] arrOfStr = row.split(",");
			
			// Apply the split array into the UserModel
			users.add(new UserModel
					(
						Integer.parseInt(arrOfStr[0]),
						arrOfStr[1],
						arrOfStr[2],
						arrOfStr[3],
						arrOfStr[4],
						arrOfStr[5],
						arrOfStr[6],
						arrOfStr[7]
					));
		}
		// return the ArrayList of users
		return users;
		
	}
	
	/**
	 * Updates the userTable with the users
	 * @param users
	 */
	public void UpdateTable(ArrayList<UserModel> users)
	{
		// Create the string ArrayList to write to the file
		ArrayList<String> rows = new ArrayList<String>();
		
		for(UserModel user : users)
		{
			rows.add(user.toFileString());
		}
		
		// Write rows to the file
		try
		{
			fas.WriteRows(rows);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
}
