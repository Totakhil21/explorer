import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class ExplorerSearchTest {
    @Test
    public void testReachableArea_someUnreachable() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,0,1},
            {1,1,1,2,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(14, actual);
    }

    // Add more tests here!
    // Come up with varied cases

        @Test
    public void testReachableArea_allReachable() {
        int[][] island = {
            {1,1,1},
            {1,0,1},
            {1,1,1}
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(9, actual); 
    }


      @Test
    public void testReachableArea_blockedStart() {
        int[][] island = {
            {2,2,2},
            {2,0,2},
            {2,2,2}
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual); // Only start is reachable
    }


    @Test
    public void testReachableArea_singleCell() {
        int[][] island = {{0}};
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual); 
    }


     @Test
    public void testReachableArea_nullIsland() {
        int[][] island = null;
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(0, actual); 
    }


     @Test
    public void testReachableArea_emptyIsland() {
        int[][] island = {};
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(0, actual); 
    }

    @Test
    public void testReachableArea_noExplorer() {
        int[][] island = {
            {1,1,1},
            {1,1,1},
            {1,1,1}
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(0, actual); 
    }

     @Test
    public void testReachableArea_topLeftStart() {
        int[][] island = {
            {0,1,1,3},
            {1,2,1,3},
            {3,1,1,2}
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(7, actual); 
    }


     @Test
    public void testReachableArea_narrowStrip() {
        int[][] island = {
            {2, 3, 0, 1, 1, 2, 3}
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(3, actual); // Narrow 1x7 strip, 3 cells reachable
    }

    @Test
    public void testReachableArea_disconnectedRegions() {
        int[][] island = {
            {0,1,1,2,1,1},
            {1,1,2,3,1,1},
            {2,3,3,1,1,1},
            {1,1,1,2,1,1}
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(5, actual); // Only top-left region reachable, 6 cells
    }

    @Test
    public void testLocateExplorer_topLeft() {
        int[][] island = {
            {0,1,1,3},
            {1,2,1,3},
            {3,1,1,2}
        };
        int[] expected = {0, 0};
        assertArrayEquals(expected, ExplorerSearch.locateExplorer(island));
    }

    @Test
    public void testLocateExplorer_middle() {
        int[][] island = {
            {1,1,1,3},
            {1,2,0,3},
            {3,1,1,2}
        };
        int[] expected = {1, 2};
        assertArrayEquals(expected, ExplorerSearch.locateExplorer(island));
    }

    @Test
    public void testLocateExplorer_noExplorer() {
        int[][] island = {
            {1,1,1,3},
            {1,2,1,3},
            {3,1,1,2}
        };
        assertArrayEquals(null, ExplorerSearch.locateExplorer(island));
    }

   @Test
    public void testGetValidMoves_allDirections() {
        int[][] island = {
            {1,1,1},
            {1,0,1},
            {1,1,1}
        };
        int[] pos = {1, 1};
        boolean[][] explored = new boolean[3][3];
        List<int[]> moves = ExplorerSearch.getValidMoves(island, pos, explored);
        Set<String> movesStrings = toSet(moves);
        assertEquals(4, movesStrings.size());
        assertTrue(movesStrings.contains("0,1")); 
        assertTrue(movesStrings.contains("2,1")); 
        assertTrue(movesStrings.contains("1,0")); 
        assertTrue(movesStrings.contains("1,2")); 
    }

    // Helper to convert move list to string set 
    private Set<String> toSet(List<int[]> moves) {

        Set<String> set = new HashSet<>();
        
        for (int[] move : moves) {
            set.add(move[0] + "," + move[1]);
        }
        return set;
    }

    

    



}
