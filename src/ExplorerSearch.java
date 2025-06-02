import java.util.ArrayList;
import java.util.List;

public class ExplorerSearch {

    /**
     * Returns how much land area an explorer can reach on a rectangular island.
     * 
     * The island is represented by a rectangular int[][] that contains
     * ONLY the following nunbers:
     * 
     * '0': represents the starting location of the explorer
     * '1': represents a field the explorer can walk through
     * '2': represents a body of water the explorer cannot cross
     * '3': represents a mountain the explorer cannot cross
     * 
     * The explorer can move one square at a time: up, down, left, or right.
     * They CANNOT move diagonally.
     * They CANNOT move off the edge of the island.
     * They CANNOT move onto a a body of water or mountain.
     * 
     * This method should return the total number of spaces the explorer is able
     * to reach from their starting location. It should include the starting
     * location of the explorer.
     * 
     * For example
     * 
     * @param island the locations on the island
     * @return the number of spaces the explorer can reach
     */
    public static int reachableArea(int[][] island) {
        // Implement your method here!\

        
         if (island == null || island.length == 0 || island[0].length == 0) {
            return 0;
        }
        
        
        int[] startPos = locateExplorer(island);
        if (startPos == null) {
            return 0; 
        }
        
        
        boolean[][] explored = new boolean[island.length][island[0].length];

        return exploreIsland(island, startPos, explored);
    }

    /**
     * Recursively explores the island and counts reachable spaces.
     * @param island the 2D array of the island
     * @param pos current position [row, col]
     * @param explored tracks visited cells
     * @return number of reachable spaces from this position
     */
    public static int exploreIsland(int[][] island, int[] pos, boolean[][] explored) {
        int row = pos[0];
        int col = pos[1];
        
        
        if (explored[row][col]) {

            return 0;
        }
        

        explored[row][col] = true;


        int reachable = 1;
        
    
        List<int[]> nextMoves = getValidMoves(island, pos, explored);
        
        
        for (int[] next : nextMoves) {

            reachable += exploreIsland(island, next, explored);
        }
        
        return reachable;
    }

    /**
     * Finds the explorer's starting position (marked '0').
     * @param island the 2D array of the island
     * @return array [row, col] of the start, or null if not found
     */
    public static int[] locateExplorer(int[][] island) {

        for (int row = 0; row < island.length; row++) {
            for (int col = 0; col < island[row].length; col++) {
                if (island[row][col] == 0) {
                    return new int[] {row, col};
                }
            }
        }
        return null; 
    }

    /**
     * Determines all valid moves from the current position.
     * @param island the 2D array of the island
     * @param pos current position [row, col]
     * @param explored tracks visited cells
     * @return list of valid neighboring positions
     */
    private static List<int[]> getValidMoves(int[][] island, int[] pos, boolean[][] explored) {

        List<int[]> validMoves = new ArrayList<>();

        int row = pos[0];
        int col = pos[1];
        

        int[][] directions = {
            {-1, 0}, 
            {1, 0},  
            {0, -1}, 
            {0, 1}   
        };
        
  
        for (int[] dir : directions) {

            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            
            
            if (nextRow >= 0 && nextRow < island.length &&

                nextCol >= 0 && nextCol < island[0].length &&

                (island[nextRow][nextCol] == 0 || island[nextRow][nextCol] == 1) &&
                !explored[nextRow][nextCol]) {
                    
                validMoves.add(new int[] {nextRow, nextCol});
            }
        }
        
        return validMoves;
    }
}
    

