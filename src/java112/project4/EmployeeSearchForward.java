package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**  
 *  Forwards requests to the employee_search.jsp page.
 *  
 *  <p>
 *  Advanced Java (Java 152-112) <br>
 *  Unit 4, Project 4 <br>
 *  Date: 11-22-2016
 *
 *  @author Aaron Groom
 *  @since  4.0
 */
@WebServlet(
    name = "Project3PropertiesServlet", 
    urlPatterns = {"/employee-search"}
)
public class EmployeeSearchForward extends HttpServlet {

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
                
        String url = "/employee_search.jsp";
         
        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}