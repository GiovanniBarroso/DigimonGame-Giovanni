package states;

import java.util.Random;

/**
 * Clase que representa un Digimon en el juego.
 */
public class Digimon {

    private String nombre;
    private int nivel;
    private int ataque;
    private int salud;
    private int dp1;
    private int dp2;

    /**
     * Constructor para inicializar un Digimon con un nombre y atributos aleatorios.
     * 
     * @param nombre El nombre del Digimon.
     */
    public Digimon(String nombre) {
        this.nombre = nombre;
        Random rand = new Random();
        this.nivel = rand.nextInt(5) + 1;
        this.ataque = 5 * nivel;
        this.salud = 10 * nivel;
        this.dp1 = 10;
        this.dp2 = 10;
    }

    /**
     * Obtiene el nombre del Digimon.
     * 
     * @return El nombre del Digimon.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el nivel del Digimon.
     * 
     * @return El nivel del Digimon.
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Obtiene el ataque del Digimon.
     * 
     * @return El ataque del Digimon.
     */
    public int getAtaque() {
        return ataque;
    }

    /**
     * Obtiene la salud del Digimon.
     * 
     * @return La salud del Digimon.
     */
    public int getSalud() {
        return salud;
    }

    /**
     * Establece la salud del Digimon.
     * 
     * @param salud La nueva salud del Digimon.
     */
    public void setSalud(int salud) {
        this.salud = salud;
    }

    /**
     * Obtiene los puntos de poder del primer ataque del Digimon.
     * 
     * @return Los puntos de poder del primer ataque.
     */
    public int getDp1() {
        return dp1;
    }

    /**
     * Obtiene los puntos de poder del segundo ataque del Digimon.
     * 
     * @return Los puntos de poder del segundo ataque.
     */
    public int getDp2() {
        return dp2;
    }

    /**
     * Realiza el primer ataque del Digimon sobre un Digimon enemigo.
     * Disminuye la salud del enemigo en función del ataque y reduce el DP1 del Digimon.
     * 
     * @param enemigo El Digimon enemigo.
     */
    public void ataque1(Digimon enemigo) {
        if (dp1 > 0) {
            enemigo.salud -= this.ataque;
            this.dp1--;
        }
    }

    /**
     * Realiza el segundo ataque del Digimon sobre un Digimon enemigo.
     * Disminuye la salud del enemigo en el doble del ataque y reduce el DP2 del Digimon en 2.
     * 
     * @param enemigo El Digimon enemigo.
     */
    public void ataque2(Digimon enemigo) {
        if (dp2 > 1) {
            enemigo.salud -= 2 * this.ataque;
            this.dp2 -= 2;
        }
    }

    /**
     * Devuelve una representación en cadena de los atributos del Digimon.
     * 
     * @return Devuelve un string que representa los datos del Digimon.
     */
    @Override
    public String toString() {
        return "\nDigimon:\n" +
                "Nombre: " + nombre + '\n' +
                "Nivel: " + nivel + '\n' +
                "Ataque: " + ataque + '\n' +
                "Salud: " + salud + '\n' +
                "DP 1: " + dp1 + '\n' +
                "DP 2: " + dp2 + '\n';
    }
}
