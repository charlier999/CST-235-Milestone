package services;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import beans.UserModel;

@ManagedBean
@ViewScoped

public class UserService
{
	private ArrayList<UserModel> users;
	private UserFAO ufao;
	
	public UserService()
	{
		this.ufao = new UserFAO();
		this.users = this.ufao.GetAllUsers();
	}

	/**
	 * Gets the user from the list by its id number
	 * @param id The user's ID number
	 * @return UserModel : The requested user data
	 */
	public UserModel GetUserByID(int id)
	{
		// Loop though all users
		for(UserModel user : users)
		{
			// If the current user has the id as the paramater
			if(user.getId() == id)
			{
				// return the current user
				return user;
			}
		}
		
		// Create a Error User to indcate that non was found
		UserModel errorUser = new UserModel
				(-1, 
				"USER NOT FOUND",
				"USER NOT FOUND",
				"USER NOT FOUND",
				"USER NOT FOUND",
				"USER NOT FOUND",
				"USER NOT FOUND",
				"USER NOT FOUND"
				);
		// Return the error user
		return errorUser;
	}

	/**
	 * Updates the entered user in the list and updates the userTable if the user exists.
	 * @param userInput : The user
	 * @return boolean : True-UserModel updated. 
	 * 	False-UserModel not found and userTable not updated.
	 */
	public boolean UpdateUser(UserModel userInput)
	{
		boolean result = false;
		// Loop though all users
		for(int i = 0; i < users.size(); i++)
		{
			// If the user id of the current iteration is the same as the userInput
			if(users.get(i).getId() == userInput.getId())
			{
				users.set(i, userInput);
				result = true;
			}
		}
		
		// If there was a change in in the user list
		if(result)
		{
			// Update the userTable with the updated user.
			ufao.UpdateTable(users);
			
			// Update the users List
			users = ufao.GetAllUsers();
		}
		// return the result of the update
		return result;
	}
	
	
	
}
