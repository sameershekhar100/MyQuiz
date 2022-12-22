package com.example.ibratquizassignment;

public class QuestionAnswer {

    public static String[] question ={
            "Which company owns the android?",
            "What is the capital of india?",
            "Who is the father of android?",
            "Will I be selected for the interview"
    };

    public static String[][] choices = {
            {"Google","Apple","Nokia","Samsung"},
            {"Bangalore","Mumbai","Chennai","Delhi"},
            {"Tim Berners-Lee","Andy Rubin","Steve Jobs","Riyan Parag"},
            {"Yes","Yes","Yes","Yes"}
    };

    public static String[] correctAnswers = {
            "Google",
            "Delhi",
            "Andy Rubin",
            "Yes"
    };
    public static int[] imageOptions={
            R.drawable.android_logo,
            R.drawable.india_gate,
            R.drawable.andy_rubin,
            R.drawable.happy_face
    };
}
