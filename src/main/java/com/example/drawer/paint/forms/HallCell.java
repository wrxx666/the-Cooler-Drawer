package com.example.drawer.paint.forms;

/**
 * Клетка, только для описания единиц зала
 */

public class HallCell extends Cell{
    boolean isEmpty;
    public HallCell(double x, double y, boolean isEmpty){
        this.isEmpty = isEmpty;
        this.x = x;
        this.y = y;
    }
}
