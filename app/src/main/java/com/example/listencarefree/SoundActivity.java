package com.example.listencarefree;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class SoundActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_sound);
    }

    public void onDefault(View v){
        final ImageButton btn = findViewById(R.id.imageButton);

        ImageView image = findViewById(R.id.imageView3);

        TextView text = findViewById(R.id.textView5);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image.setImageResource(R.drawable.defaultbutton);
                text.setText("현재 기본감지가 실행되고 있습니다.");
            }
        });

    }

    public void onSiren(View v){
        final ImageButton btn = findViewById(R.id.imageButton2);

        ImageView image = findViewById(R.id.imageView3);

        TextView text = findViewById(R.id.textView5);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image.setImageResource(R.drawable.sirenbutton);
                text.setText("현재 사이렌감지가 실행되고 있습니다.");
            }
        });

    }

    public void onBabycry(View v){
        final ImageButton btn = findViewById(R.id.imageButton3);

        ImageView image = findViewById(R.id.imageView3);

        TextView text = findViewById(R.id.textView5);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image.setImageResource(R.drawable.babybutton);
                text.setText("현재 울음감지가 실행되고 있습니다");
            }
        });
    }

    public void onScream(View v){
        final ImageButton btn = findViewById(R.id.imageButton4);

        ImageView image = findViewById(R.id.imageView3);

        TextView text = findViewById(R.id.textView5);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image.setImageResource(R.drawable.screambutton);
                text.setText("현재 비명감지가 실행되고 있습니다");
            }
        });

    }
}
