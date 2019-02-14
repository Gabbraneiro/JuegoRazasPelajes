package com.zampegab.juegorazaspelajes;

public class Caballo {
    private String nombre,raza, pelaje,str_img, str_audio_pelaje, str_audio_raza, str_audio_raza_pelaje;

    public Caballo(String nombre, String raza, String pelaje, String str_img, String str_audio_pelaje, String str_audio_raza, String str_audio_raza_pelaje) {
        this.nombre = nombre;
        this.raza = raza;
        this.pelaje = pelaje;
        this.str_img = str_img;
        this.str_audio_pelaje = str_audio_pelaje;
        this.str_audio_raza = str_audio_raza;
        this.str_audio_raza_pelaje = str_audio_raza_pelaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getPelaje() {
        return pelaje;
    }

    public void setPelaje(String pelaje) {
        this.pelaje = pelaje;
    }

    public String getStr_img() {
        return str_img;
    }

    public void setStr_img(String str_img) {
        this.str_img = str_img;
    }

    public String getStr_audio_pelaje() {
        return str_audio_pelaje;
    }

    public void setStr_audio_pelaje(String str_audio_pelaje) {
        this.str_audio_pelaje = str_audio_pelaje;
    }

    public String getStr_audio_raza() {
        return str_audio_raza;
    }

    public void setStr_audio_raza(String str_audio_raza) {
        this.str_audio_raza = str_audio_raza;
    }

    public String getStr_audio_raza_pelaje() {
        return str_audio_raza_pelaje;
    }

    public void setStr_audio_raza_pelaje(String str_audio_raza_pelaje) {
        this.str_audio_raza_pelaje = str_audio_raza_pelaje;
    }
}
