import java.net.*; //Import the java.net and java.io classes 
import java.util.Scanner;
import java.io.*;
public class Https_Connection_Buffer {

		//For the sake of simplicity I did a throw statement
		public static void main(String[] args) throws Exception{
			int loop = 1;
			
			while(loop == 1){
				
			Model model = new Model();
			View display = new View();
				
			display.printCase(model.getArrayOfStrings());
				
			Scanner reader = new Scanner(System.in);
				
			String startInput = reader.nextLine();
			
			switch(startInput){
			
			case "1":
			
			System.out.print("Please put the URL in(Make sure to put in the https and www): ");
			
			String web = reader.nextLine();
			
			URL webpagename = new URL(web);
			
			//Create a connection to the webpage
			HttpURLConnection testconnection = (HttpURLConnection) webpagename.openConnection();
			
			//Establish connection buffer and prep it to display
			BufferedReader displaydata = new BufferedReader(new InputStreamReader(testconnection.getInputStream()));
			
			//Create a string to store the data in order to display it
			String webCode;
			
			//Basic while loop to display each line of the code
			while((webCode = displaydata.readLine())!= null){
				System.out.println(webCode);
			}	
			break;
			
			case "2":
				loop = loop + 1;
				break;
			
			default:
				System.out.println("Please put in a correct value: ");
				break;
			
			}
			
			}
			System.exit(0);
			
			
      }
		
}