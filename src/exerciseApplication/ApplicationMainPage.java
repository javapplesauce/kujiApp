package exerciseApplication;


import java.io.*;
import java.io.IOException;
import java.util.*;

public class ApplicationMainPage {

	public static void main(String[] args) throws IOException, InterruptedException
	{
		System.out.print("Welcome to Kuji, the #1 rated exercise app!");
		System.out.println();
		

		int i = -1;
		Scanner console = new Scanner(System.in);
		//while(i != 0)
		//{
			System.out.println("Please choose a function for Kuji to complete: " + 
					"\n[1] journal" +
					"\n[2] timer" +
					"\n[3] dictionary" +
					"\n[4] regiment generator" + 
					"\n[5] more information on each" +
					"\n[6] quit"
					);

			i = Integer.parseInt(console.nextLine());
			
			if(i == 1)
			{
				ApplicationJournal a = new ApplicationJournal();
				a.runApp();

				
				// ApplicationJournal.runApp();
			}
			else if(i == 2)
			{
				ApplicationTimer t = new ApplicationTimer();
				t.runApp();
			}
			else if(i == 3)
			{
				// nothing yet
			}
			else if(i == 4)
			{
				// nothing yet
			}
			else if(i == 5)
			{
				// nothing yet
			}
			else if(i == 6)
			{
				// nothing yet
			}


		//}

	}
	
}
