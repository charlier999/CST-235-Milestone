package fileAccessServices;

import java.io.IOException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import beans.SongModel;
import beans.UserModel;

@ManagedBean
@ViewScoped

public class SongFAO
{

	private FileAccessService fas;
	
	private SongModel errorSong = new SongModel
			(
				-1,
				"ERROR",
				-1,
				-1,
				"ERROR",
				-1
			);
	
	
	public SongFAO()
	{
		this.fas = new FileAccessService("songsTable.txt");
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets all of the songs from the songsTable.txt
	 * @return SongModel ArrayList
	 */
	public ArrayList<SongModel> GetAllSongs()
	{
		// Get the row data from the File Access Service
		ArrayList<String> rows = new ArrayList<String>();
		try { rows = fas.GetRows(); }
		catch (IOException e) { e.printStackTrace(); }
		
		// Create Result ArrayList
		ArrayList<SongModel> songs = new ArrayList<SongModel>();
		
		for(String row : rows)
		{
			if(row.equals("No Lines Found"))
			{
				songs.add(errorSong);
				break;
			}
			
			// Split the row into an array
			String[] arrOfStr = row.split(",");
			
			// Apply the split array into the UserModel
			songs.add(new SongModel
					(
						Integer.parseInt(arrOfStr[0]),
						arrOfStr[1],
						Integer.parseInt(arrOfStr[2]),
						Integer.parseInt(arrOfStr[3]),
						arrOfStr[4],
						Integer.parseInt(arrOfStr[5])
					));
		}
		// return the ArrayList of users
		return songs;
	}

	/**
	 * Updates the songTable with the songs
	 * @param songs SongModel
	 */
	public void UpdateTable(ArrayList<SongModel> songs)
	{
		// Create the string ArrayList to write to the file
		ArrayList<String> rows = new ArrayList<String>();
		
		for(SongModel song : songs)
		{
			rows.add(song.toFileString());
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
