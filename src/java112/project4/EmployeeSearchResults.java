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
 *  Date: 11-22-2016
 *
 *  @author Aaron Groom
 *  @since  4.0
 *  
 *  Notes: 
 */
@WebServlet(
    name = "searchResults", 
    urlPatterns = {"/search-results"}
)
public class EmployeeSearchResults extends HttpServlet {

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
        
        ServletContext context = getServletContext();
        HttpSession session = request.getSession();
        EmployeeDirectory ed = (EmployeeDirectory) context.getAttribute("employeeDirectory");
        
        String searchTerm = request.getParameter("searchTerm");
        String searchType = request.getParameter("searchType");
        
        Search search = new Search();
        search.setSearchTerm(searchTerm);
        search.setSearchType(searchType);
        
        if (search.getSearchType().equals("emp_id")) {
            search = ed.findEmployeeById(search);
        } else {
            search = ed.findEmployeeByLastName(search);
        }
        
        session.setAttribute("searchResults", search);
                
        String url = "/employee_search_results.jsp";
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}