package java112.project4;
  
import java.io.*;
import java.sql.*;
  
/**
 *  
 *  <p>
 *  Advanced Java (Java 152-112) <br>
 *  Unit 4, Lab 3 <br>
 *  Date: 11-21-2016
 *
 *  @author Eric Knapp
 *  @author Aaron Groom
 */
public class JDBC PreparedStatement {

    /**
     *  The main method for teh JDBCInsertEmployees class.
     *
     *  @param  args  The command line arguments
     */
    public static void main(String[] args) {
        JDBCInsertEmployees employees = new JDBCInsertEmployees();
        employees.runSample();
    }

    public void runSample() {
  
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        System.out.println("\nNEW EMPLOYEE ENTRY");
        String employeeID = getValue("Employee ID: ");
        String firstName = getValue("First Name: ");
        String lastName = getValue("Last Name: ");
        String SSN = getValue("Social Security Number: ");
        String department = getValue("Department: ");
        String roomNumber = getValue("Room Number: ");
        String phoneNumber = getValue("Phone Number (xxx-xxxx): ");
        
  
        try {
            Class.forName("com.mysql.jdbc.Driver");
  
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/student", "student", "student");
  
            statement = connection.createStatement();
            
            String insertString = "INSERT into employees values ("
                    + employeeID + ", '" + firstName + "', '" + lastName 
                    + "', '" + SSN + "', '" + department + "', '" + roomNumber 
                    + "', '" + phoneNumber + "')";
            
            String queryString = "SELECT emp_id, first_name, last_name"
                    + " FROM employees " + "WHERE emp_id = '"
                    + employeeID + "'";
            
            System.out.println();
            System.out.println("insertString: " + insertString);
            
            int rowsAffected = statement.executeUpdate(insertString);
            System.out.println();
            System.out.println(rowsAffected + " employee created");
            
            resultSet = statement.executeQuery(queryString);
            
            while (resultSet.next()) {
                System.out.println(" Row: " + employeeID + " "
                            + firstName + " " + lastName);
            }
  
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
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
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
}