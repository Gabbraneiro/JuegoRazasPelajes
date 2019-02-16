package com.zampegab.juegorazaspelajes;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class InteraccionAActivity extends AppCompatActivity {

    int audio_raza;
    SoundPool soundPool = new SoundPool(6, AudioManager.STREAM_MUSIC, 0);
    int cant_correctas, cant_rondas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cant_correctas = 0;
        cant_rondas = 0;
        setContentView(R.layout.activity_interaccion_a);
        juegoInteraccionA();
    }

    public void juegoInteraccionA(){

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
                verificarRespuesta(c, caballos.get(2));
            }
        });

        ImageButton audio_opcion1 = findViewById(R.id.b_opcion_2);
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
                verificarRespuesta(c, caballos.get(0));
            }
        });

        ImageButton audio_opcion2 = findViewById(R.id.b_opcion_3);
        audio_opcion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audio_raza = soundPool.load(InteraccionAActivity.this, caballos.get(0).getAudio_raza(), 1);
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
                    verificarRespuesta(c, caballos.get(1));
                }
            });

            ImageButton audio_opcion3 = findViewById(R.id.b_opcion_1);
            audio_opcion3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    audio_raza = soundPool.load(InteraccionAActivity.this, caballos.get(0).getAudio_raza(), 1);
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
            audio_opcion4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    audio_raza = soundPool.load(InteraccionAActivity.this, caballos.get(0).getAudio_raza(), 1);
                    soundPool.play(audio_raza, 1, 1, 0, 0, 1);
                }
            });

        }
    }


    public void verificarRespuesta(Caballo caballo_correcto, Caballo caballo_seleccionado){
        int audio_respuesta;
        if(caballo_correcto.getRaza().equals(caballo_seleccionado.getRaza())){
            // RESPUESTA CORRECTA
            audio_respuesta = soundPool.load(this, R.raw.relincho,1);
            cant_correctas++;
        }
        else {
            // RESPUESTA INCORRECTA
            audio_respuesta = soundPool.load(this, R.raw.resoplido,1);
        }
        soundPool.play(audio_respuesta,1,1,0,0,1);
        cant_rondas++;
        if(cant_rondas < 5) {
            juegoInteraccionA();
        }
        else{
            if (cant_correctas >=3 ){

            }
        }
    }
}