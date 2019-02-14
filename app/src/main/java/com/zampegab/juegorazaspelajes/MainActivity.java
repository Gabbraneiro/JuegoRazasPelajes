package com.zampegab.juegorazaspelajes;

import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ImageButton btn_config;
    ImageButton btn_jugar;
    ImageButton btn_reconocimiento;

    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_config = findViewById(R.id.btn_conf);
        btn_reconocimiento = findViewById(R.id.btn_reconocimiento);
        btn_jugar = findViewById(R.id.btn_jugar);

        btn_config.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        btn_reconocimiento.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getModoReconocimiento() == "lista") {
                    Intent intent = new Intent(MainActivity.this, ListaActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(MainActivity.this, GrillaActivity.class);
                    startActivity(intent);
                }
            }
        });

        btn_jugar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Caballo> caballos = Repositorio.getCaballosRandom(getCantCaballos());
                HashMap modo_juego = getModoJuego();
                if(modo_juego.get("interaccion") == "A"){
                    Intent intent = new Intent(MainActivity.this, InteraccionAActivity.class);
                    intent.putExtra("nivel", "1");
                    startActivity(intent);
                }
                else if (modo_juego.get("interaccion") == "B"){
                    Intent intent = new Intent(MainActivity.this, InteraccionBActivity.class);
                    intent.putExtra("nivel", "2");
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(MainActivity.this, InteraccionCActivity.class);
                    intent.putExtra("nivel", "3");
                    startActivity(intent);
                }
            }
        });
    }

    public Integer getCantCaballos() {
        String pref_nivel = sharedPreferences.getString("nivel", "1");
        if (pref_nivel == "1") {
            return 2;
        } else {
            return 4;
        }
    }

    public String getModoReconocimiento() {
        String pref_nivel = sharedPreferences.getString("modo_reconocimiento", "1");
        if (pref_nivel == "1") {
            return "lista";
        } else {
            return "grilla";
        }
    }

    public HashMap getModoJuego() {
        HashMap<String,String> juego = new HashMap<String,String>();
        String pref_interaccion = sharedPreferences.getString("modo_interaccion", "A");
        String pref_minijuego = sharedPreferences.getString("minijuego", "1");
        juego.put("interaccion", pref_interaccion);
        juego.put("minijuego", pref_minijuego);
        return juego;
    }

}



