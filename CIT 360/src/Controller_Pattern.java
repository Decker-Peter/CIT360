
import java.util.*;
public class Controller_Pattern {
public static HashMap<String,Calculate> button = new HashMap<String,Calculate>();

public void Controller(){
	
}
public static void controls(String controlkey, Integer input1, Integer input2){
	button.put("+",new Addition());
	button.put("-",new Subtraction());
	button.put("/",new Division());
	button.put("*",new Multiplication());
	Calculate inputgetter = button.get(controlkey);
	inputgetter.execute(input1, input2);
		
}
}
