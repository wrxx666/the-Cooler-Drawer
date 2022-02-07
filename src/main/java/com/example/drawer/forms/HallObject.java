package com.example.drawer.forms;

public abstract class HallObject {
    double x;
    double y;
    double width;
    double height;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    ObjCell[] cellsCoord;
    String name;
}
