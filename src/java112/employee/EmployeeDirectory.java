package java112.employee;

import java.io.*;
import java.util.*;

/**  
 *  
 *  <p>
 *  Advanced Java (Java 152-112) <br>
 *  Unit 4, Project 4 <br>
 *  Date: 11-10-2016 <br>
 *
 *  @author Aaron Groom
 *  @since  4.0
 */

public class EmployeeDirectory {
    
    private Properties property = null;
    
    /**

	 * Constructor.
	 */

    public EmployeeDirectory() {
        
    }
    
    private void connectToDatabase() {
        
    }
    
    private String employeeID = "";
    private String firstName = "";
    private String lastName = "";
    private String SSN = "";
    private String department = "";
    private String roomNumber = "";
    private String phoneNumber = "";

    
    private void addEmployee(String employeeID, String firstName, 
                             String lastName, String SSN, String department,
                             String roomNumber, String phoneNumber) {
        
        Employee newEmployee = new Employee(); 
        newEmployee.setEmployeeID(employeeID);
        newEmployee.setFirstName(firstName);
        newEmployee.setLastName(lastName);
        newEmployee.setSSN(SSN);
        newEmployee.setDepartment(department);
        newEmployee.setRoomNumber(roomNumber);
        newEmployee.setPhoneNumber(phoneNumber);

        
    }
    
    public void findEmployeeById(Search search) {

    }
    
    public void findEmployeeByLastName(Search search) {
        
    }
}