package com.dots.client.menu;

import com.dots.client.lists.dots.ListaVertices;
import com.dots.client.lists.figures.ListaFiguras;
import com.dots.client.lists.figures.NodoFiguras;
import com.dots.client.lists.lines.ListaLineas;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.net.JarURLConnection;

public class Boton extends Button {

    private Button boton;
    private int coordenadaX;
    private int coordenadaY;

    /**
     * Es te es el constructor de la clase Boton.
     * @param ejeX variable que almacena la posición en X del botón.
     * @param ejeY variable que almacena la posición en X del botón.
     */
    public Boton (int ejeX, int ejeY){
        this.boton = crearBoton(ejeX, ejeY);
    }

    /**
     * crearBoton es una función para crear un botón con características diferentes a los botones normales.
     * @param ejeX atributo para asignar la posición en X del botón.
     * @param ejeY atributo para asignar la posición en Y del botón.
     * @return
     */
    private Button crearBoton(int ejeX, int ejeY) {

        int r = 6;
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
        System.out.println(coordenadaX +", "+ coordenadaY);
        ListaVertices l1 = ListaVertices.getInstance();
        l1.anadirElemento(coordenadaX, coordenadaY);
        ListaFiguras lF = ListaFiguras.getInstance();
        lF.anadirElemento(250, 50, 366, 50, 366, 216, 250, 216);
        NodoFiguras tmp = lF.head;
        int ancho = (tmp.getV2x() - tmp.getV1x());
        System.out.println("vertice 1:"+tmp.getV1x());
        Juego.juego.dibujarCuadros(tmp.getV1x(), tmp.getV1y(),ancho);


        if (l1.getLargo() == 2){
            l1.ordenar2();
            Juego.juego.dibujarLinea();
            l1.reiniciar();



        }

    }
    public Button getBoton (){
        return boton;
    }


}
