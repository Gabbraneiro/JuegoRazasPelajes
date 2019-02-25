package com.zampegab.juegorazaspelajes;

public class Minijuego {

    private int actual = 1;
    private static Minijuego minijuego = null;

    public static Minijuego getMinijuego() {
        if (minijuego == null) {
            minijuego = new Minijuego();
        }
        return minijuego;
    }

    public int getActual() {
        return actual;
    }

    public void setActual(int actual) {
        this.actual = actual;
    }

}
