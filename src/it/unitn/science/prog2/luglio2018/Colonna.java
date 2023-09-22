/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.science.prog2.regazzoni.luglio2018;

import java.util.ArrayList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Shape;

/**
 * contiene le 5 celle
 *
 * @author crist
 */
public class Colonna extends VBox {

    ArrayList<Cella> list = new ArrayList<>();
    ArrayList<Shape> forme = new ArrayList<>();

    Colonna() {
        for (int i = 0; i < 5; i++) {
            list.add(new Cella());
        }
        for (int i = 4; i >= 0; i--) {
            this.getChildren().add(list.get(i));
        }
    }

    public void aggiungi() {
        int indice = forme.size() - 1;
        list.get(indice).getChildren().add(forme.get(indice));
        update();
    }

    public void rimuoviTop() {
        if (forme.size() > 0) {
            int indice = forme.size() - 1;
            list.remove(indice);
            list.add(indice, new Cella());
            forme.remove(indice);
            update();
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Errore!");
            alert.setContentText("NON CI SONO PIU ELEMENTI DA TOGLIERE");
            alert.showAndWait();
        }
    }

    public void rimuoviBottom() {
        if (forme.size() > 0) {
            forme.remove(0);
            list.clear();
            for (int i = 0; i < 5; i++) {
                list.add(new Cella());
            }
            int max = forme.size();
            for (int i = 0; i < max; i++) {
                list.get(i).getChildren().add(forme.get(i));
            }
            update();
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Errore!");
            alert.setContentText("NON CI SONO PIU ELEMENTI DA TOGLIERE");
            alert.showAndWait();
        }
    }

    private void update() {
        this.getChildren().clear();
        for (int i = 4; i >= 0; i--) {
            this.getChildren().add(list.get(i));
        }
    }

    public String toString() {
        String s = "";
        int nFigure = forme.size();
        if (nFigure == 5) {
            for (int i = 4; i >= 0; i--) {
                if (forme.get(i) instanceof Cerchio) {
                    s += " Circle";
                } else if (forme.get(i) instanceof Triangolo) {
                    s += " Triangle";
                } else if (forme.get(i) instanceof Esagono) {
                    s += " Hexagon";
                }
            }
        } else {
            for (int i = 0; i < (5 - nFigure); i++) {
                s += " null";
            }
            for (int i = nFigure - 1; i >= 0; i--) {
                if (forme.get(i) instanceof Cerchio) {
                    s += " Circle";
                } else if (forme.get(i) instanceof Triangolo) {
                    s += " Triangle";
                } else if (forme.get(i) instanceof Esagono) {
                    s += " Hexagon";
                }
            }
        }

        return s;
    }

}
