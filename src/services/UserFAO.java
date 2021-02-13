package services;

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

	public ArrayList<UserModel> GetAllUsers()
	{
		return null;
		
	}
}
