package com.example.drawer.forms;


import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Описывает зал, реализует в себе список столов и задейстоваванных на поле клеток
 */
public class Hall {
    private final Color color;
    private final double width;
    private final double height;

    public static List<Table> tableList = new ArrayList<>();

    public Hall(double width, double height, Color color){
        this.width = width;
        this.height = height;
        this.color = color;

        HashSet<HallCell> hallCellSet = new HashSet();
        tableList = new ArrayList<>();

        for(int j = 0; j < height; j++){
            for(int i = 0; i < width; i++){
                hallCellSet.add(new HallCell(i,j,true));
            }
        }


    }

    /**
     * Добавляет стол в зал и проверяет его на пересечение с другими столами
     */
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
