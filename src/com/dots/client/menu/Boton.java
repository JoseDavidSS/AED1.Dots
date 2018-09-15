package com.dots.client.menu;

import javafx.scene.control.Button;
import javafx.scene.shape.Circle;

public class Boton extends Button {

    private Button boton;
    private double coordenadaX;
    private double coordenadaY;

    /**
     * Es te es el constructor de la clase Boton.
     * @param ejeX variable que almacena la posición en X del botón.
     * @param ejeY variable que almacena la posición en X del botón.
     */
    public Boton (double ejeX, double ejeY){
        this.boton = crearBoton(ejeX, ejeY);
    }

    /**
     * crearBoton es una función para crear un botón con características diferentes a los botones normales.
     * @param ejeX atributo para asignar la posición en X del botón.
     * @param ejeY atributo para asignar la posición en Y del botón.
     * @return
     */
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

    /**
     * presionarBoton es una funcion dedicada a ser llamada por el setOnAction de cada botón creado e imprime su posición en X y en Y.
     */
    private void presionarBoton (){

        System.out.println(coordenadaX +","+coordenadaY);


    }
    public Button getBoton (){
        return boton;
    }

}
