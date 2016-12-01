package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java112.employee.*;

/**  
 *  
 *  <p>
 *  Advanced Java (Java 152-112) <br>
 *  Unit 4, Sessions Lab <br>
 *  Date: 11-28-2016
 *
 *  @author Aaron Groom
 */
@WebServlet(
    name = "Sessionlab", 
    urlPatterns = {"/session-lab"}
)
public class Project4SessionLab extends HttpServlet {

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
        
        HttpSession session = request.getSession();
        Integer sessionCounter = (Integer) session.getAttribute("project4SessionCounter");
        
        if (sessionCounter == null) {
            sessionCounter = 1;
        } else {
            sessionCounter++;
        }
        session.setAttribute("project4SessionCounter", sessionCounter);
        
        String url = "/project4Session.jsp";
         
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}