package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**  
 *  Processes the report results and forwards them to the report results page.
 *  It first determines the requested report by getting the parameter from the
 *  request. It then opens the report and places it into an ArrayList which is
 *  added to the session.
 *  <p>
 *  Advanced Java (Java 152-112) <br>
 *  Unit 4, Project 4 <br>
 *  Date: 12-05-2016
 *
 *  @author Aaron Groom
 *  @since  4.0
 */
@WebServlet(
    name = "AnalyzerResults", 
    urlPatterns = {"/analyzer-results"}
)
public class AnalyzerResults extends HttpServlet {

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
        Properties properties = (Properties) context.getAttribute("analyzerProperties");
        
        String propertyName = "output.file." + request.getParameter("report");
        String fileName = properties.getProperty(propertyName);
        String inFile = properties.getProperty("output.dir") + fileName;
        
        session.setAttribute("report", getReport(inFile));
        session.setAttribute("reportName", getReportName(propertyName));
        String url = "/analyzer_results.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
    
    /**
     *  Gets a report, reads it into an ArrayList and returns the list. Each 
     *  line of the input file is added as a new element to the list.
     *
     *  @param inFile path to the input file
     *  @return arraylist containing the file
     */
    private List getReport(String inFile) {
        
        List<String> report = new ArrayList<String>();
        
        try (BufferedReader inputReader = new BufferedReader(new FileReader(inFile))) {
            String line = null;  
            while (inputReader.ready()) {
                line = inputReader.readLine();
                report.add(line);
            }
        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return report;
    }
    
    /**
     *  Returns the name of the report based on the properties file output file
     *  name parameter.
     *
     *  @param fileName properties file name parameter
     *  @return report name
     */
    private String getReportName(String fileName) {
        
        String reportName = "";
        
        if (fileName.equals("output.file.summary")) {
            reportName = "Summary";
        } else if (fileName.equals("output.file.unique")) {
            reportName = "Unique Tokens";
        } else if (fileName.equals("output.file.bigwords")) {
            reportName = "Big Words";
        } else if (fileName.equals("output.file.token.count")) {
            reportName = "Token Count";
        } else if (fileName.equals("output.file.lexical.density")) {
            reportName = "Lexical Density";
        } else if (fileName.equals("output.file.token.size")) {
            reportName = "Token Size";
        } else if (fileName.equals("output.file.keyword")) {
            reportName = "Keywords";
        } 
        return reportName;
    }
}
















