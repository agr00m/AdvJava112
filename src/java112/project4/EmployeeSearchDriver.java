package java112.project4;

import java.io.*;
import java.util.*;
import java112.employee.*;

/**  
 *  Project 4 test drive class. Tests the add and search functionality of the 
 *  Employee package.
 *  <p>
 *  Advanced Java (Java 152-112) <br>
 *  Unit 4, Project 4 <br>
 *  Date: 11-29-2016
 *
 *  @author Aaron Groom
 */
public class EmployeeSearchDriver {
    
    Properties properties = null;
    EmployeeDirectory ed = null;

    /**
     *  Main method for the class.
     */
    public static void main(String args[]) {
        EmployeeSearchDriver esd = new EmployeeSearchDriver();
        esd.run();       
    }
    
    /**
     *  Run method for the class.
     */
    private void run() {
        loadProperties("/project4.properties");
        ed = new EmployeeDirectory(properties);
        
        String opt = getValue("Search (1) or Add (2):");
        
        if (opt.equals("1")) {
            search();
        } else {
            add();
        }
    }
    
    /**
     *  Adds an employee to the employee database by propting the user for
     *  the new employee's information. It then performs a search for the 
     *  added employee to verify it has been added.
     */
    private void add() {
        
        System.out.println("\nNEW EMPLOYEE ENTRY");
        String firstName = getValue("First Name:");
        String lastName = getValue("Last Name:");
        String SSN = getValue("Social Security Number:");
        String department = getValue("Department:");
        String room = getValue("Room Number:");
        String phone = getValue("Phone Number (xxx-xxxx):");
        
        ed.addEmployee(firstName, lastName, SSN, department, room, phone);
        
        Search search = new Search();
        search.setSearchType("last_name");
        search.setSearchTerm(lastName);
        search = ed.findEmployeeByLastName(search);
        printResults(search);
    }
    
    /**
     *  Searches for an employee based on employee ID or last name. 
     */
    private void search() {
        
        EmployeeDirectory ed = new EmployeeDirectory(properties);
        Search search = new Search();
        
        search.setSearchType(getValue("Search type:"));
        search.setSearchTerm(getValue("Search term:"));
        
        if (search.getSearchType().equals("emp_id")) {
            search = ed.findEmployeeById(search);
        } else {
            search = ed.findEmployeeByLastName(search);
        }
                
        if (search.found()) {
            System.out.println("Records Found:");
        } else {
            System.out.println("No records found");
        }
        
        printResults(search);
    }
    
    /**
     * Prints search results to the console.
     *
     * @param search search object containing the search results
     */
    private void printResults(Search search) {
        
        List<Employee> employees = search.getSearchResults();
        
        for (Employee employee : employees) {
            System.out.println("ID: " + employee.getEmployeeID());
            System.out.println("First Name: " + employee.getFirstName());
            System.out.println("Last Name: " + employee.getLastName());
            System.out.println("SSN: " + employee.getSSN());
            System.out.println("Dept: " + employee.getDepartment());
            System.out.println("Phone: " + employee.getPhoneNumber());
            System.out.println("Room: " + employee.getRoomNumber());
        }
    }
    
    /**
     *  Prompts the user for input.
     *
     *  @param s message to user about what to enter
     */
    private String getValue(String s) {
        String userInput = "";
        while (userInput.length() == 0) {
            try {
                userInput = getUserInput(s);
                userInput = userInput.trim();
            }
            catch (NullPointerException ex) {
                System.out.println("Invalid entry");
            }
        }
        return userInput;
    }
    
    /**
     *  Displays the user propmt message and retrieves the entered data from
     *  from the console.
     *
     *  @param propmt message to user about what to enter
     */
    private String getUserInput(String prompt) {
    
        String  inputLine  = null;
        System.out.print(prompt + "  ");
        
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            
            if (inputLine.length() == 0) {
                return null;
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine;
    }
    
    /**
     *  Loads the properties file into the Properties object?
     *
     *  @param propertiesFilePath path to properties file
     */
    private void loadProperties(String propertiesFilePath)  {
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