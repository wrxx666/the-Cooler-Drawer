package com.example.drawer.forms;


import javafx.scene.paint.Color;
import java.util.HashMap;
import java.util.HashSet;

public class Hall {
    private final Color color;
    private final double width;
    private final double height;
    private static HashSet<HallCell> hallCellSet;
    private static HashMap<Integer,Table> tableMap;

    public Hall(double width, double height, Color color){
        this.width = width;
        this.height = height;
        this.color = color;

        hallCellSet = new HashSet();
        tableMap = new HashMap<>();

        for(int j = 0; j < height; j++){
            for(int i = 0; i < width; i++){
                hallCellSet.add(new HallCell(i,j,true));
            }
        }


    }

    public boolean addTable(Table table){
        boolean result = true;
        if(!isHallEmpty()) {
            if(isCellEmpty(table.cellsCoord)) {
                tableMap.put(table.getId(), table);
                for (HallCell hallCell : hallCellSet) {
                    for (int i = 0; i < table.cellsCoord.length; i++) {
                        if (hallCell.x == table.cellsCoord[i].x && hallCell.y == table.cellsCoord[i].y) {
                            hallCell.isEmpty = false;
                        }
                    }
                }
                result = true;

            } else {
                System.out.println("ERROR");
                result = false;
            }

        } else {
            tableMap.put(table.getId(), table);
            for (HallCell hallCell : hallCellSet) {
                for (int i = 0; i < table.cellsCoord.length; i++) {
                    if (hallCell.x == table.cellsCoord[i].x && hallCell.y == table.cellsCoord[i].y) {
                        hallCell.isEmpty = false;
                    }
                }
            }
            result = true;

        }
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
