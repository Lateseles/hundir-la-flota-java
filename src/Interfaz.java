import java.util.Scanner;

import logica.IEntradaSalida;
import logica.espacio.*;

public class Interfaz implements IEntradaSalida {
    Scanner t = new Scanner(System.in);

    @Override
    public Coordenada solicitarCoordenada() {        
        int fila, columna;
        do {
            mostrarMensaje("Dame una fila y una columna (0-9):");
            fila = t.nextInt();
            columna = t.nextInt();
        } while (!validar(fila, columna));
        return new Coordenada((byte) fila, (byte) columna);
    }

    public boolean validar(int f, int c) {
        boolean ok = true;
        if (f < 0 || f >= 10) {
            mostrarMensaje("Fila fuera de rango");
            ok = false;
        }
        if (c < 0 || c >= 10) {
            mostrarMensaje("Columna fuera de rango");
            ok = false;
        }
        return ok;
    }

    @Override
    public void mostrarMensaje(String text) {
        System.out.println(text);
    }

    @Override
    public void mostrarTableros(char[][] c, char[][] d) {
        // leyenda
        System.out.println("                 USUARIO                                          ACCION");
        System.out.print("   ");
        for (int i = 0; i < 10; i++) {
            System.out.print(" " + i + "  ");
        }
        // pinta casillas de maquina
        System.out.print("      ");
        for (int j = 0; j < 10; j++) {
            System.out.print("  " + j + " ");
        }

        System.out.println();

        // 3 espacios de separacion entre interfaz maquina y usuario

        // pinta
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " | ");

            for (int j = 0; j < 10; j++) {
                System.out.print(c[i][j] + " | ");
            }
            System.out.print("   ");
            System.out.print(i + " | ");
            for (int j = 0; j < 10; j++) {
                System.out.print(d[i][j] + " | ");
            }
            System.out.println("   ");

            for (int j = 0; j < 14; j++) {
                System.out.print(" _ ");
            }
            System.out.print("     ");

            for (int j = 0; j < 14; j++) {
                System.out.print(" _ ");
            }
            System.out.println();

        }        
    }

    @Override
    public Posicion solicitarUbicacion(String nombreBarco, byte longitudBarco) {        
        Coordenada casillaInicial;        
        byte aux;

        mostrarMensaje("Vas a situar el barco " + nombreBarco + " de longitud " + longitudBarco);
        mostrarMensaje("Se te pedirá la casilla del barco y su orientacion");
        casillaInicial = solicitarCoordenada();

        mostrarMensaje("Introduzca la orientacion: 0 Norte, 1 Este, 2 Sur, 3 Oeste");
        aux = t.nextByte();

        return new Posicion(casillaInicial, Orientacion.values()[aux]);
    }

    @Override
    public void mostrarTablero(char[][] jugador) {
        System.out.print("   ");
        for (int i = 0; i < 10; i++) {
            System.out.print(" " + i + "  ");
        }
        System.out.println();

        for (int i = 0; i < 10; i++) {
            System.out.print(i + " | ");

            for (int j = 0; j < 10; j++) {
                System.out.print(jugador[i][j] + " | ");
            }
            System.out.println();

            for (int j = 0; j < 14; j++) {
                System.out.print(" _ ");
            }
            System.out.println();
        }
    }

    @Override
    public void mostrar(TIPO_MENSAJE tipoMensaje) {
        switch (tipoMensaje) {
            case BIENVENIDA:
                mostrarMensaje("Bienvenido al hundir la flota");
                break;
            case DERROTA:
                mostrarMensaje("Has perdido la partida");
                break;
            case DESPEDIDA:
                mostrarMensaje("Fin del programa");
                break;
            case VICTORIA:
                mostrarMensaje("Enhorabuena has ganado la partida");
                break;
        }
    }
}
