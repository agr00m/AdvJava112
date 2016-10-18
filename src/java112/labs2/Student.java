package java112.labs2;

import java.util.*;
import java.io.*;

/**  
 *  Student Object for Extra Challenge questions 1 & 2 of lab 4, unit 2. 
 *  <p>
 *  Advanced Java (Java 152-112) <br>
 *  Unit 2, Lab 4 Challenge 1 & 2 <br>
 *  Date: 10-04-2016
 *
 *  @author Aaron Groom
 */
public class Student {
  
    public int studentID;
    public String firstName = "";
    public String lastName = "";
    private static int idCounter = 1;
    
    /**
     *  Constructor for class. Assigns first and last name, and ID, then 
     *  increments the ID.
     */
    public Student(String fName, String lName) {
        firstName = fName;
        lastName = lName;
        studentID = idCounter++;
    }
}