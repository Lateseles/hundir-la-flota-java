package logica;

import java.util.Random;

import logica.espacio.Coordenada;
import logica.espacio.Orientacion;
import logica.espacio.Posicion;

public class JugadorIa extends Jugador{
    private Random generadorAleatorio;

    protected JugadorIa(IEntradaSalida gui) {
        super(gui);        
        generadorAleatorio = new Random();
    }

    @Override
    public void agregarBarco(String nombre, byte longitud) {
        Barco barco;
        Posicion posicion;

        do{
            posicion = escogerUbicacion(nombre, longitud);
            barco = new Barco(nombre, posicion, longitud);            
        }while(!isValido(barco));

        barcos.add(barco);
    }

    @Override
    public Coordenada dispara(Tablero accion) {
        //TODO mejorar este método para volverlo inteligente
        return new Coordenada((byte)(Math.random() * 10), (byte)(Math.random() * 10));
    }

    private Posicion escogerUbicacion(String nombre, byte longitud){        
        return new Posicion(
                   new Coordenada((byte)(generadorAleatorio.nextInt(Tablero.TOTAL_FILAS)),
                                  (byte)(generadorAleatorio.nextInt(Tablero.TOTAL_COLUMNAS))),
                   Orientacion.values()[generadorAleatorio.nextInt(Orientacion.values().length)]);
    }

}
