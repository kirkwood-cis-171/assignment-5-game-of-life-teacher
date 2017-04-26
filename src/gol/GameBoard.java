package gol;

import framework.GameMain;
import framework.State;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class GameBoard extends State {

    private static final int CELL_SIZE = 30;
    private Cell[][] cells;


    public GameBoard(int boardSize) {
        cells = new Cell[boardSize][boardSize];
        for (int i=0; i<boardSize; i++) {
            for (int j=0; j<boardSize; j++) {
                String id = i + "x" + j;
                cells[i][j] = new Cell(id);
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
                cells[column][row].nextState(null);
            }
        }
    }

    public Cell[] getNeighborsOf(int row, int column) {
        return new Cell[] {
                cells[row][column+1],
                cells[row+1][column],
                cells[row+1][column+1]
        };
    }

    public Cell[] filterAlive(Cell[] cells) {
        ArrayList<Cell> aliveCells = new ArrayList<>();
        for (int i=0; i< cells.length; i++) {
            if( cells[i].isAlive()) {
                aliveCells.add(cells[i]);
            }
        }

        return (Cell[]) aliveCells.toArray();
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
