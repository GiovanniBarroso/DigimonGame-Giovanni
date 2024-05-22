package states;

import java.util.Scanner;

public class Menu {



	public void iniciar() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("BIENVENIDO AL JUEGO DE DIGIMON");
		System.out.println("Introduce tu nombre como Domador Digimon:");

		String nombreDomador = scanner.nextLine();
		Domador domador = new Domador(nombreDomador);
		System.out.println("Genial!, ya hemos establecido tu nombre. \n¿Qué acción quieres realizar ahora " + nombreDomador + "?");

		while (true) {

			System.out.println("1. Iniciar batalla");
			System.out.println("2. Salir del videojuego.");
			int opcion = scanner.nextInt();

			if (opcion == 1) {

				BatallaDigital batalla = new BatallaDigital(domador);
				batalla.elige();

			} else if (opcion == 2) {

				System.out.println("¡Gracias por jugar a DigimonGame!\n ¡Hasta pronto!");
				break;

			} else {
				System.out.println("Opción no válida \n ¿Qué opción quieres realizar ?");
			}
		}


	}

}
