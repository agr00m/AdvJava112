package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java112.employee.*;

/**  
 *  Startup servlet for project 4. Initializes the project's property file 
 *  and creates a new EmployeeDirectory, then attaches them to the 
 *  application's ServletContext.
 *  <p>
 *  Advanced Java (Java 152-112) <br>
 *  Unit 4, Project 4 <br>
 *  Date: 11-22-2016
 *
 *  @author Aaron Groom
 *  @since  4.0
 */
@WebServlet(
    name = "applicationStartup", 
    urlPatterns = {"/project4-startup"},
    loadOnStartup = 1
)
public class ApplicationStartup extends HttpServlet {
    
    Properties properties = null;
    
    /**
     *  Initializes the application. It first loads the application's properties
     *  file. It then creates a new instance of EmployeeDirectory passing it
     *  the Properties Object, and places the EmployeeDirectory and Properties
     *  objects into the ServletContext.
     */
    public void init() {
        loadProperties("/project4.properties");
        ServletContext context = getServletContext();
        EmployeeDirectory ed = new EmployeeDirectory(properties);
        context.setAttribute("project4properties", properties);
        context.setAttribute("employeeDirectory", ed);
        
        loadProperties("/analyzer.properties");
        context.setAttribute("analyzerProperties", properties);
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