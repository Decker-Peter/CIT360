import java.util.*;
public class Java_Collections {
/*
 * Java collections is a list of classes and functions intended to make
 * programming easier. Here is a List of the Collection
 */


	public static void main(String[] args) {
		// Make an Array
		ArrayList<String> cities = new ArrayList<String>(
				Arrays.asList("Littleton","Boulder","Denver"));
		System.out.println("Some United States cities are" +cities);
		
		
		//How to add. Under "Aztec" we are putting this in the front of the list right after 0.
	    cities.add("Cortez");
		cities.add(1,"Aztec");
	    System.out.println("Like my cities" +cities);
		
		//How to remove
		cities.remove("Aztec");
		System.out.println("Some Colorado cities are" +cities);
		
		//How to manually change a city name
		cities.set(3, "Longmont");
		System.out.println("Some Colorado cities are" +cities);
		//How to find the index of an item, or how to find the item from the index
		int cityindex = cities.indexOf("Littleton");
		System.out.println("The index number of Littleton is " +cityindex);
		String cityname = cities.get(0);
		System.out.println("The index number 0 resolves to " +cityname);
		
		// Make a LinkedList 
		LinkedList<String> mylinkedlist= new LinkedList<String>();
		// You can not use the "LinkedList.asList" command
		mylinkedlist.add("Littleton");
		mylinkedlist.add("Boulder");
		mylinkedlist.add("Denver");
		System.out.println("Here are some Colorado cities: " +mylinkedlist);
		
		//Adding and removing are the same
		//This does NOT work: mylinkedlist.add("0, Colorado Springs");
		mylinkedlist.add("Colorado Springs");
		mylinkedlist.removeFirst();
		System.out.println("After adding Colorado Springs and removing first we have "+mylinkedlist);
		
		/*Vector is a growable array that starts with an initial
		 * Capacity and can be given an increment of growth*/
		Vector<String> vector = new Vector<String>(3);
		vector.add("Denver");
		vector.add("Colorado Springs");
		vector.add("Longmont");
		System.out.println("Current size of the vector is " +vector.size());
		System.out.println("Growth increment is " +vector.capacity());
		//what happens when we add another? it grows by the growth cap #
		vector.add("Aztec");
		System.out.println("Current size of the vector is " +vector.size());
		System.out.println("Growth increment is " +vector.capacity());
		//Notice the growth increment increased by 3.
		//To display the values its the same as an array
        System.out.println(vector);  

		/*Next is the Set Collection which has HashSet's,
		 * Linked Hash Sets and Tree set. 
		 * HashSet's are similar to an array but it doesnt have an index
		 * all the data is stored and displayed in a random order.
		 */
		HashSet<String> hashset = new HashSet<String>();
		//HashSet.asList("Littleton","Boulder","Denver");
		//You cant add to a hash set using the asList option.
		//To add simple use <name>.add("Element");
		hashset.add("Denver");
		/*There is no way to add them except one at a time unless you
		make them into an array.
		Example: validStates = new HashSet<String>(Arrays.asList("AL", "AK", ".."));*/
		hashset.add("Colorado Spring");
		hashset.add("Aztec");
		hashset.add("Cortez");
		System.out.println("\nHere is the random assortment of cities: " +hashset);
		/*as you can see it randomized it
		This does NOT work: hashset.add(1,"Longmont");*/
		
		/*Linked HashSet is similar to Hashset but it maintains the
		 * order of elements in which they were added to the set.*/
	    LinkedHashSet<String> linkedhashset = new LinkedHashSet<String>();
	    linkedhashset.add("Denver");
        linkedhashset.add("Longmont");
        linkedhashset.add("Colorado Springs");
        linkedhashset.add("Aztec");
        linkedhashset.add("Cortez");
        linkedhashset.add("Dirango");
        System.out.println(linkedhashset);
		//Notice the order remained the same as we added it.
        //This: linkedhashset.add(0,"Dirango"); doesnt work
        
        /*Tree set will organize sets alphabetically 
         * or from least to greatest*/
        TreeSet<String> treeset = new TreeSet<String>();
        treeset.add("Denver");
        treeset.add("Longmont");
        treeset.add("Colorado Springs");
        treeset.add("Aztec");
        
        //This also works with numbers as well
        TreeSet<Integer> treeset2 = new TreeSet<Integer>();
        treeset2.add(3534);
        treeset2.add(-24);
        treeset2.add(89123);
        treeset2.add(213354);
        System.out.println(treeset);
        System.out.println(treeset2);
        //As you can see the ints and strings are organized
        
        
        /*The Map collection includes Hash Map, Tree Map 
         * and Linked Map */
        
        //Hash Map stores data using a key a value pair system.
        HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
        hashmap.put(1, "Denver");
        hashmap.put(2, "Longmont");
        hashmap.put(3, "Colorado Springs");
        hashmap.put(4, "Aztec");
        hashmap.put(5, "Cortez");
        //to display content you can use
        System.out.println(hashmap);
        //OR using iterator
        System.out.println("\nHash Map output");
        Set set = hashmap.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
           Map.Entry mapentry = (Map.Entry)iterator.next();
           System.out.print("key is: "+ mapentry.getKey() + " & Value is: ");
           System.out.println(mapentry.getValue());
        }
           /*You can use get to find the value at a certain int similar
           to an array list index*/
       String getbyint = hashmap.get(4);
           System.out.println("The value of int 4 is "+getbyint);
           
