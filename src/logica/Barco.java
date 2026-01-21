package logica;

import java.util.Arrays;
import logica.espacio.*;

public class Barco {
    private String nombre;
    private Coordenada[] casillas;
    private boolean[] isTocada;

    public Barco(String nombre, Coordenada[] casillas){
        this.nombre = nombre;
        this.casillas = casillas;
        isTocada = new boolean[casillas.length];
    }

    public Barco(String nombre, Posicion inicial, byte longitud){
        final Coordenada inicio = inicial.getCoordenada();
        this.nombre = nombre;
        casillas = new Coordenada[longitud];
        isTocada = new boolean[longitud];
                
        for(byte i = 0; i < longitud; i++){
            switch(inicial.getOrientacion()){
                case NORTE:    
                    casillas[i] = new Coordenada((byte)(inicio.getFila() - i), inicio.getColumna());
                    break;
                case ESTE:
                    casillas[i] = new Coordenada(inicio.getFila(), (byte)(inicio.getColumna() + i) );
                    break;
                case SUR:
                    casillas[i] = new Coordenada((byte)(inicio.getFila() + i), inicio.getColumna());                    
                    break;
                case OESTE:                    
                    casillas[i] = new Coordenada(inicio.getFila(), (byte)(inicio.getColumna() - i) );
                    break;
            }
        }
    }

    public Coordenada getCasilla(byte indice){
        return casillas[indice];
    }

    public byte getLongitud(){
        return (byte)casillas.length;
    }

    public boolean isVivo(){
        for(boolean elemento : isTocada)
            if(!elemento)
                return true;
        return false;
    }

    //Devuelve -1 si no se encuentra en esa coordenada
    public byte buscaBloque(Coordenada c){
        for(byte i = 0; i < casillas.length; i++)
            if(casillas[i].getFila() == c.getFila() && casillas[i].getColumna() == c.getColumna())
                return i;
        return -1;
    }

    public void tocaCasilla(byte indice){
        isTocada[indice] = true;
    }

    public String getNombre(){
        return nombre;
    }

    
    @Override
    public String toString(){
        return nombre + ": " + Arrays.toString(casillas);
    }
}
