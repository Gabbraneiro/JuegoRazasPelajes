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

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class GrillaPelajeActivity extends AppCompatActivity{

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
        setContentView(R.layout.activity_grilla);
        int row = 1;
        int frame = 1;
        for (int i = 0; i < caballos.size(); i++) {
            FrameLayout frame_layout = findViewById(getResources().getIdentifier("row_"+row+"_frame_"+frame,"id",GrillaPelajeActivity.this.getPackageName()));
            ImageView img = findViewById(getResources().getIdentifier("image_"+row+"_"+frame,"id",GrillaPelajeActivity.this.getPackageName()));
            ImageButton img_talk = findViewById(getResources().getIdentifier("talk_"+row+"_"+frame, "id",GrillaPelajeActivity.this.getPackageName()));
            TextView text = findViewById(getResources().getIdentifier("texto_"+row+"_"+frame,"id",GrillaPelajeActivity.this.getPackageName()));
            img.setImageResource(caballos.get(i).getImg());
            text.setText(caballos.get(i).getPelaje());
            final int sonido_caballo =caballos.get(i).getAudio_pelaje(voz);
            img_talk.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    sonido_actual = soundPool.load(GrillaPelajeActivity.this, sonido_caballo, 1);
                    int streamID = -1;
                    do {
                        streamID = soundPool.play(sonido_actual, 1, 1, 0, 0, 1);
                    } while(streamID==0);
                }
            });
            if(frame == 3){
                row++;
                frame = 1;
            }
            else{
                frame++;
            }

            frame_layout.setVisibility(View.VISIBLE);
        }
    }
}
