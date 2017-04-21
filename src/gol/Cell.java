package gol;

import java.util.Random;

public class Cell {

    private static final Random rand = new Random();
    private boolean isAlive;
    private String id;
    public Cell() {

    }
    public Cell(String id) {
       this.id = id;
    }

    public String getId() {
        return id;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void nextState(Cell[] neighbors) {
        if (neighbors == null) {
            boolean even = (rand.nextInt(100) % 2) == 0;
            isAlive = even;
        } else {

            //Real stuff
        }
    }
}
