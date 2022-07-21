package com.example.drawer.paint.forms;


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

        tableList = new ArrayList<>();

    }

    /**
     * Добавляет стол в зал и проверяет его на пересечение с другими столами
     */

    public boolean addTable(Table table){

        for(Table ex : tableList){
            if(ex != table){
                if(table.rect.intersects(ex.rect.getBoundsInParent())){
                    Table.setCount(Table.getCount()-1);
                    return false;
                }
            }
        }
        tableList.add(table);

        /* for (Table e : tableList){
            System.out.println(e.name);
        }
        System.out.println(Table.getCount());

         */
        return true;
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
