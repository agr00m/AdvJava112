package java112.project3;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**  
 *  
 *  
 *  <p>
 *  Advanced Java (Java 152-112) <br>
 *  Unit 3, Project 3 <br>
 *  Date: 11-03-2016
 *
 *  @author Aaron Groom
 *  @since  3.0
 */
@WebServlet(
    name = "Project3PropertiesServlet", 
    urlPatterns = { "/project3-properties"}
)
public class PropertiesServlet extends HttpServlet {
    
    Properties properties = null;
    
    public void init() {
        loadProperties("/project3.properties");
    }

    /**
     *  Handles HTTP GET requests.
     *
     *  @param  request                 the HttpServletRequest object
     *  @param  response                the HttpServletResponse object
     *  @exception  ServletException    if there is a Servlet failure
     *  @exception  IOException         if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

        request.setAttribute("property", properties);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
                
        String url = "/project3properties.jsp";
         
        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
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