import static org.junit.Assert.*;
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

    



}
