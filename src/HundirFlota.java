/*  Proyecto desarrollado por:
    Alexandra Ramón Angrisano y Francisco Javier Vera Valenciano
    Entornos de desarrollo. 1ºDAW
*/

import logica.Juego;

public class HundirFlota {
    public static void main(String[] args) {
        Juego juego = new Juego(new Interfaz()); //Con esta interfaz se mostrará el juego por consola
        juego.jugar();
    }
}
