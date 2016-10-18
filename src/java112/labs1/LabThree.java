package java112.labs1;

/**  
 *  LabThree class for lab 3. If one argument is entered, it prints the
 *  the argument back to the command line. If 0 or more than 1 arguments,
 *  it instructs the user to enter only one argument.
 *  <p>
 *  Advanced Java (Java 152-112) <br>
 *  Unit 1, Lab 2 <br>
 *  Date: 09-06-2016
 *
 *  @author Aaron Groom
 */
 
public class LabThree {
    
    /**
     *  Main method to run LabThree
     *  @param args The command line arguments
     */
    public static void main (String[] args) {
        
        LabThree myLabThree = new LabThree();   // Create new instance of LabThree
        
        if (args.length == 1) {                 // Ensure one command line argument
            myLabThree.run(args[0]);
        } else {
            System.out.println("Please enter one argument on the command line");
        }
    }
    
    /**
     *  LabThree run method.
     *  @param s Command line argument
     */
    public void run (String s) {
        
        System.out.println("input: " + s);
        
    }
    
}