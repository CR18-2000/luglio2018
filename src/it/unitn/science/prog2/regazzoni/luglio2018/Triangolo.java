/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.science.prog2.regazzoni.luglio2018;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

/**
 *
 * @author crist
 */
public class Triangolo extends Polygon {

    Triangolo () {
        this.getPoints().addAll(new Double[] {25.0, 0.0,
                                             50.0, 50.0,
                                             0.0, 50.0});
        this.setFill(Color.YELLOW);
        this.setStroke(Color.RED);
    }
    
}
