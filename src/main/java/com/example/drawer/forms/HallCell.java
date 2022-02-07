package com.example.drawer.forms;

public class HallCell extends Cell{
    boolean isEmpty;
    public HallCell(double x, double y, boolean isEmpty){
        this.isEmpty = isEmpty;
        this.x = x;
        this.y = y;
    }
}
