/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.science.prog2.regazzoni.luglio2018;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author crist
 */
public class Cerchio extends Circle {
       
    Cerchio () {
        this.setCenterX(25);
        this.setCenterY(25);
        this.setRadius(25);
        this.setFill(Color.YELLOW);
        this.setStroke(Color.RED);
    }
    
}
