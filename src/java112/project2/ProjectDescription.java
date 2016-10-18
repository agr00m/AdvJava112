package java112.project2;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**  
 *  This HttpServlet produces an HTML report of the project 2 properties file
 *  in a table format. The report can be accessed via link on the home page.
 *  <p>
 *  Advanced Java (Java 152-112) <br>
 *  Unit 2, Project 2 <br>
 *  Date: 10-05-2016
 *
 *  @author Aaron Groom
 */
@WebServlet(
    name = "projectDescription", 
    urlPatterns = { "/description"}
)
public class ProjectDescription extends HttpServlet {
    
    private Properties properties = null;
    Set<String> set = null;
    
    public void init() {
        loadProperties("/project2.properties");
        set = properties.stringPropertyNames();
        //set = new TreeSet<String>(set);
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
   
    private void printHead(PrintWriter out) {
        out.print("<HEAD>");
        out.print("<TITLE>Project Description</TITLE>");
        out.print("<STYLE>");
        out.print("table, td {border: 1px solid black; border-collapse: collapse;}");
        out.print("</STYLE>");
        out.print("</HEAD>");
    }
    
    private void printBody(PrintWriter out) {
        out.print("<BODY>");
        out.print("<h2>Project Propeties Servlet</h2>");
        out.print("<table style=\"width:50%\">");
        for (String s : set) {
            out.print("<tr>");
            out.print("<td>" + s + "</td>");
            out.print("<td>" + 
                properties.getProperty(s).replaceAll("(\n)","<br/>") + "</td>");
            out.print("</tr>");
        }
        out.print("</table><br>");
        out.print("<a href=\"/java112\">Home</a>");
        out.print("</BODY>");
    }
    
    /**
     *  Opens the project's property file.
     *
     *  @param propertiesFilePath path to the properties file
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

