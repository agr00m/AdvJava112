package java112.analyzer;

import java.io.*;
import java.util.*;
import java.text.NumberFormat;

/**  
 *  Creates a summary report for the Filelyzer package. The class also keeps
 *  track of the total number of tokens processed to include in the report.
 *  The name and location of the report is determined by the analyzer
 *  properties file.
 *  <p>
 *  Advanced Java (Java 152-112)<br>
 *  Unit 1, Project 1<br>
 *  Date: 09-14-2016
 *
 *  @author Aaron Groom
 *  @since Version 1.0
 */
public class SummaryReport implements Analyzer {
    
    private int tokenCount = 0;
    private Properties properties = null;
    
    /**
     *  No parameter constructor.
     */
    public SummaryReport() {
    
    }
    
    /**
     *  Override default constructor.
     *
     *  @param properties project properties file
     */
    public SummaryReport(Properties properties) {
        this.properties = properties;
    }
        
    /**
     *  Processes a token by checking to see if the token is not null or empty
     *  and increments the total tokens count.
     *  
     *  @param token token to process
     */
    public void processToken(String token) {
        if (token != null && !token.isEmpty()) {
            tokenCount++;
        }
    }
    
    /**
     *  Returns the total number of tokens processed.
     *  
     *  @return total tokens count
     */
    public int getTotalTokensCount () {
        return tokenCount;
    }
    
    /**
     *  Creates a summary report of the tokens processed. The report contains:
     *  <ul>
     *  <li> Name of the application </li>
     *  <li> Author's name </li>
     *  <li> Author's email address </li>
     *  <li> Name and path of the input file processed </li>
     *  <li> Date the file was processed </li>
     *  <li> Total number of tokens processed </li>
     *  </ul>
     */
    public void writeOutputFile(String inputFilePath) {
        
        File inputFile = null;
        Date currentDate = new Date();
        String outputFilePath = properties.getProperty("output.dir") +
                                properties.getProperty("output.file.summary");
        
        try (PrintWriter outputWriter = 
            new PrintWriter(new FileWriter(outputFilePath))
        ) {
            inputFile = new File(inputFilePath);
            
            outputWriter.println("Application: " + 
                properties.getProperty("application.name"));
            outputWriter.println("Author: " + 
                properties.getProperty("author"));
            outputWriter.println("email: " + 
                properties.getProperty("author.email.address"));
            outputWriter.println("Input file: " + inputFile.getAbsolutePath());
            outputWriter.println("Analyzed on: " + currentDate);
            outputWriter.println("Total token count: " + 
                NumberFormat.getNumberInstance(Locale.US).format(tokenCount));
            System.out.println(properties.getProperty("output.file.summary") + 
                               " written Successfully"); 
        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        } 

    }
}