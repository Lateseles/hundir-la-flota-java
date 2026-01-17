package logica;

import logica.espacio.Coordenada;
import logica.espacio.Posicion;

public interface IEntradaSalida {    
    public enum TIPO_MENSAJE{ BIENVENIDA, DESPEDIDA, VICTORIA, DERROTA }

    public Coordenada solicitarCoordenada();

    public Posicion solicitarUbicacion(String nombreBarco, byte longitudBarco);

    public void mostrarTableros(char[][] jugador, char[][] accion);

    public void mostrarTablero(char[][] jugador);

    public void mostrarMensaje(String mensaje);

    public void mostrar(TIPO_MENSAJE tipoMensaje);
}
