package java112.employee;

import java.io.*;

/**  
 *  The Employee class contains all the information about an employee.
 *  <p>
 *  Advanced Java (Java 152-112) <br>
 *  Unit 4, Project 4 <br>
 *  Date: 11-10-2016 <br>
 *
 *  @author Aaron Groom
 *  @since  4.0
 */

public class Employee {
    
    private String employeeID = "";
    private String firstName = "";
    private String lastName = "";
    private String SSN = "";
    private String department = "";
    private String roomNumber = "";
    private String phoneNumber = "";
    
    /**
	 * Constructor.
	 */
    public Employee() {
        
    }
    
    /**
	 * Converts input to String.
	 */

	public String toString() {
		return "";
	}

	
	/**
	 * Returns the value of employeeID.
	 */
	public String getEmployeeID() {
		return employeeID;
	}

	/**
	 * Sets the value of employeeID.
	 * @param employeeID The value to assign employeeID.
	 */
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	/**
	 * Returns the value of firstName.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the value of firstName.
	 * @param firstName The value to assign firstName.
	 */

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Returns the value of lastName.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the value of lastName.
	 * @param lastName The value to assign lastName.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Returns the value of SSN.
	 */
	public String getSSN() {
		return SSN;
	}

	/**
	 * Sets the value of SSN.
	 * @param SSN The value to assign SSN.
	 */
	public void setSSN(String SSN) {
		this.SSN = SSN;
	}

	/**
	 * Returns the value of department.
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * Sets the value of department.
	 * @param department The value to assign department.
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * Returns the value of roomNumber.
	 */
	public String getRoomNumber() {
		return roomNumber;
	}

	/**
	 * Sets the value of roomNumber.
	 * @param roomNumber The value to assign roomNumber.
	 */
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	/**
	 * Returns the value of phoneNumber.
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the value of phoneNumber.
	 * @param phoneNumber The value to assign phoneNumber.
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}