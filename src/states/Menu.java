package states;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase que representa el menú principal del juego.
 */
public class Menu {

    /**
     * Método que inicia el menú del juego.
     * 
     * @throws InputMismatchException si la entrada no es un número.
     */
    public void iniciar() {
        Scanner sn = new Scanner(System.in);

        System.out.println("----- BIENVENIDO AL JUEGO DE DIGIMON -----");
        System.out.println("Introduce tu nombre como Domador Digimon:");

        String nombreDomador = sn.nextLine();
        Domador domador = new Domador(nombreDomador);
        System.out.println("\n¡Genial! Ya hemos establecido tu nombre.\n¿Qué acción quieres realizar ahora, " + nombreDomador + "?");

        while (true) {
            System.out.println(domador);
            System.out.println("\n1. Iniciar batalla");
            System.out.println("2. Salir del videojuego.");

            try {
                int opcion = sn.nextInt();
                switch (opcion) {
                    case 1:
                        BatallaDigital batalla = new BatallaDigital(domador);
                        batalla.elige(sn);

                        if (domador.getEquipo().size() == 3 && domador.todosDiferentes()) {
                            System.out.println(domador); 
                            System.out.println("¡Felicidades! Has completado el videojuego tras capturar a los 3 Digimones.\n¡El juego ha finalizado! ¡Gracias por jugar!");
                            return;
                        }
                        break;
                    case 2:
                        System.out.println("¡Gracias por jugar a DigimonGame!\n¡Hasta pronto!");
                        return;
                    default:
                        System.out.println("Opción no válida\n¿Qué opción quieres realizar?");
                }

            } catch (InputMismatchException e) {
                System.out.println("Caracter no válido\n¿Qué opción quieres realizar?");
                sn.next();
            }
        }
    }
}
