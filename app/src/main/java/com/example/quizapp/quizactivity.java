package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class quizactivity extends AppCompatActivity {
    private TextView questions;
    private TextView question;
    private AppCompatButton option1,option2,option3,option4;
    private AppCompatButton nextbtn;
    private Timer quizTimer;
    private int TotaltimeMins=1;
    private int seconds=0;
    private List<QuestionList> questionlists;

   private int currentquestionpostion=0;
   private String selectedoption="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizactivity);

    final  String gettopicname=getIntent().getStringExtra("selectedtopic");
//    final TextView timer=findViewById(R.id.timer);
    final TextView selecttopic=findViewById(R.id.topic_name);
    final ImageView backbtn=findViewById(R.id.back_btn);
    questions=findViewById(R.id.questions);
    question=findViewById(R.id.question);
    option1=findViewById(R.id.option1);
    option2=findViewById(R.id.option2);
    option3=findViewById(R.id.option3);
    option4=findViewById(R.id.option4);
    nextbtn=findViewById(R.id.next_btn);


    selecttopic.setText(gettopicname);
   questionlists=questionbank.getquestions(gettopicname);

//   startTimer(timer);
    questions.setText((currentquestionpostion+1)+"/"+questionlists.size());
    question.setText(questionlists.get(0).getQuestion());
        option1.setText(questionlists.get(0).getOption1());
        option2.setText(questionlists.get(0).getOption2());
        option3.setText(questionlists.get(0).getOption3());
        option4.setText(questionlists.get(0).getOption4());
    option1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if(selectedoption.isEmpty()){
                selectedoption=option1.getText().toString();
                option1.setBackgroundResource(R.drawable.new_back_red);
                option1.setTextColor(Color.WHITE);

                revealanswer();
                questionlists.get(currentquestionpostion).setSelectedanswer(selectedoption);
            }


        }
    });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedoption.isEmpty()){
                    selectedoption=option2.getText().toString();
                    option2.setBackgroundResource(R.drawable.new_back_red);
                    option2.setTextColor(Color.WHITE);

                    revealanswer();
                    questionlists.get(currentquestionpostion).setSelectedanswer(selectedoption);
                }
            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedoption.isEmpty()){
                    selectedoption=option3.getText().toString();
                    option3.setBackgroundResource(R.drawable.new_back_red);
                    option3.setTextColor(Color.WHITE);

                    revealanswer();
                    questionlists.get(currentquestionpostion).setSelectedanswer(selectedoption);
                }
            }
        });
        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedoption.isEmpty()){
                    selectedoption=option4.getText().toString();
                    option4.setBackgroundResource(R.drawable.new_back_red);
                    option4.setTextColor(Color.WHITE);

                    revealanswer();
                    questionlists.get(currentquestionpostion).setSelectedanswer(selectedoption);
                }
            }
        });
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedoption.isEmpty()) {

                    Toast.makeText(quizactivity.this, "Please select an option", Toast.LENGTH_SHORT).show();
                }
                else
                {
                       changeNextQuestion();
                }


            }
        });
    backbtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            quizTimer.purge();
            quizTimer.cancel();
            startActivity(new Intent(quizactivity.this,MainActivity.class));
            finish();
        }
    });

    }
    private void changeNextQuestion(){
        currentquestionpostion++;
        if((currentquestionpostion+1)==questionlists.size())
        {
            nextbtn.setText("Submit Quiz");
        }
        if(currentquestionpostion<questionlists.size())
        {
            selectedoption="";
            option1.setBackgroundResource(R.drawable.background_01);
            option1.setTextColor(Color.parseColor("#1F6888"));

            option2.setBackgroundResource(R.drawable.background_01);
            option2.setTextColor(Color.parseColor("#1F6888"));

            option3.setBackgroundResource(R.drawable.background_01);
            option3.setTextColor(Color.parseColor("#1F6888"));

            option4.setBackgroundResource(R.drawable.background_01);
            option4.setTextColor(Color.parseColor("#1F6888"));

            questions.setText((currentquestionpostion+1)+"/"+questionlists.size());
            question.setText(questionlists.get(currentquestionpostion).getQuestion());
            option1.setText(questionlists.get(currentquestionpostion).getOption1());
            option2.setText(questionlists.get(currentquestionpostion).getOption2());
            option3.setText(questionlists.get(currentquestionpostion).getOption3());
            option4.setText(questionlists.get(currentquestionpostion).getOption4());

        }
        else
        {
            Toast.makeText(this, "Score is "+getcorrectAnswer(), Toast.LENGTH_SHORT).show();

            Intent intent=new Intent(quizactivity.this,quizresults.class);
            Bundle extras = new Bundle();
            extras.putString("StringVariableName", getcorrectAnswer() + "");
            intent.putExtras(extras);
            startActivity(intent);

            finish();
        }
    }
    private void startTimer(TextView timetextView)
    {
        quizTimer=new Timer();
        quizTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(seconds==0)
                {
                    TotaltimeMins--;
                    seconds=59;
                }
                else if(seconds==0&&TotaltimeMins==0){
                    quizTimer.purge();
                    quizTimer.cancel();
                    Toast.makeText(quizactivity.this, "Times Up!", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent();
                    intent.putExtra("correct",getcorrectAnswer());
                    intent.putExtra("incorrect",getIncorrectAnswer());
                    startActivity(intent);
                    finish();
                }
                else
                {
                    seconds--;
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {



                        String finalMinutes=String.valueOf(TotaltimeMins);
                        String finalsecond=String.valueOf(seconds);
                        if(finalMinutes.length()==1)
                        {
                            finalMinutes="0"+finalMinutes;

                        }
                        if(finalsecond.length()==1)
                        {
                            finalsecond="0"+finalsecond;
                        }
                        timetextView.setText(finalMinutes+":"+finalsecond);

                    }
                });

            }
        },1000,1000);
    }
    private int getcorrectAnswer(){
         int correctanswer=0;
         for(int i=0;i<questionlists.size();i++)
         {
             final String getUserselectedanswer=questionlists.get(i).getSelectedanswer();
             final String getanswer=questionlists.get(i).getAnswer();
             if(getUserselectedanswer.equals(getanswer))
             {
                 correctanswer++;
             }

         }
         return correctanswer;
    }

    private int getIncorrectAnswer(){
        int correctanswer=0;
        for(int i=0;i<questionlists.size();i++)
        {
            final String getUserselectedanswer=questionlists.get(i).getSelectedanswer();
            final String getanswer=questionlists.get(i).getAnswer();
            if(!getUserselectedanswer.equals(getanswer))
            {
                correctanswer++;
            }

        }
        return correctanswer;
    }

    @Override
    public void onBackPressed() {
        quizTimer.purge();
        quizTimer.cancel();
        startActivity(new Intent(quizactivity.this,MainActivity.class));
        finish();
    }
    private void revealanswer(){
        final String getanswer= questionlists.get(currentquestionpostion).getAnswer();
        if(option1.getText().toString().equals(getanswer))
        {
            option1.setBackgroundResource(R.drawable.new_back_green);
            option1.setTextColor(Color.GRAY);
        }
        else if(option2.getText().toString().equals(getanswer))
        {
            option2.setBackgroundResource(R.drawable.new_back_green);
            option2.setTextColor(Color.GRAY);
        }
        else if(option3.getText().toString().equals(getanswer))
        {
            option3.setBackgroundResource(R.drawable.new_back_green);
            option3.setTextColor(Color.GRAY);
        }
        else if(option4.getText().toString().equals(getanswer))
        {
            option4.setBackgroundResource(R.drawable.new_back_green);
            option4.setTextColor(Color.GRAY);
        }
    }
}