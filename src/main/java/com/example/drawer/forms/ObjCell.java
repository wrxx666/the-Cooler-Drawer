package com.example.drawer.forms;

/**
 * Клетка, только для конкретных объектов
 */
public class ObjCell extends Cell{

    HallObject owner;
    static int counter;
    int id;
    public ObjCell(double x, double y, HallObject owner) {
        this.x = x;
        this.y = y;
        this.owner = owner;
        this.id = counter;
        counter++;
    }

}
