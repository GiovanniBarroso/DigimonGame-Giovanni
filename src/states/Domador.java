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

    
    
    public List<Digimon> getEquipo() {
        return equipo;
    }

    
    
    @Override
    public String toString() {
        return TablaEquipo.format(equipo);
    }
    
    
}