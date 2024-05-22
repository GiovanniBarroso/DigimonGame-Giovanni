package states;

import java.util.Scanner;

public class Menu {
	public void iniciar() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduce el nombre del Domador:");
		String nombreDomador = scanner.nextLine();
		Domador domador = new Domador(nombreDomador);


		while (true) {
			System.out.println("1. Iniciar batalla");
			System.out.println("2. Salir");
			int opcion = scanner.nextInt();

			if (opcion == 1) {
				BatallaDigital batalla = new BatallaDigital(domador);
				batalla.elige();
			} else if (opcion == 2) {
				break;
			} else {
				System.out.println("Opción no válida");
			}
		}


	}

}
