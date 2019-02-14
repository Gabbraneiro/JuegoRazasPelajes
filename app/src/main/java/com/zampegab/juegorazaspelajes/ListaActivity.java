package com.zampegab.juegorazaspelajes;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ListaActivity  extends AppCompatActivity{

    MediaPlayer mpCaballo;
    ImageButton btnHorse1, btnHorse2, btnHorse3, btnHorse4, btnHorse5, btnHorse6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        /*mpCaballo = MediaPlayer.create(this, R.raw.caballo);

        btnHorse1 = findViewById(R.id.listImagenBtn);
        btnHorse1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpCaballo.start();
            }
        });

        btnHorse2 = findViewById(R.id.listImagenBtn2);
        btnHorse2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpCaballo.start();
            }
        });

        btnHorse3 = findViewById(R.id.listImagenBtn3);
        btnHorse3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpCaballo.start();
            }
        });*/
    }

}
