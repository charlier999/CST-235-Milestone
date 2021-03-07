package services;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import beans.SongModel;
import beans.UserModel;
import fileAccessServices.SongFAO;

@ManagedBean
@ViewScoped

public class SongService
{

	private ArrayList<SongModel> songs;
	private SongFAO sfao;
	private SongModel errorSong = new SongModel
			(
				-1,
				"ERROR",
				-1,
				-1,
				"ERROR",
				-1
			);
	
	public SongService()
	{
		this.sfao = new SongFAO();
		this.songs = this.sfao.GetAllSongs();
	}

	/**
	 * Gets the song from the list by its id number.
	 * Will return errorSong if song is not found.
	 * @param id The song's ID number.
	 * @return SongModel : The requested song data.
	 */
	public SongModel GetSongByID(int id)
	{
		// Loops through all songs
		for(SongModel song : songs)
		{
			// If the current song has the id as the paramater
			if(song.getId() == id)
			{
				// return the current song
				return song;
			}
		}
		// Return the error song if requested song was not found
		return errorSong;
	}
	
	/**
	 * Updates the entered song in the list and updates the songTable
	 * 	if the user exists
	 * @param songInput The song to update
	 * @return boolean : True-SongModel was updated.
	 * 	False-SongModel not found and songTable not updated.
	 */
	public boolean UpdateSong(SongModel songInput)
	{
		// Create inital result value
		boolean result = false;
		
		// Loop through all songs
		for(int i = 0; i < songs.size(); i++)
		{
			// If the songs id's match
			if(songs.get(i).getId() == songInput.getId())
			{
				// Replace the song in list for the inputed song
				songs.set(i, songInput);
				
				// Set the result value to true
				result = true;
				break;
			}
		}
		
		// if there was a change in the song list
		if(result)
		{
			// Update the songs table with the updated song.
			sfao.UpdateTable(songs);
			
			// Update the songs list
			songs = sfao.GetAllSongs();
		}
		// Return the result of the update
		return result;
	}
	
	/**
	 * Addes the entered song into the list then update the 
	 * 	songTable with the updated list.
	 * @param songInput : The song to be added.
	 */
	public void AddSong(SongModel songInput)
	{
		int newID;
		try
		{
			// Get the id number of the last song in the list then add one
			newID = songs.get(songs.size()-1).getId()+1;
		}
		catch(IndexOutOfBoundsException ex)
		{
			// If there is no users in the list
			newID = 1;
		}
		
		// Forces the id system to start at 1
		if(newID < 0) newID = 1;
		
		// Update the ID number of the inputed song
		songInput.setId(newID);
		
		// Add the song to the song list
		songs.add(songInput);
		
		// Update the songTable with new song
		sfao.UpdateTable(songs);
		
		// Update the songs list
		songs = sfao.GetAllSongs();
	}
	
	/**
	 * Searches through song list by title and genre for the search term.
	 * @param searchTerm : The term to search for.
	 * @return SongModel ArrayList : All songs that contains the search term.
	 */
	public ArrayList<SongModel> SearchForSongs(String searchTerm)
	{
		// Create the results list
		ArrayList<SongModel> results = new ArrayList<SongModel>();
		
		// Loop through all songs
		for(SongModel song : songs)
		{
			// If any of the String model properties match the search term, add to list
			if(song.getTitle().contains(searchTerm)) results.add(song);
			else if(song.getGenre().contains(searchTerm)) results.add(song);
		}
		
		return results;
	}
	
}
