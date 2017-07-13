package test.M;

import java.util.*;

public class Final_View {

	// This method shows how the model (data) will be presented
	public void start(String[] inputString){
		int i = 0;
		int size = inputString.length;
		String topBottom = "+--------------------------------------------------+";
		String middle = "|                                                  |";
		System.out.println(topBottom);
		while (i < size){
			System.out.println(middle.substring(0,4) + inputString[i] + middle.substring(4+inputString[i].length()));
			i++;
		}
		System.out.println(topBottom);
		System.out.print("Your input: ");
	}
	
	public void loggedin(String [] inputString){
		int i = 0;
		int size = inputString.length;
		String topBottom = "+--------------------------------------------------+";
		String middle = "|                                                  |";
		System.out.println(topBottom);
		
		while (i < size) {
		System.out.println(middle.substring(0,4) + inputString[i] + middle.substring(4+inputString[i].length()));	
		i++;
	}
		System.out.println(topBottom);
		System.out.print("Your input: ");
	}
	
	public void browse(String[] inputString){
		int i = 1;
		int size = inputString.length;
		String topBottom = "+--------------------------------------------------+";
		String middle = "|                                                  |";
		System.out.println(topBottom);
		while (i < size) {
			System.out.println(middle.substring(0,4) + inputString[i] + middle.substring(4+inputString[i].length()));	
			i++;
		}
		System.out.println(topBottom);
		
	}
	
	public void purchase(String[] inputString){
		int i = 1;
		int size = inputString.length;
		String topBottom = "+--------------------------------------------------+";
		String middle = "|                                                  |";
		System.out.println(topBottom);
		while (i < size) {
			System.out.println(middle.substring(0,4) + inputString[i] + middle.substring(4+inputString[i].length()));	
			i++;
		}
		System.out.println("|    To post type 'post'                           |");
		System.out.println("|    Enter the number you wish to purchase         |");
		System.out.println(topBottom);
		System.out.print("Your input: ");
		
	}
	

}