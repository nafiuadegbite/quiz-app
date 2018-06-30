package com.example.android.quizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

    public class MainActivity extends AppCompatActivity {
        private static final String LOG_TAG = MainActivity.class.getSimpleName();
        // Question 1
        RadioButton question1_choice3;
        // Question 2
        EditText question2_answer;
        // Question 3
        CheckBox question3_choice1;
        CheckBox question3_choice2;
        CheckBox question3_choice3;
        CheckBox question3_choice4;
        // Question 4
        EditText question4_answer;
        // Question 5
        RadioButton question5_choice2;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            // Hide the keyboard
            this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
            setContentView(R.layout.activity_main);
        }


        public void submitAnswers(View view) {
            CharSequence resultsDisplay;
            Log.e(LOG_TAG, " " + this.findViewById(R.id.question3_choice3));
            int answer1_score;
            int answer2_score;
            int answer3_score;
            int answer4_score;
            int answer5_score;
            int final_score;

            //------------------------------------------------------------------------------------------
            // Question 1 - Correct Answer is #3 (Herbert Macauly)
            //------------------------------------------------------------------------------------------
            Boolean answer1;

            question1_choice3 = (RadioButton) this.findViewById(R.id.question1_choice3);
            answer1 = question1_choice3.isChecked();
            if (answer1) {
                answer1_score = 2;
            } else {
                answer1_score = 0;
            }
            //------------------------------------------------------------------------------------------
            // Question 2 - Correct Answer is "Abuja"
            //------------------------------------------------------------------------------------------
            String answer2;
            question2_answer = (EditText) this.findViewById(R.id.question2_answer);
            answer2 = question2_answer.getText().toString().toLowerCase();
            if (answer2.equals("Abuja")) {
                answer2_score = 2;
            } else {
                answer2_score = 0;
            }
            //------------------------------------------------------------------------------------------
            // Question 3  - Correct Answers are #1 (Strength) and #3 (Dignity)
            //------------------------------------------------------------------------------------------
            Boolean answer3_choice1;
            Boolean answer3_choice2;
            Boolean answer3_choice3;
            Boolean answer3_choice4;
            question3_choice1 = (CheckBox) this.findViewById(R.id.question3_choice1);
            question3_choice2 = (CheckBox) this.findViewById(R.id.question3_choice2);
            question3_choice3 = (CheckBox) this.findViewById(R.id.question3_choice3);
            question3_choice4 = (CheckBox) this.findViewById(R.id.question3_choice4);
            answer3_choice1 = question3_choice1.isChecked();
            answer3_choice2 = question3_choice2.isChecked();
            answer3_choice3 = question3_choice3.isChecked();
            answer3_choice4 = question3_choice4.isChecked();
            if (answer3_choice1 && !answer3_choice2 && answer3_choice3 && !answer3_choice4) {
                answer3_score = 2;
            } else {
                answer3_score = 0;
            }
            //------------------------------------------------------------------------------------------
            // Question 4 - Correct Answer is "Muhammadu Buhari"
            //------------------------------------------------------------------------------------------
            String answer4;
            question4_answer = (EditText) this.findViewById(R.id.question4_answer);
            answer4 = question4_answer.getText().toString().toLowerCase();
            if (answer4.equals("Muhammadu Buhari")) {
                answer4_score = 2;
            } else {
                answer4_score = 0;
            }
            //------------------------------------------------------------------------------------------
            // Question 5  - Correct Answers is #2 "1914"
            //------------------------------------------------------------------------------------------
            Boolean answer5;
            question5_choice2 = (RadioButton) this.findViewById(R.id.question5_choice2);
            answer5 = question5_choice2.isChecked();
            if (answer5) {
                answer5_score = 2;
            } else {
                answer5_score = 0;
            }
            //------------------------------------------------------------------------------------------
            // Final Score
            //------------------------------------------------------------------------------------------
            final_score = answer1_score + answer2_score + answer3_score + answer4_score + answer5_score;

            if (final_score == 10) {
                resultsDisplay = "Perfect! You scored 10 out of 10";
            } else {
                resultsDisplay = "Try again. You scored " + final_score + " out of 10";
            }

            Context context = getApplicationContext();
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, resultsDisplay, duration);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
}
