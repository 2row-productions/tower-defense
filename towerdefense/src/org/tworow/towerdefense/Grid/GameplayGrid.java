package org.tworow.towerdefense.Grid;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class GameplayGrid {

    private int cols;
    private int rows;
    private final static int PADDING = 10;
    private int CELL_SIZE = 50;
    private Rectangle grid;

    public GameplayGrid(int cols, int rows){
        this.cols = cols;
        this.rows = rows;

    grid = new Rectangle(PADDING,PADDING,getWidth(),getHeight());
    grid.setColor(Color.RED);

    }

    public void init(){
        grid.fill();
    }

    public int getWidth(){
        return cols * CELL_SIZE;
    }

    public int getHeight(){
        return rows * CELL_SIZE;
    }





}
