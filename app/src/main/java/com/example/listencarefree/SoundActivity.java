package com.example.listencarefree;

import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import org.tensorflow.lite.Interpreter;

import android.content.Intent;
import android.speech.RecognizerIntent;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;


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

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,getPackageName()); // 여분의 키
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,"ko-KR"); // 언어 설정

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image.setImageResource(R.drawable.defaultbutton);
                text.setText("현재 기본감지가 실행되고 있습니다.");

                Interpreter tflite = getTfliteInterpreter("default_mfcc_model.tflite");
            }
        });

    }


    public void onSiren(View v){
        final ImageButton btn = findViewById(R.id.imageButton2);

        ImageView image = findViewById(R.id.imageView3);

        TextView text = findViewById(R.id.textView5);

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,getPackageName()); // 여분의 키
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,"ko-KR"); // 언어 설정

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image.setImageResource(R.drawable.sirenbutton);
                text.setText("현재 사이렌감지가 실행되고 있습니다.");

                Interpreter tflite = getTfliteInterpreter("default_mfcc_model.tflite");
            }
        });

    }

    public void onBabycry(View v){
        final ImageButton btn = findViewById(R.id.imageButton3);

        ImageView image = findViewById(R.id.imageView3);

        TextView text = findViewById(R.id.textView5);

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,getPackageName()); // 여분의 키
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,"ko-KR"); // 언어 설정

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image.setImageResource(R.drawable.babybutton);
                text.setText("현재 울음감지가 실행되고 있습니다");

                Interpreter tflite = getTfliteInterpreter("default_mfcc_model.tflite");
            }
        });
    }

    public void onScream(View v){
        final ImageButton btn = findViewById(R.id.imageButton4);

        ImageView image = findViewById(R.id.imageView3);

        TextView text = findViewById(R.id.textView5);

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,getPackageName()); // 여분의 키
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,"ko-KR"); // 언어 설정

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image.setImageResource(R.drawable.screambutton);
                text.setText("현재 비명감지가 실행되고 있습니다");

                Interpreter tflite = getTfliteInterpreter("default_mfcc_model.tflite");
            }
        });

    }

    private Interpreter getTfliteInterpreter(String modelPath){
        try {
            return new Interpreter(loadModelFile(SoundActivity.this, modelPath));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private MappedByteBuffer loadModelFile(Activity activity, String modelPath) throws IOException{
        AssetFileDescriptor fileDescriptor = activity.getAssets().openFd(modelPath);
        FileInputStream inputStream = new FileInputStream(fileDescriptor.getFileDescriptor());
        FileChannel fileChannel = inputStream.getChannel();
        long startOffset = fileDescriptor.getStartOffset();
        long declaredLength = fileDescriptor.getDeclaredLength();
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength);
    }
}
