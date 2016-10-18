package java112.analyzer;
import java.io.*;

/**  
 *  Token analyzer Interface for Filelyzer package. Classes that implements the 
 *  Analyzer interface must be able to analyze and process tokens and create an
 *  output file.
 *  <p>
 *  Advanced Java (Java 152-112)<br>
 *  Unit 1, Project 1<br>
 *  Date: 09-14-2016
 *  
 *  @author Aaron Groom
 *  @since Version 1.0
 */
public interface Analyzer {
    
    /**
     *  Processes a token.
     * 
     *  @param token token to process
     */
    void processToken(String token);
    
    /**
     *  Creates, and writes to, an output file.
     * 
     *  @param inputFilePath path to the input file, including the file name
     */
    void writeOutputFile(String inputFilePath);
}