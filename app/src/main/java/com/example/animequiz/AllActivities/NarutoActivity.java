package com.example.animequiz.AllActivities;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.animequiz.QuestionAnswer.Narutoqns;
import com.example.animequiz.R;

public class NarutoActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView totalQuestionTextView, questions;
    private Button optionA, optionB, optionC, optionD, submitButton;
    private int score = 0;
    private int questionLength = Narutoqns.questions.length;
    private int currentQuestionIndex = 0;
    private String selectedAnswer = "";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naruto);

        totalQuestionTextView = findViewById(R.id.totalQuestion);
        questions = findViewById(R.id.questions);
        optionA = findViewById(R.id.optionA);
        optionB = findViewById(R.id.optionB);
        optionC = findViewById(R.id.optionC);
        optionD = findViewById(R.id.optionD);
        submitButton = findViewById(R.id.submit);

        // Set OnClickListener for the buttons
        optionA.setOnClickListener(this);
        optionB.setOnClickListener(this);
        optionC.setOnClickListener(this);
        optionD.setOnClickListener(this);
        submitButton.setOnClickListener(this);

        totalQuestionTextView.setText("Total Questions: " + questionLength);

        loadNewQuestion();
    }
    @Override
    public void onClick(View v) {
        resetButtonBackgrounds();
        Button clickedButton = (Button) v;

        if (v.getId() == R.id.submit) {
            if (selectedAnswer.equals(Narutoqns.correctAnswers[currentQuestionIndex])) {
                score++;
            }
            if (currentQuestionIndex < questionLength - 1) {
                currentQuestionIndex++;
                loadNewQuestion();
            } else {
                finishQuiz();
            }
        } else {
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.GREEN);
        }
    }
    private void resetButtonBackgrounds() {
        optionA.setBackgroundColor(Color.WHITE);
        optionB.setBackgroundColor(Color.WHITE);
        optionC.setBackgroundColor(Color.WHITE);
        optionD.setBackgroundColor(Color.WHITE);
    }
    private void loadNewQuestion() {
        if (currentQuestionIndex == questionLength) {
            finishQuiz();
            return;
        }
        questions.setText(Narutoqns.questions[currentQuestionIndex]);
        optionA.setText(Narutoqns.choices[currentQuestionIndex][0]);
        optionB.setText(Narutoqns.choices[currentQuestionIndex][1]);
        optionC.setText(Narutoqns.choices[currentQuestionIndex][2]);
        optionD.setText(Narutoqns.choices[currentQuestionIndex][3]);
    }
    private void finishQuiz() {
        StringBuilder resultMessage = new StringBuilder("Score is " + score + " out of " + questionLength + "\n\n");
        String passStatus = (currentQuestionIndex >= questionLength / 2) ? "Passed" : "Failed";

        for (int i = 0; i < questionLength; i++) {
            resultMessage.append("\nQuestion ").append(i + 1).append(": ");
            resultMessage.append("Your Answer: ").append(selectedAnswer);
            resultMessage.append(", Correct Answer: ").append(Narutoqns.correctAnswers[i]);
        }
        // Log information for debugging
        Log.d("Quiz", "Finish Quiz - Status: " + passStatus + ", Score: " + score + "/" + questionLength);

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage(resultMessage.toString())
                .setPositiveButton("Restart", (dialogInterface, i) -> restartQuiz())
                .setCancelable(false)
                .show();
    }
    private void restartQuiz() {
        score = 0;
        currentQuestionIndex = 0;
        // Start QuizActivity
        Intent intent = new Intent(NarutoActivity.this, QuizActivity.class);
        startActivity(intent);
        // Finish the current activity (NarutoActivity)
        finish();
    }
}