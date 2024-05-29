package main;

import states.Menu;

/**
 * Clase main del juego Digimon.
 * 
 * @author Giovanni
 */
public class Main {

    /**
     * Método principal que inicia el juego Digimon.
     *
     * @param args Los argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        // Código para iniciar el juego
        Menu menu = new Menu();
        menu.iniciar();
    }
}
