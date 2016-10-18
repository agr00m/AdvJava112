package java112.labs2;

import java.util.*;
import java.io.*;

/**  
 *  LabFour class for Lab 4 of unit 2. Demonstrates creating and using a 
 *  HashMap and TreeMap by adding items and printing the contents to the 
 *  console.
 *  <p>
 *  Advanced Java (Java 152-112) <br>
 *  Unit 2, Lab 4 <br>
 *  Date: 10-04-2016
 *
 *  @author Aaron Groom
 */
public class LabTwoFour {
    
    Map<String,Integer> map = null;
    Map<String,Integer> map2 = null;
    
    /**
     *  Main method for the class. Instantiates a new instance of the class
     *  and calls the run method.
     *  
     *  @param args command line arguments
     */
    public static void main(String[] args) {
        LabTwoFour myLabTwoFour = new LabTwoFour();
        myLabTwoFour.run();
    }

    /**
     *  Run method for the class. 
     */
    public void run() {
        
        // Instantiate a new instance of HashMap.
        map = new HashMap<String,Integer>();    
        
        // Populate and print the map
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        printMap(map);
        System.out.println();
        
        findKey("Three");
        
        // Instantiate a new instace of TreeMap, with map as an argument for 
        // its constructor, to get an alphabetically ordered Map.
        map2 = new TreeMap<String,Integer>(map);
        altPrintMap(map2); 
    }
    
    /**
     *  Searches the HashMap for the given key. If found, the key/value pair
     *  is printed to the console.
     *
     *  @param key key to search for
     */
    public void findKey(String key) {
        
        System.out.println("Searching for key: " + key);
        
        if (map.containsKey(key)) {
            System.out.println("Found! " + key + "=" + map.get(key));
        } else {
            System.out.println("Key not found!");
        }
        System.out.println();
    }
    
    /**
     *  Prints a Map to the console using a for loop.
     *
     *  @param m map to print
     */
    public void printMap(Map<String,Integer> m) {    
        for (Map.Entry<String,Integer> entry : m.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.println(key + " = " + value);
        }
    }  
    
    /**
     *  Prints a Map to the console using the forEach method of Map.
     *
     *  @param m map to print
     */
    public void altPrintMap(Map<String,Integer> m) {    
        m.forEach((k,v)->System.out.println("Key: " + k + "\tValue: " + v));
    }  
}