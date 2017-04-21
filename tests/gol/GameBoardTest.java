package gol;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by k0808273 on 4/19/2017.
 */
public class GameBoardTest {
    @Test
    public void testGetNeighbors() {
        GameBoard gb = new GameBoard(6);
        Cell[] neighbors = gb.getNeighborsOf(0,0);
        assertEquals(3, neighbors.length);
        assertEquals("0x0", neighbors[0].getId());
        assertEquals("1x0", neighbors[1].getId());
        assertEquals("0x1", neighbors[2].getId());
    }
}