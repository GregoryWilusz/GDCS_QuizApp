package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the start quiz button is clicked.
     */
    public void goToQuiz(View view) {
        EditText enteredName = (EditText) findViewById(R.id.name_field);
        String userName = enteredName.getText().toString();

        setContentView(R.layout.question_one);
    }

    /**
     * This method is called when the next question button is clicked.
     */
    public void goToSecondQuestion(View view) {
        setContentView(R.layout.question_two);
    }

    /**
     * This method is called when the next question button is clicked.
     */
    public void goToThirdQuestion(View view) {
        setContentView(R.layout.question_three);
    }

    /**
     * This method is called when the next question button is clicked.
     */
    public void goToFourthQuestion(View view) {
        setContentView(R.layout.question_four);
    }

    /**
     * This method is called when the next question button is clicked.
     */
    public void goToFifthQuestion(View view) {
        setContentView(R.layout.question_five);
    }

    /**
     * This method is called when the next question button is clicked.
     */
    public void goToSixthQuestion(View view) {
        setContentView(R.layout.question_six);
    }

    /**
     * This method is called when the 'check the answers' button is clicked.
     */
    public void goToSummary(View view) {
        setContentView(R.layout.summary);
    }

    /**
     * This method is called when the next question button is clicked.
     */
    public void goToHomePage(View view) {
        setContentView(R.layout.activity_main);
    }
}
