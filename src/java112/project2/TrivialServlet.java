package java112.project2;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  This is part of a lab and is the first servlet for the course.
 *
 *  @author    eknapp
 */
@WebServlet(
    name = "trivialServlet", 
    urlPatterns = { "/trivial", "/simple" }
)
public class TrivialServlet extends HttpServlet {

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
        
        // set the response type before sending data
        PrintWriter out = response.getWriter();
        out.print("<HTML>");
        out.print("<HEAD><TITLE>TrivialServlet Output</TITLE></HEAD>");
        out.print("<BODY>");
        
        // Page headers
        out.print("<h1>TrivialServlet Here!</h1>");
        out.print("<h3>A simple change...</h3>");
        
        // Extra Challenge 1 - Ordered List
        out.print("<ol>");
        out.print("<li>Chevy</li>");
        out.print("<li>Toyota</li>");
        out.print("<li>Saturn</li>");
        out.print("</ol>");

        // Extra Challenge 2 questions
        out.print("<p><b>What is @WebServlet? What does it do?</b><br>");
        out.print("@WebServlet is an annotation used to declare/define a " +
                  "servlet component in a web application.</p>");
        out.print("<p><b>What is name? What does it do?</b><br>");
        out.print("name is an attribute of the @WebServlet and defines the " +
                  "name of the servlet.</p>");
        out.print("<p><b>What is urlPatterns? What does it do?</b><br>");
        out.print("From what I can tell, urlPatterns defines the URL " +
                  "paths that can be used to execute the WebServlet. It is " +
                  "also recommended, but not required, that it be used if " + 
                  " you want to define other attributes of the servlet.</p>");
        
        // Image
        out.print("<p>");
        out.print("<img src=\"images/emma1.jpg\">");
        out.print("</p>");
        
        // Link to homepage
        out.print("<a href=\"/java112\">Home</a>");
        
        System.out.println("Is this logging?");
        log("Is this logging?");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }
}