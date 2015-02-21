public class Fun2Maze {
    static char wall = '#';
    static char floor = '.';
    static char path = '@';
    static char start = '%';
    static char exit = '$';
    
    public static void main(String[] args){
        int size = 16;
        char[][] maze = new char[size][size];
        //char[][] maze = makeMaze(size);
        
        //System.out.println(maze);
        populateMaze(maze, size);
        printMaze(maze, size);
    }
    
    public static char[][] populateMaze(char[][] maze, int size) {
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                if (outsideWall(i, j, size)) {
                        maze[i][j] = wall;
                }
                else  {
                    maze = makePath(maze, size);
                    maze[i][j] = floor;
                }
            }
        }
        return maze;
    }
    
    public static char[][] makePath(char[][] maze,int size) {
        for (int i = 1; i < size - 1; i++) {
            maze[5][i] = path;
        }
        return maze;
    }
    
    public static boolean outsideWall(int i, int j, int size) {
        if ((i == 0) || (j == 0) || (i == size - 1) || (j == size - 1)) {
            return true;
        }
        else return false;
    }
    
    public static char[][] makeMaze(int size) {
        char[][] arr = new char[size][size];
        return arr;
    }
    public static void printMaze(char[][] m, int size){
        for (int i = 0; i < size; i++){
            System.out.println();
            for (int j = 0; j < size; j++){
                System.out.printf("" + m[i][j]);
            }
        }
    }
}