package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String topicname="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      final LinearLayout java=findViewById(R.id.javalayout);
      final LinearLayout androidlayout=findViewById(R.id.androidlayout);
      final LinearLayout kotlin=findViewById(R.id.kotlinlayout);
      final LinearLayout flutter=findViewById(R.id.flutterlayout);
      final Button startbtn = findViewById(R.id.startquiz);

      java.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              topicname="java";
              java.setBackgroundResource(R.drawable.new_java_background);
              androidlayout.setBackgroundResource(R.drawable.new_back_ground_01);
              kotlin.setBackgroundResource(R.drawable.new_back_ground_01);
              flutter.setBackgroundResource(R.drawable.new_back_ground_01);

          }
      });
      androidlayout.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              topicname="android";
              androidlayout.setBackgroundResource(R.drawable.new_java_background);
              java.setBackgroundResource(R.drawable.new_back_ground_01);
              kotlin.setBackgroundResource(R.drawable.new_back_ground_01);
              flutter.setBackgroundResource(R.drawable.new_back_ground_01);
          }
      });
        kotlin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                topicname="kotlin";
                kotlin.setBackgroundResource(R.drawable.new_java_background);
                java.setBackgroundResource(R.drawable.new_back_ground_01);
                androidlayout.setBackgroundResource(R.drawable.new_back_ground_01);
                flutter.setBackgroundResource(R.drawable.new_back_ground_01);
            }
        });
        flutter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                topicname="flutter";
                flutter.setBackgroundResource(R.drawable.new_java_background);
                java.setBackgroundResource(R.drawable.new_back_ground_01);
                kotlin.setBackgroundResource(R.drawable.new_back_ground_01);
                androidlayout.setBackgroundResource(R.drawable.new_back_ground_01);
            }
        });
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(topicname.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please select a topic", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent=new Intent(MainActivity.this,quizactivity.class);
                    intent.putExtra("selectedtopic",topicname);
                    startActivity(intent);
                }
            }
        });




    }
}