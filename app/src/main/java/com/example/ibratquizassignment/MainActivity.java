package com.example.ibratquizassignment;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView questionNo,question;
    RadioGroup radioGroup;
    Button submit;
    ImageView optionImage;
    int points=0;
    RadioButton A,B,C,D;
    int index=0;
    int length=QuestionAnswer.question.length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("My Quiz");
        questionNo=findViewById(R.id.count);
        System.out.println(length);
        A=findViewById(R.id.A);
        B=findViewById(R.id.B);
        C=findViewById(R.id.C);
        D=findViewById(R.id.D);
        question=findViewById(R.id.question);
        optionImage=findViewById(R.id.imageOption);
        submit=findViewById(R.id.submit);
        radioGroup=findViewById(R.id.questiongrp);

        loadQue();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next();
            }
        });
    }
    void loadQue(){
        if(index==length){
            createDialog();
            return;
        }
        question.setText(QuestionAnswer.question[index]);
        String[] options =QuestionAnswer.choices[index];
        optionImage.setImageResource(QuestionAnswer.imageOptions[index]);
        A.setText(options[0]);
        B.setText(options[1]);
        C.setText(options[2]);
        D.setText(options[3]);
        int c=1+index;
        questionNo.setText("Question Number:"+c+"");

    }

    private void createDialog() {
        String passStatus = "";
        if(points > length*0.60){
            passStatus = "Passed";
        }else{
            passStatus = "Failed";
        }
        new AlertDialog.Builder(this).setTitle(passStatus)
                .setMessage("Score is "+ points+" out of "+ length)
                .setPositiveButton("Restart",((dialogInterface, i) -> restartQuiz()))
                .setNegativeButton("Exit",((dialogInterface, i) -> {android.os.Process.killProcess(android.os.Process.myPid());
                    System.exit(1);}))
                .setCancelable(false)
                .show();
    }

    private void restartQuiz() {
       index=0;
       points=0;
       loadQue();
    }

    void next(){
        int selectedId = radioGroup.getCheckedRadioButtonId();
        if(selectedId==-1){
            Toast.makeText(MainActivity.this,"Nothing selected", Toast.LENGTH_SHORT).show();

        }
        else{
            RadioButton rb=(RadioButton) findViewById(selectedId);
            String radioText=rb.getText().toString();
            if(radioText.equals(QuestionAnswer.correctAnswers[index])) points++;
            radioGroup.clearCheck();
            index++;
            loadQue();
        }


    }

}