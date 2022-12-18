package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class quizresults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizresults);

        final Button startnxt=findViewById(R.id.startnextquiz);
         TextView correctanswer=findViewById(R.id.correctanswer);
         TextView incorrectanswer=findViewById(R.id.incorrectanswer);
        Bundle extras = getIntent().getExtras();
        String stringVariableName = extras.getString("StringVariableName");
        int intVariableName = Integer.parseInt(stringVariableName);
        correctanswer.setText("Correct Answers :  "+intVariableName);
        incorrectanswer.setText("Incorrect Answers :  "+(6-intVariableName));

        startnxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(quizresults.this,MainActivity.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(quizresults.this,MainActivity.class));
        finish();
    }
}