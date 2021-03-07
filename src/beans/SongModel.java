package beans;

public class SongModel
{
	private int id = 0;
	
	private String title = "";
	
	/**
	 * The userID of the artist
	 */
	private int artistUserID = 0;
	
	/**
	 * The albumID the song is asscoated with
	 */
	private int albumID = 0;
	
	private String genre = "";
	
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
