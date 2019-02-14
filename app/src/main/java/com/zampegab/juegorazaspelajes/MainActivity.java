package com.zampegab.juegorazaspelajes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageButton btn_config;
    ImageButton btn_jugar;
    ImageButton btn_reconocimiento;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Caballo> caballo = Repositorio.getCaballosRandom(1);

        btn_config = findViewById(R.id.btn_conf);
        btn_reconocimiento = findViewById(R.id.btn_reconocimiento);
        btn_jugar = findViewById(R.id.btn_jugar);

        btn_config.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        btn_reconocimiento.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, GrillaActivity.class);
                startActivity(intent);
            }
        });

        btn_jugar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InteraccionBActivity.class);
                startActivity(intent);
            }
        });
    }
}



