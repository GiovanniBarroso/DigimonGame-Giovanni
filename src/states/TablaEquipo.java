package states;

import java.util.List;

/**
 * Clase que representa una tabla con el equipo de Digimones.
 */
public class TablaEquipo {

    /**
     * Formatea el equipo de Digimones en una representación en tabla.
     * 
     * @param equipo La lista de Digimones a formatear.
     * @return Devuelve un string con la representación en tabla del equipo.
     */
    public static String format(List<Digimon> equipo) {

        StringBuilder cadenaConstruida = new StringBuilder();
        String[][] tabla = new String[6][3];

        // Rellenar la tabla con datos de los Digimon
        for (int i = 0; i < 3; i++) {
            if (i < equipo.size()) {
                Digimon digimon = equipo.get(i);
                tabla[0][i] = digimon.getNombre();
                tabla[1][i] = "Nivel: " + digimon.getNivel();
                tabla[2][i] = "Ataque: " + digimon.getAtaque();
                tabla[3][i] = "Salud: " + digimon.getSalud();
                tabla[4][i] = "DP 1: " + digimon.getDp1();
                tabla[5][i] = "DP 2: " + digimon.getDp2();
            } else {
                tabla[0][i] = "";
                tabla[1][i] = "";
                tabla[2][i] = "";
                tabla[3][i] = "";
                tabla[4][i] = "";
                tabla[5][i] = "";
            }
        }

        cadenaConstruida.append("\nEquipo de Digimon:\n");
        cadenaConstruida.append("+------------------+------------------+------------------+\n");
        cadenaConstruida.append("|     Digimon 1    |     Digimon 2    |     Digimon 3    |\n");
        cadenaConstruida.append("+------------------+------------------+------------------+\n");

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                cadenaConstruida.append(String.format("| %-16s ", tabla[i][j]));
            }

            cadenaConstruida.append("|\n");
            cadenaConstruida.append("+------------------+------------------+------------------+\n");
        }

        return cadenaConstruida.toString();
    }
}
