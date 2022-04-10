package com.company.mazes;//package com.company.mazes;
//import java.io.*;
//import java.util.*;
//
//class GFG {
//
//    static ArrayList<String> res;
//    public static ArrayList<String> findPath(int[][] m, int n) {
//        res = new ArrayList<>();
//        // dx, dy will be used to follow `DLRU` exploring approach
//        // which is lexicographically sorted order
//        int[] dx = { 1,  0, 0, -1 };
//        int[] dy = { 0, -1, 1,  0 };
//        if (m[0][0] == 1) {
//            m[0][0] = 2;
//            findPathHelper(m, n, 0, 0, dx, dy, "");
//        }
//        return res;
//    }
//
//    private static void findPathHelper(int[][] m, int n, int x, int y, int[] dx, int[] dy, String path) {
//        if (x == n - 1 && y == n - 1) {
//            res.add(path);
//            return;
//        }
//        String dir = "DLRU";
//        for (int i = 0; i < 4; i++) {
//            int row = x + dx[i];
//            int col = y + dy[i];
//            if (isValid(row, col, m, n)) {
//                m[row][col] = 2;                // used to track visited cells of matrix
//                findPathHelper(m, n, row, col, dx, dy, path + dir.charAt(i));
//                m[row][col] = 1;                // mark it unvisited yet explorable
//            }
//        }
//    }
//
//    private static boolean isValid(int row, int col, int[][] m, int n) {
//        if (row >= 0 && row < n && col >= 0 && col < n && m[row][col] == 1) {
//            return true;
//        }
//        return false;
//    }
//
//    public static void main(String[] args) {
//        int m[][] = {   { 1, 0, 0, 0, 0 },
//                        { 1, 1, 1, 1, 1 },
//                        { 1, 1, 1, 0, 1 },
//                        { 0, 0, 0, 0, 1 },
//                        { 0, 0, 0, 0, 1 } };
//        int n = m.length;
//
//        ArrayList<String> ans = findPath(m, n);
//        System.out.println(ans);
//    }
//}


// Java implementation of the above approach
import java.util.*;

class GFG{

    // Vector to store all the possible paths
    static Vector<String> possiblePaths = new Vector<>();
    static String path = "";
    static final int MAX =  5;

    // Function returns true if the
// move taken is valid else
// it will return false.
    static boolean isSafe(int row, int col, int m[][],
                          int n, boolean visited[][])
    {
        if (row == -1 || row == n || col == -1 ||
                col == n || visited[row][col] ||
                m[row][col] == 0)
            return false;

        return true;
    }

    // Function to print all the possible
// paths from (0, 0) to (n-1, n-1).
    static void printPathUtil(int row, int col, int m[][],
                              int n, boolean visited[][])
    {

        // This will check the initial point
        // (i.e. (0, 0)) to start the paths.
        if (row == -1 || row == n || col == -1 || col == n || visited[row][col] || m[row][col] == 0)
            return;

        // If reach the last cell (n-1, n-1)
        // then store the path and return
        if (row == n - 1 && col == n - 1)
        {
            possiblePaths.add(path);
            return;
        }

        // Mark the cell as visited
        visited[row][col] = true;

        // Try for all the 4 directions (down, left,
        // right, up) in the given order to get the
        // paths in lexicographical order

        // Check if downward move is valid
        if (isSafe(row + 1, col, m, n, visited))
        {
            path += 'D';
            printPathUtil(row + 1, col, m, n,
                    visited);
            path = path.substring(0, path.length() - 1);
        }

        // Check if the left move is valid
        if (isSafe(row, col - 1, m, n, visited))
        {
            path += 'L';
            printPathUtil(row, col - 1, m, n,
                    visited);
            path = path.substring(0, path.length() - 1);
        }

        // Check if the right move is valid
        if (isSafe(row, col + 1, m, n, visited))
        {
            path += 'R';
            printPathUtil(row, col + 1, m, n,
                    visited);
            path = path.substring(0, path.length() - 1);
        }

        // Check if the upper move is valid
        if (isSafe(row - 1, col, m, n, visited))
        {
            path += 'U';
            printPathUtil(row - 1, col, m, n,
                    visited);
            path = path.substring(0, path.length() - 1);
        }

        // Mark the cell as unvisited for
        // other possible paths
        visited[row][col] = false;
    }

    // Function to store and print
// all the valid paths
    static void printPath(int m[][], int n)
    {
        boolean [][]visited = new boolean[n][MAX];

        // Call the utility function to
        // find the valid paths
        printPathUtil(0, 0, m, n, visited);

        // Print all possible paths
        for(int i = 0; i < possiblePaths.size(); i++)
            System.out.print(possiblePaths.get(i) + " ");
    }

    // Driver code
    public static void main(String[] args)
    {
        int m[][] = {   { 1, 0, 0, 0, 0 },
                        { 1, 1, 1, 1, 1 },
                        { 1, 1, 1, 0, 1 },
                        { 0, 0, 0, 0, 1 },
                        { 0, 0, 0, 0, 1 } };
        int n = m.length;

        printPath(m, n);
    }
}
