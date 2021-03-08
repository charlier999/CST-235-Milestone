package fileAccessServices;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped


/**
 * Reads and writes to textfiles
 * @author Charles Davis
 *
 */
public class FileAccessService
{
	private File file;

	/**
	 * Reads and Writes to the entered text file
	 * @param filePath The path to the text file
	 */
	public FileAccessService(String filePath)
	{
		String workingDirectory = System.getProperty("user.dir");
		
		this.file = new File(workingDirectory, filePath);
		
		System.out.println("Final filepath : " + file.getAbsolutePath());
		
		
		// Create the file if it does not exist
		try 
		{ 
			if(this.file.createNewFile())
				System.out.println("-----------------------------------------{FILE " + filePath + " WAS CREATED}--------------------------------------------------");
			else
				System.out.println("-----------------------------------------{FILE " + filePath + "  WAS NOT CREATED}---------------------------------------------");
		}
		catch (IOException e) { e.printStackTrace(); }
	}
	/**
	 * Gets the rows and translates it to an Array List from the file.
	 * @return ArrayList<String> of all rows in the file.
	 * @throws IOException
	 */
	public ArrayList<String> GetRows() throws IOException
	{
		// Inituate the reader
		BufferedReader br = new BufferedReader(new FileReader(this.file));
		
		// Inituate the result list
		ArrayList<String> lines = new ArrayList<String>();
		try
		{
			// Create a temp string varable
			String line;
			// fill string with values from reader
			while ((line = br.readLine()) != null)
			{
				// add the line to the list
				lines.add(line);
			}
		}
		finally
		{
			// Close the reader
			br.close();
		}
		
		if(lines.isEmpty()) 
		{
			System.out.println("-----------------------------------------{FILE " + file.getPath() + " HAS NO LINES}--------------------------------------------------");
			lines.add("No Lines Found");
		}
		else
		{
			System.out.println("-----------------------------------{FILE " + file.getPath() + " HAS " + lines.size() + " LINES}-------------------------------------------");
		}
		
		return lines;
	}
	/**
	 * Writes each row in rows into the file
	 * @param rows The rows to write
	 * @throws IOException
	 */
	public void WriteRows(ArrayList<String> rows) throws IOException
	{
		// Inituate the writer
		PrintWriter pw = new PrintWriter(new FileWriter(this.file));

		// write a row for each row in rows
		for(String row : rows)
		{
			// write row to file
			pw.println(row);
		}
		pw.close();
		
	}
}
