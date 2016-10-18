package java112.project2;

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
 *  Unit 2, Lab 5 <br>
 *  Date: 10-05-2016
 *
 *  @author Aaron Groom
 */
@WebServlet(
    name = "first112Servlet", 
    urlPatterns = { "/first"}
)
public class First112Servlet extends HttpServlet {
    
    private int hitCounter = 1;
    private Date firstHit = null;
    
    public void init() {
        log("Lab5 init log.");
        firstHit = getCurrentDate();
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
    
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.print("<HTML>");
        printHead(out);
        printBody(out);
        out.print("</HTML>");
        out.close();
        
        log("Lab5 doGet log.");
    }
    
    public void destroy() {
        log("Lab5 destroy log.");   
    }
    
    private void printHead(PrintWriter out) {
        out.print("<HEAD>");
        out.print("<TITLE>First 112 Servlet</TITLE>");
        out.print("</HEAD>");
    }
    
    private void printBody(PrintWriter out) {
        out.print("<BODY>");
        out.print("<center>");
        out.print("<h2>Aaron Groom</h2>");
        out.print("<img src=\"images/advanced-java.png\"><br>");
        out.print("Advanced Java Programming <br>");
        out.print("Course No. 10-152-112 <br>");
        out.print("<a href=\"/java112\">Home Page</a>");
        out.print("</center>");
        out.print("</BODY>");
    }
        
    private Date getCurrentDate() {
        Date currentDate = new Date();
        return currentDate;
    }
    
}

