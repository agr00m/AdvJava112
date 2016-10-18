package java112.labs1;
import java.util.*;
import java.io.*;

/**  
 *  LabEight class for Lab 8. Creates a Sorted Set, populates it, and writes
 *  it to an output file.
 *  <p>
 *  Advanced Java (Java 152-112) <br>
 *  Unit 1, Lab 8 <br>
 *  Date: 09-14-2016 <br>
 *
 *  @author Aaron Groom
 */

public class LabEight {
    
    Set<String> labEightSet = null;
    
    /**
     *  Main method for the class. Checks for two command line arguments and
     *  calls the run method.
     *
     *  @param args The command line arguments
     */
    public static void main(String[] args) {
    
        LabEight myLabEight = null;
        
        if (args.length == 1) {         // Ensure there are 2 command line arguments
            myLabEight = new LabEight();
            myLabEight.run(args[0]);
        } else {
            System.out.println("Please enter one argument on the command line, an output file name");
        }
    }
    
    
    /**
     *  Run method for the class. Instantiates and populates a TreeSet, then
     *  calls a method to output the list to a file.
     *
     *  @param outputFileName Name of the output file to write to
     */
    public void run(String outputFileName) {
    
        labEightSet = new TreeSet<String>();    // Instantiate an instance of ArrayList
        
        // Populate the TreeSet
        labEightSet.add("one");
        labEightSet.add("one");
        labEightSet.add("five");
        labEightSet.add("two");
        labEightSet.add("four");
        labEightSet.add("two");
        labEightSet.add("three");
        labEightSet.add("three");
        labEightSet.add("four");
        labEightSet.add("three");
        
        writeSetToOutputFile(outputFileName);   // Write the ArrayList to a file
    }
    
    
    /**
     *  Writes the Sorted Set to an output file.
     *
     *  @param outputFileName Name of the output file to write to
     */
    public void writeSetToOutputFile(String outputFileName) {
    
        File outputFile = null;
        
        // Create output file path
        String outFile = "/home/student/Dropbox/projects/src/java112/labs1/" + outputFileName + ".txt";
        
        try (PrintWriter outputWriter = new PrintWriter(new FileWriter(outFile))) {
        
            outputFile = new File(outFile);     // Create the output file
            
            if (!outputFile.exists()) {         // Ensure file exists
                outputFile.createNewFile();
            }
            
            for (String element: labEightSet) {
                outputWriter.println(element);  // Write the message to the output file
            }
            
            outputWriter.close();               // Close the output file
            System.out.println("File written Successfully");
            
        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}
    