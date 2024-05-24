package states;

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
		System.out.println(domador);  // Mostrar el equipo del domador en formato de tabla
		System.out.println("Elige un Digimon de tu equipo para combatirlo:");
		for (int i = 0; i < domador.getEquipo().size(); i++) {
			System.out.println((i + 1) + ". " + domador.getEquipo().get(i));
		}
		int opcion = sn.nextInt();
		pelea(domador.getEquipo().get(opcion - 1), sn);
	}

	public void pelea(Digimon digimon, Scanner sn) {
		while (enemigo.getSalud() > 0 && digimon.getSalud() > 0) {
			System.out.println("Elige tu acción:");
			System.out.println("1. Ataque 1");
			System.out.println("2. Ataque 2");
			System.out.println("3. Capturar");

			int accion = sn.nextInt();

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
			}

			System.out.println("Estado enemigo: " + enemigo);
			System.out.println("Estado tu Digimon: " + digimon);
		}
		if (enemigo.getSalud() <= 0) {
			System.out.println("Has derrotado al enemigo!");
		}
	}
}