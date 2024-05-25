package states;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Clase que representa al Domador del juego, el cual puede tener un equipo de hasta 3 Digimones.
 */
public class Domador {

    private List<Digimon> equipo;

    /**
     * Constructor para crear al Domador con un Digimon aleatorio en su equipo.
     * 
     * @param nombre El nombre del domador.
     */
    public Domador(String nombre) {
        this.equipo = new ArrayList<>();
        agregarDigimonAleatorio();
    }

    /**
     * Agrega un Digimon aleatorio al equipo del domador.
     */
    private void agregarDigimonAleatorio() {
        String[] nombres = {"Agumon", "Gabumon", "Patamon"};
        Random rand = new Random();
        String nombreDigimon = nombres[rand.nextInt(nombres.length)];
        Digimon digimon = new Digimon(nombreDigimon);
        equipo.add(digimon);
    }

    /**
     * Intenta capturar un Digimon enemigo si su salud es menor o igual a 20.
     * 
     * @param digimon El Digimon enemigo a capturar.
     * @return true si el Digimon fue capturado, false en caso contrario.
     */
    public boolean capturar(Digimon digimon) {
        if (digimon.getSalud() <= 20) {
            if (equipo.size() < 3) {
                for (Digimon d : equipo) {
                    if (d.getNombre().equals(digimon.getNombre())) {
                        System.out.println("Ya tienes a " + digimon.getNombre() + " en tu equipo.");
                        return false;
                    }
                }
                equipo.add(digimon);
                System.out.println("¡Enhorabuena! " + digimon.getNombre() + " se ha unido a tu equipo.");
                return true;
            }
        } else {
            System.out.println("Lo siento, " + digimon.getNombre() + " no se puede unir, su salud es mayor a 20 HP.");
        }
        return false;
    }

    /**
     * Verifica si todos los Digimones en el equipo del domador son diferentes.
     * 
     * @return true si todos los Digimones son diferentes, false en caso contrario.
     */
    public boolean todosDiferentes() {
        if (equipo.size() != 3) {
            return false;
        }
        List<String> nombres = new ArrayList<>();
        for (Digimon d : equipo) {
            if (nombres.contains(d.getNombre())) {
                return false;
            }
            nombres.add(d.getNombre());
        }
        return true;
    }

    /**
     * Obtiene el equipo de Digimones del domador.
     * 
     * @return La lista de Digimones del equipo.
     */
    public List<Digimon> getEquipo() {
        return equipo;
    }

    /**
     * Convierte el equipo del domador a una representación en cadena.
     * 
     * @return Devuelve un string que representa el equipo del domador.
     */
    @Override
    public String toString() {
        return TablaEquipo.format(equipo);
    }
}
