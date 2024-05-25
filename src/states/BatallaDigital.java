package states;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class BatallaDigital {
    private Domador domador;
    private Digimon enemigo;

    public BatallaDigital(Domador domador) {
        this.domador = domador;
        generarEnemigo();
    }

    private void generarEnemigo() {
        String[] nombres = {"Agumon", "Gabumon", "Patamon"};
        Random rand = new Random();
        String nombreEnemigo = nombres[rand.nextInt(nombres.length)];
        enemigo = new Digimon(nombreEnemigo);
        System.out.println("¡Digimon enemigo encontrado!: " + enemigo);
    }

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
                    break; // Salir del bucle tras seleccionar correctamente
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, introduce un número válido.");
                sn.next(); // Limpiar el input inválido
            }
        }
    }

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
                            System.out.println("Opción no válida");
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
                                System.out.println("Tu Digimon ha sido derrotado!");
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
                    sn.next(); // Limpiar el input inválido
                }

                System.out.println("Estado enemigo: " + enemigo);
                System.out.println("Estado tu Digimon: " + digimon);
            }

            if (enemigo.getSalud() <= 0) {
                System.out.println("Has derrotado al enemigo!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada no válida. Por favor, introduce un número.");
            sn.next();
        }
    }
}
