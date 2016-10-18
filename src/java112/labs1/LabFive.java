package java112.labs1;
import java.io.*;

/**  
 *  LabFive class for Lab 5. Creates an output file and writes a message to 
 *  the file.
 *  <p>
 *  Advanced Java (Java 152-112) <br>
 *  Unit 1, Lab 5 <br>
 *  Date: 09-08-2016 <br>
 *
 *  @author Aaron Groom
 */

public class LabFive {
    
    /**
     *  Main method for the class.
     *  @param args The command line arguments
     */
    public static void main (String[] args) {
        
        LabFive myLabFive = new LabFive();
        
        if (args.length == 2) {
            myLabFive.run(args[0], args[1]);
        } else {
            System.out.println("Please enter two argument on the command line, a file name and a message");
        }
    }
     
    /**
     *  LabFive run method. Creates a new file and writes the "message"
     *  to the file.
     *  @param outputFileName   Name of the output file create
     *  @param message          Message to be written to the output file
     */
    public void run (String outputFileName, String message) {
        
        File outputFile = null;
        
        // Create output file path
        String outFile = "/home/student/Dropbox/projects/src/java112/labs1/" + outputFileName + ".txt";
        
        try (
            BufferedWriter outputWriter = 
                new BufferedWriter(new FileWriter(outFile))
        ) {   
            outputFile = new File(outFile);     // Create the output file
            
            if (!outputFile.exists()) {         // Ensure file exists
                outputFile.createNewFile();
            }
            
            outputWriter.write(message);    // Write the message to the output file
            outputWriter.close();           // Close the output file
            System.out.println("File written Successfully");
            
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}