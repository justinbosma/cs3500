/**
 * Recursive maze solver
 * @author Nick Scheuring
 * @email scheuring.n@husky.neu.edu
 * @category NSCC - Java2 - Spring 2012
 */
public class Tester {
    //2D array representing the maze - # = walls, . = halls
    static char maze[][] =  {
        {'#','#','#','#','#','#','#','#','#','#','#','#'},
        {'#','.','.','.','#','.','.','.','.','.','.','#'},
        {'.','.','#','.','#','.','#','#','#','#','.','#'},
        {'#','#','#','.','#','.','.','.','.','#','.','#'},
        {'#','.','.','.','.','#','#','#','.','#','.','.'},
        {'#','#','#','#','.','#','.','#','.','#','.','#'},
        {'#','.','.','#','.','#','.','#','.','#','.','#'},
        {'#','#','.','#','.','#','.','#','.','#','.','#'},
        {'#','.','.','.','.','.','.','.','.','#','.','#'},
        {'#','#','#','#','#','#','.','#','#','#','.','#'},
        {'#','.','.','.','.','.','.','#','.','.','.','#'},
        {'#','#','#','#','#','#','#','#','#','#','#','#'}
    };
    //Is the position out of the maze?
    static boolean outBounds = false;
    //Is the position the exit?
    static boolean exit = false;
    //Is the path open?
    static boolean open = false;

    /**
     * Main method for Maze class
     * @param Args - command line arguments
     */
    public static void main(String [] Args) {
        //row/col init to start position/maze entrance
        int row = 2;
        int col = 0;

        System.out.println("Start from position (2,0) ");
        findPath(row,col);
        System.out.println("Maze Solved!");
        printMaze();
        System.out.printf("\n\n");
    }
    /**
     * Find the path through the maze
     * @param row
     * @param col
     * @return boolean
     */
    public static boolean findPath(int row,int col) {
        int up = row - 1;
        int right = col + 1;
        int down = row + 1;
        int left = col - 1;
        System.out.printf("Move to position ( %d, %d ) \n", row,col);

        outBounds = outBounds(row,col);
        if(outBounds)return false;

        exit = exit(row,col);
        if(exit)return true;

        open = open(row,col);
        if(!open)return false;

        maze[row][col] = 'x';

        if(findPath(up,col) == true)return true;
        if(findPath(row,right) == true)return true;
        if(findPath(down,col) == true)return true;
        if(findPath(row,left) == true)return true;

        maze[row][col] = '.';
        return false;
    }
    /**
     * Is the position out of the maze?
     * @param row
     * @param col
     * @return boolean
     */
    public static boolean outBounds(int row, int col) {
        boolean outBounds = false;
        if(row < 0 || row > 11 || col < 0 || col > 11)outBounds = true;
        return outBounds;
    }
    /**
     * Is the position the exit?
     * @param row
     * @param col
     * @return boolean
     */
    public static boolean exit(int row, int col) {
        boolean exit = false;
        if(row == 4 && col == 11)exit = true;
        return exit;
    }
    /**
     * Is the path open?
     * @param row
     * @param col
     * @return boolean
     */
    public static boolean open(int row, int col) {
        boolean open = false;
        if(maze[row][col] == '.')open = true;
        return open;
    }
    /**
     * Prints the maze to the screen as a 2D image
     */
    public static void printMaze() {
        for(int i = 0; i < 12; i++)
        {
            for (int j = 0; j < 12; j++)
            {
                System.out.printf("%s", maze[i][j]);
            }
            System.out.println();
        }
    }

}   //end class Maze