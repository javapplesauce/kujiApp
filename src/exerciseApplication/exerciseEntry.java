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
