package org.tworow.towerdefense.Grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell extends Rectangle {
    Rectangle rectangle;

    public Cell(int padding, int padding2, int col, int row, Color color) {
        rectangle = new Rectangle(padding, padding2, col, row);
        rectangle.setColor(color);
        rectangle.draw();
    }

}
