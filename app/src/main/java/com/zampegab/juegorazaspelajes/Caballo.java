package com.zampegab.juegorazaspelajes;

import java.io.Serializable;

public class Caballo implements Serializable {
    private String nombre,raza,pelaje,descripcion;
    private int id, img, audio_pelaje, audio_raza, audio_raza_pelaje;


    public Caballo(int id,String nombre, String raza, String pelaje, int img, int audio_pelaje, int audio_raza, int audio_raza_pelaje, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.pelaje = pelaje;
        this.img = img;
        this.audio_pelaje = audio_pelaje;
        this.audio_raza = audio_raza;
        this.audio_raza_pelaje = audio_raza_pelaje;
        this.descripcion = descripcion;

    }

    public int getId() {
        return id;
    }


    public String getRaza() {
        return raza;
    }


    public String getPelaje() {
        return pelaje;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public int getImg() {
        return img;
    }


    public int getAudio_pelaje(String g) {
        if (g.equals("f")) {
            return audio_pelaje;
        }
        return audio_pelaje;
    }


    public int getAudio_raza(String g) {
        if (g.equals("f")) {
            return audio_raza;
        }
        return audio_raza;
    }


    public int getAudio_raza_pelaje(String g) {
        if(g.equals("f")){
            return audio_raza_pelaje;
        }
        return audio_raza_pelaje;
    }

}
