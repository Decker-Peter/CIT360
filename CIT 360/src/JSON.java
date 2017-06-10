import org.quickconnectfamily.json.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class JSON {
	
	public static void main(String args[]) throws ParseException, JSONException, IOException {

		// Print the options using the View class from MVC 
		
		View.printArray(new ArrayList<String>(Arrays.asList("1. Read JSON String and Save to a File", "2. Read JSON File")));
		
		System.out.print("Your input here: ");

		Scanner reader = new Scanner(System.in);
		
		String inputData = reader.nextLine();

		
		// There are three main functions of QCJSON, read string, read file and save file
		// #1 ask the user to read JSON string and then save that string to a file
		// #2 ask the user to read in a file
		// anything else will cause the program to terminate
		 
		if(inputData == "1"){
			
			jUtil();
		}
		
		else if(inputData == "2"){
			
			jInStream();
		}
		
		else {
			
			System.out.println("You did not choose a number that was given to you please restart the program when your ready to comply.");
			
		}
		
		reader.close();
	}
	
	 // jUtil read JSON strings and parse them into either ArrayList or HashMap
	 // After the parsing, will ask user if they want to save the file
	 
	private static void jUtil() throws JSONException, ParseException, IOException {

		Scanner reader = new Scanner(System.in);
		
		String inputData = "";

		System.out.print("Input your JSON String: ");
		
		inputData = reader.nextLine();

		JSONUtilities jsonUtil = new JSONUtilities();
		
		String inType = jsonUtil.parse(inputData).getClass().getSimpleName();

		if(inType == "HashMap"){
			
			HashMap parsedJSONMap = (HashMap) jsonUtil.parse(inputData);
			
			System.out.println("We converted the JSON file into a HashMap, and here is the data.");
			
			System.out.println(parsedJSONMap);

			saveJSON(parsedJSONMap);
			
		} 
		else if (inType == "ArrayList"){
			
			ArrayList parsedJSONArray = (ArrayList) jsonUtil.parse(inputData);
			
			System.out.println("We converted the JSON file into an ArrayList, and here is the data.");
			
			System.out.println(parsedJSONArray);

			saveJSON(parsedJSONArray);
		}
		
		
		reader.close();
	}

	
	
	 // jInStream read a JSON file and parse them into either ArrayList or HashMap
	 // After the parsing, will ask user if they want to save the file
	 
	private static void jInStream() throws JSONException, ParseException, IOException {
		
		Scanner reader = new Scanner(System.in);
		
		String inputData = "";

		System.out.print("Enter the file path to reach your JSON file: ");
		
		inputData = reader.nextLine();

		InputStream inStream = new FileInputStream(new File(inputData));

		Scanner inScanner = new Scanner(inStream);

		String inString = "";

		while (inScanner.hasNext()) {
			
			inString += inScanner.nextLine();
			
		}

		String inType = new JSONUtilities().parse(inString).getClass().getSimpleName();

		JSONInputStream jsonInput = new JSONInputStream(new FileInputStream(new File(inputData)));

		if( inType == "HashMap"){
			
			HashMap parsedJSONMap = (HashMap) jsonInput.readObject();
			
			System.out.println("The JSON file was converted into a HashMap, and here is the data.");
			
			System.out.println(parsedJSONMap);

			saveJSON(parsedJSONMap);
			
		}
		
		else if (inType == "ArrayList"){
			
			ArrayList parsedJSONArray = (ArrayList) jsonInput.readObject();
			
			System.out.println("The JSON file was converted into an ArrayList, and here is the data.");
			
			System.out.println(parsedJSONArray);

			saveJSON(parsedJSONArray);
			
		}

		reader.close();
		
		inScanner.close();
	}
	
	
	 // saveJSON saves serializable objects into JSON files
	 // It ask user for the path which the file will be saved.
	 
	private static void saveJSON(Serializable collection) throws JSONException, IOException{
		
		System.out.println("Do you want to save the object to a new file?(y/n) ");
		
		Scanner reader = new Scanner(System.in);
		
		String inputText = reader.next();
		
		if (inputText.equals("y")) {
			
			System.out.print("Please input file path: ");	
			
			String outputFileNamePath = reader.next();
			
			FileOutputStream fout = new FileOutputStream(outputFileNamePath);
			
			JSONOutputStream jsonOut = new JSONOutputStream(fout);

			jsonOut.writeObject(collection);
			
			System.out.println("Your file has been successfully saved.");
		}
		
		reader.close();
	}
}