/**
 * @author Miuru Abeysiriwardana
 * @uow_id w1761114
 * @iit_id 2019450
 */
package maze;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RunMaze {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Text File Name : ");
        String fName = scan.nextLine();
        Maze m = new Maze("src/maze/" + fName);
        m.printMaze();
        Stopwatch timer = new Stopwatch();
        Path p = new Path();
        Cell end = m.findEntrance();
        p.addCell(end);
        while (end.isFinished() == false){
            Cell next = m.findAvailableNeighbor(end);
            if (next == null){
                p.removeCell();
                end = p.lastCell();
            }else{
                next.markVisited();
                p.addCell(next);
                end = next;
            }
        }
        p.printCell();
        StdOut.println("elapsed time = " + timer.elapsedTime());
    }
}