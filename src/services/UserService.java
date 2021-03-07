package services;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import beans.UserModel;
import fileAccessServices.UserFAO;

@ManagedBean
@ViewScoped

/**
 * The interactions of the userlist
 * @author Charles Davis
 *
 */
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
	 * Updates the entered user in the list and updates the userTable 
	 * 	if the user exists.
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
				break;
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
	
	/**
	 * Adds the entered user into the list and updates the userTable
	 * @param userInput : The user to be added
	 */
	public void AddUser(UserModel userInput)
	{
		int newID;
		try
		{
		// Get the id number of last user in the list and add one
		newID = users.get(users.size()-1).getId()+1;
		}
		catch(IndexOutOfBoundsException ex)
		{
			// If there is no users in the list
			newID = 1;
		}
		
		// forces the id system to start at 1
		if(newID < 0) newID = 1;
		
		// Update the ID number of the inputed user to the next ID number in the list
		userInput.setId(newID);
		
		// Add the user to the list
		users.add(userInput);

		// Update the userTable with the new user.
		ufao.UpdateTable(users);
		
		// Update the users List
		users = ufao.GetAllUsers();
	}

	/**
	 * Searches through all of the users and if the username, first name, last name, email, address, 
	 * or phone number contains the search term, be added to the results.
	 * @param searchTerm : The term to search through the users.
	 * @return ArrayList : All users that contains the search Term.
	 */
	public ArrayList<UserModel> SearchForUsers(String searchTerm)
	{
		// Create the results list
		ArrayList<UserModel> results = new ArrayList<UserModel>();
		
		// Loop though all users
		for(UserModel user : users)
		{
			// if the user's username, first name, last name, email, address, 
			// or phone number contains the search term add the user to the
			// result list.
			if(user.getUserName().equals(searchTerm)) results.add(user);
			else if(user.getFirstName().contains(searchTerm)) results.add(user);
			else if(user.getLastName().contains(searchTerm)) results.add(user);
			else if(user.getEmail().contains(searchTerm)) results.add(user);
			else if(user.getAddress().contains(searchTerm)) results.add(user);
			else if(user.getPhoneNumber().contains(searchTerm)) results.add(user);
		}
		
		// return the results
		return results;
	}

	/**
	 * Gets the UserModel by the credentals entered. 
	 * If the userID is -1, the user was not found.
	 * @param userName : The username credental.
	 * @param password : The password credental.
	 * @return UserModel : The requested user or user was not found user.
	 */
	public UserModel GetUserByCredentails(String userName, String password)
	{
		// Create the result value with defalt properties
		UserModel result = new UserModel
				(-1, 
				"USER NOT FOUND",
				"USER NOT FOUND",
				"USER NOT FOUND",
				"USER NOT FOUND",
				"USER NOT FOUND",
				"USER NOT FOUND",
				"USER NOT FOUND"
				);
		
		// Loop though all users
		for(UserModel user : users)
		{
			// If the credentals match the current user
			if(user.getUserName().equals(userName) && user.getPassword().equals(password))
			{
				// Set the current user to the result
				result = user;
			}
		}
		
		// Return the result
		return result;
	}
}
