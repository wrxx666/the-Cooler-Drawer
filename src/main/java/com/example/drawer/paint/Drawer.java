package com.example.drawer.paint;

import com.example.drawer.paint.forms.Hall;
import com.example.drawer.paint.forms.Table;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Рисователь стола в чистом поле
 */
public class Drawer {

    public static void drawHall(GraphicsContext gc, Hall hall){
        gc.setFill(hall.getColor());
        gc.fillRect(0,0, hall.getWidth(), hall.getHeight());
    }

    public static void drawTable(GraphicsContext gc, Hall floor, Table table){
        if (floor.addTable(table)) {
            gc.setFill(Color.GREEN);
            gc.setLineWidth(1);
            gc.fillRoundRect(table.getX(), table.getY(), table.getWidth(), table.getHeight(), 10, 10);
            gc.strokeRoundRect(table.getX(), table.getY(), table.getWidth(), table.getHeight(), 10, 10);
        } else {
            System.out.println("SPACE IS NOT AVAILABLE");
        }
    }

}
