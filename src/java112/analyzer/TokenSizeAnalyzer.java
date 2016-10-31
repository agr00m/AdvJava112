package java112.analyzer;

import java.io.*;
import java.util.*;
import java.math.*;

/**  
 *  Token Size Analyzer determines the size distribution of tokens within the
 *  input file. It then produces a report containing two parts. Part one lists
 *  each token and the number of times it occurred within the input file. Part
 *  two displays a histogram showing a visual representation of the token's 
 *  distribution compared to other tokens.
 *  <p>
 *  Advanced Java (Java 152-112)<br>
 *  Unit 3, Project 3<br>
 *  Date: 10-17-2016
 *  
 *  @author Aaron Groom
 *  @since Version 3.0
 */

public class TokenSizeAnalyzer implements Analyzer {
    
    private Properties properties = null;
    private Map<Integer, Integer> tokenSizes = null; 
    private int maximumSize = 0;
    
    /**
     *  Instantiates a new TreeSet instance and assignes it to the 
     *  uniqueTokensList Set.
     */
    public TokenSizeAnalyzer() {
        tokenSizes = new TreeMap<Integer, Integer>();
    }
    
    /**
     *  Override default constructor.
     *
     *  @param properties project 2 properties file
     */
    public TokenSizeAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }
    
    /**
     *  Processes a token by first ensuring the token is not null or empty.
     *  Then it increments the tokenOccurence count (the token's location
     *  within the input file) and checks to see if the token is a keyword.
     *  If it is a keyword, then it updates the ArrayList of occurances by
     *  adding a new element containing the tokenOccurence count.
     *  
     *  @param token token value to process
     */
    public void processToken(String token) {
        if (token != null && !token.isEmpty()) {
            int tokenSize = token.length();
            if (tokenSizes.containsKey(tokenSize)) {
                tokenSizes.put(tokenSize, tokenSizes.get(tokenSize) + 1);
            } else {
                tokenSizes.put(tokenSize, 1);
            }
            
            if (tokenSize > maximumSize) {
                maximumSize = tokenSize;
            }
        }
    }
    
    /**
     *  Creates a report containing each unique token processed. Tokens
     *  are listed in alphabetical order and printed on their own line. 
     */
    public void writeOutputFile(String inputFilePath) {       
        
        String outputFilePath = properties.getProperty("output.dir") +
                                properties.getProperty("output.file.token.size");
        int maxCount = calcHighestCount();
        
        try (PrintWriter outputWriter = 
            new PrintWriter(new FileWriter(outputFilePath))
        ) {
            tokenSizes.forEach((k,v)->outputWriter.println(k + "\t" + v));
            
            outputWriter.println();
            outputWriter.println();
            
            for (Map.Entry<Integer,Integer> entry : tokenSizes.entrySet()) {
                for (int i = 0; i < calcHistCount(entry.getValue(), maxCount); i++) {
                    outputWriter.print("*");        
                }
                outputWriter.println();
            }

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
     *  Calculates the highest token size count in the map. 
     *
     *  @return highest token size count
     */
    private int calcHighestCount() {
        int highestCount = 0;
        for (Map.Entry<Integer,Integer> entry : tokenSizes.entrySet()) {
            if (entry.getValue() > highestCount) {
                highestCount = entry.getValue();
            }
        }
        return highestCount;
    }
    
    /**
     *  Calculates the number of '*' characters to print for the histogram.
     *
     *  @param tokenSize length of token
     *  @param higestCount highest token count in map 
     */
    private int calcHistCount(int tokenSize, int higestCount) {
        int histCount = (int)Math.round(tokenSize * 80.0 / higestCount);
        if (histCount < 1) {
            histCount = 1;
        }
        return histCount;
    }
    
    /**
     *  Get method for the tokenSizes map.
     *
     *  @return token sizes
     */
    public Map<Integer, Integer> getTokenSizes() {
        return tokenSizes;
    }
    
    /**
     *  Get method for maximumSize.
     *
     *  @return maximum token size
     */
    public int getMaximumSize() {
        return maximumSize;
    }
}