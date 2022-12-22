package com.example.ibratquizassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView questionNo,question;
    RadioGroup radioGroup;
    Button submit;
    int points=0;
    RadioButton A,B,C,D;
    int index=0;
    int length=QuestionAnswer.question.length;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionNo=findViewById(R.id.count);
        A=findViewById(R.id.A);
        B=findViewById(R.id.B);
        C=findViewById(R.id.C);
        D=findViewById(R.id.D);
        question=findViewById(R.id.question);
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
        if(index==length-1){
            createDialog();
            return;
        }
        question.setText(QuestionAnswer.question[index]);
        String options[]=QuestionAnswer.choices[index];
        A.setText(options[0]);
        B.setText(options[1]);
        C.setText(options[2]);
        D.setText(options[3]);
        int c=1+index;
        questionNo.setText("Question Number:"+c+"");
        index++;
    }

    private void createDialog() {
        Toast.makeText(this, ""+points, Toast.LENGTH_SHORT).show();
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
            loadQue();
        }


    }

}