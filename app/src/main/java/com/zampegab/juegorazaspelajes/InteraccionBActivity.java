package com.zampegab.juegorazaspelajes;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class InteraccionBActivity  extends AppCompatActivity {

    MediaPlayer mpRaza;
    MediaPlayer mpResult;
    ImageButton btnRaza;
    ImageButton btnHorse1;
    ImageButton btnHorse2;
    ImageButton btnHorse3;
    ImageButton btnHorse4;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interaccion_b);


        btnRaza = findViewById(R.id.b_imageButton);
        btnRaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpRaza = MediaPlayer.create(InteraccionBActivity.this, R.raw.caballo);
                mpRaza.start();
            }
        });

        btnHorse1 = findViewById(R.id.b_horse1);
        btnHorse1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpResult = MediaPlayer.create(InteraccionBActivity.this, R.raw.incorrect);
                mpResult.start();
            }
        });

        btnHorse2 = findViewById(R.id.b_horse2);
        btnHorse2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpResult = MediaPlayer.create(InteraccionBActivity.this, R.raw.incorrect);
                mpResult.start();
            }
        });

        btnHorse3 = findViewById(R.id.b_horse3);
        btnHorse3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpResult = MediaPlayer.create(InteraccionBActivity.this, R.raw.correct);
                mpResult.start();
            }
        });

        btnHorse4 = findViewById(R.id.b_horse4);
        btnHorse4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpResult = MediaPlayer.create(InteraccionBActivity.this, R.raw.incorrect);
                mpResult.start();
            }
        });

        btnBack = findViewById(R.id.b_buttonBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
