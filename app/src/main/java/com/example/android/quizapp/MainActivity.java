package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ViewAnimator;

public class MainActivity extends AppCompatActivity {

    EditText enteredName;
    ViewAnimator viewAnimator;
    Button  goBackToFirstQuestion, goToSecondQuestion, goBackToSecondQuestion, goToThirdQuestion,
            goToFourthQuestion, goBackToThirdQuestion, goToFifthQuestion, goBackToFourthQuestion, goToSixthQuestion,
            goBackToFifthQuestion, goToSummary;
    Animation animationIn, animationOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewAnimator = findViewById(R.id.viewAnimator);
        goBackToFirstQuestion = findViewById(R.id.goBackToFirstQuestion);
        goToSecondQuestion = findViewById(R.id.goToSecondQuestion);
        goToThirdQuestion = findViewById(R.id.goToThirdQuestion);
        goBackToSecondQuestion = findViewById(R.id.goBackToSecondQuestion);
        goToFourthQuestion = findViewById(R.id.goToFourthQuestion);
        goBackToThirdQuestion = findViewById(R.id.goBackToThirdQuestion);
        goToFifthQuestion = findViewById(R.id.goToFifthQuestion);
        goBackToFourthQuestion = findViewById(R.id.goBackToFourthQuestion);
        goToSixthQuestion = findViewById(R.id.goToSixthQuestion);
        goBackToFifthQuestion = findViewById(R.id.goBackToFifthQuestion);
        goToSummary = findViewById(R.id.goToSummary);


        animationIn = AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.slide_in_left);
        animationOut = AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.slide_out_right);

        viewAnimator.setInAnimation(animationIn);
        viewAnimator.setOutAnimation(animationOut);

//        goToSecondQuestion.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                viewAnimator.showNext();
//            }
//        });
//
//        goBackToFirstQuestion.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                viewAnimator.showPrevious();
//            }
//        });
//
//        goToThirdQuestion.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                viewAnimator.showNext();
//            }
//        });
//
//        goBackToSecondQuestion.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                viewAnimator.showPrevious();
//            }
//        });
//
//        goToFourthQuestion.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                viewAnimator.showNext();
//            }
//        });
//
//        goBackToThirdQuestion.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                viewAnimator.showPrevious();
//            }
//        });
//
//        goToFifthQuestion.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                viewAnimator.showNext();
//            }
//        });
//
//        goBackToFourthQuestion.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                viewAnimator.showPrevious();
//            }
//        });
//
//        goToSixthQuestion.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                viewAnimator.showNext();
//            }
//        });
//
//        goBackToFifthQuestion.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                viewAnimator.showPrevious();
//            }
//        });

        goToSummary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewAnimator.showNext();
            }
        });
    }

    public void goNext(View view) {
        viewAnimator.showNext();
    }

    public void goBack(View view) {
        viewAnimator.showPrevious();
    }

    /**
     * This method checks if the name is provided.
     */
    public void isNameProvided(View view) {
        enteredName = (EditText) findViewById(R.id.name_field);
        if (enteredName.getText().toString().equals("")) {
            Toast.makeText(this, getString(R.string.toast_no_name), Toast.LENGTH_SHORT).show();
            return;
        } else {
            viewAnimator.showNext();
        }
    }

    /**
     * This method checks which answers are correct and counts them.
     */
    public void checkTheAnswers(View view) {
        int correctAnswersCounter = 0;

        RadioButton allTimeDHWinner = findViewById(R.id.q1b);
        if (allTimeDHWinner.isChecked()) {
            correctAnswersCounter ++;
        }

        RadioButton maxSpeedRecorded = findViewById(R.id.q2c);
        if (maxSpeedRecorded.isChecked()) {
            correctAnswersCounter ++;
        }

        RadioButton theGradient = findViewById(R.id.q3d);
        if (theGradient.isChecked()) {
            correctAnswersCounter ++;
        }

        CheckBox overallTitles = (CheckBox) findViewById(R.id.overallTitles);
        CheckBox goldOlympic = (CheckBox) findViewById(R.id.goldOlympic);
        CheckBox goldWC = (CheckBox) findViewById(R.id.goldWC);
        if (overallTitles.isChecked() && goldOlympic.isChecked() && goldWC.isChecked()) {
            correctAnswersCounter ++;
        }

        RadioButton accelerateTime = findViewById(R.id.q5b);
        if (accelerateTime.isChecked()) {
            correctAnswersCounter ++;
        }

        EditText countryWithFirstRace = (EditText) findViewById(R.id.q6);
        if (countryWithFirstRace.getText().equals("sweden")) {
            correctAnswersCounter ++;
        }

        showSummary(correctAnswersCounter, enteredName);
    }

    public void showSummary(int score, EditText name) {
        Toast.makeText(this, name + ": you answered " + score + "/6 questions correctly!", Toast.LENGTH_SHORT).show();
    }

    /**
     * This method clear the enteredName and return to default View.
     */
    public void startAgain(View view) {
        enteredName.setText("");
        viewAnimator.setDisplayedChild(0);

    }

}