      /*Tree map sorts Data just like the TreeSet only in Map Format*/
           TreeMap<Integer, String> treemap = 
                   new TreeMap<Integer, String>();  
           treemap.put(1, "Denver");
           treemap.put(2, "Longmont");
           treemap.put(3, "Colorado Springs");
           treemap.put(4, "Aztec");
           treemap.put(5, "Cortez");
           
           TreeMap<Integer, String> treemap2 = 
                   new TreeMap<Integer, String>();  
           treemap2.put(1, "A");
           treemap2.put(2, "B");
           treemap2.put(3, "C");
           treemap2.put(4, "D");
           treemap2.put(5, "E");
           //Display treemap data
           System.out.println("\nTree Map output");
           System.out.println(treemap);
           System.out.println("\nTree Map 2 output");
           System.out.println(treemap2);
           //OR using iterator
           System.out.println("\nTree Map output");
           Set set2 = treemap.entrySet();
           Iterator iterator2 = set2.iterator();
           while(iterator2.hasNext()) {
              Map.Entry mapentry2 = (Map.Entry)iterator2.next();
              System.out.print("key is: "+ mapentry2.getKey() + " & Value is: ");
              System.out.println(mapentry2.getValue());
        
           }
           System.out.println("\nTree Map 2 output");
           Set set3 = treemap2.entrySet();
           Iterator iterator3 = set3.iterator();
           while(iterator3.hasNext()) {
              Map.Entry mapentry3 = (Map.Entry)iterator3.next();
              System.out.print("key is: "+ mapentry3.getKey() + " & Value is: ");
              System.out.println(mapentry3.getValue());
        
           }
           //Notice Tree Map 2 lists them by their key not their value!
           
           /*Linked Hash Map retains the insertion Order using the
            * Head Tail method as does the Liked hash*/
           
           LinkedHashMap<Integer, String> linkedhashmap = 
                   new LinkedHashMap<Integer, String>();
           linkedhashmap.put(1, "A");
           linkedhashmap.put(2, "B");
           linkedhashmap.put(3, "C");
           linkedhashmap.put(4, "D");
           linkedhashmap.put(5, "E");
           
           System.out.println("\nLinked Hash Map output");
           Set set4 = linkedhashmap.entrySet();
           Iterator iterator4 = set4.iterator();
           while(iterator4.hasNext()) {
              Map.Entry me = (Map.Entry)iterator4.next();
              System.out.print("Key is: "+ me.getKey() + 
                      " & Value is: "+me.getValue()+"\n");
           }
              //Values are in the order entered
              
            /*Iteration is to repeat or loop mathematically and is the
            Last Java collection*/
              System.out.println("\nExample of iteration");
              Set set5 = linkedhashmap.entrySet();
              Iterator iterator5 = set5.iterator();
              while(iterator5.hasNext()) {
                 Map.Entry me1 = (Map.Entry)iterator5.next();
                 System.out.print("Key is: "+ me1.getKey() + 
                         " & Value is: "+me1.getValue()+"\n");
       
           }

           /*ListIterator can reverse or forward the order of 
            * the iteration/loop using Previous and Next*/
              ListIterator<String> litr = null;
              List<String> names = new ArrayList<String>();
              names.add("1");
              names.add("2");
              names.add("3");
              names.add("4");
              names.add("5");
              //Obtaining list iterator
              litr=names.listIterator();
           
              //To move from start to end use litr.hasNext
              System.out.println("\nTraversing the list in forward direction:");
              while(litr.hasNext()){
                 System.out.println(litr.next());
              }
              
              //To move from end to start us litr.hasPrevious
              System.out.println("\nTraversing the list in backward direction:");
              while(litr.hasPrevious()){
                 System.out.println(litr.previous());
              }
	}

}