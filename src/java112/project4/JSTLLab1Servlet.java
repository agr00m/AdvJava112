package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**  
 *  
 *  <p>
 *  Advanced Java (Java 152-112) <br>
 *  Unit 4, JSTL Lab 1 <br>
 *  Date: 11-28-2016
 *
 *  @author Aaron Groom
 */
@WebServlet(
    name = "jstlLab1", 
    urlPatterns = {"/jstlLab1"}
)
public class JSTLLab1Servlet extends HttpServlet {

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
        
        List<String> myList = new ArrayList<String>();
        myList.add("This is the first item");
        myList.add("Here is the second item");
        myList.add("And another item");
        myList.add("The final item");
        
        request.setAttribute("myList", myList);
        
        String url = "/jsp/jstl-lab2.jsp";
         
        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}