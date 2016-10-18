package java112.analyzer;
import java.io.*;
import java.util.*;

/**  
 *  Creates a report containing all the unique tokens processed and the number
 *  of times the token occured. The name and location of the report is 
 *  determined by the analyzer properties file. 
 *  <p>
 *  Advanced Java (Java 152-112)<br>
 *  Unit 2, Project 2<br>
 *  Date: 10-06-2016
 *  
 *  @author Aaron Groom
 *  @since Version 2.0
 */

public class TokenCountAnalyzer implements Analyzer {
    
    private Properties properties = null;
    private Map<String, Integer> tokenCounts = null;    
    
    /**
     *  Instantiates a new TreeSet instance and assignes it to the 
     *  uniqueTokensList Set.
     */
    public TokenCountAnalyzer() {
        tokenCounts = new TreeMap<String, Integer>();
    }
    
    /**
     *  Override default constructor with the analyzer properties file.
     *
     *  @param properties project 2 properties file
     */
    public TokenCountAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }
    
    /**
     *  Processes a token by first ensuring the token is not null or empty.
     *  Then it checks to see if the token has already been processed. If no,
     *  it adds the token to the list. If yes, it increments the occurance 
     *  count of the token.
     *
     *  @param token token to process
     */
    public void processToken(String token) {
        if (token != null && !token.isEmpty()) {
            if (tokenCounts.containsKey(token)) {
                tokenCounts.put(token, tokenCounts.get(token) + 1);
            } else {
                tokenCounts.put(token, 1);
            }
        }
    }
    
    /**
     *  Creates a report containing each unique token processed and the number
     *  of times the token appears in the file. Each token/count appears on 
     *  its own line in alphabetical order.
     */
    public void writeOutputFile(String inputFilePath) {       
        
        String outputFilePath = properties.getProperty("output.dir") +
            properties.getProperty("output.file.token.count");
        
        try (PrintWriter outputWriter = 
            new PrintWriter(new FileWriter(outputFilePath))
        ) {
            tokenCounts.forEach((k,v)->outputWriter.println(k + "\t" + v));
            System.out.println(
                properties.getProperty("output.file.token.count") + 
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
     *  Get method for the tokenCounts map.
     *
     *  @return unique tokens with count
     */
    public Map getTokenCounts() {
        return tokenCounts;
    }
}