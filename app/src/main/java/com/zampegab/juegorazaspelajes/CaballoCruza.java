package com.zampegab.juegorazaspelajes;

public class CaballoCruza {

    private int id, imgId, imgPadres;
    private String nombre, padre, madre;

    public CaballoCruza(int id, String nombre, int imgId, String padre, String madre, int imgPadres){
        this.id = id;
        this.nombre = nombre;
        this.imgId = imgId;
        this.padre = padre;
        this.madre = madre;
        this.imgPadres = imgPadres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public int getImgPadres() {
        return imgPadres;
    }

    public void setImgPadres(int imgPadres) {
        this.imgPadres = imgPadres;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPadre() {
        return padre;
    }

    public void setPadre(String padre) {
        this.padre = padre;
    }

    public String getMadre() {
        return madre;
    }

    public void setMadre(String madre) {
        this.madre = madre;
    }

}
