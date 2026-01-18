import java.util.Scanner;

public class Interfaz {
    public static void main(String[] args) {

        int posiciones = solicitarFilaColumna();

        // Crear tablero de la máquina 
        char[][] maquina = new char[10][10];
         // Crear tablero del usuario
        char[][] usuario = new char[10][10];

        // Mostrar los dos tableros
        mostrarTablero(maquina, usuario);
    }

    public static int solicitarFilaColumna() {
        Scanner t = new Scanner(System.in);
        int fila, columna;
        do {
            mensajes("Dame una fila y una columna (0-9):");
            fila = t.nextInt();
            columna = t.nextInt();
        } while (!validar(fila, columna));
        return fila * 10 + columna;
    }

    public static boolean validar(int f, int c) {
        boolean ok = true;
        if (f < 0 || f >= 10) {
            mensajes("Fila fuera de rango");
            ok = false;
        }
        if (c < 0 || c >= 10) {
            mensajes("Columna fuera de rango");
            ok = false;
        }
        return ok;
    }

    public static void mensajes(String text) {
        System.out.println(text);
    }

    public static void mostrarTablero(char[][] c, char[][] d) {
        // leyenda
        System.out.println("                 MAQUINA                                          USUARIO");
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
}
