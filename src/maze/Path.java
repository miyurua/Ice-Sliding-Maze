/**
 * @author Miuru Abeysiriwardana
 * @uow_id w1761114
 * @iit_id 2019450
 */
package maze;

import java.util.ArrayList;

public class Path {
    /**
     * Member Methods
     */
    private ArrayList<Cell> cells;

    /**
     * Class constructor; creates an empty path initially.
     */
    public Path(){cells = new ArrayList<Cell>();}

    /**
     * Accessor Methods
     *
     * @return last cell of the path.
     * @return null if the path is empty.
     */
    public Cell lastCell(){return cells.get(cells.size() - 1);}

    /**
     * Enhanced for loop to print every cell on the path.
     */
    public void printCell(){
        for(Cell c : cells){
            System.out.println(c);
        }
    }

    /**
     * Mutator Methods
     *
     * Method to add a given cell to the end of the path.
     * @param toAdd cell class object.
     */
    public void addCell(Cell toAdd){
        cells.add(toAdd);
    }

    /**
     * Method to Remove the last cell from the path.
     */
    public void removeCell(){
        int lastCellIndex = cells.size() - 1;
        cells.remove(lastCellIndex);
    }

}
