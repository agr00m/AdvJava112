package java112.project2;
 
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
 
/**
 *  This is a simple servlet to show html output
 *
 *@author    eknapp
 */
@WebServlet (
    name = "simpleServlet", 
    urlPatterns = { "/simple-html" }
)
public class SimpleHtmlServlet extends HttpServlet {
 
     
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
 
        response.setContentType("text/html");
 
        PrintWriter  out  = response.getWriter();
        out.println("<html><body>Hello there!</body></html>");
 
    }
}