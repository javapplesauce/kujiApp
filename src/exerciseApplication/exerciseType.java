package exerciseApplication;

public class exerciseType {

	private int identifier;
	private String name = "";
	
	public exerciseType(String identifier, String name)
	{
		this.identifier = Integer.parseInt(identifier);
		this.name = name;	
	}
	
	public String giveBackTag()
	{
		return "," + identifier + "," + name;
	}
	
	public String getIdentifier()
	{
		return "" + identifier;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String toString()
	{
		return identifier + "," + name + ",";
	}
	
	public String getAbbreviation()
	{
		return "";
	}
	
	
}
