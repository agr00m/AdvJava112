package java112.analyzer;

import java.io.*;
import java.util.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**  
 *  Determines the lexical density of an input file. It then creates a report 
 *  that conntains the total word, lexical word count and the lexical density
 *  of the input file. <br><br>
 *  
 *  Advanced Java (Java 152-112)<br>
 *  Unit 2, Project 2<br>
 *  Date: 10-06-2016
 *  
 *  @author Aaron Groom
 *  @since Version 2.0
 */

public class LexicalDensityAnalyzer implements Analyzer {
    
    private Properties properties = null;
    private Set<String> functionWords = null;
    private int totalTokensCount = 0;
    private int functionWordsCount = 0;
    
    /**
     *  Instantiates a new TreeSet instance and assignes it to the 
     *  uniqueTokensList Set.
     */
    public LexicalDensityAnalyzer() {
        functionWords = new TreeSet<String>();
    }
    
    /**
     *  Overload constructor with the project properties file.
     *
     *  @param properties project 2 properties file
     */
    public LexicalDensityAnalyzer(Properties properties) {
        
        this();
        this.properties = properties;
        
        String inFile = properties.getProperty("file.path.function.words");
        
        try (BufferedReader inputReader = new BufferedReader(new FileReader(inFile))) {            
            while (inputReader.ready()) {
                functionWords.add(inputReader.readLine());
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
     *  Processes the passed token. It first ensurs the token is not null or 
     *  empty, then checks to see if the token is a function (non-lexical) word.
     *  If so, it increments function word count. It also keeps track of the 
     *  total tokens processed.
     *
     *  @param token token to process
     */
    public void processToken(String token) {
        if (token != null && !token.isEmpty()) {
            if (functionWords.contains(token)) {
                functionWordsCount++;
            }
            totalTokensCount++;
        }
    }
    
    /**
     *  Creates a report containing the lexical analysis of the input file.
     *  The report also contains the total words processes, total lexial words
     *  found, and the density as a percentage.
     */
    public void writeOutputFile(String inputFilePath) {       
        
        DecimalFormat df = new DecimalFormat("0.##%");
        int lexicalWordsCount = totalTokensCount - functionWordsCount;
        double lexicalWordDensity = lexicalWordsCount / 
            (double)totalTokensCount;
        String outputFilePath = properties.getProperty("output.dir") +
            properties.getProperty("output.file.lexical.density");

        try (PrintWriter outputWriter = 
            new PrintWriter(new FileWriter(outputFilePath))
        ) {
            outputWriter.println("Lexical Density Analysis");
            outputWriter.println();
            outputWriter.println("Total words processed: " + 
                NumberFormat.getNumberInstance(Locale.US).format(totalTokensCount));
            outputWriter.println("Lexical words found: " + 
                NumberFormat.getNumberInstance(Locale.US).format(lexicalWordsCount));
            outputWriter.println("Lexical density: " 
                                 + df.format(lexicalWordDensity));
            System.out.println(
                properties.getProperty("output.file.lexical.density") + 
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