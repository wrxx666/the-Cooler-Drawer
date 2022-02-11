package com.example.drawer.paint.forms;

import javafx.scene.shape.Rectangle;

/**
 * Описывает некий стол
 */
public class Table extends HallObject{

    private static int count;
    private final int id;
    public Rectangle rect;

    public Table(double x,double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        int square = (int) (width * height);


        id = count;
        name = "Table" + id;
        count++;

        rect = new Rectangle();
        rect.setX(x);
        rect.setY(y);
        rect.setWidth(width);
        rect.setHeight(height);



    }

    @Override
    public String toString() {
        return "Table{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
