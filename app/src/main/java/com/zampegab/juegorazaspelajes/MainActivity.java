package com.zampegab.juegorazaspelajes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    final Button buttonRecognition = (Button) findViewById(R.id.buttonRecognition);
    final ImageButton buttonSettings = (ImageButton) findViewById(R.id.imageConfigurate);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonRecognition.setOnClickListener(new OnClickListener(){
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
        });
    }

}
