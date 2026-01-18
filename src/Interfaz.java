import java.util.Scanner;

public class Interfaz {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        int posiciones = solicitarFilaColumna();
    }

    public static int solicitarFilaColumna() {
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
}
