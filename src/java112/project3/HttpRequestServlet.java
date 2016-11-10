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
 *  Unit 3, Project 3 <br>
 *  Date: 11-01-2016
 *
 *  @author Aaron Groom
 *  @since  3.0
 */
@WebServlet(
    name = "HTTPRequestServlet", 
    urlPatterns = { "/httpRequest"}
)
public class HttpRequestServlet extends HttpServlet {

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
        
        HttpRequestData rd = new HttpRequestData();
        
        rd.setRemoteComputer(request.getRemoteHost());
        rd.setRemoteComputerAddress(request.getRemoteAddr());
        rd.setRequestMethod(request.getMethod());
        rd.setRequestURI(request.getRequestURI());
        rd.setRequestURL(request.getRequestURL().toString());
        rd.setRequestProtocol(request.getProtocol());
        rd.setServerName(request.getServerName());
        rd.setServerPort(request.getServerPort());
        rd.setServerLocale(request.getLocale().toString());
        rd.setQueryString(request.getQueryString());
        rd.setQueryParameter(request.getParameter("queryParameter"));
        rd.setUserAgent(request.getHeader("user-agent"));
        
        request.setAttribute("data", rd);
        
        String url = "/project3.jsp";
         
        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }
}