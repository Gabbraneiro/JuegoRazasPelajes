package com.zampegab.juegorazaspelajes;

import java.util.ArrayList;

public class Repositorio {
    private static ArrayList<Caballo> caballos;

    private static ArrayList<Caballo> hardcodeCaballos(){
        ArrayList<Caballo> retorno = new ArrayList<Caballo>();
        retorno.add(new Caballo("angola","spc","zainocolorado","angola-spc-zainocolorado","raza-spc","pelaje-zaino_colorado","razaconpelaje-spc-zaina_colorada"));
        retorno.add(new Caballo("candelaria","mestizo","tobiano","candelaria-mestizo-tobiano","raza-mestizo","pelaje-tobiano","razaconpelaje-mestizo-tobiano"));
        retorno.add(new Caballo("ciro","mestizo","tordillo canela","candelaria-mestizo-tobiano","raza-mestizo","pelaje-tordiollo_canela","razaconpelaje-mestizo-tordillo_canela"));
        retorno.add(new Caballo("bionda","cruza arabe","alazan ruano","bionda_cruzarabe_alazan_ruano","notfound","pelaje-alazan_ruano","notfound"));
        retorno.add(new Caballo("bonita","mestizo criollo","overo azulejo","bonita_mestizo_criollo_overo_azulejo","raza-mestizo","pelaje-overo_azulejo","notfound"));
        retorno.add(new Caballo("huaflin","criollo","horespicaso","huaflin-criollo-horespicaso","raza-criollo","pelaje-picaso","notfound"));
        retorno.add(new Caballo("juana","cruza de milla","bayo","juana-cuartodemilla-bayo","raza-cuartodemilla","pelaje-bayo","razaconpelaje-cuartodemilla-bayo"));
        return retorno;
    }

    public static ArrayList<Caballo> getCaballos(){
        if(caballos == null){
            caballos = hardcodeCaballos();
        }
        return caballos;
    }

    public static ArrayList<Caballo> getCaballosRandom(int cantidad){
        ArrayList<Caballo> retorno = new ArrayList<Caballo>();
        int max = getCaballos().size() -1;
        for (int i = 0; i < cantidad; i++) {
            int random = (int)Math.random()*max +1;
            retorno.add(getCaballos().get(random));
        }
        return retorno;

    }
    public static Caballo findCaballoBy(String by, String str_filtro){
        Caballo caballo = null;
        switch (by){
            case "raza":
                caballo = findCaballoByRaza(str_filtro);
                break;
            case "pelaje":
                caballo = findCaballoByPelaje(str_filtro);
                break;
            case "raza_pelaje":
                caballo = findCaballoByRazaPelaje(str_filtro);
                break;
            case "str_img":
                caballo = findCaballoByStrImg(str_filtro);
            case "str_audio_pelaje":
                caballo = findCaballoByStrAudioPelaje(str_filtro);
                break;
            case "str_audio_raza":
                caballo = findCaballoByStrAudioRaza(str_filtro);
                break;
            case "str_audio_raza_pelaje":
                caballo = findCaballoByStrAudioRazaPelaje(str_filtro);
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

    private static Caballo findCaballoByStrImg(String str_img){
        Caballo caballo = null;
        for (Caballo c: getCaballos()) {
            if(c.getStr_img() == str_img){
                caballo = c;
            }
        }
        return caballo;
    }

    private static Caballo findCaballoByStrAudioPelaje(String str_audio_pelaje){
        Caballo caballo = null;
        for (Caballo c: getCaballos()) {
            if(c.getStr_audio_pelaje() == str_audio_pelaje){
                caballo = c;
            }
        }
        return caballo;
    }

    private static Caballo findCaballoByStrAudioRaza(String str_audio_raza){
        Caballo caballo = null;
        for (Caballo c: getCaballos()) {
            if(c.getStr_audio_raza() == str_audio_raza){
                caballo = c;
            }
        }
        return caballo;
    }

    private static Caballo findCaballoByStrAudioRazaPelaje(String str_audio_raza_pelaje){
        Caballo caballo = null;
        for (Caballo c: getCaballos()) {
            if(c.getStr_audio_raza_pelaje() == str_audio_raza_pelaje){
                caballo = c;
            }
        }
        return caballo;
    }
}
