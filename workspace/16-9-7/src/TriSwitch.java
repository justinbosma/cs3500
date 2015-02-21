import java.util.Scanner;


/**
 * TriSwitch Game - 3 bins, 3 values 16 - 9 - 7
 * Move them around until its 8 8 0
 * TODO : - Move method from each bin to each other bin
 * TODO : - Calculate if the game is over
 * TODO : - Accept User Input
 * TODO : - Message method - Start Game/ Move and UI msgs/Game Over
 * @author Nicholas Scheuring - scheuring.n@husky.neu.edu
 * @version May 10, 2014
 */

public class TriSwitch {
    static int[] bins = {0, 9, 7};
    /**
     * Main method for TriSwitch game
     * @param Args
     */
    public static void main (String[] Args) {
        splashScreen();
        printBins();
        if (isValidStartGame(getUserInput())) {
            System.out.println("Game Beginning");
        }
        //while(!gameWon()) {
        //}
    }
    
    /**
     * Displays the Splash Screen
     * -Game Details/Instructions
     * -User Instructions
     */
    static void splashScreen() {
        String border = "\n***************************************************\n";
        String welcome = "*****     Welcome to the Tri Switch Game!     *****\n";
        String description = 
                "*    This is a game consisting of three bins.     *"
                + "\n* Each bin can contain a certain number of items. *"
                + "\n*        7 items, 9 items, and 16 items.          *"
                + "\n*   The goal of the games is to move the items    *"
                + "\n*   from one bin to another in order to wind up   *"
                + "\n*      with 2 bins, each containing 8 items       *"
                + "\n*          and 1 empty bin. Good Luck!            *";
        System.out.println(border + welcome + description + border + border);
    }
    /**
     * Gets the users next move
     */
    static void getUserMove() {
        
    }
    /**
     * Accepts input from user
     */
    static String getUserInput() {
        String input = "";
        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();
        return input;
    }
    /**
     * Validates the start game user input
     */
    static boolean isValidStartGame(String s) {
        return s instanceof String;
    }
    /**
     * Method converts an integer value to a string containing that
     * number of symbols. Used to display the values contained
     * in the bins.
     * @param n - the number to convert to symbols
     * @return the string representation of the integer value
     */
    static String valueToString(int n) {
        String str = "";
        if (n == 0) {
            return str + "\n";
        }
        if (n > 0) {
            return str + "* " + valueToString(n - 1);
        }
        else {
            return "Massive error here, value cannot be negative: "
                    + "Error: valueToString() method";
        }
    }
    /**
     * PrintBins method to display the values in the bins
     */
    static void printBins() {
        String border = "----------------------------------\n";
        System.out.println(border + "16 | " + valueToString(bins[0])
                + border + " 9 | " + valueToString(bins[1])
                + border + " 7 | " + valueToString(bins[2]) + border
                + "\n" + getMessage());
    }
    /**
     * TODO : - Message method - Start Game/ Move and UI msgs/Game Over
     */
    static String getMessage() {
        
        String start = "Press a key to begin.";
        String message = start;
        String choose = "Choose a bin:\n b for bin 1, n for bin 2, m for bin 3";
        //TODO : add a method so that this will display the to and from bins
        String status = "Moving from bin x to bin x";
        String win = "You Win!!! Game Over. \n Would you like to play again?";
        return message;
    }
    /**
     * Game Win Condition
     * if two of the containers contain value 8 and
     * the other container contains value 0
     */
    boolean gameWon() {
        return (bins[0] == 8 && bins [1] == 8 && bins[2] == 0);
    }
    /**
     * Moves items from bin 16 to bin 9
     */
    static void from16to9() {
        int nine = bins[1];
        int sixt = bins[0];
        if (nine == 9) {
            
        }
    }
    /**
     * Moves items from bin 16 to bin 7
     */
    static void from16to7() {
        
    }
    /**
     * Moves items from bin 9 to bin 16
     */
    static void from9to16() {
        
    }
    /**
     * Moves items from bin 9 to bin 7
     */
    static void from9to7() {
        
    }
    /**
     * Moves items from bin 7 to bin 16
     */
    static void from7to16() {
        bins[0] = bins[0] + bins[2];
        bins[2] = 0;
    }
    /**
     * Moves items from bin 7 to bin 9
     */
    static void from7to9() {
        
    }
}