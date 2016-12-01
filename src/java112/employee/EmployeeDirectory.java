package java112.employee;

import java.io.*;
import java.util.*;
import java.sql.*;

/**  
 *  
 *  <p>
 *  Advanced Java (Java 152-112) <br>
 *  Unit 4, Project 4 <br>
 *  Date: 11-10-2016 <br>
 *
 *  @author Aaron Groom
 *  @since  4.0
 *  
 *  Notes: Completed but not tested.
 */

public class EmployeeDirectory {
    
    private Properties properties = null;
    
    /**
	 * Default constructor for class.
	 */
    public EmployeeDirectory() {
        
    }
    
    /**
	 * Overload constructor for class that includes the properties file.
	 */
    public EmployeeDirectory(Properties prop) {
        properties = prop;
    }
    
    /**
	 * Adds a new employee to the employee database. The new employee's
	 * information is included in the parameters.
	 *    
	 * @param firstName employee's first name
	 * @param lastName employee's last name
	 * @param SSN employee's social security number
	 * @param department employee's department
	 * @param roomNumber employee's room number
	 * @param phoneNumber employee's phone number
	 */
    public void addEmployee(String firstName, String lastName, String SSN, 
                             String department,String roomNumber, 
                             String phoneNumber) {
    
        Connection con = null; 
        PreparedStatement addEmployee = null;
        
        try {
            con = connectToDatabase();   
            addEmployee = con.prepareStatement("INSERT INTO employees " + 
                "(first_name, last_name, ssn, dept, room, phone) " +
                "VALUES (?,?,?,?,?,?)");
            addEmployee.setString(1, firstName);
            addEmployee.setString(2, lastName);
            addEmployee.setString(3, SSN);
            addEmployee.setString(4, department);
            addEmployee.setString(5, roomNumber);
            addEmployee.setString(6, phoneNumber);
            addEmployee.executeUpdate();
        } catch (SQLException sqlException) {
            System.err.println("Error adding employee " + sqlException);
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException sqlException) {
                System.err.println("Error in connection.ecting to database "
                        + sqlException);
                sqlException.printStackTrace();
            } catch (Exception exception) {
                System.err.println("General Error");
                exception.printStackTrace();
            }
        }
    }
    
    /**
	 * Finds an employee by the employee's ID. 
	 *    
	 * @param search search object containing search criteria (type and term)
	 */
    public Search findEmployeeById(Search search) {
        return findEmployee(search);
    }
    
    /**
	 * Finds an employee by the employee's last name. 
	 *    
	 * @param search search object containing search criteria (type and term)
	 */
    public Search findEmployeeByLastName(Search search) {
        return findEmployee(search);
    }
    
    /**
     *  Finds an employee in the database based on the searh type and term
     *  specified in the search object.
     *
     *  @param search search criteria
     */
    public Search findEmployee(Search search) {

        Connection con = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
 
        try {
            con = connectToDatabase();
            if (search.getSearchType().equals("emp_id")) {
                preparedStatement = con.prepareStatement("SELECT * FROM employees WHERE emp_id = ?");
                preparedStatement.setInt(1, Integer.parseInt(search.getSearchTerm()));
            } else {
                preparedStatement = con.prepareStatement("SELECT * FROM employees WHERE last_name LIKE ?");
                preparedStatement.setString(1, search.getSearchTerm());
            } 
            resultSet = preparedStatement.executeQuery();
            search = processResults(resultSet, search);
        } catch (ClassNotFoundException classNotFound) {
            System.err.println("Cannot find database driver ");
            classNotFound.printStackTrace();
        } catch (SQLException sqlException) {
            System.err.println("Error in connection.ecting to database "
                    + sqlException);
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException sqlException) {
                System.err.println("Error in connection.ecting to database "
                        + sqlException);
                sqlException.printStackTrace();
            } catch (Exception exception) {
                System.err.println("General Error");
                exception.printStackTrace();
            }
        }
        return search;
    }
    
    /**
     *  Processes a set of search results for a search. If the search results
     *  in any records, it adds the employee to the search and sets the found
     *  flag to true. If no records are found, it sets the found flag to false.
     *
     *  @param resultSet query results to process
     *  @param search search object to process query for
     *  @throws SQLException if there's an error in the ResultSet
     */
    private Search processResults(ResultSet resultSet, Search search) throws SQLException {
        
        Employee employee = null;
        
        if (resultSet.isBeforeFirst()) {
            while (resultSet.next()) {
                employee = new Employee();
                employee.setEmployeeID(Integer.toString(resultSet.getInt("emp_id")));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setSSN(resultSet.getString("ssn"));
                employee.setDepartment(resultSet.getString("dept"));
                employee.setRoomNumber(resultSet.getString("room"));
                employee.setPhoneNumber(resultSet.getString("phone"));
                search.addFoundEmployee(employee);
            }
            search.setFound(true);
        } else {
            search.setFound(false);
        }
        return search;
    }
            
    /**
	 * Creates a connection to the employee database.
	 *
	 * @throws ClassNotFoundException if there's an issue with the database driver
	 * @throws SQLException if there's an issue connecting to the database
	 * @throws Exception if there are any general errors
	 */
    private Connection connectToDatabase() throws ClassNotFoundException, 
                                                  SQLException, Exception {
        Connection con = null;
        
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/student", "student", "student");
        
        //Class.forName(properties.getProperty("database.driver"));
        /*
        con = DriverManager.getConnection(
                    properties.getProperty("database.url"),
                    properties.getProperty("database.username"), 
                    properties.getProperty("database.password"));
        */
        return con;
    }
}