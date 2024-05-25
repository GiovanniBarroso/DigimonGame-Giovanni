package states;

import java.util.List;

public class TablaEquipo {

    public static String format(List<Digimon> equipo) {
        StringBuilder sb = new StringBuilder();
        sb.append("\nEquipo de Digimon:\n");

        // Encabezado de la tabla
        sb.append("+------------------+------------------+------------------+\n");
        sb.append("|     Digimon 1    |     Digimon 2    |     Digimon 3    |\n");
        sb.append("+------------------+------------------+------------------+\n");

        // Fila de nombres
        sb.append(crearFila(equipo, "Nombre", d -> d.getNombre()));

        // Fila de niveles
        sb.append(crearFila(equipo, "Nivel", d -> String.valueOf(d.getNivel())));

        // Fila de ataques
        sb.append(crearFila(equipo, "Ataque", d -> String.valueOf(d.getAtaque())));

        // Fila de salud
        sb.append(crearFila(equipo, "Salud", d -> String.valueOf(d.getSalud())));

        return sb.toString();
    }

    private static String crearFila(List<Digimon> equipo, String atributo, AtributoDigimon extractor) {
        StringBuilder fila = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            if (i < equipo.size()) {
                Digimon digimon = equipo.get(i);
                fila.append(String.format("| %-16s ", atributo + ": " + extractor.extraer(digimon)));
            } else {
                fila.append("|                  ");
            }
        }
        fila.append("|\n");
        fila.append("+------------------+------------------+------------------+\n");
        return fila.toString();
    }

    @FunctionalInterface
    private interface AtributoDigimon {
        String extraer(Digimon digimon);
    }
}
