package com.zampegab.juegorazaspelajes;

import android.content.Intent;
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
    private int correcto_relincho, incorrecto_resoplido,cant_correctas, cant_rondas;

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
        final List<CaballoCruza> caballos = Repositorio.getCaballosCruzaRandom(cantCaballos);
        final CaballoCruza c = caballos.get((int) (Math.random() * (caballos.size() - 1)));
        ImageView caballo_correcto = findViewById(R.id.c_caballo_correcto);
        caballo_correcto.setImageResource(c.getImgPadres());

        ImageView opcion1 = findViewById(R.id.c_opcion_2);
        opcion1.setImageResource(caballos.get(0).getImgId());
        ImageView opcion2 = findViewById(R.id.c_opcion_3);
        opcion2.setImageResource(caballos.get(1).getImgId());


        if (caballos.size() > 2) {
            ImageView opcion3 = findViewById(R.id.c_opcion_1);
            opcion3.setImageResource(caballos.get(2).getImgId());
            ImageView opcion4 = findViewById(R.id.c_opcion_4);
            opcion4.setImageResource(caballos.get(3).getImgId());
            opcion3.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    if(caballos.get(2).getImgPadres() == c.getImgPadres()){
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
                    if(caballos.get(3).getImgPadres() == c.getImgPadres()){
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
                if(caballos.get(0).getImgPadres() == c.getImgPadres()){
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
                if(caballos.get(1).getImgPadres() == c.getImgPadres()){
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
        //AnimationDrawable animationCopa = (AnimationDrawable)iv.getBackground();
        iv.setVisibility(View.VISIBLE);
        //animationCopa.start();
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
                // SE DA LA OPCION DE VOLVER AL MAIN
                Minijuego.getMinijuego().setActual(1);
                copa();
                accion.setText("Volver al inicio");
                accion.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                modal.setVisibility(View.VISIBLE);
                accion.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v){
                        modal.setVisibility(View.GONE);
                        Intent intent = new Intent(InteraccionCActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });

            }
            else{
                //SE DA LA OPCION DE VOLVER A JUGAR LA INTERACCION C
                accion.setText(R.string.retry);
                accion.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                modal.setVisibility(View.VISIBLE);
                accion.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v){
                        modal.setVisibility(View.GONE);
                        interaccionC.setVisibility(View.VISIBLE);
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
        TextView correctas = findViewById(R.id.c_correctas2);
        correctas.setText("Correctas: "+cant_correctas);
        TextView ronda = findViewById(R.id.c_rondas);
        ronda.setText("Rondas: "+cant_rondas);
    }


}