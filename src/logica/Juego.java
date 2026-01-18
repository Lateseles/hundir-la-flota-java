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
        descriptivo = new Tablero();
        accion = new Tablero();
        humano = new JugadorHumano(gui, descriptivo);
        maquina = new JugadorIa(gui);       
    }

    public void jugar(){    
        boolean continuarPartida = true; 
        boolean turnoHumano = true;           
        gui.mostrar(IEntradaSalida.TIPO_MENSAJE.BIENVENIDA);
       
        posicionarBarcos(humano);
        posicionarBarcos(maquina);

        while(continuarPartida){            
            if(turnoHumano){
                gui.mostrarTableros(descriptivo.getEstado(), accion.getEstado());                
                final Coordenada disparo = humano.dispara(accion);
                gui.mostrarMensaje("Disparo Jugador");
                final char resultado = maquina.golpeado(disparo);
                accion.setCasilla(disparo.getFila(), disparo.getColumna(), resultado);                              
            } else{
                gui.mostrarMensaje("Disparo Maquina");
                final Coordenada disparo = maquina.dispara(descriptivo);
                final char resultado = humano.golpeado(disparo);
                descriptivo.setCasilla(disparo.getFila(), disparo.getColumna(), resultado); 
            }      
            turnoHumano = !turnoHumano;
            
            if(maquina.isPerdido()){
                gui.mostrar(IEntradaSalida.TIPO_MENSAJE.VICTORIA);
                continuarPartida = false;
            }
            else if(humano.isPerdido()){
                gui.mostrar(IEntradaSalida.TIPO_MENSAJE.DERROTA);
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
