package gol;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by k0808273 on 4/19/2017.
 */
public class GameBoardTest {
    @Test
    public void testGetNeighborsTopLeftCorner() {
        GameBoard gb = new GameBoard(6);
        Cell[] neighbors = gb.getNeighborsOf(0,0);
        assertEquals(3, neighbors.length);
        assertEquals("0x1", neighbors[0].getId());
        assertEquals("1x0", neighbors[1].getId());
        assertEquals("1x1", neighbors[2].getId());
    }

    @Test
    public void testGetNeighborsTopRightCorner() {
        GameBoard gb = new GameBoard(6);
        Cell[] neighbors = gb.getNeighborsOf(0,5);
        assertEquals(3, neighbors.length);
        assertEquals("0x4", neighbors[0].getId());
        assertEquals("1x4", neighbors[1].getId());
        assertEquals("1x5", neighbors[2].getId());
    }

    @Test
    public void testGetNeighborsBottomRightCorner() {
        GameBoard gb = new GameBoard(6);
        Cell[] neighbors = gb.getNeighborsOf(5,5);
        assertEquals(3, neighbors.length);
        assertEquals("4x4", neighbors[0].getId());
        assertEquals("4x5", neighbors[1].getId());
        assertEquals("5x4", neighbors[2].getId());
    }

    @Test
    public void testGetNeighborsBottomLeftCorner() {
        GameBoard gb = new GameBoard(6);
        Cell[] neighbors = gb.getNeighborsOf(5,0);
        assertEquals(3, neighbors.length);
        assertEquals("4x0", neighbors[0].getId());
        assertEquals("4x1", neighbors[1].getId());
        assertEquals("5x1", neighbors[2].getId());
    }
    @Test
    public void testGetNeighborsMiddle() {
        GameBoard gb = new GameBoard(6);
        Cell[] neighbors = gb.getNeighborsOf(1,2);
        assertEquals(8, neighbors.length);
        assertEquals("0x1", neighbors[0].getId());
        assertEquals("0x2", neighbors[1].getId());
        assertEquals("0x3", neighbors[2].getId());

        assertEquals("1x1", neighbors[3].getId());
        assertEquals("1x3", neighbors[4].getId());

        assertEquals("2x1", neighbors[5].getId());
        assertEquals("2x2", neighbors[6].getId());
        assertEquals("2x3", neighbors[7].getId());
    }

}