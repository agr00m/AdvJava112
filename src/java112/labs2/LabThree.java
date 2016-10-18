package java112.labs2;

import java.util.*;
import java.io.*;

/**  
 *  LabThree class for Lab 3 of unit 2. Opens a properties file and display
 *  its contents to the console.
 *  <p>
 *  Advanced Java (Java 152-112) <br>
 *  Unit 2, Lab 3 <br>
 *  Date: 10-04-2016
 *
 *  @author Aaron Groom
 */
public class LabThree {
    
    Properties properties;
    String propertiesFilePath = "";
    
    /**
     *  Main method for the class. Ensures only one argument, then calls
     *  the run method.
     *  
     *  @param args command line arguments
     */
    public static void main(String[] args) {
        
        LabThree myLabThree = null;
        if (args.length == 1) {
            myLabThree = new LabThree();
            myLabThree.run(args[0]);
        } else {
            System.out.println("Enter only a single argument, the path to the properties file");
        }
    }
    
    /**
     *  Run method for the class.
     *  
     *  @param path path to the properties file to process
     */
    public void run(String path) {

        propertiesFilePath = path;
        loadProperties(path);
        
        Set<String> keys = properties.stringPropertyNames();
        
        // Print the properties file
        System.out.println("Unordered List:");
        for (String s: keys) {
            System.out.print(s + " = ");
            System.out.println(properties.getProperty(s));
        }
        
        // Create a TreeSet and assign the keys Set to it so that
        // it prints out an alphabetically ordered list.
        Set<String> orderedKeys = new TreeSet<String>(keys);
        System.out.println();
        System.out.println("Ordered List:");
        for (String s: orderedKeys) {
            System.out.print(s + " = ");
            System.out.println(properties.getProperty(s));
        }
    }
    
    /**
     *  Loads the properties file into the Properties object?
     *
     *  @param propertiesFilePath path to properties file
     */
    public void loadProperties(String propertiesFilePath)  {
        properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        } catch(IOException ioe) {
            System.out.println("Can't load the properties file");
            ioe.printStackTrace();
        } catch(Exception e) {
            System.out.println("Problem: " + e);
            e.printStackTrace();
        }
    }
}