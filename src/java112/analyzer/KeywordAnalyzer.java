package java112.analyzer;

import java.io.*;
import java.util.*;
import java.math.*;

/**  
 *  
 *  <p>
 *  Advanced Java (Java 152-112)<br>
 *  Unit 3, Project 3<br>
 *  Date: 10-17-2016
 *  
 *  @author Aaron Groom
 *  @since Version 1.0
 */

public class KeywordAnalyzer implements Analyzer {
    
    private Map<String, List<Integer>> keywordMap;
    private Properties properties;
    private int tokenOccurence;
    
    /**
     *  Instantiates a new TreeSet instance and assignes it to the 
     *  uniqueTokensList Set.
     */
    public KeywordAnalyzer() {
        //tokenSizes = new TreeMap<Integer, Integer>();
    }
    
    /**
     *  Override default constructor.
     *
     *  @param properties project 2 properties file
     */
    public KeywordAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }
    
    /**
     *  
     *  
     *  @param token token value to process
     */
    public void processToken(String token) {
        if (token != null && !token.isEmpty()) {
            
            /*
            int tokenSize = token.length();
            if (tokenSizes.containsKey(tokenSize)) {
                tokenSizes.put(tokenSize, tokenSizes.get(tokenSize) + 1);
            } else {
                tokenSizes.put(tokenSize, 1);
            }
            if (tokenSize > maximumSize) {
                maximumSize = tokenSize;
            }
            */
        }
    }
    
    /**
     *  Creates a report containing each unique token processed. Tokens
     *  are listed in alphabetical order and printed on their own line. 
     */
    public void writeOutputFile(String inputFilePath) {       
        
        String outputFilePath = properties.getProperty("output.dir") +
                                properties.getProperty("output.file.token.size");
        
        try (PrintWriter outputWriter = 
            new PrintWriter(new FileWriter(outputFilePath))
        ) {
            
            /*
            tokenSizes.forEach((k,v)->outputWriter.println(k + "\t" + v));
            outputWriter.println();
            outputWriter.println();
            for (Map.Entry<Integer,Integer> entry : tokenSizes.entrySet()) {
                for (int i = 0; i < calcHistCount(entry.getValue(), maxCount); i++) {
                    outputWriter.print("*");        
                }
                outputWriter.println();
            }
            */
            System.out.println(properties.getProperty("output.file.token.size") + 
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
     *  Get method for keywordMap map.
     *
     *  @return keyword map
     */
    public Map<String, List<Integer>> getKeywordMap() {
        return keywordMap;
    }
}