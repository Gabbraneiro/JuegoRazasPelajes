package com.zampegab.juegorazaspelajes;

import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.media.SoundPool;


import java.util.List;

public class InteraccionCActivity  extends AppCompatActivity {

    private SoundPool  soundPool;
    private int sonido_raza, correcto_relincho, incorrecto_resoplido,cant_correctas, cant_rondas;
    private ImageButton btnRaza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        soundPool = new SoundPool(6, AudioManager.STREAM_MUSIC, 0);
        correcto_relincho = soundPool.load(this, R.raw.relincho, 1);
        incorrecto_resoplido = soundPool.load(this, R.raw.resoplido, 1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interaccion_c);

        jugarInteraccionC();

    }
    private void jugarInteraccionC(){
        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        int cantCaballos = MainActivity.getCantCaballos(sharedPreferences);
        final List<Caballo> caballos = Repositorio.getCaballosRandom(cantCaballos);
        final Caballo c = caballos.get((int) (Math.random() * (caballos.size() - 1)));
        ImageView caballo_correcto = findViewById(R.id.c_caballo_correcto);
        caballo_correcto.setImageResource(c.getImg());

        ImageView opcion1 = findViewById(R.id.c_opcion_2);
        opcion1.setImageResource(caballos.get(0).getImg());
        ImageView opcion2 = findViewById(R.id.c_opcion_3);
        opcion2.setImageResource(caballos.get(1).getImg());


        if (caballos.size() > 2) {
            ImageView opcion3 = findViewById(R.id.c_opcion_1);
            opcion3.setImageResource(caballos.get(2).getImg());
            ImageView opcion4 = findViewById(R.id.c_opcion_4);
            opcion4.setImageResource(caballos.get(3).getImg());
            opcion3.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    if(caballos.get(2).getRaza() == c.getRaza()){
                        //RESPUESTA CORRECTA.
                        cant_correctas++;
                        soundPool.play(correcto_relincho,1,1,0,0,1);
                    }
                    else{
                        //RESPUESTA INCORRECTA
                        soundPool.play(incorrecto_resoplido,1,1,0,0,1);
                    }
                    cant_rondas++;
                    checkContadores();
                }
            });
            opcion4.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    if(caballos.get(3).getRaza() == c.getRaza()){
                        //RESPUESTA CORRECTA.
                        cant_correctas++;
                        soundPool.play(correcto_relincho,1,1,0,0,1);
                    }
                    else{
                        //RESPUESTA INCORRECTA
                        soundPool.play(incorrecto_resoplido,1,1,0,0,1);
                    }
                    cant_rondas++;
                    checkContadores();
                }
            });
        }
        opcion1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(caballos.get(0).getRaza() == c.getRaza()){
                    //RESPUESTA CORRECTA.
                    cant_correctas++;
                    soundPool.play(correcto_relincho,1,1,0,0,1);
                }
                else{
                    //RESPUESTA INCORRECTA
                    soundPool.play(incorrecto_resoplido,1,1,0,0,1);
                }
                cant_rondas++;
                checkContadores();

            }
        });
        opcion2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(caballos.get(1).getRaza() == c.getRaza()){
                    //RESPUESTA CORRECTA.
                    cant_correctas++;
                    soundPool.play(correcto_relincho,1,1,0,0,1);
                }
                else{
                    //RESPUESTA INCORRECTA
                    soundPool.play(incorrecto_resoplido,1,1,0,0,1);
                }
                cant_rondas++;
                checkContadores();
            }
        });
    }
    private void copa(){
        ImageView iv = findViewById(R.id.copa);
        AnimationDrawable animationCopa = (AnimationDrawable)iv.getBackground();
        iv.setVisibility(View.VISIBLE);
        animationCopa.start();
    }

    @Override
    protected void onResume(){
        super.onResume();
        cant_correctas = 0; cant_rondas = 0;
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }
    private void checkContadores(){

        if(cant_rondas == 5){
            final ScrollView interaccionC = findViewById(R.id.scroll_C);
            final Button accion = findViewById(R.id.c_accion_nivel);
            final FrameLayout modal = findViewById(R.id.c_div_fin_nivel);
            if(cant_correctas >= 3){
                // SE DA LA OPCION DE PASAR AL SIGUIENTE MINIJUEGO
                copa();
                accion.setText("Volver al home");
                accion.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                modal.setVisibility(View.VISIBLE);
                accion.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v){
                        // ELIMINA LA ACTIVITY
                        finish();
                    }
                });

            }
            else{
                //SE DA LA OPCION DE VOLVER A JUGAR LA INTERACCION B
                accion.setText(R.string.retry);
                accion.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                modal.setVisibility(View.VISIBLE);
                accion.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v){
                        interaccionC.setVisibility(View.VISIBLE);
                        modal.setVisibility(View.GONE);
                        jugarInteraccionC();
                    }
                });
            }
            cant_correctas = 0; cant_rondas = 0;
            updateViewContadores();
            interaccionC.setVisibility(View.INVISIBLE);
        }
        else{
            updateViewContadores();
            jugarInteraccionC();
        }
    }

    private void updateViewContadores(){
        TextView correctas = findViewById(R.id.correctas2);
        correctas.setText("Correctas: "+cant_correctas);
        TextView ronda = findViewById(R.id.rondas);
        ronda.setText("Rondas: "+cant_rondas);
    }


}