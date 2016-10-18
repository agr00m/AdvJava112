package java112.analyzer;
import java.io.*;

/**  
 *  Driver class for Filelyzer package. 
 *  <p>
 *  Advanced Java (Java 152-112)<br>
 *  Unit 1, Project 1<br>
 *  Date: 09-14-2016
 *  
 *  @author Aaron Groom
 *  @since Version 1.0
 */
public class AnalyzerDriver {

    /**
     *  Main method for the class. Accepts command line arguments, 
     *  creates a new instance of the AnalizeFile class and calls its  
     *  runAnalysis() method.
     *
     *  @param args command line arguments
     */
    public static void main (String[] args) {
        AnalyzeFile analyzeFile = new AnalyzeFile();
        analyzeFile.runAnalysis(args);
    }
}

/*
 *  71,243 Unique Tokens
 *  4,468,588 Total Tokens
*/