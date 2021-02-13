package beans;

public class AlbumModel
{

	private int id = 0;
	
	private String title = "";
	
	private int artistID = 0;
	
	private String genre = "";
	
	public AlbumModel(int id, String title, int artistID, String genre)
	{
		this.id = id;
		this.title = title;
		this.artistID = artistID;
		this.genre = genre;
	}
	// No getters or setters until properties are finished
}
