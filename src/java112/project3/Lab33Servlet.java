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
 *  Unit 3, Lab 3 <br>
 *  Date: 10-24-2016
 *
 *  @author Aaron Groom
 */
@WebServlet(
    name = "Lab33Servlet", 
    urlPatterns = { "/lab33Servlet"}
)
public class Lab33Servlet extends HttpServlet {
    
    private int hitCounter;
    
    public void init() {
        hitCounter = 0;
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
                    
        Map map = new HashMap();
        map.put("text", "Hit Counter:");
        map.put("number", ++hitCounter);
        map.put("aDate", new Date());
        map.put("html", "<a href=\"index.jsp\">Home</a>");
        
        request.setAttribute("myMap", map);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String url = "/lab33.jsp";
         
        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }
}