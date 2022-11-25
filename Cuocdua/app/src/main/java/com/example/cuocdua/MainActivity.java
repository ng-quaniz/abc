package com.example.cuocdua;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import kotlinx.coroutines.channels.ChannelResult;

public class MainActivity extends AppCompatActivity {

    TextView t1;
    Button b1;
    CheckBox c1,c2,c3;
    SeekBar s1,s2,s3;
    int diem = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anhxa();
        s1.setEnabled(false);
        s2.setEnabled(false);
        s3.setEnabled(false);
        t1.setText(diem + "");

        final CountDownTimer countDownTimer = new CountDownTimer(60000, 300) {
            @Override
            public void onTick(long l) {
                int n = 5;
                Random random = new Random();
                int o = random.nextInt(n);
                int t = random.nextInt(n);
                int th = random.nextInt(n);
    // kt win
                if(s1.getProgress() >= s1.getMax()){
                    this.cancel();
                    b1.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"One win", Toast.LENGTH_LONG).show();
                    if(c1.isChecked()){
                        diem += 10;
                        Toast.makeText(MainActivity.this, "Bạn đoán đúng", Toast.LENGTH_SHORT).show();
                    }else{
                        diem -= 5;
                        Toast.makeText(MainActivity.this, "Bạn đoán sai", Toast.LENGTH_SHORT).show();
                    }
                    t1.setText(diem + "");
                    EnableCheckBox();
                }
                if(s2.getProgress() >= s2.getMax()){
                    this.cancel();
                    b1.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"Two win", Toast.LENGTH_LONG).show();
                    if(c2.isChecked()){
                        diem += 10;
                        Toast.makeText(MainActivity.this, "Bạn đoán đúng", Toast.LENGTH_SHORT).show();
                    }else{
                        diem -= 5;
                        Toast.makeText(MainActivity.this, "Bạn đoán sai", Toast.LENGTH_SHORT).show();
                    }
                    t1.setText(diem + "");
                    EnableCheckBox();
                }
                if(s3.getProgress() >= s3.getMax()){
                    this.cancel();
                    b1.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"Three win", Toast.LENGTH_LONG).show();
                    if(c3.isChecked()){
                        diem += 10;
                        Toast.makeText(MainActivity.this, "Bạn đoán đúng", Toast.LENGTH_SHORT).show();
                    }else{
                        diem -= 5;
                        Toast.makeText(MainActivity.this, "Bạn đoán sai", Toast.LENGTH_SHORT).show();
                    }
                    t1.setText(diem + "");
                    EnableCheckBox();
                }
                s1.setProgress(s1.getProgress() + o );
                s2.setProgress(s2.getProgress() + t );
                s3.setProgress(s3.getProgress() + th );

            }

            @Override
            public void onFinish() {

            }
        };
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(c1.isChecked() || c2.isChecked() || c3.isChecked()){
                s1.setProgress(0);
                s2.setProgress(0);
                s3.setProgress(0);
                b1.setVisibility(View.INVISIBLE);
                countDownTimer.start();
                DisableCheckBox();
               }else {
                   Toast.makeText(MainActivity.this, "Vui lòng đặt cược trước khi chơi!", Toast.LENGTH_SHORT).show();
               }
               
            }
        });
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c1.setChecked(c1.isChecked());
                c2.setChecked(false);
                c3.setChecked(false);
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c1.setChecked(false);
                c2.setChecked(c2.isChecked());
                c3.setChecked(false);
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c1.setChecked(false);
                c2.setChecked(false);
                c3.setChecked(c3.isChecked());
            }
        });
    }

    private  void EnableCheckBox() {
        c1.setEnabled(true);
        c2.setEnabled(true);
        c3.setEnabled(true);
    }
    private  void DisableCheckBox() {
        c1.setEnabled(false);
        c2.setEnabled(false);
        c3.setEnabled(false);
    }


    private void Anhxa(){
         t1 = (TextView) findViewById(R.id.text1);
         b1 = (Button) findViewById(R.id.button1);
         c1 = (CheckBox) findViewById(R.id.checkbox1);
         c2 = (CheckBox) findViewById(R.id.checkbox2);
         c3 = (CheckBox) findViewById(R.id.checkbox3);
         s1 = (SeekBar) findViewById(R.id.seekbar1);
         s2 = (SeekBar) findViewById(R.id.seekbar2);
         s3 = (SeekBar) findViewById(R.id.seekbar3);

    }
}
