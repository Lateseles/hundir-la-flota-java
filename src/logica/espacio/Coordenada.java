package logica.espacio;

public class Coordenada {
    private byte fila;
    private byte columna;

    public Coordenada(byte fila, byte columna){
        this.fila = fila;
        this.columna = columna;
    }

    public byte getFila(){
        return fila;
    }

    public byte getColumna(){
        return columna;
    }

    public void setFila(byte fila){
        this.fila = fila;
    }

    public void setColumna(byte columna){
        this.columna = columna;
    }

    @Override
    public String toString(){
        return String.format("(%d,%d)",fila, columna);
    }
}
