package states;

import java.util.Random;

public class Digimon {
    private String nombre;
    private int nivel;
    private int ataque;
    private int salud;
    private int dp1;
    private int dp2;

    public Digimon(String nombre) {
        this.nombre = nombre;
        Random rand = new Random();
        this.nivel = rand.nextInt(5) + 1; 
        this.ataque = 5 * nivel;
        this.salud = 10 * nivel;
        this.dp1 = 10;
        this.dp2 = 10;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getDp1() {
        return dp1;
    }

    public int getDp2() {
        return dp2;
    }

    public void ataque1(Digimon enemigo) {
        if (dp1 > 0) {
            enemigo.salud -= this.ataque;
            this.dp1--;
        }
    }

    public void ataque2(Digimon enemigo) {
        if (dp2 > 1) {
            enemigo.salud -= 2 * this.ataque;
            this.dp2 -= 2;
        }
    }

    @Override
    public String toString() {
        return "Digimon:\n" +
                "Nombre: " + nombre + '\n' +
                "Nivel: " + nivel + '\n' +
                "Ataque: " + ataque + '\n' +
                "Salud: " + salud + '\n' +
                "Ataque1: " + dp1 + '\n' +
                "Ataque2: " + dp2 + '\n';
    }
}
