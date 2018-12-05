package com.zampegab.juegorazaspelajes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {

    final Button buttonRecognition = (Button) findViewById(R.id.buttonRecognition);

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
    }
}
