package com.zampegab.juegorazaspelajes;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class InteraccionBActivity  extends AppCompatActivity {

    MediaPlayer sonido_raza;
    MediaPlayer sonido_result;
    ImageButton btnRaza;
    int cant_correctas, cant_rondas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cant_correctas = 0; cant_rondas = 0;
        List<Caballo> caballos = Repositorio.getCaballosRandom((int) getIntent().getExtras().get("caballos"));
        setContentView(R.layout.activity_interaccion_b);
        ImageView opcion1 = findViewById(R.id.a_opcion_2);
        opcion1.setImageResource(caballos.get(0).getImg());
        ImageView opcion2 = findViewById(R.id.a_opcion_3);
        opcion2.setImageResource(caballos.get(1).getImg());
        if (caballos.size() > 2) {
            ImageView opcion3 = findViewById(R.id.a_opcion_1);
            opcion3.setImageResource(caballos.get(2).getImg());
            ImageView opcion4 = findViewById(R.id.a_opcion_4);
            opcion4.setImageResource(caballos.get(3).getImg());
        }

        final Caballo c = caballos.get((int)(Math.random() * (caballos.size()-1)));
        TextView raza = findViewById(R.id.a_raza);
        raza.setText(c.getRaza());
        btnRaza = findViewById(R.id.a_sonido);
        btnRaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sonido_raza = MediaPlayer.create(InteraccionBActivity.this, c.getAudio_raza());
                sonido_raza.start();
            }
        });
    }


}
