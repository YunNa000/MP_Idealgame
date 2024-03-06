package com.example.ideal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioTop, radioBottom;
    ImageView imageView;
    ImageView imageView2;
    TextView txtView;
    EditText editText;
    Button btn_play;
    Button btn_stop;

    MediaPlayer mediaPlayer;
    RandomValues randomArray;

    String[] titles = {
            "그림0",
            "응급조치키트",
            "그림2",
            "그림3",
            "그림4",
            "그림5",
            "그림6",
            "그림7"
    };

    Integer[] images = {
            R.drawable.fig0,
            R.drawable.fig1,
            R.drawable.fig2,
            R.drawable.fig3,
            R.drawable.fig4,
            R.drawable.fig5,
            R.drawable.fig6,
            R.drawable.fig7
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        randomArray = new RandomValues(8);
        randomArray.getRandomArray();
        txtView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);
        imageView.setImageResource(images[randomArray.randomArray[0]]);
        imageView2 = findViewById(R.id.imageView2);
        imageView2.setImageResource(images[randomArray.randomArray[1]]);
        radioTop = findViewById(R.id.radioTop);
        radioBottom = findViewById(R.id.radioBottom);
        radioGroup = findViewById(R.id.radioGroup);
        txtView.setText("이상형 월드컵 8강");

        btn_play = findViewById(R.id.btn_play);
        btn_stop = findViewById(R.id.btn_stop);

        // 재생버튼 눌렀을때..
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.music);
                mediaPlayer.start();
            }
        });


        // 정지버튼 눌렀을때..
        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                }
            }
        });


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            int stage = 0;

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton select = (RadioButton)findViewById(checkedId);
                switch (select.getId()) {
                    case R.id.radioTop:
                        radioTop.setChecked(false);
                        showImageView(stage, 0);
                        break;
                    case R.id.radioBottom:
                        radioBottom.setChecked(false);
                        showImageView(stage, 1);
                        break;
                }
                stage += 1;
            }
        });
    }

    public void showImageView(int stage, int select){
        int[] tmpArray = randomArray.getRandomArray();
        int selectNum2 = 8;
        if(stage == 0 ){
            txtView.setText("이상형 월드컵 8강-2");
            tmpArray[stage+selectNum2] = tmpArray[2*stage+select];
            randomArray.setRandomArray(tmpArray);
            imageView.setImageResource(images[tmpArray[2*(stage+1)]]);
            imageView2.setImageResource(images[tmpArray[2*(stage+1)+1]]);
        }
        if(stage == 1){
            txtView.setText("이상형 월드컵 8강-3");
            tmpArray[stage+selectNum2] = tmpArray[2*stage+select];
            randomArray.setRandomArray(tmpArray);
            imageView.setImageResource(images[tmpArray[2*(stage+1)]]);
            imageView2.setImageResource(images[tmpArray[2*(stage+1)+1]]);
        }
        if(stage == 2){
            txtView.setText("이상형 월드컵 8강-4");
            tmpArray[stage+selectNum2] = tmpArray[2*stage+select];
            randomArray.setRandomArray(tmpArray);
            imageView.setImageResource(images[tmpArray[2*(stage+1)]]);
            imageView2.setImageResource(images[tmpArray[2*(stage+1)+1]]);
        }
        if(stage == 3 ){
            txtView.setText("이상형 월드컵 4강-1");
            tmpArray[stage+selectNum2] = tmpArray[2*stage+select];
            randomArray.setRandomArray(tmpArray);
            imageView.setImageResource(images[tmpArray[2*(stage+1)]]);
            imageView2.setImageResource(images[tmpArray[2*(stage+1)+1]]);
        }
        if(stage == 4){
            txtView.setText("이상형 월드컵 4강-2");
            tmpArray[stage+selectNum2] = tmpArray[2*stage+select];
            randomArray.setRandomArray(tmpArray);
            imageView.setImageResource(images[tmpArray[2*(stage+1)]]);
            imageView2.setImageResource(images[tmpArray[2*(stage+1)+1]]);
        }
        if(stage == 5){
            txtView.setText("이상형 월드컵 결승");
            tmpArray[stage+selectNum2] = tmpArray[2*stage+select];
            randomArray.setRandomArray(tmpArray);
            imageView.setImageResource(images[tmpArray[2*(stage+1)]]);
            imageView2.setImageResource(images[tmpArray[2*(stage+1)+1]]);
        }
        if (stage == 6){
            tmpArray[stage+selectNum2] = tmpArray[2*stage+select];
            randomArray.setRandomArray(tmpArray);
            //imageView.setImageResource(images[tmpArray[2*(stage+1)]]);
            //imageView2.setImageResource(images[tmpArray[2*(stage+1)+1]]);
            new AlertDialog.Builder(this)
                    .setIcon(R.mipmap.ic_launcher)
                    .setTitle("우승")
                    .setMessage(String.format("우승 : %s",titles[tmpArray[2*stage+select]]))
                    .setNeutralButton("닫기", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    })
                    .show();
        }
        Toast.makeText(getApplicationContext(),titles[tmpArray[2*stage+select]],Toast.LENGTH_SHORT).show();
    }
}