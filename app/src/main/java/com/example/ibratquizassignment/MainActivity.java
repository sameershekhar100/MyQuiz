package com.example.ibratquizassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView questionNo,question;
    Button submit;
    RadioButton A,B,C,D;
    int index=0;
    int length=QuestionAnswer.question.length;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionNo=findViewById(R.id.count);
        question=findViewById(R.id.question);
        A=findViewById(R.id.A);
        B=findViewById(R.id.B);
        C=findViewById(R.id.C);
        D=findViewById(R.id.D);
        submit=findViewById(R.id.submit);

        loadQue();
    }
    void loadQue(){
        question.setText(QuestionAnswer.question[index]);
        String options[]=QuestionAnswer.choices[index];
        A.setText(options[0]);
        B.setText(options[1]);
        C.setText(options[2]);
        D.setText(options[3]);
    }

}