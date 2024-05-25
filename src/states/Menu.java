package states;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	public void iniciar() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("----- BIENVENIDO AL JUEGO DE DIGIMON -----");
		System.out.println("Introduce tu nombre como Domador Digimon:");

		String nombreDomador = scanner.nextLine();
		Domador domador = new Domador(nombreDomador);
		System.out.println("\n¡Genial! Ya hemos establecido tu nombre.\n¿Qué acción quieres realizar ahora, " + nombreDomador + "?");

		while (true) {
			System.out.println(domador);
			System.out.println("\n1. Iniciar batalla");
			System.out.println("2. Salir del videojuego.");
			try {
				int opcion = scanner.nextInt();
				switch (opcion) {
				case 1:
					BatallaDigital batalla = new BatallaDigital(domador);
					batalla.elige(scanner);  

					if (domador.getEquipo().size() == 3 && domador.todosDiferentes()) {
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
				System.out.println("Entrada no válida. Por favor, introduce un número.");
				scanner.next();
			} 
		}
	}
}