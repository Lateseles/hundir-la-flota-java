package logica;

import java.util.Iterator;
import java.util.LinkedList;

import logica.espacio.Coordenada;

public abstract class Jugador {    
    protected LinkedList<Barco> barcos;  
    protected IEntradaSalida gui;

    protected Jugador(IEntradaSalida gui){
        this.gui = gui;
        barcos = new LinkedList<Barco>();        
    }

    public abstract void agregarBarco(String nombre, byte longitud);
    
    public abstract Coordenada dispara(Tablero accion);

    public boolean isPerdido(){
        return barcos.isEmpty();
    }

    public char golpeado(Coordenada c){
        Iterator<Barco> it = barcos.iterator();
        Barco barcoActual;
        byte bloque;

        while(it.hasNext()){
            barcoActual = it.next();
            bloque = barcoActual.buscaBloque(c);
            if(bloque >= 0){
                barcoActual.tocaCasilla(bloque);
                if(barcoActual.isVivo()){
                    gui.mostrarMensaje(barcoActual.getNombre() + " tocado");
                }else{
                    gui.mostrarMensaje(barcoActual.getNombre() + " hundido!!");
                    barcos.remove(barcoActual);
                }

                return Tablero.TOCADO;
            }
        }
        gui.mostrarMensaje("Agua");

        return Tablero.DISPARO;
    }
}
