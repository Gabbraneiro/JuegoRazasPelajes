package com.zampegab.juegorazaspelajes;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class GrillaActivity extends AppCompatActivity{

        MediaPlayer mpCaballo;
        ImageButton btnHorse1, btnHorse2, btnHorse3, btnHorse4, btnHorse5, btnHorse6;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            List<Caballo> caballos = Repositorio.getCaballos();
            setContentView(R.layout.activity_grilla);

            /*mpCaballo = MediaPlayer.create(this, R.raw.caballo);

            btnHorse1 = findViewById(R.id.imageButton);
            btnHorse1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mpCaballo.start();
                }
            });

            btnHorse2 = findViewById(R.id.imageButton2);
            btnHorse2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mpCaballo.start();
                }
            });

            btnHorse3 = findViewById(R.id.imageButton3);
            btnHorse3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mpCaballo.start();
                }
            });

            btnHorse4 = findViewById(R.id.imageButton4);
            btnHorse4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mpCaballo.start();
                }
            });

            btnHorse5 = findViewById(R.id.imageButton5);
            btnHorse5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mpCaballo.start();
                }
            });

            btnHorse6 = findViewById(R.id.imageButton6);
            btnHorse6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mpCaballo.start();
                }
            });*/
        }
}
