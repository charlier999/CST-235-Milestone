package beans;

import javax.faces.bean.ManagedBean;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ManagedBean
public class SongModel
{
	@NotNull
	private int id = 0;
	
	@NotNull
	@Size(min=2, max=20)
	private String title = "";
	
	/**
	 * The userID of the artist
	 */
	@NotNull
	private int artistUserID = 0;
	
	/**
	 * The albumID the song is asscoated with
	 */
	@NotNull
	private int albumID = 0;
	
	@NotNull
	@Size(min=2, max=20)
	private String genre = "";
	
	@NotNull
	private int year = 0000;
	
	public SongModel(int id, String title, int artistUserID, int albumID, String genre, int year)
	{
		this.id = id;
		this.title = title;
		this.artistUserID = artistUserID;
		this.albumID = albumID;
		this.genre = genre;
		this.year = year;
	}
	
	//Used for ManagedBean
	public SongModel() {
		
	}

	
	public String toFileString()
	{
		return this.id + ","
			+ this.title + ","
			+ this.artistUserID + ","
			+ this.albumID + ","
			+ this.genre + ","
			+ this.year;
	}


	public int getId()
	{ return id; }


	public String getTitle()
	{ return title; }


	public int getArtistUserID()
	{ return artistUserID; }


	public int getAlbumID()
	{ return albumID; }


	public String getGenre()
	{ return genre; }


	public int getYear()
	{ return year; }


	public void setId(int id)
	{ this.id = id; }


	public void setTitle(String title)
	{ this.title = title; }


	public void setArtistUserID(int artistUserID)
	{ this.artistUserID = artistUserID; }


	public void setAlbumID(int albumID)
	{ this.albumID = albumID; }


	public void setGenre(String genre)
	{ this.genre = genre; }


	public void setYear(int year)
	{ this.year = year; }
	
	
	
}
