package gol;

import java.util.Random;

public class Cell {

    private static final Random rand = new Random();
    private boolean isAlive = false;
    private String id;

    public Cell(String id) {
       this.id = id;
    }
    public Cell(String id, Boolean isAlive) {
        this.id = id;
        this.isAlive = isAlive;
    }

    public String getId() {
        return id;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void nextState(Cell[] neighbors) {

        if(isAlive && neighbors.length < 2) {
            isAlive = false;
        } else if ( isAlive && (neighbors.length == 2 || neighbors.length == 3)) {
            isAlive = true;
        } else if (isAlive && neighbors.length > 3) {
            isAlive = false;
        } if ( !isAlive && neighbors.length == 3) {
            isAlive = true;
        }
    }

    public void live() {
        isAlive = true;
    }
}
