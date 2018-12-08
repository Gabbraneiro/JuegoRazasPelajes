package com.zampegab.juegorazaspelajes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    Button buttonLista;
    Button buttonGrilla;
    Button buttonPlay;
    Button buttonPlay2;
    ImageButton buttonSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLista = findViewById(R.id.buttonLista);
        buttonGrilla = findViewById(R.id.buttonGrilla);
        buttonPlay = findViewById(R.id.buttonPlay);
        buttonPlay2 = findViewById(R.id.buttonPlay2);
        buttonSettings = findViewById(R.id.imageConfigurate);

        buttonLista.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, ListaActivity.class);
                startActivity(intent);
            }
        });

        buttonGrilla.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, GrillaActivity.class);
                startActivity(intent);
            }
        });

        buttonPlay2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InteraccionBActivity.class);
                startActivity(intent);
            }
        });

        buttonPlay.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InteraccionCActivity.class);
                startActivity(intent);
            }
        });

        buttonSettings.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
    }
}


        /* buttonRecognition.setOnClickListener(new OnClickListener(){
@Override
public void onClick(View v){
        Intent intent = new Intent(MainActivity.this, GrillaActivity.class);
        startActivity(intent);
        }
        });
        buttonSettings.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });*/
