package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java112.employee.*;

/**  
 *  Adds a new employee to the employee database. It first retrieves the input
 *  from the Add Employee web form and verifies that the entered information
 *  is correct. If so, adds the employee via the addEmployee() method in the 
 *  EmployeeDirectory class and returns a confirmation. If any input is not 
 *  valid, it returns a message indicating which fields were not valid. 
 *  <p>
 *  Advanced Java (Java 152-112) <br>
 *  Unit 4, Project 4 <br>
 *  Date: 11-28-2016
 *
 *  @author Aaron Groom
 *  @since  4.0
 */
@WebServlet(
    name = "addEmployee", 
    urlPatterns = {"/add-employee"}
)
public class EmployeeAdd extends HttpServlet {
    
    private String message = "";
    
    /**
     *  Handles HTTP GET requests. Redundant method that simply redirects
     *  to the doPost method.
     *
     *  @param  request                 the HttpServletRequest object
     *  @param  response                the HttpServletResponse object
     *  @exception  ServletException    if there is a Servlet failure
     *  @exception  IOException         if there is an IO failure
     */
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
    
    /**
     *  Checks to see if the information entered on the add employee web for
     *  is valid. If any information is invalid, it adds a message indicating
     *  what fields are invalid and why, and sets the return valid flag to false.
     *
     *  @param first_name employee first name 
     *  @param last_name employee last name
     *  @param ssn employee social security number
     *  @param dept employee department
     *  @param room employee room number
     *  @param phone employee phone number
     *  @return true of data is valid, false if errors exist
     */
    private boolean validInputs(String first_name, String last_name, 
                String ssn, String dept, String room, String phone) {
        
        boolean flag = true;
        
        if ((first_name == null) || (first_name.trim().equals(""))) {
            message += "<li>Enter First Name.</li>";
            flag = false;
        } else if (first_name.length() > 25) {
            message += "<li>First name exceeds maximum length (25 characters).</li>";
            flag = false;
        }
        
        if ((last_name == null) || (last_name.trim().equals(""))) {
            message += "<li>Enter Last Name.</1i>";
            flag = false;
        } else if (last_name.length() > 30) {
            message += "<li>Last name exceeds maximum length (30 characters).</li>";
            flag = false;
        }
        
        if ((ssn == null) || (ssn.trim().equals(""))) {
            message += "<li>Enter SSN.</li>";
            flag = false;
        } else if (!ssn.matches("\\d{3}-\\d{2}-\\d{4}")) {
            message += "<li>Invalid SSN format (###-##-####)</li>";
            flag = false;
        }
        
        if ((dept == null) || (dept.trim().equals(""))) {
            message += "<li>Enter Department.</li>";
            flag = false;
        } else if (dept.length() > 10) {
            message += "<li>Department exceeds maximum length (10 characters).</li>";
            flag = false;
        }
        
        if ((room == null) || (room.trim().equals(""))) {
            message += "<li>Enter Room #.</li>";
            flag = false;
        } else if (room.length() > 10) {
            message += "<li>Room # exceeds maximum length (10 characters).</li>";
            flag = false;
        }
        
        if ((phone == null) || (phone.trim().equals(""))) {
            message += "<li>Enter Phone #.</li>";
            flag = false;
        } else if (!phone.matches("\\d{3}-\\d{4}")) {
            message += "<li>Invalid phone # format (###-####)</li>";
            flag = false;
        }
        
        return flag;
    }
}