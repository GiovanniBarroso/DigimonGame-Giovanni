package states;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Domador {
	private List<Digimon> equipo;

	public Domador(String nombre) {
		this.equipo = new ArrayList<>();
		agregarDigimonAleatorio();
	}

	private void agregarDigimonAleatorio() {
		String[] nombres = {"Agumon", "Gabumon", "Patamon"};
		Random rand = new Random();
		String nombreDigimon = nombres[rand.nextInt(nombres.length)];
		Digimon digimon = new Digimon(nombreDigimon);
		equipo.add(digimon);
	}

	public void capturar(Digimon digimon) {
		if (digimon.getSalud() <= 20) {
			if (equipo.size() < 3) {
				equipo.add(digimon);
				System.out.println("¡Enhorabuena!," + digimon.getNombre() + " se ha unido a su equipo.");
			} else {
				System.out.println("¡Vaya!, el equipo ya está completo (3 DIGIMON).");
			}
		} else {
			System.out.println("Lo siento, " + digimon.getNombre() + " no se puede unir, su salud es mayor a 20 HP");
		}
	}


	public List<Digimon> getEquipo() {
		return equipo;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Equipo de Digimon:\n");
		sb.append("+------------------+------------------+------------------+\n");
		sb.append("|     Digimon 1    |     Digimon 2    |     Digimon 3    |\n");
		sb.append("+------------------+------------------+------------------+\n");

		for (int i = 0; i < 3; i++) {
			if (i < equipo.size()) {
				Digimon digimon = equipo.get(i);
				sb.append(String.format("| %-16s ", digimon.getNombre()));
			} else {
				sb.append("|                  ");
			}
		}
		sb.append("|\n");
		sb.append("+------------------+------------------+------------------+\n");

		return sb.toString();
	}
}
