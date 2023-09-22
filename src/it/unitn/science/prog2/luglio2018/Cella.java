/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.science.prog2.regazzoni.luglio2018;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * classe che contiene le celle della colonna
 * @author crist
 */
public class Cella extends StackPane {
    
    Cella () {
        this.setWidth(50);
        this.setHeight(50);
        Rectangle rect = new Rectangle (50, 50);
        rect.setFill(Color.BLACK);
        rect.setStroke(Color.GREENYELLOW);
        this.getChildren().add(rect);
    }
    
}
