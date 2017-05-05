package gol;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by k0808273 on 4/21/2017.
 */
public class CellTest {
    @Test
    public void testCanBecomeAlive() {
        Cell c = new Cell("0x0");
        Cell[] neighbors = new Cell[] {
                new Cell("1x0"),
                new Cell("1x1"),
                new Cell("0x1")
        };

        assertFalse("Cell should start dead", c.isAlive());
        c.nextState(neighbors);
        assertTrue("Cell should have been born",c.isAlive());
    }

    @Test
    public void testAliveWithLessThan2NeighborsDies() {
       Cell c = new Cell("1", true);
       c.nextState(makeNeighbors(1));
       assertFalse("Should be dead",c.isAlive());
    }

    private Cell[] makeNeighbors(int num) {
        Cell[] cells = new Cell[num];
        for(int i=0; i< num; i++) {
            cells[i] = new Cell("", true);
        }

        return cells;
    }
    @Test
    public void testAliveWith2Or3LiveNeigborsStaysAlive() {

        Cell c = new Cell("1", true);
        c.nextState(makeNeighbors(2));
        assertTrue("Should be alive",c.isAlive());
        c.nextState(makeNeighbors(3));
        assertTrue("Should be alive",c.isAlive());
    }
    @Test
    public void testAliveWithMoreThan3LiveNeighborsDies() {
        Cell c = new Cell("1", true);
        c.nextState(makeNeighbors(4));
        assertFalse("Should be dead",c.isAlive());

    }
    @Test
    public void testDeadWithExactly3NeighborsIsBorn()  {
        Cell c = new Cell("1", false);
        c.nextState(makeNeighbors(3));
        assertTrue("Should be alive",c.isAlive());

    }

    @Test
    public void testDeadWith2NeighborsStaysDead() {
        Cell c = new Cell("1", false);
        c.nextState(makeNeighbors(2));
        assertFalse("Should be dead",c.isAlive());

    }
}