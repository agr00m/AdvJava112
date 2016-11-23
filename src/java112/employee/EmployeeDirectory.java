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
	 * Creates a connection to the employee database.
	 * @throws ClassNotFoundException if there's an issue with the database driver
	 * @throws SQLException if there's an issue connecting to the database
	 * @throws Exception if there are any general errors
	 */
    private Connection connectToDatabase() throws ClassNotFoundException, 
                                                  SQLException, Exception {
        Connection con = null;
        Class.forName(properties.getProperty("database.driver"));
        con = DriverManager.getConnection(
                    properties.getProperty("database.url"), 
                    properties.getProperty("database.username"), 
                    properties.getProperty("database.password"));
        return con;
    }
    
    /**
	 * Adds an employee to the employee database.
	 */
    public void addEmployee(String firstName, String lastName, String SSN, 
                             String department,String roomNumber, 
                             String phoneNumber) {
    
        Connection con = null; 
        PreparedStatement addEmployee = null;
        
        try {
            con = connectToDatabase();   
            addEmployee = con.prepareStatement("INSERT INTO employees VALUES (?,?,?,?,?,?)");
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
    
    public void findEmployeeById(Search search) {
        findEmployee(search);
    }
    
    public void findEmployeeByLastName(Search search) {
        findEmployee(search);
    }
    
    /**
     *  Finds an employee in the database based on the searh type and term
     *  specified in the search object.
     *
     *  @param search search criteria
     */
    private void findEmployee(Search search) {
        
        Connection con = null;
        ResultSet resultSet = null;
        String queryString =  "SELECT * FROM employees WHERE ? = ?";
        PreparedStatement preparedStatement = null;
        
        try {
            con = connectToDatabase();  // Get connection to database
            preparedStatement = con.prepareStatement(queryString);  // Prepare SQL statement
            
            // Set the first ? of the query string depending on search type. 
            // int if by id, String if by last name
            if (search.getSearchType().equals("emp_id")) {
                preparedStatement.setInt(1, Integer.parseInt(search.getSearchTerm()));
            } else {
                preparedStatement.setString(1, search.getSearchTerm());
            } 
            preparedStatement.setString(2, search.getSearchTerm()); 
            
            // Query the database and process the results
            resultSet = preparedStatement.executeQuery(queryString);
            processResults(resultSet, search);
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
    }
    
    /**
     *  Processes a set of search results for a search.
     *
     *  @param resultSet query results to process
     *  @param search search object to process query for
     */
    private void processResults(ResultSet resultSet, Search search) throws SQLException {
        
        Employee employee = null;
        
        if (resultSet.isBeforeFirst()) {
            search.setFound(true);
            while (resultSet.next()) {
                employee = new Employee();
                employee.setEmployeeID(Integer.toString(resultSet.getInt("emp_id")));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setSSN(resultSet.getString("ssn"));
                employee.setDepartment(resultSet.getString("department"));
                employee.setRoomNumber(resultSet.getString("room_number"));
                employee.setPhoneNumber(resultSet.getString("phone_number"));
            }
            search.addFoundEmployee(employee);
        } else {
            search.setFound(false);
        }
    }
}