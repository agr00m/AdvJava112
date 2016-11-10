package java112.analyzer;

import java.io.*;
import java.util.*;

/**  
 *  Determines the unique tokens greater than or equal to a specified length
 *  within an input file. It then creates a report listing all the unique 
 *  tokens processed, in alphabetical order, that meet this criteria. The 
 *  length of "big words" and the name and location of the report is determined 
 *  by the analyzer properties file. <br><br>
 *  
 *  Advanced Java (Java 152-112)<br>
 *  Unit 2, Project 2<br>
 *  Date: 10-06-2016
 *  
 *  @author Aaron Groom
 *  @since Version 2.0
 */

public class BigWordAnalyzer implements Analyzer {
    
    private Set<String> bigWords = null;    
    private Properties properties = null;
    private int minimumWordLength = 0;
    
    /**
     *  Instantiates a new TreeSet instance and assignes it to the 
     *  uniqueTokensList Set.
     */
    public BigWordAnalyzer() {
        bigWords = new TreeSet<String>();
    }
    
    /**
     *  Overload constructor with the project properties file.
     *
     *  @param properties project 2 properties file
     */
    public BigWordAnalyzer(Properties properties) {
        this();
        this.properties = properties;
        minimumWordLength = 
            Integer.parseInt(properties.getProperty("bigwords.minimum.length"));
    }
    
    /**
     *  Processes the passed token to see if it's a "big word." It ensures the 
     *  passed token is not null or empty, then adds it to the unique token 
     *  list. The token list is maintained sing a TreeSet which ensures only 
     *  unique tokens are kept.
     *
     *  @param token token value to process
     */
    public void processToken(String token) {
        if (token != null && !token.isEmpty() && 
                token.length() >= minimumWordLength) {
            bigWords.add(token);
        }
    }
    
    /**
     *  Creates a report containing each unique token processed. Tokens
     *  are listed in alphabetical order and printed on their own line. The name
     *  and location of the report are determined by the analyzer properties
     *  file.
     */
    public void writeOutputFile(String inputFilePath) {       
        
        String outputFilePath = properties.getProperty("output.dir") +
                                properties.getProperty("output.file.bigwords");
        
        try (PrintWriter outputWriter = 
            new PrintWriter(new FileWriter(outputFilePath))
        ) {
            for (String token: bigWords) {
                outputWriter.println(token);
            }
            System.out.println(properties.getProperty("output.file.bigwords") + 
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
     *  Get method for the bigWords set.
     *
     *  @return big words list
     */
    public Set<String> getBigWords() {
        return bigWords;
    }
}