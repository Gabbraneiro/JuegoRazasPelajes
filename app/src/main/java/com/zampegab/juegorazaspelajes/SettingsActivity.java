package com.zampegab.juegorazaspelajes;

import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class SettingsActivity extends PreferenceActivity /*implements SharedPreferences.OnSharedPreferenceChangeListener*/ {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction().replace(android.R.id.content, new MyPreferenceFragment()).commit();

        /*final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        if(Minijuego.getMinijuego().getActual() != 3){
            Preference preference = findViewById("modo_interaccion");

            //sharedPreferences.
        }

    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if(key.equals())
    }*/
    }
}
