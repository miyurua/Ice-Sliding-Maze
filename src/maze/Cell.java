/**
 * @author Miuru Abeysiriwardana
 * @uow_id w1761114
 * @iit_id 2019450
 */
package maze;

public class Cell {
    /**
     * Class Variables
     */
    private static final char AVAILABLE = '.';
    private static final char VISITED = 'V';
    private static final char OBSTACLE = '0';
    private static final char START = 'S';
    private static final char FINISHED = 'F';

    /**
     * Member Variables
     */
    private int row;
    private int col;
    private char state;

    /**
     * Cell class constructor
     * @param row row of the grid
     * @param col column of the grid
     * @param code current char value of the state - V/S/F
     */
    public Cell(int row, int col, char code) {
        this.row = row;
        this.col = col;
        state = code;
    }

    /**
     * Accessor Methods
     */
    public boolean isOpen() { return state == AVAILABLE || state == FINISHED; }
    public boolean isStart(){ return state == START; }
    public boolean isFinished(){ return state == FINISHED; }
    public int getRow() { return row; }
    public int getCol() { return col; }
    public char toChar() { return state; }
    public String toString() { return "( " + row + ", " + col + " : " + toChar() + " )"; }

    /**
     * Mutator Methods
     *
     * Method to mark a visited cell VISITED
     */
    public void markVisited() {
        if(state == AVAILABLE)
            state = VISITED;
    }

    /**
     * Method to clear a VISITED cell as AVAILABLE
     */
    public void clearVisited(){
        if(state == VISITED)
            state = AVAILABLE;
    }
}
