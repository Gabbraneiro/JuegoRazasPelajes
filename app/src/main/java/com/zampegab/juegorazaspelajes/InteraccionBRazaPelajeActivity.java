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

public class InteraccionBRazaPelajeActivity extends AppCompatActivity {
    private SoundPool soundPool;
    private int sonido_raza_pelaje, correcto_relincho, incorrecto_resoplido,cant_correctas, cant_rondas;
    private ImageButton btnRazaPelaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        soundPool = new SoundPool(6, AudioManager.STREAM_MUSIC, 0);
        correcto_relincho = soundPool.load(this, R.raw.relincho, 1);
        incorrecto_resoplido = soundPool.load(this, R.raw.resoplido, 1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interaccion_b);

        jugarMinijuegoDos();
    }

    private void jugarMinijuegoDos(){
        final List<Caballo> caballos = Repositorio.getCaballosRandom((int) getIntent().getExtras().get("caballos"));
        ImageView opcion1 = findViewById(R.id.a_opcion_2);
        opcion1.setImageResource(caballos.get(0).getImg());
        ImageView opcion2 = findViewById(R.id.a_opcion_3);
        opcion2.setImageResource(caballos.get(1).getImg());

        int random = (int)(Math.random() * (caballos.size()-1));
        final Caballo c = caballos.get(random);
        TextView raza_pelaje = findViewById(R.id.a_raza);
        String str = c.getRaza() + " " + c.getPelaje();
        raza_pelaje.setText(str);
        sonido_raza_pelaje = soundPool.load(InteraccionBRazaPelajeActivity.this, c.getAudio_raza_pelaje(), 1);
        btnRazaPelaje = findViewById(R.id.a_sonido);
        btnRazaPelaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sonido_raza_pelaje,1,1,0,0,1);
            }
        });

        if (caballos.size() > 2) {
            ImageView opcion3 = findViewById(R.id.a_opcion_1);
            opcion3.setImageResource(caballos.get(2).getImg());
            ImageView opcion4 = findViewById(R.id.a_opcion_4);
            opcion4.setImageResource(caballos.get(3).getImg());
            opcion3.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    if(caballos.get(2).getRaza() == c.getRaza() && caballos.get(2).getPelaje() == c.getPelaje()){
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
                    if(caballos.get(3).getRaza() == c.getRaza() && caballos.get(3).getPelaje() == c.getPelaje()){
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
                if(caballos.get(0).getRaza() == c.getRaza() && caballos.get(0).getPelaje() == c.getPelaje()){
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
                if(caballos.get(1).getRaza() == c.getRaza() && caballos.get(1).getPelaje() == c.getPelaje()){
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
    private void confeti(){
        ImageView iv = findViewById(R.id.confeti);
        AnimationDrawable animationConfeti = (AnimationDrawable)iv.getBackground();
        iv.setVisibility(View.VISIBLE);
        animationConfeti.start();
    }

    private void jugarMinijuegoTres(){
        Intent i = new Intent(InteraccionBRazaPelajeActivity.this, InteraccionCActivity.class);
        startActivity(i);
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
            final ScrollView interaccionB = findViewById(R.id.scroll_B);
            final Button accion = findViewById(R.id.accion_nivel);
            final FrameLayout modal = findViewById(R.id.div_fin_nivel);
            if(cant_correctas >= 3){
                // SE DA LA OPCION DE PASAR AL SIGUIENTE MINIJUEGO
                confeti();
                accion.setText(R.string.to_next);
                accion.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                modal.setVisibility(View.VISIBLE);
                accion.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v){
                        jugarMinijuegoTres();
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
                        interaccionB.setVisibility(View.VISIBLE);
                        modal.setVisibility(View.GONE);
                        jugarMinijuegoDos();
                    }
                });
            }
            cant_correctas = 0; cant_rondas = 0;
            updateViewContadores();
            interaccionB.setVisibility(View.INVISIBLE);
        }
        else{
            updateViewContadores();
            jugarMinijuegoDos();
        }
    }

    private void updateViewContadores(){
        TextView correctas = findViewById(R.id.correctas2);
        correctas.setText("Correctas: "+cant_correctas);
        TextView ronda = findViewById(R.id.rondas);
        ronda.setText("Rondas: "+cant_rondas);
    }
}
