package com.zampegab.juegorazaspelajes;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

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

    public Intent nextLevel(int lvl, Activity contexto_previo, SharedPreferences sharedPreferences){
        String pref_interaccion = sharedPreferences.getString("modo_interaccion", "A");
        setActual(lvl);
        Intent intent = null;
        if(lvl == 3){
            return new Intent(contexto_previo, InteraccionCActivity.class);
        }
        switch (pref_interaccion){
            case "A":
                if(lvl == 1){
                    int random = 1;
                    //random = (int) (Math.random() * 2);
                    if(random == 1){
                        return new Intent(contexto_previo, InteraccionAActivity.class);
                    }
                    else{
                        return new Intent(contexto_previo, InteraccionA1PelajesActivity.class);
                    }
                }
                else if(lvl == 2){
                    return new Intent(contexto_previo, InteraccionARazaPelajeActivity.class);
                }
                break;

            case "B":
                if(lvl == 1){
                    int random = 1;
                    //random = (int) (Math.random() * 2);
                    if(random == 1){
                        return new Intent(contexto_previo, InteraccionBActivity.class);
                    }
                    else{
                        return new Intent(contexto_previo, InteraccionBPelajeActivity.class);
                    }
                }
                else if(lvl == 2){
                    return  new Intent(contexto_previo, InteraccionBRazaPelajeActivity.class);
                }
                break;
        }
        if(lvl == 3){
            return new Intent(contexto_previo, InteraccionCActivity.class);
        }
        return null;
    }
}
