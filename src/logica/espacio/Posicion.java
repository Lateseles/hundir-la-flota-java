package logica.espacio;

public class Posicion {
    private Coordenada lugar;
    private Orientacion sentido;

    public Posicion(Coordenada lugar, Orientacion sentido){
        this.lugar = lugar;
        this.sentido = sentido;
    }

    public Coordenada getCoordenada(){
        return lugar;
    }

    public Orientacion getOrientacion(){
        return sentido;
    }

    public void setOrientacion(Orientacion sentido){
        this.sentido = sentido;
    }

    public void gira(byte pasos){  
        final byte numeroOrientaciones = (byte)Orientacion.values().length;
       
        sentido = Orientacion.values()[(sentido.ordinal() + pasos % numeroOrientaciones + numeroOrientaciones) % numeroOrientaciones];
    }    
}
