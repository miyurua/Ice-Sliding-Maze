package com.company;

import java.util.ArrayList;

public class RatMaze{
    private static void solveRatMaze(int rows, int cols, int maze[][], int n, ArrayList<String> ans, String move, int visited[][]){
        if(rows == n-1 && cols == n-1){
            ans.add(move);
            return;
        }

        // Down
        if (rows+1 < n && visited[rows+1][cols] == 0 && maze[rows+1][cols] == 1){
           visited[rows][cols] = 1;
           solveRatMaze(rows+1, cols, maze, n, ans, move + 'D', visited);
           visited[rows][cols] = 0;
        }
        //Left
        if (cols-1 > 0 && visited[rows][cols-1] == 0 && maze[rows][cols+1] == 1){
            visited[rows][cols] = 1;
            solveRatMaze(rows, cols+1, maze, n, ans, move + 'L', visited);
            visited[rows][cols] = 0;
        }
        //Right
        if (cols+1 < n && visited[rows][cols+1] == 0 && maze[rows][cols+1] == 1){
            visited[rows][cols] = 1;
            solveRatMaze(rows, cols+1, maze, n, ans, move + 'R', visited);
            visited[rows][cols] = 0;
        }
        //Up
        if (rows-1 >= 0 && visited[rows-1][cols] == 0 && maze[rows-1][cols] == 1){
            visited[rows][cols] = 1;
            solveRatMaze(rows-1, cols, maze, n, ans, move + 'U', visited );
        }


    }

}
