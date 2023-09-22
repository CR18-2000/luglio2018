/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.science.prog2.regazzoni.luglio2018;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

/**
 * contiene i pulsanti e l'anteprima della figura
 * @author crist
 */
public class Centro extends VBox {
    
    Button circle; Button triangle; Button hexagon;
    Cella cella;
    Button add; Button removeTop; Button removeBottom; Button print;
    Colonna col;
    //se è 1 aggiungo il cerchio, 2 il triangolo e 3 l'esagono
    int figura;
    
    Centro (Colonna col) {
        figura = 0;
        this.col=col;
        add = new Button ("Add");
        add.setPrefWidth(125);
        EventHandler<ActionEvent> eventHandlerAdd = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                aggiungere();
            }
        };
        add.addEventHandler(ActionEvent.ACTION, eventHandlerAdd);
        //this.add(add, 0, 0);
        removeBottom = new Button ("Remove bottom");
        removeBottom.setPrefWidth(125);
        EventHandler<ActionEvent> eventHandlerRemBottom = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                col.rimuoviBottom();
            }
        };
        removeBottom.addEventHandler(ActionEvent.ACTION, eventHandlerRemBottom);
        //this.add(removeBottom, 1, 0);
        removeTop = new Button ("Remove top");
        removeTop.setPrefWidth(125);
        EventHandler<ActionEvent> eventHandlerRemTop = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                col.rimuoviTop();
            }
        };
        removeTop.addEventHandler(ActionEvent.ACTION, eventHandlerRemTop);
        //this.add(removeTop, 0, 1);
        print = new Button  ("Print Stack");
        print.setPrefWidth(125);
        EventHandler<ActionEvent> eventHandlerPrint = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(col.toString());
            }
        };
        print.addEventHandler(ActionEvent.ACTION, eventHandlerPrint);
        //this.add(print, 1, 1);
        HBox hb1 = new HBox ();
        hb1.getChildren().addAll(add, removeBottom);
        hb1.setAlignment(Pos.CENTER);
        hb1.setPrefWidth(250);
        HBox hb2 = new HBox ();
        hb2.getChildren().addAll(removeTop, print);
        hb2.setAlignment(Pos.CENTER);
        hb2.setPrefWidth(250);
        cella = new Cella ();
        HBox hb3 = new HBox ();
        hb3.getChildren().add(cella);
        hb3.setAlignment(Pos.CENTER);
        circle = new Button ("Cirlce");
        circle.setPrefWidth(83);
        EventHandler<ActionEvent> eventHandlerCirlce = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cerchio();
                circle.setDisable(true);
                triangle.setDisable(false);
                hexagon.setDisable(false);
            }
        };
        circle.addEventHandler(ActionEvent.ACTION, eventHandlerCirlce);
        //this.add(circle, 0, 4);
        triangle = new Button ("Triangle");
        triangle.setPrefWidth(83);
        EventHandler<ActionEvent> eventHandlerTri = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                triangolo();
                triangle.setDisable(true);
                hexagon.setDisable(false);
                circle.setDisable(false);
            }
        };
        triangle.addEventHandler(ActionEvent.ACTION, eventHandlerTri);
        //this.add(triangle, 1, 4);
        hexagon = new Button ("Hexagon");
        hexagon.setPrefWidth(83);
        EventHandler<ActionEvent> eventHandlerHex = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                esagono();
                hexagon.setDisable(true);
                triangle.setDisable(false);
                circle.setDisable(false);
            }
        };
        hexagon.addEventHandler(ActionEvent.ACTION, eventHandlerHex);
        //this.add(hexagon, 2, 4);
        HBox hb4 = new HBox ();
        hb4.getChildren().addAll(circle, triangle, hexagon);
        hb4.setAlignment(Pos.CENTER);
        hb4.setPrefWidth(250);
        this.getChildren().addAll(hb1, hb2, hb3, hb4);
    }
     
    private void cerchio () {
        cella.getChildren().clear();
        cella.getChildren().add(new Cerchio());
        figura=1;
    }
    
    private void triangolo () {
        cella.getChildren().clear();
        cella.getChildren().add(new Triangolo());
        figura=2;
    }
     
    private void esagono () {
        cella.getChildren().clear();
        cella.getChildren().add(new Esagono());
        figura=3;
    }
    
    private void aggiungere () {
        if (col.forme.size()!=5&&figura!=0) {
        switch (figura) {
            case 1:
                col.forme.add(new Cerchio());
                break;
            case 2:
                col.forme.add(new Triangolo());
                break;
            case 3:
                col.forme.add(new Esagono());
                break;
            }
        col.aggiungi();
        }
        else  if (col.forme.size()!=5){
            Alert alert = new Alert (AlertType.ERROR);
            alert.setTitle("Errore!");
            alert.setContentText("COLONNA PIENA!!");
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert (AlertType.ERROR);
            alert.setTitle("Errore!");
            alert.setContentText("NESSUNA FIGURA SELEZIONATA!");
            alert.showAndWait();
        }
    }
    
}
