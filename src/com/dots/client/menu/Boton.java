package com.dots.client.menu;

import javafx.scene.control.Button;
import javafx.scene.shape.Circle;

public class Boton extends Button {

    private Button boton;
    private double coordenadaX;
    private double coordenadaY;

    public Boton (double ejeX, double ejeY){

        this.boton = crearBoton(ejeX, ejeY);
    }

    private Button crearBoton(double ejeX, double ejeY) {

        double r = 6.0;
        coordenadaX = ejeX;
        coordenadaY = ejeY;

        Button btn = new Button();
        btn.setOnAction(e-> presionarBoton());
        btn.setLayoutX(ejeX);
        btn.setLayoutY(ejeY);
        btn.setShape(new Circle(r));
        btn.setMinSize(2 * r, 2 * r);
        btn.setMaxSize(2 * r, 2 * r);
        return btn;
    }

    private void presionarBoton (){
        System.out.println(coordenadaX +","+coordenadaY);


    }
    public Button getBoton (){
        return boton;
    }

}
