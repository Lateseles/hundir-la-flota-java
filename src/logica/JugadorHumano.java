package logica;

import logica.espacio.Coordenada;
import logica.espacio.Posicion;

public class JugadorHumano extends Jugador{
    private Tablero descriptivo;

    protected JugadorHumano(IEntradaSalida gui, Tablero descripcion) {
        super(gui);
        descriptivo = descripcion;
    }

    private void marcar(Barco b){
        for(byte casilla = 0; casilla < b.getLongitud(); casilla++){
            descriptivo.setCasilla(b.getCasilla(casilla).getFila(), b.getCasilla(casilla).getColumna(), Tablero.BARCO);
        }
    }

    @Override
    public void agregarBarco(String nombre, byte longitud) {
        Barco barco;
        Posicion posicion;

        gui.mostrarTablero(descriptivo.getEstado());
        do{
            posicion = gui.solicitarUbicacion(nombre, longitud);
            barco = new Barco(nombre, posicion, longitud);
            if(!isValido(barco)){
                gui.mostrarMensaje("El barco no puede posicionarse ahí");
            }
        }while(!isValido(barco));

        barcos.add(barco);
        marcar(barco);
    }

    @Override
    public Coordenada dispara(Tablero accion) {
        Coordenada disparo;
        char valorCasilla;

        do{
            disparo = gui.solicitarCoordenada();
            valorCasilla = accion.getValor(disparo.getFila(), disparo.getColumna());
            if(valorCasilla != Tablero.VACIO)
                gui.mostrarMensaje("Esa casilla ya ha sido disparada, prueba otra");
        }while(valorCasilla != Tablero.VACIO);
        
        return disparo;
    }

}
