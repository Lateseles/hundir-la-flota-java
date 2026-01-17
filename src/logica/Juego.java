package logica;

import logica.espacio.Coordenada;

public class Juego {
    IEntradaSalida gui;
    Jugador humano;
    Jugador maquina;
    Tablero descriptivo;
    Tablero accion;

    public Juego(IEntradaSalida gui){
        this.gui = gui;
        humano = new JugadorHumano(gui);
        maquina = new JugadorIa(gui);
        descriptivo = new Tablero();
        accion = new Tablero();
    }

    public void Jugar(){    
        boolean continuarPartida = true; 
        boolean turnoHumano = true;           
        gui.mostrar(IEntradaSalida.TIPO_MENSAJE.BIENVENIDA);

        gui.mostrarTableros(descriptivo.getEstado(), accion.getEstado());
        posicionarBarcos(humano);
        posicionarBarcos(maquina);

        while(continuarPartida){
            if(turnoHumano){
                final Coordenada disparo = humano.dispara(accion);
                final char resultado = maquina.golpeado(disparo);
                accion.setCasilla(disparo.getFila(), disparo.getColumna(), resultado);                              
            } else{
                final Coordenada disparo = maquina.dispara(descriptivo);
                final char resultado = humano.golpeado(disparo);
                descriptivo.setCasilla(disparo.getFila(), disparo.getColumna(), resultado); 
            }      
            
            if(maquina.isPerdido()){
                gui.mostrar(IEntradaSalida.TIPO_MENSAJE.DERROTA);
                continuarPartida = false;
            }
            else if(humano.isPerdido()){
                gui.mostrar(IEntradaSalida.TIPO_MENSAJE.VICTORIA);
                continuarPartida = false;
            }
        }

        gui.mostrar(IEntradaSalida.TIPO_MENSAJE.DESPEDIDA);
    }
    
    private void posicionarBarcos(Jugador jugador){        
        jugador.agregarBarco("Portaviones", (byte)5);        
        jugador.agregarBarco("Acorazado", (byte)4);
        jugador.agregarBarco("Submarino", (byte)3);
        jugador.agregarBarco("Crucero", (byte)3);
        jugador.agregarBarco("Destructor", (byte)2);
    }

}
