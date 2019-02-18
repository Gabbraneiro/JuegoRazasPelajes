package com.zampegab.juegorazaspelajes;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.List;

public class InteraccionAActivity extends AppCompatActivity {

    int audio_raza;
    SoundPool soundPool = new SoundPool(6, AudioManager.STREAM_MUSIC, 0);
    int incorrecto_resoplido = soundPool.load(this, R.raw.resoplido,1);
    int correcto_relincho = soundPool.load(this, R.raw.relincho,1);
    int cant_correctas, cant_rondas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cant_correctas = 0;
        cant_rondas = 0;
        setContentView(R.layout.activity_interaccion_a);
        jugarInteraccionA();
    }

    public void jugarInteraccionA(){

        final List<Caballo> caballos = Repositorio.getCaballosRandom((int) getIntent().getExtras().get("caballos"));
        final Caballo c = caballos.get((int) (Math.random() * (caballos.size() - 1)));
        ImageView raza = findViewById(R.id.a_raza);
        raza.setImageResource(c.getImg());

        // OPCION 1
        TextView opcion1 = findViewById(R.id.a_opcion_2);
        opcion1.setText(caballos.get(0).getRaza());
        opcion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarRespuesta(c, caballos.get(0));
            }
        });

        ImageButton audio_opcion1 = findViewById(R.id.b_opcion_2);
        audio_opcion1.setImageResource(caballos.get(0).getImg());
        audio_opcion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audio_raza = soundPool.load(InteraccionAActivity.this, caballos.get(0).getAudio_raza(), 1);
                soundPool.play(audio_raza, 1, 1, 0, 0, 1);
            }
        });

        //OPCION 2
        TextView opcion2 = findViewById(R.id.a_opcion_3);
        opcion2.setText(caballos.get(1).getRaza());
        opcion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarRespuesta(c, caballos.get(1));
            }
        });

        ImageButton audio_opcion2 = findViewById(R.id.b_opcion_3);
        audio_opcion2.setImageResource(caballos.get(1).getImg());
        audio_opcion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audio_raza = soundPool.load(InteraccionAActivity.this, caballos.get(1).getAudio_raza(), 1);
                soundPool.play(audio_raza, 1, 1, 0, 0, 1);
            }
        });

        // Nivel dificil
        if (caballos.size() > 2) {

            // OPCION 3
            TextView opcion3 = findViewById(R.id.a_opcion_1);
            opcion3.setText(caballos.get(2).getRaza());
            opcion3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    verificarRespuesta(c, caballos.get(2));
                }
            });

            ImageButton audio_opcion3 = findViewById(R.id.b_opcion_1);
            audio_opcion3.setImageResource(caballos.get(2).getImg());
            audio_opcion3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    audio_raza = soundPool.load(InteraccionAActivity.this, caballos.get(2).getAudio_raza(), 1);
                    soundPool.play(audio_raza, 1, 1, 0, 0, 1);
                }
            });

            //OPCION 4
            TextView opcion4 = findViewById(R.id.a_opcion_4);
            opcion4.setText(caballos.get(3).getRaza());
            opcion4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    verificarRespuesta(c, caballos.get(3));
                }
            });

            ImageButton audio_opcion4 = findViewById(R.id.b_opcion_4);
            audio_opcion4.setImageResource(caballos.get(3).getImg());
            audio_opcion4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    audio_raza = soundPool.load(InteraccionAActivity.this, caballos.get(3).getAudio_raza(), 1);
                    soundPool.play(audio_raza, 1, 1, 0, 0, 1);
                }
            });

        }
    }


    public void verificarRespuesta(Caballo caballo_correcto, Caballo caballo_seleccionado){
        if(caballo_correcto.getRaza().equals(caballo_seleccionado.getRaza())){
            // RESPUESTA CORRECTA
            soundPool.play(correcto_relincho,1,1,0,0,1);
            cant_correctas++;
        }
        else {
            // RESPUESTA INCORRECTA
            soundPool.play(incorrecto_resoplido,1,1,0,0,1);
        }
        cant_rondas++;
        updateViewContadores();

    }

    private void updateViewContadores(){
        TextView correctas = findViewById(R.id.correctas2);
        correctas.setText("Correctas: "+cant_correctas);
        TextView ronda = findViewById(R.id.rondas);
        ronda.setText("Rondas: "+cant_rondas);
    }

    @Override
    protected void onResume(){
        super.onResume();
        cant_correctas = 0; cant_rondas = 0;
    }

    public void verificar_rondas(){
        if(cant_rondas == 5) {
            final ScrollView interaccionA = findViewById(R.id.scroll_A);
            final Button accion = findViewById(R.id.a_accion_nivel);
            final FrameLayout modal = findViewById(R.id.a_div_fin_nivel);
            if (cant_correctas >=3 ){
                // SE DA LA OPCION DE PASAR AL SIGUIENTE MINIJUEGO
                confeti();
                accion.setText(R.string.to_next);
                accion.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                modal.setVisibility(View.VISIBLE);
                accion.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v){
                        jugarInteraccionB();
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
                        interaccionA.setVisibility(View.VISIBLE);
                        modal.setVisibility(View.GONE);
                        jugarInteraccionA();
                    }
                });
            }
            cant_correctas = 0; cant_rondas = 0;
            updateViewContadores();
            interaccionA.setVisibility(View.INVISIBLE);
        }
        else{
            updateViewContadores();
            jugarInteraccionA();
        }
    }

    private void confeti(){
        ImageView iv = findViewById(R.id.a_confeti);
        AnimationDrawable animationConfeti = (AnimationDrawable)iv.getBackground();
        iv.setVisibility(View.VISIBLE);
        animationConfeti.start();
    }

    private void jugarInteraccionB(){
        Intent i = new Intent(InteraccionAActivity.this, InteraccionBActivity.class);
        startActivity(i);
    }
}