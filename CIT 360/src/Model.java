import java.util.*;

//Model works on the data which you get from connecting to a Database or use put/get public methods.
public class Model {
	ArrayList<String> characters;
	int size = 8;
	
	//Give data set.
	public Model(){
		characters = new ArrayList<String>(Arrays.asList("Skywalker", "Gandalf", "Bourne", "Logan"));
	}
	
    // The put method to update model.
	public void addString(String dataString){
		characters.add(dataString);
	}
	
	// The get method to update model.
	public ArrayList<String> getArrayOfStrings(){
		return characters;
	}
	
	//Create a rule so the data is not bigger then the variable size.
	public boolean isNotFull(){
		if(characters.size()<size){
			return true;
		}
		else{
			return false;
		}
	}
}