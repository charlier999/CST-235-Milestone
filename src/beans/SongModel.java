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

	// No getters or setters until properties are finished
}
