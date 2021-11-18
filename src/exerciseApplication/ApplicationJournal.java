package exerciseApplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ApplicationJournal {

	public ApplicationJournal() throws IOException
	{
		/*
		 * DICTIONARY:
		 * - identifierArr = the array with all the identifiers and exercise name
		 * - entryArr = the array with all the entries (or the cumulative data)
		 * - summaryArr = the arrayList that temporarily stores all the data of a single exercise that someone wants to log
		 * - exerciseFreq = the arrayList that stores info on the frequency of exercises
		 */
		
		/*
		 * TO DO LIST:
		 * - figure out how much to progressively overload (take the average of everything and add it to the value? take 
		 * - work on the analysis portion of the program
		 */
		
		// to check if there's new data being added, if yes, this boolean changes to true, and the variables get added to
		
	}
		
	public void runApp() throws IOException, InterruptedException
	{
		
		boolean newData = false;
		int newExerciseNum = 0;
		int newEntryNum = 0;
		
		// read all the files
		String exerciseList = readFile("C:\\Users\\s-liric\\OneDrive - Bellevue School District\\2021 Summer - 2022\\Per 5 CompSci Independent Study\\EclipseAppStuff\\exerciseList.txt");
		String cumulData = readFile("C:\\Users\\s-liric\\OneDrive - Bellevue School District\\2021 Summer - 2022\\Per 5 CompSci Independent Study\\EclipseAppStuff\\CumulativeData.txt");
		
		String exerciseListPath = "C:\\Users\\s-liric\\OneDrive - Bellevue School District\\2021 Summer - 2022\\Per 5 CompSci Independent Study\\EclipseAppStuff\\exerciseList.txt";
		String cumulDataPath = "C:\\Users\\s-liric\\OneDrive - Bellevue School District\\2021 Summer - 2022\\Per 5 CompSci Independent Study\\EclipseAppStuff\\CumulativeData.txt";
		
		// split the exercise list into an arrayList of objects
		
		String[] exerciseListArray = exerciseList.split(",");
		ArrayList<exerciseType> identifierArr = new ArrayList<>();
		
		for(int i = 0; i < exerciseListArray.length-1; i+=2)
		{
			identifierArr.add(new exerciseType(exerciseListArray[i], exerciseListArray[i+1]));
		}
		
		
		// split the cumulative data file into an arrayList of objects
		String[] exerciseEntryArray = cumulData.split("\n");
		ArrayList<exerciseEntry> entryArr = new ArrayList<>();
		 
		for(int i = 0; i < exerciseEntryArray.length; i++)
		{
			String[] bucket = exerciseEntryArray[i].split(" ");

			int temp = Integer.parseInt(bucket[3].substring(0,bucket[3].length()-1));
			
			exerciseEntry e = new exerciseEntry(Integer.parseInt(bucket[0]), bucket[1], Integer.parseInt(bucket[2]), temp);
			entryArr.add(e);
		}
		
		// create the arrayList that temporarily stores all the objects of a single exercise that someone wants to see logged
		ArrayList<exerciseEntry> summaryArr = new ArrayList<>();
		
		
		// opening statement
		
		// create scanner for input from user
		Scanner functionChooser = new Scanner(System.in);

		// while(whatFunct != 0)
		// {
			//choose function page
			System.out.println("\nplease select a journal function for Kuji to complete: " +
					"\n[0] go back to main page" + 
					"\n[1] create a new journal" +
					"\n[2] add to an existing journal" +
					"\n[3] view existing journal !UNDER CONSTRUCTION!" + 
					"\n[4] view analysis " + 
					"\n[5] WORK IN PROGRESS"
					);
			
			// get input from user
			int whatFunct = Integer.parseInt(functionChooser.nextLine());
			
			// statements to distinguish which is which
			if(whatFunct == 0)
			{
				// break or stop or something idk
			}
			else if(whatFunct == 1)
			{
				// add to a new exercise
				newData = true;
				newExerciseNum += 1;
				
				Scanner newIdent = new Scanner(System.in);
				System.out.println("What's the name of the exercise that you want to start logging? ");
				String numb = newIdent.nextLine();
				identifierArr.add(new exerciseType(toString(identifierArr.size()+1), numb));
				System.out.println("Your exercise has been added :D ");
				
			}
			else if(whatFunct == 2)
			{
				newData = true;
				newEntryNum += 1;	
				
				// ask what exercise what they wanted to log
				Scanner br = new Scanner(System.in);
				
				System.out.println("Enter the exercise you want to log:");
				for(int i = 0; i < identifierArr.size(); i++)
				{
					System.out.println(identifierArr.get(i).getIdentifier() + ": " + identifierArr.get(i).getName());
				}
				int identifierNum = Integer.parseInt(br.nextLine());
				
				
				System.out.println("Enter the date [in x/y/z form]");
				String date = br.nextLine();
				System.out.println("Enter the amount of reps you've completed");
				int repCount = Integer.parseInt(br.nextLine());
				System.out.println("Enter the amount of weight you've lifted (whole numbers, round up if neccessary)");
				int weightCount = Integer.parseInt(br.nextLine());

				// take the exercise, and add to cumulative data?
				exerciseEntry b = new exerciseEntry(identifierNum, date, repCount, weightCount);
				entryArr.add(b);
				
				System.out.println("Your entry has been added!");
				
				br.close();
				
			}
			else if(whatFunct == 3)
			{
				// ask which exercise they wanted to see the progress of
				System.out.println("Which exercise do you want to see every entry of? ");
				Scanner summaryScanner = new Scanner(System.in);
				for(int i = 0; i < identifierArr.size(); i++)
				{
					System.out.println(identifierArr.get(i).getIdentifier() + ": " + identifierArr.get(i).getName());
				}
				int whichExerciseSummary = Integer.parseInt(summaryScanner.nextLine());
				
				// sort and pick out which journals they wanted the app to show
				for(int i = 0; i < entryArr.size(); i++)
				{
					if(entryArr.get(i).returnIdentifier() == whichExerciseSummary)
					{
						summaryArr.add(entryArr.get(i));
					}
				}
				
				
				
				
				
				// display the data
				for(int i = 0; i < summaryArr.size(); i++)
				{
					System.out.println(summaryArr.get(i).returnDate() + ": " + summaryArr.get(i).returnWeightC() + " lbs lifted. ");
					
				}
				
			}
			// bruh
			else if(whatFunct == 4)
			{
				/*
				 - TO DO LIST:
				 - list out every journal of a certain exercise?
				 - get the most frequently done exercise?
				 - change in weight for a certain exercise?
				 - get all the information for an exercise?
				 - 
				 
				 */
				
				// get input on what analysis should be completed
				Scanner asdf = new Scanner(System.in);
				System.out.println("Summary: How do you want your information summarized?" + 
									"\n[1] display all logs from one exercise" + 
									"\n[2] display information about the frequency of each exercise" + 
									"\n[3] display the growth in weight for one exercise"
									);
				int asdfResponse = Integer.parseInt(asdf.nextLine());
				
				
				// get input on which exercise should be analyzed
				System.out.println("Which exercise do you want analyzed?");
				Scanner Sca = new Scanner(System.in);
				for(int i = 0; i < identifierArr.size(); i++)
				{
					System.out.println(identifierArr.get(i).getIdentifier() + ": " + identifierArr.get(i).getName());
				}
				int exerciseWhat = Integer.parseInt(Sca.nextLine());
				
				
				// processes the input from the user
				if(asdfResponse == 1)
				{
					// display all logs from one exercise
					for(int i = 0; i < entryArr.size(); i++)
					{
						if(entryArr.get(i).returnIdentifier() == exerciseWhat)
						{
							summaryArr.add(entryArr.get(i));
						}
					}
					System.out.println("Preparing all journals for viewing. - - -\\( ^o^ )/ ");
					TimeUnit.SECONDS.sleep(1);
					for(int i = 0; i < summaryArr.size(); i++)
					{
						System.out.println(summaryArr.get(i).returnDate() + ": " + 
										summaryArr.get(i).returnWeightC() + "lbs for " + 
										summaryArr.get(i).returnRepC() + " reps."
											);
					}
					Sca.close();
				}
				else if(asdfResponse == 2)
				{
					// goes through the entire cumulData arraylist and concatenate one each time the identiiers match up
					
					// assigns an identifier to each row of the array
					int[][] exerciseFreq = new int[identifierArr.size()][2];
					for(int i = 0; i < identifierArr.size(); i++)
					{
						exerciseFreq[i][0] = Integer.parseInt(identifierArr.get(i).getIdentifier());
						exerciseFreq[i][1] = 0;
					}
					
					// concantenation portion
					for(int i = 0; i < entryArr.size(); i++)
					{
						exerciseFreq[entryArr.get(i).returnIdentifier()-1][1]++;
					}
					
					System.out.println("Crunching the numbers \\( ^o^)\\ \\( ^o^)\\");
					TimeUnit.SECONDS.sleep(1);
					
					System.out.println(identifierArr.get(exerciseWhat-1).getName() + " were completed " + 
					exerciseFreq[Integer.parseInt(identifierArr.get(exerciseWhat-1).getIdentifier())-1][1] + " times.");
				
					
				}
				else if(asdfResponse == 3)
				{
					// get the earliest date
					
					// get the most recent date
					
					// subtract the weight difference (change input based on if you've increased weight or decreased weight
				}
				
				
				
				
				// sort the array by the date
				
				// use android studio to graph the progress ovre a chart
				
				
			}
			else if(whatFunct == 5)
			{
				// what do you want to do:
				/*
				 - get the most frequently done exercise?
				 - change in weight for a certain exercise?
				 = get all the information for an exercise?
				 - figure out how much to progressively overload (take the average of everything and add it to the value? take 
				 
				 
				 */
				
			}
		
		
		functionChooser.close();
		
		if(newData == true)
		{
			if(!(newExerciseNum == 0))
			{
				writeToFile(exerciseListPath, identifierArr.get(identifierArr.size()-1).toString());

			}
			
			if(!(newEntryNum == 0))
			{
				
				writeToFile(cumulDataPath, entryArr.get(entryArr.size()-1).toString());
				
			}
			
			
		}
		
		
	}
	
	public static String readFile(String fileName) throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader (fileName));
	    String         line = null;
	    StringBuilder  stringBuilder = new StringBuilder();
	    String         ls = System.getProperty("line.separator");

	    try {
	        while((line = reader.readLine()) != null) {
	            stringBuilder.append(line);
	            stringBuilder.append(ls);
	        }

	        return stringBuilder.toString();
	    } finally {
	        reader.close();
	    }
	}
	
	public static void writeToFile(String data, String msg)  {
	    String fileName = data;
	    PrintWriter printWriter = null;
	    File file = new File(fileName);
	    try {
	        if (!file.exists()) file.createNewFile();
	        printWriter = new PrintWriter(new FileOutputStream(fileName, true));
	        
	        if(data.equals("C:\\Users\\s-liric\\OneDrive - Bellevue School District\\2021 Summer - 2022\\Per 5 CompSci Independent Study\\EclipseAppStuff\\exerciseList.txt"))
	        {
	        	printWriter.write(msg);
	        }
	        else
	        {
	        	printWriter.write("\n" + msg);
	        }
	    } catch (IOException ioex) {
	        ioex.printStackTrace();
	    } finally {
	        if (printWriter != null) {
	            printWriter.flush();
	            printWriter.close();
	        }
	    }
	}
	
	public void printStuff() throws IOException {

		System.out.print("debugging");
		
    }

	public static String toString(int number)
	{
		return "" + number;
	}


	
}
