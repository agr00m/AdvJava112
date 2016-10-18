package java112.labs1;
import java.io.*;

/**  
 *  LabFour class for Lab 4. Reads an input file and prints the contents 
 *  to the terminal window.
 *  <p>
 *  Advanced Java (Java 152-112) <br>
 *  Unit 1, Lab 4 <br>
 *  Date: 09-08-2016 <br>
 *
 *  @author Aaron Groom 
 */

public class LabFour {
    
    /**
     *  Main method for the class.
     *  @param args The command line arguments
     */
    public static void main(String[] args) {
        
        LabFour myLabFour = new LabFour();  // Create new instance of LabFour
        
        if (args.length == 1) {             // Ensure one command line argument
            myLabFour.run(args[0]);
        } else {
            System.out.println("Please enter one argument on the command line");
        }
    }

    /**
     *  LabFour run method. Opens the input file, reads it line-by-line
     *  and prints each line to the terminal window.
     *  @param fileName Input file name
     */
    public void run(String fileName) {
        
        String inFile = "/home/student/Dropbox/projects/src/java112/labs1/" + fileName + ".txt";
        
        try (BufferedReader inputReader = new BufferedReader(new FileReader(inFile))) {
            String line = null;                     // String to read data into
            
            while (inputReader.ready()) {
                line = inputReader.readLine();      // Reads a line from the input file
                System.out.println(line);           // Prints the line to the terminal window
            }
        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}