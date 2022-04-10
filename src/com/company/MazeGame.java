package com.company;
import java.util.*;
import java.io.*;

/**
 * @author Miuru Abeysiriwardana
 * @uow_id w1761114
 * @iit_id 2019450
 */


public class MazeGame {
    public static final int n = 10;
    public static char[][] grid = new char[n][n];
    static String path = "";
    static Vector<String> possiblePaths = new Vector<>();
    static final int MAX =  grid.length;
    public static final String GRID_FILE = "src/com/company/mazes/maze10_CW.txt";

    // function to read the text file
    public static void initGrid() {
        try {
            File file = new File(GRID_FILE);
            Scanner scanner = new Scanner(file);
            // Converting to 2D array
            for (int i = 0; scanner.hasNext(); i++) {
                String line = scanner.next();
                for (int j = 0; j < n; j++) {
                    grid[i][j] = line.charAt(j);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File NOT Found.");
        }
    }

    //function to print the maze grid
    public static void printGrid() {
        // Printing the maze
        initGrid();
        for (char[] row : grid) {
            for (char cell : row) {
                System.out.print(cell + "  ");
            }
            System.out.println();
        }
    }

    public static int printStartEnd(){
        //Ending Position
        for (int i=0; i< grid.length; ++i){
            for(int j=0; j< grid.length; ++j){
                if (grid[i][j] == 'S'){
                    System.out.println("\nStarting Position: " + i + ", " + j);
                }
                if (grid[i][j] == 'F'){
                    System.out.println("\nEnding Position  : " + i + ", " + j);
                }
            }
        }
        return 0;
    }

    // function that returns true if the move is possible and false if it is not

    public static boolean isPossible(int row, int col, char grid[][], int n, boolean visited[][]) {
        if (row == -1 || row == n || col == -1 || col == n || visited[row][col] || grid[row][col] == 0) {
            return false;
        }
        return true;
    }

    // function to check paths from S to F
    public static void pathTaken(int row, int col, char grid[][], int n, boolean visited[][]) {

        //Initialization - Starting Position
        if (row == -1 || row == n || col == -1 || col == n || visited[row][col] || grid[row][col] == 0) {
            return;
        }

        //Ending Position
        if (grid[row][col] == 'F'){
            System.out.println("DONE!");
            possiblePaths.add(path);
        }

        //Marking visited paths
        visited[row][col] = true;

        //Directions
        //Down
        if (isPossible(row+1, col, grid, n, visited)){
            path += 'D';
            pathTaken(row+1, col, grid, n, visited);
            path = path.substring(0, path.length() - 1);
        }
        //Left
        if (isPossible(row, col-1, grid, n, visited)){
            path += 'L';
            pathTaken(row, col-1, grid, n, visited);
            path = path.substring(0, path.length() - 1);
        }
        //Up
        if (isPossible(row-1, col, grid, n, visited)) {
            path += 'U';
            pathTaken(row-1, col, grid, n, visited);
            path = path.substring(0, path.length() - 1);
        }
        //Right
        if (isPossible(row, col+1, grid, n, visited)) {
            path += 'R';
            pathTaken(row, col+1, grid, n, visited);
            path = path.substring(0, path.length() - 1);
        }

        //Unchecking visited cells
        visited[row][col] = false;

    }

    static void printPath(char grid[][], int n){
        System.out.println("printPath");
        boolean [][]visited = new boolean[n][MAX];

        pathTaken(0, 9, grid, n, visited);

        for (int i = 0; i < possiblePaths.size(); i++){
            System.out.println("possiblePath");
            System.out.print(possiblePaths.get(i)+ "  ");
        }
        System.out.println(possiblePaths);
    }

    public static void main(String[] args) {
        printGrid();
        printStartEnd();
        printPath(grid, n);
    }
}