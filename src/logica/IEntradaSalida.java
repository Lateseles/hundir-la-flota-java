package logica;

import logica.espacio.Coordenada;
import logica.espacio.Posicion;

public interface IEntradaSalida {    

    public Coordenada solicitarCoordenada();

    public Posicion solicitarUbicacion(String nombreBarco, byte longitudBarco);

    public void mostrarTableros(char[][] jugador, char[][] accion);

    public void mostrarMensaje(String mensaje);
}
