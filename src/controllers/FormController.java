package controllers;

import java.util.ArrayList;

import javax.faces.bean.*;
import javax.faces.context.FacesContext;

import beans.SongModel;
import beans.UserModel;
import services.SongService;
import services.UserService;

@ManagedBean
@ViewScoped
public class FormController 
{
	public String onLogin() 
	{
		FacesContext context = FacesContext.getCurrentInstance();
		UserModel user = context.getApplication().evaluateExpressionGet(context, "#{userModel}", UserModel.class);	
		UserService us = new UserService();
		
		// Check users table for credentials
		UserModel result = us.GetUserByCredentails(user.getUserName(), user.getPassword());
		
		// If the creditals are not correct.
		if(result.getId() == -1) 
			// Send user back to login page
			return "Login.xhtml";
		
		// Send user data to response view
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("usermodel", user);

		// Send user to response view
		return "Response.xhtml";
	}
	
	public String onRegistration()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		UserModel user = context.getApplication().evaluateExpressionGet(context, "#{userModel}", UserModel.class);
		
		System.out.println("-----------------------------------{REGISTRATION GOT USER: " + user.toString() +"}-------------------------------------------");
		
		UserService us = new UserService();
		
		// look for users with the same username
		ArrayList<UserModel> searchResult = us.SearchForUsers(user.getUserName());
		
		// Loop through all results
		for(UserModel um : searchResult)
		{
			// If iteritive user's username is the same as the entered username
			if(um.getUserName().equals(user.getUserName()))
			{
				return "Registration.xhtml";
			}
		}
		
		// Add the user to the users Table
		us.AddUser(user);
		
		// Return registration Success page
		return "RegistrationSuccess.xhtml";
	}
	public String onSongCreate()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		SongModel song = context.getApplication().evaluateExpressionGet(context, "#{songModel}", SongModel.class);
		
		SongService ss = new SongService();
		
		ss.AddSong(song);
		
		return "Response.xhtml";
	}
}
