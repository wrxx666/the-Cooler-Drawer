package com.example.drawer;

import com.example.drawer.forms.Hall;
import com.example.drawer.forms.Table;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

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

    private void drawWall(GraphicsContext gc,double x,double y, double x1, double y1){
        gc.setLineWidth(5);
        gc.strokeLine(x,y,x1,y1);
    }

    private void drawPlan(GraphicsContext gc){
        drawWall(gc,0,0,200,0);
        drawWall(gc,0,0,0,200);
        drawWall(gc,0,100,100,100);
        drawWall(gc,0,200,200,200);
    }
}
