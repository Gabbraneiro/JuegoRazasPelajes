package com.zampegab.juegorazaspelajes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class InteraccionAActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<Caballo> caballos = (ArrayList<Caballo>) getIntent().getExtras().get("caballos");
        setContentView(R.layout.activity_interaccion_a);
    }
}