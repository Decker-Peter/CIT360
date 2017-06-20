import java.util.*;

public class View {

	// This method shows how the model (data) will be presented
	public void printOut(ArrayList<String> inputStrings){
		String topBottom = "+----------------------------------------+";
		String middle = "|                                        |";
		System.out.println(topBottom);
		inputStrings.forEach(word -> System.out.println(middle.substring(0, 4) + word + middle.substring(4+word.length())));
		System.out.println(topBottom);
		System.out.print("Add name of character: ");
	}

}