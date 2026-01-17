package logica;

import java.util.Arrays;

public class Tablero {
    public static final char BARCO   = 'B';
    public static final char VACIO   = ' ';
    public static final char TOCADO  = 'X';
    public static final char DISPARO = 'O';
    public static final byte TOTAL_FILAS = 10;
    public static final byte TOTAL_COLUMNAS = 10;

    char[][] estado;

    public Tablero(){
        estado = new char[TOTAL_FILAS][TOTAL_COLUMNAS];
        for(byte i = 0; i < TOTAL_FILAS; i++)
            Arrays.fill(estado[i], VACIO);
    }

    public void setCasilla(byte fila, byte columna, char valor){
        estado[fila][columna] = valor;
    }

    public char getValor(byte fila, byte columna){
        return estado[fila][columna];        
    }

    public static boolean isDentro(byte fila, byte columna){
        return    fila >= 0 && fila    < TOTAL_FILAS &&
               columna >= 0 && columna < TOTAL_COLUMNAS;
    }

    public char[][] getEstado(){
        return estado;
    }
}
