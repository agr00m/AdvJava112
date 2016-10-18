package java112.labs2;

import java.util.*;
import java.io.*;

/**  
 *  Extra Challenge 1 and 2 of Lab 4 of unit 2. Creates a map with values 
 *  that are Objects.
 *  <p>
 *  Advanced Java (Java 152-112) <br>
 *  Unit 2, Lab 4 Challenge 1 & 2 <br>
 *  Date: 10-04-2016
 *
 *  @author Aaron Groom
 */
public class LabTwoFourChallenge {
    
    Map<Integer,Student> students = null;
    //Map<Integer,Student> map2 = null;
    Student student = null;
    
    /**
     *  Main method for the class. Instantiates a new instance of the class
     *  and calls the run method.
     *  
     *  @param args command line arguments
     */
    public static void main(String[] args) {
        LabTwoFourChallenge LabTwoFourChallenge = new LabTwoFourChallenge();
        LabTwoFourChallenge.run();
    }
    
    /**
     *  Run method for the class. Creates a new HashMap of students, populates
     *  and displays it. It then updates one of the student's names.
     */
    public void run() {
        
        students = new HashMap<Integer,Student>();  
        
        student = new Student("Aaron", "Groom");
        students.put(student.studentID, student);
        student = new Student("Joey", "Redovich");
        students.put(student.studentID, student);
        student = new Student("Matt", "Treske");
        students.put(student.studentID, student);
        student = new Student("Kevin", "McNulty");
        students.put(student.studentID, student);        
        displayStudents();

        student = students.get(2);
        student.firstName = "Joseph";
        students.put(2, student);
        displayStudents();
    }
    
    /**
     *  Prints all students in the students map to the console.
     */
    public void displayStudents() {        
        for (Map.Entry<Integer,Student> s : students.entrySet()) {
            student = s.getValue();
            System.out.print("ID: " + student.studentID);
            System.out.print("\tName: " + student.firstName);
            System.out.println(" " + student.lastName);
        }
    }
}