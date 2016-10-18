package java112.labs1;
import java.util.*;
import java.io.*;

/**  
 *  LabSeven class for Lab 7. Creates an ArrayList, populates it, and writes 
 *  it to an output file.
 *  <p>
 *  Advanced Java (Java 152-112) <br>
 *  Unit 1, Lab 7 <br>
 *  Date: 09-14-2016
 *
 *  @author Aaron Groom
 */

public class LabSeven {
    
    public List<String> labSevenList = null;
    
    /**
     *  Main method for the class.
     *  @param args The command line arguments
     */
    public static void main(String[] args) {
        
        LabSeven myLabSeven = null;
        
        if (args.length == 1) {         // Ensure there are 2 command line arguments
            myLabSeven = new LabSeven();
            myLabSeven.run(args[0]);
        } else {
            System.out.println("Please enter one argument on the command line, an output file name");
        }
    }
    
    
    /**
     *  Run method for the class.
     *
     *  @param outputFileName Name of the output file to write to
     */
    public void run(String outputFileName) {
    
        labSevenList = new ArrayList<String>();     // Instantiate an instance of ArrayList
        
        // Populate the ArrayList
        labSevenList.add("one");
        labSevenList.add("two");
        labSevenList.add("three");
        labSevenList.add("four");
        labSevenList.add("five");
        labSevenList.add("six");
        labSevenList.add("seven");
        labSevenList.add("eight");
        labSevenList.add("nine");
        labSevenList.add("ten");
        
        writeListToOutputFile(outputFileName);      // Write the ArrayList to a file
    }
    
    
    /**
     *  Writes the ArrayList to an output file.
     *
     *  @param outputFileName Name of the output file to write to
     */
    public void writeListToOutputFile(String outputFileName) {
    
        File outputFile = null;
        
        // Create output file path
        String path = "/home/student/Dropbox/projects/src/java112/labs1/" + outputFileName;
        
        try (
            PrintWriter outputWriter = 
                new PrintWriter(new FileWriter(path))
        ) {
            outputFile = new File(path);        // Create the output file
            
            if (!outputFile.exists()) {         // Ensure file exists
                outputFile.createNewFile();
            }
            
            for (String element: labSevenList) {
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