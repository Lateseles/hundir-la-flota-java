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

    protected boolean isValido(Barco barco){
        final byte longitud = barco.getLongitud();
        Iterator<Barco> it;

        for(byte i = 0; i < longitud; i++){
            final Coordenada actual = barco.getCasilla(i);            
            final Coordenada[] casilla = { actual,
                 new Coordenada((byte)(actual.getFila() - 1), actual.getColumna()),
                 new Coordenada(actual.getFila(), (byte)(actual.getColumna() + 1)),
                 new Coordenada((byte)(actual.getFila() + 1), actual.getColumna()),
                 new Coordenada(actual.getFila(), (byte)(actual.getColumna() - 1)),
                 };            

            if(!Tablero.isDentro(actual.getFila(), actual.getColumna()))
                return false;
            
            for(byte j = 0; j < casilla.length; j++){
                it = barcos.iterator();
                while(it.hasNext()){
                    Barco b = it.next();
                    if(b.buscaBloque(casilla[j]) >= 0)
                        return false;
                }
            }       
                    
        }
        return true;
    }

}
