package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java112.analyzer.*;

/**  
 *
 *  <p>
 *  Advanced Java (Java 152-112) <br>
 *  Unit 4, Project 4 <br>
 *  Date: 11-28-2016
 *
 *  @author Aaron Groom
 *  @since  4.0
 */
@MultipartConfig
@WebServlet(
    name = "FileUploadServlet", 
    urlPatterns = {"/upload"}
)
public class FileUploadServlet extends HttpServlet {
        
    /**
     *  Handles HTTP POST requests. 
     *
     *  @param  request                 the HttpServletRequest object
     *  @param  response                the HttpServletResponse object
     *  @exception  ServletException    if there is a Servlet failure
     *  @exception  IOException         if there is an IO failure
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
        
        HttpSession session = request.getSession(); 
        String message = "";
        
        response.setContentType("text/html;charset=UTF-8");
        
        final String path = "/home/student/projects/uploads";
        final Part filePart = request.getPart("file");
        final String fileName = getFileName(filePart);
    
        OutputStream out = null;
        InputStream filecontent = null;
    
        try {
            out = new FileOutputStream(new File(path + File.separator + fileName));
            filecontent = filePart.getInputStream();
    
            int read = 0;
            final byte[] bytes = new byte[1024];
    
            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            
            message = "File successfully uploaded <br>";
            runAnalyzers(fileName);      
        } catch (FileNotFoundException fne) {
            System.err.println("Error adding employee " + fne);
            fne.printStackTrace();
            message = "File not found.";
        } finally {
            if (out != null) {
                out.close();
            }
            if (filecontent != null) {
                filecontent.close();
            }
        }
        
        session.setAttribute("message", message);
        String url = request.getContextPath() + "/analyzer_upload.jsp";
        response.sendRedirect(url);
    }
    
    /**
     *  Runs the analyzers on the uploaded file. It's essentially the same as
     *  the AnalyzerDriver class. It creates a new instance of the AnalyzeFile
     *  class, then calls the runAnalysis method, passing it the path to the
     *  input and properties file.
     *  
     *  @param fileName name of the file to analyze
     */
    private void runAnalyzers(String fileName) {
        String[] args = new String[2];
        args[0] = "uploads/" + fileName;
        args[1] = "/analyzer.properties";
        
        AnalyzeFile analyzeFile = new AnalyzeFile();
        analyzeFile.runAnalysis(args);
    }
    
    /**
     *  Retrieves the file name from the file part.
     *  
     *  @param part part of the POST header with file name
     */
    private String getFileName(final Part part) {
        
        final String partHeader = part.getHeader("content-disposition");
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}