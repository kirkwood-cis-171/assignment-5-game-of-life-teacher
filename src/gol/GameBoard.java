package gol;

import framework.GameMain;
import framework.State;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Random;

public class GameBoard extends State {

    private static final int CELL_SIZE = 30;
    private Cell[][] cells;


    public GameBoard(int boardSize) {
        cells = new Cell[boardSize][boardSize];
        for (int i=0; i<boardSize; i++) {
            for (int j=0; j<boardSize; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {

        for (int i=0; i<cells.length; i++) {
            for (int j=0; j<cells[i].length; j++) {
                Cell[] neighbors = getNeighborsOf(i,j);
                cells[j][i].nextState(null);
            }
        }
    }

    public Cell[] getNeighborsOf(int row, int column) {
        return new Cell[] { new Cell("0x0"), new Cell("1x0"), new Cell("0x1")};
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
