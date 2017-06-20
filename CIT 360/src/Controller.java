import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Controller {
	public static void main(String[] args) {
		
		// The Controller does the logic using the model (data) and the view (interface). 
		Model model = new Model();
		String inputData = "";
		Scanner reader = new Scanner(System.in);
		
		//System.out.print("Please input a ");
		
		while(model.isNotFull()){
			View display = new View();
			
			display.printOut(model.getArrayOfStrings());
			 // Reading from System.in
			inputData = reader.next();
			model.addString(inputData);
		}
		
		// When the list is full displays these messages and the data.
		System.out.println();
		System.out.println("List is full");
		System.out.println(model.getArrayOfStrings());
		
		
	}
}