package com.example.drawer.forms;


import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Hall {
    private final Color color;
    private final double width;
    private final double height;
    private static HashSet<HallCell> hallCellSet;

    public static List<Table> tableList = new ArrayList<>();

    public Hall(double width, double height, Color color){
        this.width = width;
        this.height = height;
        this.color = color;

        hallCellSet = new HashSet();
        tableList = new ArrayList<>();

        for(int j = 0; j < height; j++){
            for(int i = 0; i < width; i++){
                hallCellSet.add(new HallCell(i,j,true));
            }
        }


    }

    public boolean addTable(Table table){
        boolean result = true;

        for(Table ex : tableList){
            if(ex != table){
                if(table.rect.intersects(ex.rect.getBoundsInParent())){
                    result = false;
                }
            }
        }
        tableList.add(table);
        return result;
    }

    private boolean isCellEmpty(ObjCell[] objCells){
        boolean result = true;
        for(HallCell hallCell : hallCellSet){
            for(int i = 0; i < objCells.length; i++){
                if(objCells[i].x == hallCell.x && objCells[i].y == hallCell.y){
                    result = false;
                }
            }
        }
        return result;
    }

    private boolean isHallEmpty(){
        boolean result = true;
        for(HallCell hallCell : hallCellSet){
            if(!hallCell.isEmpty){
                result = false;
                break;
            }
        }
        return result;
    }

    public Color getColor() {
        return color;
    }



    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }


}
