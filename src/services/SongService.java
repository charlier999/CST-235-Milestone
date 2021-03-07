package services;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import beans.SongModel;
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
}
