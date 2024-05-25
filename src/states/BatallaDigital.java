package states;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Clase que representa la batalla entre el domador y el Digimon enemigo.
 */
public class BatallaDigital {

    private Domador domador;
    private Digimon enemigo;

    /**
     * Constructor para inicializar la batalla.
     * 
     * @param domador El domador que participa en la batalla.
     */
    public BatallaDigital(Domador domador) {
        this.domador = domador;
        generarEnemigo();
    }

    /**
     * Genera un enemigo Digimon aleatorio.
     */
    private void generarEnemigo() {
        String[] nombres = {"Agumon", "Gabumon", "Patamon"};
        Random rand = new Random();
        String nombreEnemigo = nombres[rand.nextInt(nombres.length)];
        enemigo = new Digimon(nombreEnemigo);
        System.out.println("¡Digimon enemigo encontrado!: " + enemigo);
    }

    /**
     * Permite al usuario elegir un Digimon de su equipo para combatir.
     * 
     * @param sn Scanner utilizado para la entrada del usuario.
     * @throws InputMismatchException si la entrada no es un número.
     */
    public void elige(Scanner sn) {
        while (true) {
            try {
                System.out.println(domador);
                System.out.println("Elige un Digimon de tu equipo para combatirlo:");

                for (int i = 0; i < domador.getEquipo().size(); i++) {
                    System.out.println((i + 1) + ". " + domador.getEquipo().get(i).getNombre());
                }

                int opcion = sn.nextInt();

                if (opcion < 1 || opcion > domador.getEquipo().size()) {
                    System.out.println("Opción no válida. Por favor, elige un número entre 1 y " + domador.getEquipo().size());
                } else {
                    pelea(domador.getEquipo().get(opcion - 1), sn);
                    break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, introduce un número válido.");
                sn.next();
            }
        }
    }

    /**
     * Lógica de la pelea entre el Digimon del domador y el Digimon enemigo.
     * 
     * @param digimon El Digimon del domador que combate.
     * @param sn Scanner para la entrada del usuario.
     * @throws InputMismatchException si la entrada no es un número.
     */
    public void pelea(Digimon digimon, Scanner sn) {
        Random rand = new Random();

        try {
            while (enemigo.getSalud() > 0 && digimon.getSalud() > 0) {
                try {
                    System.out.println("Elige tu acción:");
                    System.out.println("1. Ataque 1");
                    System.out.println("2. Ataque 2");
                    System.out.println("3. Capturar");

                    int accion = sn.nextInt();
                    boolean accionValida = true;

                    switch (accion) {
                        case 1:
                            digimon.ataque1(enemigo);
                            break;
                        case 2:
                            digimon.ataque2(enemigo);
                            break;
                        case 3:
                            if (domador.capturar(enemigo)) {
                                return;
                            }
                            break;
                        default:
                            System.out.println("Opción no válida\n");
                            accionValida = false;
                    }

                    if (accionValida) {
                        if (enemigo.getSalud() > 0) {
                            int ataqueEnemigo = rand.nextInt(2) + 1;

                            if (ataqueEnemigo == 1) {
                                enemigo.ataque1(digimon);
                                System.out.println("El enemigo usó Ataque 1. Daño: " + enemigo.getAtaque());
                            } else {
                                enemigo.ataque2(digimon);
                                System.out.println("El enemigo usó Ataque 2. Daño: " + (2 * enemigo.getAtaque()));
                            }

                            if (digimon.getSalud() <= 0) {
                                System.out.println("¡Tu Digimon ha sido derrotado!");
                                domador.getEquipo().remove(digimon);

                                if (domador.getEquipo().isEmpty()) {
                                    System.out.println("No te quedan más Digimones. El juego ha terminado.");
                                    System.exit(0);
                                } else {
                                    elige(sn);
                                }
                                return;
                            }
                        }
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Entrada no válida. Por favor, introduce un número.");
                    sn.next();
                }

                System.out.println("Estado enemigo: " + enemigo);
                System.out.println("Estado tu Digimon: " + digimon);
            }

            if (enemigo.getSalud() <= 0) {
                System.out.println("¡Has derrotado al enemigo!");
            }

        } catch (InputMismatchException e) {
            System.out.println("Entrada no válida. Por favor, introduce un número.");
            sn.next();
        }
    }
}
