package java112.analyzer;

import java.io.*;
import java.util.*;
import java.math.*;

/**  
 *  Keyword Analyzer determines where keywords are within the input file.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     tokens by checking to see if they are a keyword.
 *  If the token is a keyword, it saves the location of each occurance within
 *  the input file and produces a report displaying each keyword and the 
 *  location(s) it occurred.
 *  <p>
 *  Advanced Java (Java 152-112)<br>
 *  Unit 3, Project 3<br>
 *  Date: 10-31-2016
 *  
 *  @author Aaron Groom
 *  @since Version 3.0
 */

public class KeywordAnalyzer implements Analyzer {
    
    private Map<String, List<Integer>> keywordMap;
    private Properties properties;
    private int tokenOccurence;
    
    /**
     *  Default constructor for class. Instantiates a new instance of 
     *  HashMap and assigns it to the keywordMap.
     */
    public KeywordAnalyzer() {
        keywordMap = new TreeMap<String, List<Integer>>();
        tokenOccurence = 0;
    }
    
    /**
     *  Override constructor. If provided with the analyzer propert file, 
     *  it populates the HashMap with the list of keywords.
     *
     *  @param properties project properties file
     */
    public KeywordAnalyzer(Properties properties) {
        this();
        this.properties = properties;
        
        String inFile = properties.getProperty("file.path.keywords");
        
        try (BufferedReader inputReader = new BufferedReader(new FileReader(inFile))) {            
            while (inputReader.ready()) {
                keywordMap.put(inputReader.readLine(), new ArrayList<Integer>());
            }
        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    
    /**
     *  Processes a token by first ensuring the token is not null or empty.
     *  Then it increments the tokenOccurence count (the token's location 
     *  within the input file) and checks to see if the token is a keyword.
     *  If it is a keyword, then it updates the ArrayList of occurances by
     *  adding a new element containing the tokenOccurence count.
     *  
     *  @param token token to process
     */
    public void processToken(String token) {
        if (token != null && !token.isEmpty()) {
            tokenOccurence++;
            keywordMap.computeIfPresent(token, (k,v) -> {
                v.add(tokenOccurence);
                return v;
            });
        }
    }
    
    /**
     *  Creates the report containing each keyword and the location(s)
     *  of the keywords in the input file.
     *  
     *  @param inputFilePath 
     */
    public void writeOutputFile(String inputFilePath) {       
        
        String outputFilePath = properties.getProperty("output.dir") +
                                properties.getProperty("output.file.keyword");
        
        try (PrintWriter outputWriter = 
            new PrintWriter(new FileWriter(outputFilePath))
        ) {
            
            keywordMap.forEach( (k,v) -> {
                    outputWriter.print(k + " =\n[");
                    for (int i = 1; i < v.size(); i++) {
                        outputWriter.print(v.get(i-1) + ", ");
                        if (i % 9 == 0) {
                            outputWriter.print("\n");
                        }
                     }
                     outputWriter.print(v.get(v.size()-1) + "]\n\n");
            });

            System.out.println(properties.getProperty("output.file.keyword") + 
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