package exerciseApplication;

public class exerciseEntry {

	private int identifier;
	private String date = "";
	private int repC;
	private int weightC;
	
	public exerciseEntry(int identifier, String date, int repC, int weightC)
	{
		this.identifier = identifier;
		this.date = date;
		this.repC = repC;
		this.weightC = weightC;
		
		/*
		 */
		
	}
	
	public void getDateInformation()
	{
		String month = "";
		String day = "";
		String year = "";
		
		String date = "12/2/21"; // this is a date I'm going to switch with the date given for the enry
		month = date.substring(0, date.indexOf("/"));
		date = date.substring(date.indexOf("/") + 1, date.length());
		
		day = date.substring(0, date.indexOf("/"));
		year = date.substring(date.indexOf("/"), date.length());
		
		
		// substring the stuff out right the index takes the smallest value of something 
		// so i should be able to to tkae out the date, then set the string to the old string
		// without having the other sring be the string 
		
		
	}
	
	public void setDate(String date)
	{
		this.date = date;
	}
	
	public void setRepC(int repC)
	{
		this.repC = repC;
	}
	
	public void setWeightC(int weightC)
	{
		this.weightC = weightC;
	}
	
	public int returnIdentifier()
	{
		return identifier;
	}
	
	public String returnDate()
	{
		return date;
	}
	
	public int returnRepC()
	{
		return repC;
	}
	
	public int returnWeightC()
	{
		return weightC;
	}
	
	public String toString()
	{
		return identifier + " " + date + " " + repC + " " + weightC;
		
	}
	
}
