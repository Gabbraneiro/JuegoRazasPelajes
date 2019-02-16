package com.zampegab.juegorazaspelajes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.media.SoundPool;

import java.util.ArrayList;
import java.util.List;

public class InteraccionBActivity  extends AppCompatActivity {

    private SoundPool  soundPool;
    int sonido_raza, correcto_relincho, incorrecto_resoplido;
    private ImageButton btnRaza;
    private int cant_correctas, cant_rondas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        soundPool = new SoundPool(6, AudioManager.STREAM_MUSIC, 0);
        correcto_relincho = soundPool.load(this, R.raw.relincho, 1);
        incorrecto_resoplido = soundPool.load(this, R.raw.resoplido, 1);
        super.onCreate(savedInstanceState);
        cant_correctas = 0; cant_rondas = 0;
        setContentView(R.layout.activity_interaccion_b);

        jugarInteraccionB();

    }
    private void jugarInteraccionB(){
        final List<Caballo> caballos = Repositorio.getCaballosRandom((int) getIntent().getExtras().get("caballos"));
        ImageView opcion1 = findViewById(R.id.a_opcion_2);
        opcion1.setImageResource(caballos.get(0).getImg());
        ImageView opcion2 = findViewById(R.id.a_opcion_3);
        opcion2.setImageResource(caballos.get(1).getImg());

        int random = (int)(Math.random() * (caballos.size()-1));
        final Caballo c = caballos.get(random);
        TextView raza = findViewById(R.id.a_raza);
        raza.setText(c.getRaza());
        sonido_raza = soundPool.load(InteraccionBActivity.this, c.getAudio_raza(), 1);
        btnRaza = findViewById(R.id.a_sonido);
        btnRaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sonido_raza,1,1,0,0,1);
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
                    jugarInteraccionB();
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
                    jugarInteraccionB();
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
                //confeti();
                jugarInteraccionB();

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
                jugarInteraccionB();
            }
        });
    }
    private void confeti(){
        //PROBANDO
        ImageView sv = findViewById(R.id.confeti);
        try{
            int resId = getResources().getIdentifier("com.zampegab.juegorazaspelajes:drawable/angola_spc_zainocolorado",null,null);
            sv.setImageResource(resId);/*
            for (int i = 8; i < 71; i++) {
                int resId = getResources().getIdentifier("com.zampegab.juegorazaspelajes:drawable/c00"+i,null,null);
                sv.setImageResource(resId);
            }*/
        }
        catch (Exception e){
            Intent i = new Intent(InteraccionBActivity.this, MainActivity.class);
            startActivity(i);
        }
       /*
*/
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

}
