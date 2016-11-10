package java112.analyzer;

import java.io.*;
import java.util.*;
import java.math.*;

/**  
 *  Determines the size distribution of tokens within an input file. It then 
 *  produces a report containing two parts. Part one lists each token and the 
 *  number of times it occurred within the input file. Part two displays a 
 *  histogram showing a visual representation of the token's distribution 
 *  compared to other token sizes.<br><br>
 *  
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
     *  Overload constructor with the project properties file.
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
        if (token != null && !token.isEmpty()) {    // Check if null or empty
            int tokenSize = token.length();         // Get token size
            tokenSizes.putIfAbsent(tokenSize, 0);   // Add if not present
            tokenSizes.put(tokenSize, tokenSizes.get(tokenSize)+1); // Increment
        }
    }
    
    /**
     *  Creates a report containg the size distribution of the tokens in the
     *  input file. The report includes a table with the token sizes and 
     *  frequency each occurred and a historgram showing the proportinal 
     *  relationship of the frequencies.
     *  
     *  @param inputFilePath input file path
     */
    public void writeOutputFile(String inputFilePath) {       
        
        String outputFilePath = properties.getProperty("output.dir") +
                                properties.getProperty("output.file.token.size");
        int histHeight = 40;    // Top/Bottom histogram character height
        maximumSize = Collections.max(tokenSizes.values()); // Find maximumSize
        
        try (PrintWriter outputWriter = 
            new PrintWriter(new FileWriter(outputFilePath))
        ) {
            // Print tables and histograms
            printTokenTable(outputWriter);
            printHistogramLtoR(outputWriter);
            printHistogramRtoL(outputWriter);            
            printHistogramBtoT(outputWriter, histHeight);
            printHistogramTtoB(outputWriter, histHeight);
            
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
     *  Prints a table containing the size of tokens processed and the frequency
     *  each size occurred in the input file.
     *  
     *  @param outputWriter output stream to print to
     */
    void printTokenTable(PrintWriter outputWriter) {
        tokenSizes.forEach((k,v)->outputWriter.println(k + "\t" + v));
        outputWriter.println("Maximum Size = " + maximumSize);
        outputWriter.println();
    }
    
    /**
     *  Prints a histogram of the size distributions. The histogram is displayed
     *  from left to right.
     *  
     *  @param outputWriter output stream to print to
     */
    void printHistogramLtoR(PrintWriter outputWriter) {
        printDividerLine(outputWriter, "-", 80);
        outputWriter.println("    Token Size Histogram (Left -> Right)");
        printDividerLine(outputWriter, "-", 80);
        for (Map.Entry<Integer,Integer> entry : tokenSizes.entrySet()) {
            outputWriter.print(entry.getKey() + "\t");
            for (int i = 0; i < map(entry.getValue(), 76); i++) {
                outputWriter.print("*");        
            }
            outputWriter.println();
        }
        outputWriter.println();
    }
    
    /**
     *  Prints a histogram of the size distributions. The histogram is displayed
     *  from right to left.
     *  
     *  @param outputWriter output stream to print to
     */
    void printHistogramRtoL(PrintWriter outputWriter) {
        
        printDividerLine(outputWriter, "-", 80);
        outputWriter.println("    Token Size Histogram (Right -> Left)");
        printDividerLine(outputWriter, "-", 80);
        
        for (Map.Entry<Integer,Integer> entry : tokenSizes.entrySet()) {
            outputWriter.print(entry.getKey() + "\t");
            for (int i = 0; i < 76; i++) {
                if (map(entry.getValue(), 76) < (76-i)) {
                    outputWriter.print(" ");
                } else {
                    outputWriter.print("*");
                }
            }
            outputWriter.println();
        }
        outputWriter.println();
    }
    
    /**
     *  Prints a histogram of the size distributions. The histogram is displayed
     *  from bottom to top.
     *  
     *  @param outputWriter output stream to print to
     */
    void printHistogramBtoT(PrintWriter outputWriter, int histHeight) {
        
        printDividerLine(outputWriter, "-", 80);
        outputWriter.println("    Token Size Histogram (Bottom -> Top)");
        printDividerLine(outputWriter, "-", 80);
        
        for (int height = histHeight; height >= 1; height--) {
            for (Map.Entry<Integer,Integer> entry : tokenSizes.entrySet()) {
                if (map(entry.getValue(), histHeight) >= height) {
                    outputWriter.print("*\t");
                } else {
                    outputWriter.print(" \t");
                }
                //outputWriter.print("\t");
            }
            outputWriter.println();
        }
        for (Map.Entry<Integer,Integer> entry : tokenSizes.entrySet()) {
            outputWriter.print(entry.getKey() + "\t");
        }
        outputWriter.print("\n\n");
    }
    
    /**
     *  Prints a histogram of the size distributions. The histogram is displayed
     *  from top to bottom.
     *  
     *  @param outputWriter output stream to print to
     *  @param maxRange maximum value in the new range
     */
    void printHistogramTtoB(PrintWriter outputWriter, int histHeight) {
        
        printDividerLine(outputWriter, "-", 80);
        outputWriter.println("    Token Size Histogram (Top -> Bottom)");
        printDividerLine(outputWriter, "-", 80);
            
        for (Map.Entry<Integer,Integer> entry : tokenSizes.entrySet()) {
                outputWriter.print(entry.getKey() + "\t");
        }
        outputWriter.println();
        
        for (int height = 1; height <= histHeight; height++) {
            for (Map.Entry<Integer,Integer> entry : tokenSizes.entrySet()) {
                if (map(entry.getValue(), histHeight) >= height) {
                    outputWriter.print("*");
                } else {
                    outputWriter.print(" ");
                }
                outputWriter.print("\t");
            }
            outputWriter.println();
        }
    }
    
    /**
     *  Maps a value from one range to another range. The from range is always
     *  0 - maximumSize. The to range is 0 - maxRange.
     *
     *  @param value length of token
     *  @param maxRange maximum value in the new range
     */
    private int map(int value, int maxRange) {
        int histCount = (int)Math.round(value * maxRange / maximumSize);
        if (histCount < 1) {
            histCount = 1;
        }
        return histCount;
    }
    
    /**
     *  Prints a divider line to the output stream.
     *
     *  @param outputWriter output spream to print to
     *  @param s characters to print
     *  @param chars number of times to print the characters (max 80)
     */
    public void printDividerLine(PrintWriter outputWriter, String s, int chars) {
        if (chars * s.length() > 80) {
            chars = 80 / s.length();
        }
        for (int i = 0; i < chars; i++) {
            outputWriter.print(s);
        }
        outputWriter.println();
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