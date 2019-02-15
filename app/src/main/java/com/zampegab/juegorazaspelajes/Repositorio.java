package com.zampegab.juegorazaspelajes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Repositorio {
    private static List<Caballo> caballos;

    private static List<Caballo> hardcodeCaballos(){
        List<Caballo> retorno = new ArrayList<Caballo>();
        retorno.add(new Caballo("angola","spc","zainocolorado",R.drawable.angola_spc_zainocolorado,R.raw.raza_spc,R.raw.pelaje_zaino,R.raw.razaconpelaje_spc_zaina_colorada, ""));
        retorno.add(new Caballo("candelaria","mestizo","tobiano",R.drawable.candelaria_mestizo_tobiano,R.raw.raza_mestizo,R.raw.pelaje_tobiano,R.raw.razaconpelaje_mestizo_tobiano,""));
        retorno.add(new Caballo("ciro","mestizo","tordillo canela",R.drawable.ciro_mestizo_tordillocanela,R.raw.raza_mestizo,R.raw.pelaje_tordiollo_canela,R.raw.razaconpelaje_mestizo_tordillo_canela,""));
        retorno.add(new Caballo("bionda","cruza arabe","alazan ruano",R.drawable.bionda_cruzaarabe_alazanruano,-1,R.raw.pelaje_alazan_ruano,-1,""));
        retorno.add(new Caballo("bonita","mestizo criollo","overo azulejo",R.drawable.bonita_mestizo_criollo_overo_azulejo,R.raw.raza_mestizo,R.raw.pelaje_overo_azulejo,-1,""));
        retorno.add(new Caballo("huaflin","criollo","horespicaso",R.drawable.huaflin_criollo_horespicaso,R.raw.raza_criollo,R.raw.pelaje_picaso,-1,""));
        retorno.add(new Caballo("juana","cruza de milla","bayo",R.drawable.juana_cuartodemilla_bayo,R.raw.raza_cuartodemilla,R.raw.pelaje_bayo,R.raw.razaconpelaje_cuartodemilla_bayo,""));
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
        List<Caballo> retorno = new ArrayList<Caballo>();
        int max = getCaballos().size() -1;
        for (int i = 0; i < cantidad; i++) {
            int random = (int)Math.random()*max +1;
            retorno.add(var_caballos.get(random));
            var_caballos.remove(random);
            max--;
        }
        return retorno;

    }
    public static Caballo findCaballoBy(String by, Object str_filtro){
        Caballo caballo = null;
        switch (by){
            case "raza":
                caballo = findCaballoByRaza((String)str_filtro);
                break;
            case "pelaje":
                caballo = findCaballoByPelaje((String)str_filtro);
                break;
            case "raza_pelaje":
                caballo = findCaballoByRazaPelaje((String)str_filtro);
                break;
            case "str_img":
                caballo = findCaballoByimg((int)str_filtro);
            case "str_audio_pelaje":
                caballo = findCaballoByStrAudioPelaje((int)str_filtro);
                break;
            case "str_audio_raza":
                caballo = findCaballoByStrAudioRaza((int)str_filtro);
                break;
            case "str_audio_raza_pelaje":
                caballo = findCaballoByStrAudioRazaPelaje((int)str_filtro);
                break;



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
