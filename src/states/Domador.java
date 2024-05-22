package states;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Domador {
	
	private String nombre;
	private List<Digimon> equipo;

	
	public Domador(String nombre) {
		this.nombre = nombre;
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
				System.out.println(digimon.getNombre() + " se ha unido a su equipo");
			} else {
				System.out.println("Equipo completo, no se puede unir");
			}
		} else {
			System.out.println(digimon.getNombre() + " no se puede unir, salud mayor a 20");
		}
	}

	
	public List<Digimon> getEquipo() {
		return equipo;
	}

	
	@Override
	public String toString() {
		return "Domador{" +
				"nombre='" + nombre + '\'' +
				", equipo=" + equipo +
				'}';
	}
	
}