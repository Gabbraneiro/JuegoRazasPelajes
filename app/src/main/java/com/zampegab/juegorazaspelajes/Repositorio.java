package com.zampegab.juegorazaspelajes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Repositorio {
    private static List<Caballo> caballos;

    private static List<Caballo> hardcodeCaballos(){
        List<Caballo> retorno = new ArrayList<>();
        retorno.add(new Caballo(1,"angola","spc","zainocolorado",R.drawable.angola_spc_zainocolorado,R.raw.pelaje_zaino,R.raw.raza_spc,R.raw.razaconpelaje_spc_zaina_colorada, ""));
        retorno.add(new Caballo(2,"candelaria","mestizo","tobiano",R.drawable.candelaria_mestizo_tobiano,R.raw.pelaje_tobiano,R.raw.raza_mestizo,R.raw.razaconpelaje_mestizo_tobiano,""));
        retorno.add(new Caballo(3,"ciro","mestizo","tordillo canela",R.drawable.ciro_mestizo_tordillocanela,R.raw.pelaje_tordiollo_canela,R.raw.raza_mestizo,R.raw.razaconpelaje_mestizo_tordillo_canela,""));
        //xretorno.add(new Caballo(4,"bionda","cruza arabe","alazan ruano",R.drawable.bionda_cruzaarabe_alazanruano,R.raw.pelaje_alazan_ruano,-1 ,-1,""));
        retorno.add(new Caballo(5,"bonita","mestizo criollo","overo azulejo",R.drawable.bonita_mestizo_criollo_overo_azulejo,R.raw.pelaje_overo_azulejo,R.raw.raza_mestizo,-1,""));
        retorno.add(new Caballo(6,"huaflin","criollo","horespicaso",R.drawable.huaflin_criollo_horespicaso,R.raw.pelaje_picaso,R.raw.raza_criollo,-1,""));
        retorno.add(new Caballo(7,"juana","cuarto    de milla","bayo",R.drawable.juana_cuartodemilla_bayo,R.raw.pelaje_bayo,R.raw.raza_cuartodemilla,R.raw.razaconpelaje_cuartodemilla_bayo,""));
        return retorno;
    }
    public static List<Caballo> getCaballos(){
        if(caballos == null){
            caballos = hardcodeCaballos();
        }
        Collections.shuffle(caballos);
        return caballos;
    }

    public static List<Caballo> getCaballosRandom(int cantidad){
        List<Caballo> var_caballos = getCaballos();
        List<Caballo> retorno = new ArrayList<>();
        int max = getCaballos().size() -1;
        for (int i = 0; i < cantidad; i++) {
            int random = (int)(Math.random()*max);
            retorno.add(var_caballos.get(random));
            var_caballos.remove(random);
            max--;
        }
        caballos = null;
        return retorno;

    }
    public static Caballo findCaballoBy(String by, Object str_filtro){
        Caballo caballo = null;
        switch (by){
            case "raza":
                return findCaballoByRaza((String)str_filtro);
            case "pelaje":
                return findCaballoByPelaje((String)str_filtro);
            case "raza_pelaje":
                return findCaballoByRazaPelaje((String)str_filtro);
            case "str_img":
                return findCaballoByimg((int)str_filtro);
            case "str_audio_pelaje":
                return findCaballoByStrAudioPelaje((int)str_filtro);
            case "str_audio_raza":
                return findCaballoByStrAudioRaza((int)str_filtro);
            case "str_audio_raza_pelaje":
                return findCaballoByStrAudioRazaPelaje((int)str_filtro);
        }
        return caballo;
    }

    private static Caballo findCaballoByRaza(String raza){
        Caballo caballo = null;
        for (Caballo c: getCaballos()) {
            if(c.getRaza() == raza){
                caballo = c;
            }
        }
        return caballo;
    }

    private static Caballo findCaballoByPelaje(String pelaje){
        Caballo caballo = null;
        for (Caballo c: getCaballos()) {
            if(c.getPelaje() == pelaje){
                caballo = c;
            }
        }
        return caballo;
    }

    private static Caballo findCaballoByRazaPelaje(String razapelaje){
        Caballo caballo = null;
        for (Caballo c: getCaballos()) {
            if(c.getRaza()+c.getPelaje() == razapelaje){
                caballo = c;
            }
        }
        return caballo;
    }

    private static Caballo findCaballoByimg(int img){
        Caballo caballo = null;
        for (Caballo c: getCaballos()) {
            if(c.getImg() == img){
                caballo = c;
            }
        }
        return caballo;
    }

    private static Caballo findCaballoByStrAudioPelaje(int audio_pelaje){
        Caballo caballo = null;
        for (Caballo c: getCaballos()) {
            if(c.getAudio_pelaje() == audio_pelaje){
                caballo = c;
            }
        }
        return caballo;
    }

    private static Caballo findCaballoByStrAudioRaza(int audio_raza){
        Caballo caballo = null;
        for (Caballo c: getCaballos()) {
            if(c.getAudio_raza() == audio_raza){
                caballo = c;
            }
        }
        return caballo;
    }

    private static Caballo findCaballoByStrAudioRazaPelaje(int audio_raza_pelaje){
        Caballo caballo = null;
        for (Caballo c: getCaballos()) {
            if(c.getAudio_raza_pelaje() == audio_raza_pelaje){
                caballo = c;
            }
        }
        return caballo;
    }


}
