package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java112.employee.*;

/**  
 *  
 *  
 *  <p>
 *  Advanced Java (Java 152-112) <br>
 *  Unit 4, Project 4 <br>
 *  Date: 11-28-2016
 *
 *  @author Aaron Groom
 *  @since  4.0
 *  
 *  Notes: 
 */
@WebServlet(
    name = "addEmployee", 
    urlPatterns = {"/add-employee"}
)
public class EmployeeAdd extends HttpServlet {
    
    private String message = "";
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
        doPost(request, response);
    }
    /**
     *  Handles HTTP POST requests.
     *
     *  @param  request                 the HttpServletRequest object
     *  @param  response                the HttpServletResponse object
     *  @exception  ServletException    if there is a Servlet failure
     *  @exception  IOException         if there is an IO failure
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        ServletContext context = getServletContext();
        EmployeeDirectory ed = (EmployeeDirectory) context.getAttribute("employeeDirectory");
        message = "";
        
        String first_name = request.getParameter("first_name");
        String last_name  = request.getParameter("last_name");
        String ssn        = request.getParameter("ssn");
        String dept       = request.getParameter("dept");
        String room       = request.getParameter("room");
        String phone      = request.getParameter("phone");
        
        if (validInputs(first_name, last_name, ssn, dept, room, phone)) {
            ed.addEmployee(first_name, last_name, ssn, dept, room, phone);
            message = "<h3>Employee Added.</h3>";
        } else {
            message = "<h3>Errors Found</h3><ul>" + message + "</ul>";
        }

        session.setAttribute("message", message);
        String url = request.getContextPath() + "/employee_add.jsp";
        response.sendRedirect(url);
    }
    
    private boolean validInputs(String first_name, String last_name, 
                String ssn, String dept, String room, String phone) {
        
        boolean flag = true;
        
        if ((first_name == null) || (first_name.trim().equals(""))) {
            message += "<li>Enter First Name.</li>";
            flag = false;
        }
        
        if ((last_name == null) || (last_name.trim().equals(""))) {
            message += "<li>Enter Last Name.</1i>";
            flag = false;
        }
        
        if ((ssn == null) || (ssn.trim().equals(""))) {
            message += "<li>Enter SSN.</li>";
            flag = false;
        }
        
        if ((dept == null) || (dept.trim().equals(""))) {
            message += "<li>Enter Department.</li>";
            flag = false;
        }
        
        if ((room == null) || (room.trim().equals(""))) {
            message += "<li>Enter Room #.</li>";
            flag = false;
        }
        
        if ((phone == null) || (phone.trim().equals(""))) {
            message += "<li>Enter Phone #.</li>";
            flag = false;
        }
        
        return flag;
    }
}