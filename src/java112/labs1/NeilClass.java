package java112.labs1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


/**
 *  Contains routines to get keyboard input.
 *  Create date: 1/20/2009
 *  by www.neiljohan.com
 *
 *  @author Neil Class
 */
 
public class NeilClass {

    /**  
     *  Gets a String input from the keyboard.
     *
     *  @param tMessage Input String from the keyboard
     *  @return string input from the keyboard
     *  @throws IOException if an input or output exception occurred
     */
    public static String GetInputString(final String tMessage) throws IOException {
    
        final BufferedReader tKeyboard =  new BufferedReader(new InputStreamReader(System.in));
        System.out.print(tMessage);
        System.out.flush();
        String tLinex = tKeyboard.readLine();
        return tLinex;
    }
    
    /**  
     *  Gets an Integer input from the keyboard. First gets the string input,
     *  then attempts to convert to an integer value.
     *
     *  @param tMessage Input String from the keyboard
     *  @return integer input from the keyboard
     *  @throws IOException If an input or output exception occurred
     */
    public static int GetInputInt(final String tMessage) throws IOException {
    
        final BufferedReader tKeyboard =  new BufferedReader(new InputStreamReader(System.in));
        System.out.print(tMessage);
        System.out.flush();
        String tLinex = tKeyboard.readLine();
        int tValue = 0;

        try {
            tValue = new Integer(tLinex).intValue();
        } catch (NumberFormatException pNumberFormatException) {
            System.out.println("You typed in a non-digit character or other non-valid input");
            System.exit(1);
        }
        return tValue;
    }

    /**  
     *  Gets a double input from the keyboard. First gets the string input,
     *  then attempts to convert to a double value.
     *
     *  @param tMessage Input String from the keyboard
     *  @return double input from the keyboard
     *  @throws IOException If an input or output exception occurred
     */
    public static double GetInputDouble(final String tMessage) throws IOException {
    
        final BufferedReader tKeyboard =  new BufferedReader(new InputStreamReader(System.in));
        System.out.print(tMessage);
        System.out.flush();
        String tLinex = tKeyboard.readLine();
        double tValue=0;

        try {
            tValue = new Double(tLinex).doubleValue();
        } catch (NumberFormatException pNumberFormatException) {
            System.out.println("You typed in a non-digit character or other non-valid input");
            System.exit(1);
        }
        return tValue;
    }
    
    /**  
     *  Draws a dashed line across the terminal window.
     *
     *  @param tLength number of dashes to draw
     */
    public static void DrawLine(int tLength) {
    
        for (int Counter = 1; Counter <  tLength; Counter++) {
            System.out.print('-');
        }
        System.out.println();
    }
}