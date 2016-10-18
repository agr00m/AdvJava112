package java112.labs1;
import java.io.*;

/**  
 *  LabSix class for Lab 6. Reads the input file and copies it to the output
 *  file.
 *  <p>
 *  Advanced Java (Java 152-112) <br>
 *  Unit 1, Lab 6 <br>
 *  Date: 09-08-2016 
 *
 *  @author Aaron Groom
 */

public class LabSix {
    
    /**
     *  Main method for the class.
     *  @param args The command line arguments
     */
    public static void main (String[] args) {
        
        LabSix myLabSix = new LabSix();
        
        if (args.length == 2) {         // Ensure there are 2 command line arguments
            myLabSix.run(args[0], args[1]);
        } else {
            System.out.println("Please enter two argument on the command line, an input file name and an output file name");
        }
    }
     
    /**
     *  LabSix run method. Opens the input file, and creates a new output file. 
     *  It then reads each line of the input file, and writes that line to the 
     *  output file.
     *  @param inputFileName    Name of the input file to read
     *  @param outputFileName   Name of the output file to create
     */
    public void run (String inputFileName, String outputFileName) {
        
        File outputFile = null;
        
        // Create I/O file paths
        String inFile = "/home/student/Dropbox/projects/src/java112/labs1/" 
                        + inputFileName + ".txt";
        String outFile = "/home/student/Dropbox/projects/src/java112/labs1/" 
                        + outputFileName + ".txt";
            
        try (
            BufferedReader  inputReader = 
                new BufferedReader(new FileReader(inFile));
            BufferedWriter outputWriter = 
                new BufferedWriter(new FileWriter(outFile))
        ) {
            String line = null;                     // String to read data into
            
            outputFile = new File(outFile);         // Create the output file
            if (!outputFile.exists()) {             // Eensure file exists.
                outputFile.createNewFile();
            }
            
            while (inputReader.ready()) {
                line = inputReader.readLine();      // Reads a line from the input file
                outputWriter.write(line);           // Writes a line to the output file
                outputWriter.write("\n");           // New line
            }
            // outputWriter.close();                   // Close the output file (?)
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