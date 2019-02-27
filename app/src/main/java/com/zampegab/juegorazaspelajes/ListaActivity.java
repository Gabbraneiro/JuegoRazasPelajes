package com.zampegab.juegorazaspelajes;

import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListaActivity  extends AppCompatActivity{

    private List<Caballo> caballos;
    private SoundPool soundPool;
    private int sonido_actual;
    private String voz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        voz = sharedPreferences.getString("voz","m");
        super.onCreate(savedInstanceState);
        soundPool = new SoundPool(8, AudioManager.STREAM_MUSIC, 0);
        caballos = Repositorio.getCaballos();
        setContentView(R.layout.activity_lista);
        int row = 1;
        for (int i = 0; i < caballos.size(); i++) {
            LinearLayout linear_layout = findViewById(getResources().getIdentifier("linear_row_" + row,"id",ListaActivity.this.getPackageName()));
            ImageView img = findViewById(getResources().getIdentifier("image_" + row,"id",ListaActivity.this.getPackageName()));
            ImageButton img_talk = findViewById(getResources().getIdentifier("button_" + row, "id",ListaActivity.this.getPackageName()));
            TextView text = findViewById(getResources().getIdentifier("text_" + row + "_1","id",ListaActivity.this.getPackageName()));
            TextView text2 = findViewById(getResources().getIdentifier("text_" + row + "_1","id",ListaActivity.this.getPackageName()));

            img.setImageResource(caballos.get(i).getImg());
            text.setText(caballos.get(i).getRaza());
            final int sonido_caballo =caballos.get(i).getAudio_raza(voz);
            img_talk.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    sonido_actual = soundPool.load(ListaActivity.this, sonido_caballo, 1);
                    int streamID = -1;
                    do {
                        streamID = soundPool.play(sonido_actual, 1, 1, 0, 0, 1);
                    } while(streamID==0);
                }
            });
            text2.setText(caballos.get(i).getDescripcion());

            row++;

            linear_layout.setVisibility(View.VISIBLE);
        }
    }

}
