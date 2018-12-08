package com.zampegab.juegorazaspelajes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.media.MediaPlayer;

public class InteraccionCActivity extends AppCompatActivity{

    MediaPlayer mpResult;
    ImageButton btnHorse1;
    ImageButton btnHorse2;
    ImageButton btnHorse3;
    ImageButton btnHorse4;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interaccion_c);

        btnHorse1 = findViewById(R.id.horse1);
        btnHorse1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpResult = MediaPlayer.create(InteraccionCActivity.this, R.raw.incorrect);
                mpResult.start();
            }
        });

        btnHorse2 = findViewById(R.id.horse2);
        btnHorse2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpResult = MediaPlayer.create(InteraccionCActivity.this, R.raw.correct);
                mpResult.start();
            }
        });

        btnHorse3 = findViewById(R.id.horse3);
        btnHorse3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpResult = MediaPlayer.create(InteraccionCActivity.this, R.raw.incorrect);
                mpResult.start();
            }
        });

        btnHorse4 = findViewById(R.id.horse4);
        btnHorse4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpResult = MediaPlayer.create(InteraccionCActivity.this, R.raw.incorrect);
                mpResult.start();
            }
        });

        btnBack = findViewById(R.id.buttonBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
