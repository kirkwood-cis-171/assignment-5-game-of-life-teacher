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
}