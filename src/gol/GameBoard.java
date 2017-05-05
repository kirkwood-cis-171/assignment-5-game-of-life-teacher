package gol;

import framework.GameMain;
import framework.State;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GameBoard extends State {

    private static final int CELL_SIZE = 5;
    private Cell[][] cells;


    private int getBoardSize() {
        return cells.length;
    }
public GameBoard(int boardSize) {
        Random r = new Random();
        cells = new Cell[boardSize][boardSize];
        for (int i=0; i<boardSize; i++) {
            for (int j=0; j<boardSize; j++) {
                String id = i + "x" + j;
                cells[i][j] = new Cell(id);

                int random = r.nextInt(100);
                if ( (random % 2 == 0) || random % 3 == 0) {
                    cells[i][j].live();
                }
            }
        }
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {

        for (int row=0; row<cells.length; row++) {
            for (int column=0; column<cells[row].length; column++) {
                Cell[] neighbors = getNeighborsOf(row,column);
                Cell[] aliveNeighbors = filterAlive(neighbors);
                cells[column][row].nextState(aliveNeighbors);
            }
        }
    }

    public Cell[] getNeighborsOf2(int row, int column) {
        ArrayList<Cell> neighbors = new ArrayList<Cell>();

        //if column is 0 then this won't work
        int columnBefore = column - 1;

        // if column == column count (getBoardSize)
        int columnAfter = column + 1;

        //if row is 0 then this wont work
        int rowAbove = row - 1;
        int rowBelow = row + 1;

        //all the ones above
        if (rowAbove > -1 && columnBefore > -1) {
            neighbors.add(cells[rowAbove][columnBefore]);
        }

        if (rowAbove > -1) {
            neighbors.add(cells[rowAbove][column]);
        }

        if (rowAbove > -1 && columnAfter < this.getBoardSize()) {
            neighbors.add(cells[rowAbove][columnAfter]);
        }

        if (columnBefore > -1) {
            neighbors.add(cells[row][columnBefore]);
        }

        if (columnAfter < this.getBoardSize()) {
            neighbors.add(cells[row][columnAfter]);
        }

        if (columnBefore > -1 && rowBelow < this.getBoardSize()) {
            neighbors.add(cells[rowBelow][columnBefore]);
        }

        if (rowBelow < this.getBoardSize()) {
            neighbors.add(cells[rowBelow][column]);
        }

        if (columnAfter < this.getBoardSize() && rowBelow < this.getBoardSize()) {
            neighbors.add(cells[rowBelow][columnAfter]);
        }
        return neighbors.toArray(new Cell[neighbors.size()]);
    }

    public Cell[] getNeighborsOf(int row, int column) {
        ArrayList<Cell> neighbors = new ArrayList();
        for (int rowIdx = row -1; rowIdx <= row+1; rowIdx++) {
            for (int colIdx = column - 1; colIdx <= column+1; colIdx++) {

                if (row == rowIdx && column == colIdx) {
                    //self
                } else {

                    if( rowIdx > -1 &&
                        rowIdx < getBoardSize() &&
                        colIdx > -1 &&
                        colIdx < getBoardSize()) {
                        neighbors.add(cells[rowIdx][colIdx]);
                    }
                }

            }
        }

        return neighbors.toArray(new Cell[neighbors.size()]);
    }

    //This screws up my ordering
    public Cell[] getNeighborsOf3(int row, int column) {
        Set<Cell> neighbors = new HashSet<>();

        int columnBefore = Math.min(0, column - 1);
        int columnAfter = Math.max(getBoardSize()-1, column + 1);
        int rowAbove = Math.min(0, row - 1);
        int rowBelow = Math.max(getBoardSize()-1, row + 1);

        //all the ones above
        neighbors.add(cells[rowAbove][columnBefore]);
        neighbors.add(cells[rowAbove][column]);
        neighbors.add(cells[rowAbove][columnAfter]);
        neighbors.add(cells[row][columnBefore]);
        neighbors.add(cells[row][columnAfter]);
        neighbors.add(cells[rowBelow][columnBefore]);
        neighbors.add(cells[rowBelow][column]);
        neighbors.add(cells[rowBelow][columnAfter]);

        return neighbors.toArray(new Cell[neighbors.size()]);
    }

    public Cell[] filterAlive(Cell[] cells) {
        ArrayList<Cell> aliveCells = new ArrayList<>();
        for (int i=0; i< cells.length; i++) {
            if( cells[i].isAlive()) {
                aliveCells.add(cells[i]);
            }
        }

        return aliveCells.toArray(new Cell[aliveCells.size()]);
    }
    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0,0, GameMain.WIDTH, GameMain.HEIGHT);

        for (int i=0; i<cells.length; i++) {
            for (int j=0; j<cells[i].length; j++) {
                drawCell(g, i, j);
            }
        }
    }

    private void drawCell(Graphics g, int i, int j) {
        Cell c = cells[i][j];
        if (c.isAlive()) {
            g.setColor(Color.BLACK);
        } else {
            g.setColor(Color.WHITE);
        }

        g.fillRect(CELL_SIZE * j, CELL_SIZE * i, CELL_SIZE - 1, CELL_SIZE - 1);
    }

    @Override
    public void onClick(MouseEvent e) {

    }

    @Override
    public void onKeyPress(KeyEvent e) {

    }

    @Override
    public void onKeyRelease(KeyEvent e) {

    }
}
