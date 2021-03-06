package com.zampegab.juegorazaspelajes;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton btn_conf;
    ImageButton btn_jugar;
    ImageButton btn_reconocimiento;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        btn_conf = findViewById(R.id.btn_conf);
        btn_reconocimiento = findViewById(R.id.btn_reconocimiento);
        btn_jugar = findViewById(R.id.btn_jugar);

        btn_conf.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton imagen = findViewById(R.id.btn_conf);
                imagen.setImageResource(R.drawable.config_click);

                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
                imagen.setImageResource(R.drawable.config_click);
            }
        });

        btn_reconocimiento.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton imagen = findViewById(R.id.btn_reconocimiento);
                imagen.setImageResource(R.drawable.reconocimiento_click);
               // new CuadroDialogo(context, 1, "correcta", 1);
                String pref_reconocimiento = sharedPreferences.getString("modo_reconocimiento", "1");
                String tipo_reconocimiento = sharedPreferences.getString("tipo_reconocimiento", "1");
                Intent intent = null;
                if (pref_reconocimiento.equals("1")) {

                    if(tipo_reconocimiento.equals("1")){
                        intent = new Intent(MainActivity.this, ListaActivity.class);
                    }
                    else if(tipo_reconocimiento.equals("2")){
                        intent = new Intent(MainActivity.this, ListaPelajeActivity.class);
                    }
                    else{
                        intent = new Intent(MainActivity.this, ListaCruzaActivity.class);
                    }
                    startActivity(intent);
                } else {
                    if(tipo_reconocimiento.equals("1")){
                        intent = new Intent(MainActivity.this, GrillaActivity.class);
                    }
                    else if(tipo_reconocimiento.equals("2")){
                        intent = new Intent(MainActivity.this, GrillaPelajeActivity.class);
                    }
                    else{
                        intent = new Intent(MainActivity.this, ListaCruzaActivity.class);
                    }
                    startActivity(intent);
                }
                imagen.setImageResource(R.drawable.reconocimiento_regular);
            }
        });

        btn_jugar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton imagen = findViewById(R.id.btn_jugar);
                imagen.setImageResource(R.drawable.jugar_click);
                String pref_interaccion = sharedPreferences.getString("modo_interaccion", "A");
                Minijuego minijuego = Minijuego.getMinijuego();
                Intent intent = null;
                if(minijuego.getActual() == 3){
                    intent = new Intent(MainActivity.this, InteraccionCActivity.class);
                    startActivity(intent);
                }
                switch (pref_interaccion){
                    case "A":
                        if(minijuego.getActual() == 1){
                            int random = 1;
                            random = (int) (Math.random() * 2);
                            if(random == 1){
                                intent = new Intent(MainActivity.this, InteraccionAActivity.class);
                            }
                            else{
                                intent = new Intent(MainActivity.this, InteraccionA1PelajesActivity.class);
                            }
                        }
                        else if(minijuego.getActual() == 2){
                            intent = new Intent(MainActivity.this, InteraccionARazaPelajeActivity.class);
                        }
                        break;

                    case "B":
                        if(minijuego.getActual() == 1){
                            int random = 1;
                            random = (int) (Math.random() * 2);
                            if(random == 1){
                                intent = new Intent(MainActivity.this, InteraccionBActivity.class);
                            }
                            else{
                                intent = new Intent(MainActivity.this, InteraccionBPelajeActivity.class);
                            }
                        }
                        else if(minijuego.getActual() == 2){
                            intent = new Intent(MainActivity.this, InteraccionBRazaPelajeActivity.class);
                        }
                        break;
                    case "C":
                        intent = new Intent(MainActivity.this, InteraccionCActivity.class);
                        break;
                }

                //intent.putExtra("caballos", getCantCaballos(sharedPreferences));
                startActivity(intent);
                imagen.setImageResource(R.drawable.jugar_regular);
            }
        });
    }

    public static Integer getCantCaballos(SharedPreferences sharedPreferences) {
        String pref_nivel = sharedPreferences.getString("nivel", "1");
        if (pref_nivel.equals("1")) {
            return 2;
        } else {
            return 4;
        }
    }

}



