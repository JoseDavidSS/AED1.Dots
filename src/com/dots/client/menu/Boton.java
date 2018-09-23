package com.dots.client.menu;

import com.dots.client.lists.dots.ListaVertices;
import com.dots.client.lists.figures.ListaFiguras;
import com.dots.client.socket.Cliente;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;

/**
 * Clase envoltorio que extiende de Button de JavaFX.
 */

public class Boton extends Button {

    private Button boton;
    private int coordenadaX;
    private int coordenadaY;

    /**
     * Constructor de la clase Boton.
     * @param ejeX variable que almacena la posición en X del botón.
     * @param ejeY variable que almacena la posición en X del botón.
     */

    public Boton (int ejeX, int ejeY){
        this.boton = crearBoton(ejeX, ejeY);
    }

    /**
     * Método para crear un botón con características diferentes a los botones normales.
     * @param ejeX atributo para asignar la posición en X del botón.
     * @param ejeY atributo para asignar la posición en Y del botón.
     * @return el botón creado.
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
     * Método dedicado a ser llamado por el setOnAction de cada botón creado e imprime su posición en X y en Y.
     */

    private void presionarBoton (){
        if (Juego.turno){
            System.out.println(coordenadaX +", "+ coordenadaY);
            ListaVertices l1 = ListaVertices.getInstance();
            l1.anadirElemento(coordenadaX, coordenadaY);
            if (l1.getLargo() == 2){
                Cliente c = new Cliente();
                c.enviarListaVertices(l1);
                l1 = c.solicitarListaVertices();
                if (l1.isValido()){
                    System.out.println("LINEA ADMITIDA");
                    Juego.juego.dibujarLinea();
                    l1.reiniciar();
                    Juego.turno = false;
                    ListaFiguras.setInstance(c.solicitarListaFiguras());
                    Juego.juego.dibujarFiguras();
                    Turno t = new Turno();
                    t.start();
                }
                else{
                    System.out.println("LINEA NO ADMITIDA");
                    l1.reiniciar();
                }
            }
        }else{
            System.out.println("NO ES MI TURNO");
        }

    }

    /**
     * Método que retorna el atributo boton de tipo Button.
     * @return el botón creado.
     */

    public Button getBoton (){
        return boton;
    }


}
