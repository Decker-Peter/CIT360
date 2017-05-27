import java.net.*; //Import the java.net and java.io classes 
import java.io.*;
public class Https_Connection_Buffer {

		//For the sake of simplicity I did a throw statement
		public static void main(String[] args) throws Exception{
			//Creates an object that will attempt to retrieve the data
			//Choose a Https website URL. (It has to be HTTPS)
			URL webpagename = new URL("https://www.google.com");
			
			//Create a connection to the webpage
			HttpURLConnection testconnection = (HttpURLConnection) webpagename.openConnection();
			//Establish connection buffer and prep it to display
			BufferedReader displaydata = new BufferedReader(new InputStreamReader(testconnection.getInputStream()));
			//Create a string to store the data in order to display it
			String google;
			//Basic while loop to display each line of the code
			while((google = displaydata.readLine())!= null){
				System.out.println(google);
				
			}
      }
		
}