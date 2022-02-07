package com.example.drawer.forms;

public class Table extends HallObject{

    private static int count;
    private final int id;

    public Table(double x,double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        int square = (int) (width * height);
        cellsCoord = new ObjCell[square];

        id = count;
        name = "Table" + id;
        count++;

        for(int j = 0, s=0; j < height; j++){
            for (int i = 0; i < width; i++,s++){
                cellsCoord[s] = new ObjCell(x+i,y+j,this);
            }
        }

    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Table{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
