package com.example.animequiz.AllActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.animequiz.QuestionAnswer.Haikyuuqns;
import com.example.animequiz.QuestionAnswer.Narutoqns;
import com.example.animequiz.R;

public class HaikyuuActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView totalQuestionTextView, questions;
    private Button optionA, optionB, optionC, optionD, submitButton;
    private int score = 0;
    private final int questionLength = Haikyuuqns.questions.length;
    private int currentQuestionIndex = 0;
    private String[] selectedAnswer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_haikyuu);

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
        // Initialize the array with the length of the question set
        selectedAnswer = new String[questionLength];

        loadNewQuestion();
    }
    @Override
    public void onClick(View v) {
        resetButtonBackgrounds();
        Button clickedButton = (Button) v;

        if (v.getId() == R.id.submit) {
            if (selectedAnswer[currentQuestionIndex] == null) {
                // Show a warning toast if no answer is selected
                Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show();
                optionA.setBackgroundColor(Color.RED);
                optionB.setBackgroundColor(Color.RED);
                optionC.setBackgroundColor(Color.RED);
                optionD.setBackgroundColor(Color.RED);

            } else {
                if (selectedAnswer[currentQuestionIndex].equals(Narutoqns.correctAnswers[currentQuestionIndex])) {
                    score++;
                }
                if (currentQuestionIndex < questionLength - 1) {
                    currentQuestionIndex++;
                    loadNewQuestion();
                } else {
                    finishQuiz();
                }
            }
        } else {
            selectedAnswer[currentQuestionIndex] = clickedButton.getText().toString();
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
        questions.setText(Haikyuuqns.questions[currentQuestionIndex]);
        optionA.setText(Haikyuuqns.choices[currentQuestionIndex][0]);
        optionB.setText(Haikyuuqns.choices[currentQuestionIndex][1]);
        optionC.setText(Haikyuuqns.choices[currentQuestionIndex][2]);
        optionD.setText(Haikyuuqns.choices[currentQuestionIndex][3]);
    }
    private void finishQuiz() {
        StringBuilder resultMessage = new StringBuilder("Score is " + score + " out of " + questionLength + "\n\n");
        String passStatus = (score >= questionLength / 2) ? "Passed" : "Failed";
        for (int i = 0; i < questionLength; i++) {
            resultMessage.append("\nQuestion ").append(i + 1).append(": ");
            resultMessage.append("Your Answer: ").append(selectedAnswer[i]);
            resultMessage.append(", Correct Answer: ").append(Haikyuuqns.correctAnswers[i]);
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
        Intent haikyuu = new Intent(HaikyuuActivity.this, QuizActivity.class);
        startActivity(haikyuu);
        // Finish the current activity (NarutoActivity)
        finish();
    }
}