package com.zampegab.juegorazaspelajes;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
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

public class ListaPelajeActivity extends AppCompatActivity{

    private List<Caballo> caballos;
    private SoundPool soundPool;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        soundPool = new SoundPool(8, AudioManager.STREAM_MUSIC, 0);
        caballos = Repositorio.getCaballos();
        setContentView(R.layout.activity_lista);
        int row = 1;
        int frame = 1;
        for (int i = 0; i < caballos.size(); i++) {
            LinearLayout linear_layout = findViewById(getResources().getIdentifier("linear_row_" + row,"id",ListaPelajeActivity.this.getPackageName()));
            ImageView img = findViewById(getResources().getIdentifier("image_" + row,"id",ListaPelajeActivity.this.getPackageName()));
            ImageButton img_talk = findViewById(getResources().getIdentifier("button_" + row, "id",ListaPelajeActivity.this.getPackageName()));
            TextView text = findViewById(getResources().getIdentifier("text_" + row + "_1","id",ListaPelajeActivity.this.getPackageName()));
            TextView text2 = findViewById(getResources().getIdentifier("text_" + row + "_1","id",ListaPelajeActivity.this.getPackageName()));

            img.setImageResource(caballos.get(i).getImg());
            text.setText(caballos.get(i).getPelaje());
            final int sonido_caballo =caballos.get(i).getAudio_pelaje();
            img_talk.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    int sonido = soundPool.load(ListaPelajeActivity.this, sonido_caballo, 1);
                    soundPool.play(sonido,1,1,0,0,1);
                }
            });
            text2.setText(caballos.get(i).getDescripcion());

            row++;

            linear_layout.setVisibility(View.VISIBLE);
        }
    }

}
