package java112.project4;
  
import java.io.*;
import java.sql.*;
  
/**
 *  Connects to the employee database and inserts a new employee using the
 *  PreparedStatement object. New employee information is entered via the 
 *  command line during program execution.
 *  <p>
 *  Advanced Java (Java 152-112) <br>
 *  Unit 4, Lab 3 <br>
 *  Date: 11-21-2016
 *
 *  @author Aaron Groom
 */
public class JDBCPreparedStatement {

    /**
     *  The main method for teh JDBCInsertEmployees class.
     *
     *  @param  args  The command line arguments
     */
    public static void main(String[] args) {
        JDBCPreparedStatement employees = new JDBCPreparedStatement();
        employees.runSample();
    }

    public void runSample() {
  
        Connection con = null;                  // JDBC Connection object
        Statement statement = null;             // For queryString
        ResultSet resultSet = null;             // For query results
        PreparedStatement insertEmp = null;   // For insertStatement
        
        // Get the new employee information
        System.out.println("\nNEW EMPLOYEE ENTRY");
        int employeeID = Integer.parseInt(getValue("Employee ID:"));
        String firstName = getValue("First Name:");
        String lastName = getValue("Last Name:");
        String SSN = getValue("Social Security Number:");
        String department = getValue("Department:");
        String roomNumber = getValue("Room Number:");
        String phoneNumber = getValue("Phone Number (xxx-xxxx):");
        
        // Create query string statment to display newly entered employee.
        String queryString = "SELECT emp_id, first_name, last_name"
                    + " FROM employees " + "WHERE emp_id = '"
                    + employeeID + "'";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection
                    ("jdbc:mysql://localhost/student?useSSL=false", "student", "student");
            statement = con.createStatement();
            
            resultSet = statement.executeQuery(queryString);
            if (resultSet.isBeforeFirst()) {
                String result = getValue("\nEmployee ID already exists. Update? (y/n):");
                if (result.equals("y") || result.equals("Y")) {
                    insertEmp = con.prepareStatement("UPDATE employees " +
                            "SET first_name = ?, last_name = ?, ssn = ?, " +
                            "dept = ?, room = ?, phone = ? WHERE emp_id = ?");
                    insertEmp.setString(1, firstName);
                    insertEmp.setString(2, lastName);
                    insertEmp.setString(3, SSN);
                    insertEmp.setString(4, department);
                    insertEmp.setString(5, roomNumber);
                    insertEmp.setString(6, phoneNumber);
                    insertEmp.setInt(7, employeeID);
                    insertEmp.executeUpdate();
                }
            } else {
                insertEmp = con.prepareStatement
                        ("INSERT INTO employees VALUES (?,?,?,?,?,?,?)");
                insertEmp.setInt(1, employeeID);
                insertEmp.setString(2, firstName);
                insertEmp.setString(3, lastName);
                insertEmp.setString(4, SSN);
                insertEmp.setString(5, department);
                insertEmp.setString(6, roomNumber);
                insertEmp.setString(7, phoneNumber);
                insertEmp.executeUpdate();
            }
            
            resultSet = statement.executeQuery(queryString);
            while (resultSet.next()) {
                System.out.println(" Row: " + employeeID + " "
                            + firstName + " " + lastName);
            }
        } catch (ClassNotFoundException classNotFound) {
            System.err.println("Cannot find database driver");
            classNotFound.printStackTrace();
        } catch (SQLException sqlException) {
            System.err.println("Error in connection.ecting to database " + sqlException);
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
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

/*

*/