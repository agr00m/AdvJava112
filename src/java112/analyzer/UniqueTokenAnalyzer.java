package java112.analyzer;
import java.io.*;
import java.util.*;

/**  
 *  Determines the unique tokens present within an input file. It then produces
 *  a report contaning a list of all unique tokens, listed in alphabetical 
 *  order. The name and location of the report is determined by the analyzer 
 *  properties file. <br><br> 
 *  
 *  Advanced Java (Java 152-112)<br>
 *  Unit 1, Project 1<br>
 *  Date: 09-23-2016
 *  
 *  @author Aaron Groom
 *  @since Version 1.0
 */

public class UniqueTokenAnalyzer implements Analyzer {
    
    private Set<String> uniqueTokensList = null;    
    private Properties properties = null;
    
    /**
     *  Instantiates a new TreeSet instance and assignes it to the 
     *  uniqueTokensList Set.
     */
    public UniqueTokenAnalyzer() {
        uniqueTokensList = new TreeSet<String>();
    }
    
    /**
     *  Overload constructor with the project properties file.
     *
     *  @param properties project 2 properties file
     */
    public UniqueTokenAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }
    
    /**
     *  Ensures the passed token is not null or empthy, then adds it to the 
     *  unique token list. The token list is maintained sing a TreeSet which 
     *  ensures only unique tokens are kept. The name and location of the 
     *  report is determined by the analyzer properties file.
     *
     *  @param token token value to process
     */
    public void processToken(String token) {
        if (token != null && !token.isEmpty()) {
            uniqueTokensList.add(token);
        }
    }
    
    /**
     *  Creates a report containing each unique token processed. Tokens
     *  are listed in alphabetical order and printed on their own line. 
     */
    public void writeOutputFile(String inputFilePath) {       
        
        String outputFilePath = properties.getProperty("output.dir") +
                                properties.getProperty("output.file.unique");
        
        try (PrintWriter outputWriter = 
            new PrintWriter(new FileWriter(outputFilePath))
        ) {
            for (String token: uniqueTokensList) {
                outputWriter.println(token);
            }
            System.out.println(properties.getProperty("output.file.unique") + 
                               " written Successfully");
        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    
    /**
     *  Get method for the uniqueTokenList set.
     *
     *  @return unique token list
     */
    public Set getUniqueTokensList() {
        return uniqueTokensList;
    }
}