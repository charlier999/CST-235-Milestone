package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import services.SongService;

@ManagedBean
@ViewScoped
public class TableController
{

	public String AllSongsTable()
	{
		SongService ss = new SongService();
		
		
		return "AllProducts.xhtml";
	}

}
