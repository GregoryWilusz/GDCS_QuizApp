package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewAnimator;

public class MainActivity extends AppCompatActivity {

    EditText enteredName, countryFirst;
    ViewAnimator viewAnimator;
    Animation animationIn, animationOut;
    int correctAnswersCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewAnimator = findViewById(R.id.viewAnimator);

        animationIn = AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.slide_in_left);
        animationOut = AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.slide_out_right);

        viewAnimator.setInAnimation(animationIn);
        viewAnimator.setOutAnimation(animationOut);
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

    public void saveSixAnswerAndGoNext(View view) {
        countryFirst = (EditText) findViewById(R.id.q6);
        checkTheAnswers();
        summarize();
        viewAnimator.showNext();

        TextView summaryText = (TextView) findViewById(R.id.summaryText);
        summaryText.setText(String.format("%s: you answered %d/6 questions correctly!", enteredName, correctAnswersCounter));
    }

    public void summarize() {
        Toast.makeText(this, enteredName + ": you answered " + correctAnswersCounter + "/6 questions correctly!", Toast.LENGTH_LONG).show();
    }

    public void goNext(View view) {
        viewAnimator.showNext();
    }

    public void goBack(View view) {
        viewAnimator.showPrevious();
    }

    /**
     * This method checks which answers are correct and counts them.
     */
    public int checkTheAnswers() {
        correctAnswersCounter = 0;

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

        if (countryFirst.getText().toString().toLowerCase().equals("sweden")) {
            correctAnswersCounter ++;
        }

        return correctAnswersCounter;
    }

    public void clearData() {
        enteredName.setText("");
        countryFirst.setText("");
        RadioGroup radioGroupQ1 = (RadioGroup) findViewById(R.id.qOneRadioGroup);
        RadioGroup radioGroupQ2 = (RadioGroup) findViewById(R.id.qTwoRadioGroup);
        RadioGroup radioGroupQ3 = (RadioGroup) findViewById(R.id.qThreeRadioGroup);
        RadioGroup radioGroupQ5 = (RadioGroup) findViewById(R.id.qFiveRadioGroup);
        radioGroupQ1.clearCheck();
        radioGroupQ2.clearCheck();
        radioGroupQ3.clearCheck();
        radioGroupQ5.clearCheck();

        LinearLayout checkBoxesContainer = (LinearLayout) findViewById(R.id.checkBoxesContainer);
        for (int i = 0; i < checkBoxesContainer.getChildCount(); i++) {
            View checkBoxesContainerChild = checkBoxesContainer.getChildAt(i);
            if (checkBoxesContainerChild instanceof CheckBox) {
                ((CheckBox) checkBoxesContainerChild).setChecked(false);
            }
        }
    }

    /**
     * This method clear the enteredName and return to default View.
     */
    public void startAgain(View view) {
        clearData();
        viewAnimator.setDisplayedChild(0);
    }

}


