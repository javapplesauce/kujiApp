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
		String returnThis = "";
		String tempName = name;
		
		if(tempName.indexOf(" ") == -1)
		{
			return name.substring(0,2) + name.substring(name.length()-1);
		}
		else
		{
			while(tempName.indexOf(" ") != -1)
			{
				returnThis += tempName.substring(0,2);
				tempName = tempName.substring(tempName.indexOf(" ") + 1);
			}
			return returnThis;
			
		}
		
		// high low, lower low, then go into some back and forth between those two and it'll work
		// make work on doing something in between those
		// maybe go from up to down 
		
	}
	
	
}
