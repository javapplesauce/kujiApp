package exerciseApplication;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ApplicationTimer
{
	private int intervals;
	private int minWork;
	private int secWork;
	private int minRest;
	private int secRest;
	
	public ApplicationTimer() throws InterruptedException
	{
		Scanner inputTime = new Scanner(System.in);
		
		System.out.println("How many intervals? ");
		this.intervals = Integer.parseInt(inputTime.nextLine());
		System.out.println("How many minutes of work? ");
		this.minWork = Integer.parseInt(inputTime.nextLine());
		System.out.println("How many seconds of work? ");
		this.secWork = Integer.parseInt(inputTime.nextLine());
		System.out.println("How many minutes of rest? ");
		this.minRest = Integer.parseInt(inputTime.nextLine());
		System.out.println("How many seconds of rest? ");
		this.secRest = Integer.parseInt(inputTime.nextLine());
		

		
		for(int i = 0; i < intervals; i++)
		{
			countDown(minWork, secWork);
			countDown(minRest, secRest); 
		}
		
	   
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
		
		
	}
}
