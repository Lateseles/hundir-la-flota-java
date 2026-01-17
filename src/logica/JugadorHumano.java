package logica;

import logica.espacio.Coordenada;

public class JugadorHumano extends Jugador{

    protected JugadorHumano(IEntradaSalida gui) {
        super(gui);
        
    }

    @Override
    public void agregarBarco(String nombre, byte longitud) {
        //TODO IMPLEMENTAR METODO
    }

    @Override
    public Coordenada dispara(Tablero accion) {
        return null; //TODO IMPLEMENTAR METODO
    }

}
