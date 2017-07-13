package test.M;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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
import java.util.List;
import java.util.Scanner;

public class Final_Controller {
	public static void main(String[] args) throws JSONException, ParseException, IOException {
		String username;
		String inputData;
		String status = "true";
		String ndstatus = "true";
		Scanner reader = new Scanner(System.in);
		
	while (status == "true")
		{
		
		Final_Model model = new Final_Model();
		Final_View display = new Final_View();
		display.start(model.getArrayOfStrings());
		inputData = reader.next();
		
		if (inputData.equals("1")){
			
			
			display.browse(model.BrowsePurchase());
			
			
			} else if (inputData.equals("2")) {
				status = "false";
				
				String password;
				String email;
			
				System.out.print("Enter Username: ");
				username = reader.next();
				
				System.out.print("Enter Password: ");
				password = reader.next();
				
				System.out.print("Enter Email Address: ");
				email = reader.next();
				
				model.Register(username, password, email);
				model.Login_Model(username);
				
				while (ndstatus == "true")
					
				{
					display.loggedin(model.getStringLoggedIn());
					inputData = reader.next();
					
					if (inputData.equals("1")){
						String name;
						Float price;
						
						System.out.print("Enter Game Name: ");
						name = reader.next();
						
						System.out.print("Enter Price: ");
						price = reader.nextFloat();
						
						model.PostGame(name, price);
						
					} else if (inputData.equals("2")) {
						
						display.purchase(model.BrowsePurchase());
						ndstatus ="false";
						
						
						
						
						
						
						
						
					}  else if (inputData.equals("3")) {
						
						status = "false";
						System.exit(0);
						
					}
					
					
					
					
					
					
			
				} 
	
			} else if (inputData.equals("3")) {
				status = "false";
				String[] test;
				String password;
				int size;
				int i = 1;
				test = model.loginInfo();
				size = test.length;
				
				
				
			
				System.out.print("Enter Username: ");
				username = reader.next();
				
				System.out.print("Enter Password: ");
				password = reader.next();
				
				//while (i < size){
				//	System.out.println(test[i]);
				//i++;
				//}
				
				
				
				String login = username + password;
				
				//System.out.println(size);
				
				while (i < size){
					
					if (test[i].indexOf(login) != -1){
						
						int newNumber = test[i].indexOf(login);
					

					String newString = test[i].substring(newNumber);
					
					if(login.equals(newString)){
						while (true)
							
						{
							model.Login_Model(username);
							
							display.loggedin(model.getStringLoggedIn());
							inputData = reader.next();
							
							if (inputData.equals("1")){
								String name;
								Float price;
								
								System.out.print("Enter Game Name: ");
								name = reader.next();
								
								System.out.print("Enter Price: ");
								price = reader.nextFloat();
								
								model.PostGame(name, price);
								
							} else if (inputData.equals("2")) {
								
								display.purchase(model.BrowsePurchase());
								ndstatus ="false";
								
								
								
								
								
								
								
								
							}  else if (inputData.equals("3")) {
								
								System.exit(0);
								
							}
							
							
							
							
							
							
					
						} 
						
						
						
					}
					}
					
					i++;	
						
						
						
						
						
					}
					
				status = "true";
					
			
			}  else if (inputData.equals("4")) {
				status = "false";
				System.exit(0);
			}
		
		
		
		} 	
		
	}
}