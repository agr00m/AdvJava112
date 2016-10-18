package java112.labs1;

/**  
 *  MysteryClassOne class for Lab 2.
 *  <p>
 *  Advanced Java (Java 152-112) <br>
 *  Unit 1, Lab 2 <br>
 *  Date: 08-29-2016
 *
 *  @author Aaron Groom
 */

public class MysteryClassOne {
    
    /**
     *  Main method for the class.
     *
     *  @param args The command line arguments
     */
    public static void main (String[] args) {
        MysteryClassOne labOne = new MysteryClassOne();
        System.out.println("The number is " + labOne.mysteryMethodOne());
        System.out.println("The first item in the array is " + args[0]);
        System.out.println("The second item in the array is " + args[1]);
    }    
    
    /**
     *  This method is a myster!
     *
     *  @return an integer
     */
    public int mysteryMethodOne() {
        return 1;
    }

}