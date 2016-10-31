package java112.analyzer;

import java.io.*;
import java.util.*;

/**  
 *  File processing class for Filelyzer package. The class opens the input file
 *  and reads it line-by-line, breaking each line into an array of individual
 *  tokens. The tokens are then passed to the analyzers for processsing.
 *  Finally, it calls the writeOutputFile() method for each analyzer. 
 *  <p>
 *  Advanced Java Programming (Java 152-112)<br>
 *  Unit 2, Project 2<br>
 *  Date: 10-06-2016
 *
 *  @author Aaron Groom
 */
public class AnalyzeFile {

    public static final int numCommandLineArgs = 2;
    private String inputFilePath = "./";
    private Properties properties = null;
    private List<Analyzer> analyzers = new ArrayList<Analyzer>();

    /**
     *  Main run method for the class. Ensures there the correct number of
     *  command line arguments are entered, then calls methods that add 
     *  analyzers, open and process the input file and finally writes the
     *  reports.
     *  
     *  @param arguments command line arguments. This should be the name of the 
     *                   input file to process.
     */
    public void runAnalysis(String[] arguments) {

        if (arguments.length == numCommandLineArgs) {
            inputFilePath = arguments[0];
            loadProperties(arguments[1]);
            addAnalyzers();
            processInputFile();
            writeAllOutputFiles();
        } else {
            System.out.println("Please enter one argument on the command " +
                               "line, the path to the input file");
        } 
    }
    
    /**
     *  Opens the project's property file.
     *
     *  @param propertiesFilePath path to the properties file
     */
    public void loadProperties(String propertiesFilePath)  {
        properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        } catch(IOException ioe) {
            System.out.println("Can't load the properties file");
            ioe.printStackTrace();
        } catch(Exception e) {
            System.out.println("Problem: " + e);
            e.printStackTrace();
        }
    }
    
    /**
     *  Adds the analyzers being impliemented.
     */
    private void addAnalyzers() {
        analyzers.add(new SummaryReport(properties));
        analyzers.add(new UniqueTokenAnalyzer(properties));
        analyzers.add(new BigWordAnalyzer(properties));
        analyzers.add(new TokenCountAnalyzer(properties));
        analyzers.add(new LexicalDensityAnalyzer(properties));
        analyzers.add(new TokenSizeAnalyzer(properties));
        analyzers.add(new KeywordAnalyzer(properties));
    }
    
    
    /**
     *  Opens the input file and manages exception handling.
     */
    private void processInputFile() {
        
        try (BufferedReader inputReader = 
            new BufferedReader(new FileReader(inputFilePath))
        ) {   
            processInputFile(inputReader);  
        } catch (java.io.FileNotFoundException fnfe) {
            System.out.println("Failed to read input file");
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            System.out.println("IO Exception");
            ioe.printStackTrace();
        } catch (Exception e) {
            System.out.println("General Error");
            e.printStackTrace();
        }   
    }
    
    /**
     *  Processes the input file. Reads in each line, separates the line into
     *  tokens then calls a method to process the tokens.
     *
     *  @param inputReader The BufferedReader stream for the input file.
     *  @throws IOException error reading the input file
     */
    private void processInputFile(BufferedReader inputReader) 
        throws IOException {
        
        String inputLine = "";
        String[] tokenArray = null;
        String token = "";
            
        while (inputReader.ready()) {
            inputLine = inputReader.readLine();
            tokenArray = inputLine.split("\\W");
            procesTokens(tokenArray);
        }
    }
    
    /**
     *  Processes the tokens from each line. Loops through the tokens array
     *  and calls the processToken method for each analyzer.
     *
     *  @param tokens tokens to process
     */
    private void procesTokens(String[] tokens) {
        for (int i = 0; i < tokens.length; i++) {
            for (Analyzer analyzer : analyzers) {
                analyzer.processToken(tokens[i]);
            }
        }
    }

    /**
     *  Prints the output files by calling the writeOutputFile() method for
     *  each analyzer.
     */
    private void writeAllOutputFiles() {
        for (Analyzer analyzer : analyzers) {
                analyzer.writeOutputFile(inputFilePath);
        }
    }
}