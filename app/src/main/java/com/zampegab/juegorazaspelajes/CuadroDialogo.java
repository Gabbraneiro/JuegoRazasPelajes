package com.zampegab.juegorazaspelajes;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class CuadroDialogo extends AppCompatActivity {

    public CuadroDialogo(Context context, int ronda, String respuesta, int r_correctas){
        final Dialog dialogo = new Dialog(context);
        dialogo.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogo.setCancelable(false);
        dialogo.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        TextView titulo = findViewById(R.id.dialogo_titulo);
        TextView rondas = findViewById(R.id.dialogo_ronda);
        TextView correctas = findViewById(R.id.dialogo_correctas);

        titulo.setText("Respuesta " + respuesta);
        rondas.setText("Ronda " + ronda + " de 5");
        correctas.setText("Respuestas correctas: " + r_correctas + rondas);
        dialogo.setContentView(R.layout.cuadro_dialogo);

        final Button boton = findViewById(R.id.dialogo_button);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogo.dismiss();
            }
        });

        dialogo.show();
    }
}
