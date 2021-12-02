package exerciseApplication;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ApplicationTimer
{
	
	public ApplicationTimer() throws InterruptedException
	{
		runApp();
	}
	
	public void runApp() throws InterruptedException
	{
		Scanner inputTime = new Scanner(System.in);
		
		System.out.println("How many intervals? ");
		int intervals = Integer.parseInt(inputTime.nextLine());
		System.out.println("How many minutes of work? ");
		int minWork = Integer.parseInt(inputTime.nextLine());
		System.out.println("How many seconds of work? ");
		int secWork = Integer.parseInt(inputTime.nextLine());
		System.out.println("How many minutes of rest? ");
		int minRest = Integer.parseInt(inputTime.nextLine());
		System.out.println("How many seconds of rest? ");
		int secRest = Integer.parseInt(inputTime.nextLine());
		
		
		System.out.println("Starting timer... ");
		countDown(0, 3);
		
		for(int i = 0; i < intervals; i++)
		{
			System.out.println("Interval " + (i+1) + ": begin! ");
			countDown(minWork, secWork);
			
			System.out.println("Rest! ");
			countDown(minRest, secRest); 
		}
		
		System.out.println("timer done! ");
	}
	
	
	public static void countDown(int min, int sec) throws InterruptedException
	{
		boolean x = true;
		if(sec < 10)
		{
			System.out.println(min + ":0" + sec);
		}
		else
		{
			System.out.println(min + ":" + sec);
		}
		
		while(x)
		{
			TimeUnit.SECONDS.sleep(1);
			x = true;
			sec--;
			if(sec < 10)
			{
				System.out.println(min + ":0" + sec);
			}
			else
			{
				System.out.println(min + ":" + sec);
			}
			if(min != 0 && sec == 0)
			{
				min--;
				sec = 60;
			}
			
			if(min == 0 && sec == 0)
			{
				x = false;
			}
		}
		TimeUnit.SECONDS.sleep(1);
		
		
	}
}
