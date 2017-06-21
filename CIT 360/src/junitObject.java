import java.util.ArrayList;
import java.util.Arrays;

public class junitObject {
	public int twoElementAddition(int one, int two){
		return one+two;
	}
	
	public int square(int number){
		return number*number;
	}
	
	public void printMessageByTimes(int times){
		for(int i = 0; i< times; i++){
			System.out.print("Print Message");
		}
	}
	
	public String nullName(String name){
		if(name == "Peter"){
			return null;
		}
		return name;
	}
	
	public Object returnSameObject(Object obj){
		return obj;
	}
	
	public void arrayIndexOutofBounds(){
		ArrayList<String> array = new ArrayList<String>(Arrays.asList("Luke", "Vader", "Yoda"));
		System.out.println(array.get(5));		
	}
}