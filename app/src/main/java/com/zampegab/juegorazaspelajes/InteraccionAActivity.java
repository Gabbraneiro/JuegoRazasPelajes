package com.zampegab.juegorazaspelajes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.media.SoundPool;
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

import java.util.List;

public class InteraccionAActivity extends AppCompatActivity {

    private SoundPool soundPool;
    private int audio_raza, cant_correctas, cant_rondas, incorrecto_resoplido, correcto_relincho;
    ImageButton btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        cant_correctas = 0;
        cant_rondas = 0;
        soundPool = new SoundPool(6, AudioManager.STREAM_MUSIC, 0);
        incorrecto_resoplido = soundPool.load(this, R.raw.resoplido,1);
        correcto_relincho = soundPool.load(this, R.raw.relincho,1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interaccion_a);
        jugarMinijuegoUno();
    }

    public void jugarMinijuegoUno(){
        final List<Caballo> caballos = Repositorio.getCaballosRandom((int) getIntent().getExtras().get("caballos"));
        final Caballo c = caballos.get((int) (Math.random() * (caballos.size() - 1)));
        ImageView caballo_correcto = findViewById(R.id.a_caballo_correcto);
        caballo_correcto.setImageResource(c.getImg());

        // OPCION 1
        TextView opcion1 = findViewById(R.id.opcion2);
        opcion1.setText(caballos.get(0).getRaza());
        opcion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarRespuesta(c, caballos.get(0));
            }
        });

        ImageButton audio_opcion1 = findViewById(R.id.b_opcion_2);
        audio_opcion1.setImageResource(R.drawable.audio_regular);
        audio_opcion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sonido = soundPool.load(InteraccionAActivity.this, caballos.get(0).getAudio_raza(), 1);
                soundPool.play(sonido, 1, 1, 0, 0, 1);
            }
        });

        //OPCION 2
        TextView opcion2 = findViewById(R.id.opcion3);
        opcion2.setText(caballos.get(1).getRaza());
        opcion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarRespuesta(c, caballos.get(1));
            }
        });

        ImageButton audio_opcion2 = findViewById(R.id.b_opcion_3);
        audio_opcion2.setImageResource(R.drawable.audio_regular);
        audio_opcion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sonido = soundPool.load(InteraccionAActivity.this, caballos.get(1).getAudio_raza(), 1);
                soundPool.play(sonido, 1, 1, 0, 0, 1);
            }
        });

        // Nivel dificil
        if (caballos.size() > 2) {

            // OPCION 3
            TextView opcion3 = findViewById(R.id.opcion1);
            opcion3.setText(caballos.get(2).getRaza());
            opcion3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    verificarRespuesta(c, caballos.get(2));
                }
            });

            ImageButton audio_opcion3 = findViewById(R.id.b_opcion_1);
            audio_opcion3.setImageResource(R.drawable.audio_regular);
            audio_opcion3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int sonido = soundPool.load(InteraccionAActivity.this, caballos.get(2).getAudio_raza(), 1);
                    soundPool.play(sonido, 1, 1, 0, 0, 1);
                }
            });

            //OPCION 4
            TextView opcion4 = findViewById(R.id.opcion4);
            opcion4.setText(caballos.get(3).getRaza());
            opcion4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    verificarRespuesta(c, caballos.get(3));
                }
            });

            ImageButton audio_opcion4 = findViewById(R.id.b_opcion_4);
            audio_opcion4.setImageResource(R.drawable.audio_regular);
            audio_opcion4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int sonido = soundPool.load(InteraccionAActivity.this, caballos.get(3).getAudio_raza(), 1);
                    soundPool.play(sonido, 1, 1, 0, 0, 1);
                }
            });
        }
        else{
            FrameLayout opcion3 = findViewById(R.id.o1);
            FrameLayout opcion4 = findViewById(R.id.o4);
            opcion3.setVisibility(View.INVISIBLE);
            opcion4.setVisibility(View.INVISIBLE);
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
        verificar_rondas();
    }

    private void updateViewContadores(){
        TextView correctas = findViewById(R.id.a_correctas2);
        correctas.setText("Correctas: "+cant_correctas);
        TextView ronda = findViewById(R.id.a_rondas);
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
                        jugarMinijuegoDos();
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
                        jugarMinijuegoUno();
                    }
                });
            }
            cant_correctas = 0; cant_rondas = 0;
            updateViewContadores();
            interaccionA.setVisibility(View.INVISIBLE);
        }
        else{
            updateViewContadores();
            jugarMinijuegoUno();
        }
    }

    private void confeti(){
        ImageView iv = findViewById(R.id.a_confeti);
        AnimationDrawable animationConfeti = (AnimationDrawable)iv.getBackground();
        iv.setVisibility(View.VISIBLE);
        animationConfeti.start();
    }

    private void jugarMinijuegoDos(){
        /*final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String pref_nivel = sharedPreferences.getString("nivel", "1");
        int cant_caballos;
        if (pref_nivel.equals("1")) {
            cant_caballos = 2;
        } else {
            cant_caballos = 4;
        }*/
        Intent i = new Intent(InteraccionAActivity.this, InteraccionARazaPelajeActivity.class);
        i.putExtra("caballos", (int) getIntent().getExtras().get("caballos"));
        startActivity(i);
        finish();
    }
}