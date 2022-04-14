/**
 * @author Miuru Abeysiriwardana
 * @uow_id w1761114
 * @iit_id 2019450
 */
package maze;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {
    public static int count = 0;
    private Cell[][] grid;

    /**
     * Maze Class Constructor.
     * Method to Read the txt file and construct the maze by assigning the contents into a 2D array.
     * @param filename Name of the Text file that's uploaded.
     */
    public Maze(String filename) throws FileNotFoundException {
        int rows, cols;
        Scanner input = null;
        try{
            input = new Scanner(new File(filename));
            System.out.println("File Read Successfully!");
        } catch (Exception e) {
            System.out.println("File NOT Found!");
            System.exit(-1);
        }

        // Reading in the maze size
        File mazeInfo = new File(filename);
        Scanner scanMaze = new Scanner(mazeInfo);
        while (scanMaze.hasNextLine()){
            scanMaze.nextLine();
            count++;
        }

        rows = count;
        cols = count;

        grid = new Cell[rows][cols];
        for (int row = 0; row < rows; row++){
            String currRow = input.next();
            for (int col = 0; col < cols; col++){
                char theChar = currRow.charAt(col);
                Cell newCell = new Cell(row, col, theChar);
                grid[row][col] = newCell;
            }
        }
    }

    /**
     * Accessor Methods.
     * Method to Find the Starting Position of the maze - 'S'
     * @return 'S' cell position co-ordinates
     */
    public Cell findEntrance(){
        int rows = grid.length;
        int cols = grid[0].length;
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                if (grid[r][c].isStart()){
                    return grid[r][c];
                }
            }
        }
        return null;
    }

    /**
     * Method to find if a neighbor is available for a given cell.
     * @param fromCell Cell Class object
     * @return reference to a neighbor cell.
     * @return null if there isn't any.
     */
    public Cell findAvailableNeighbor(Cell fromCell){
        int row = fromCell.getRow();
        int col = fromCell.getCol();
        //Up
        if (row - 1 >= 0 && grid[row-1][col].isOpen()){
            return grid[row-1][col];
        }
        //Left
        if (col - 1 >= 0 && grid[row][col-1].isOpen()){
            return grid[row][col-1];
        }
        //Down
        if (row + 1 < grid.length && grid[row + 1][col].isOpen()){
            return grid[row + 1][col];
        }//Right
        if (col + 1 < grid[row].length && grid[row][col + 1].isOpen()){
            return grid[row][col + 1];
        }
        return null;
    }

    /**
     * Method to print the maze
     */
    public void printMaze(){
        for (int row = 0; row < grid.length; row++){
            for (int col = 0; col < grid[row].length; col++){
                System.out.print(grid[row][col].toChar() + "  ");
            }
            System.out.println();
        }
    }

    /**
     * Method to clear the visited cell to AVAILABLE.
     */
    public void clearVisited(){
        int rows = grid.length;
        int cols = grid[0].length;
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                grid[r][c].clearVisited();
            }
        }
    }
}