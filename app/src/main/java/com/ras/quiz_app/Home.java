package com.ras.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home extends AppCompatActivity  implements View.OnClickListener {
    TextView totalNumberofQuestion;
    TextView questionBox;
    Button ans1,ans2,ans3,ans4;
    Button submitBtn;

    int score =0;
    int totalQuestion = Questions.question.length;
    int currentIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();

        totalNumberofQuestion = findViewById(R.id.totalNumberofQuestion);
        questionBox = findViewById(R.id.question_box);
        ans1 = findViewById(R.id.answer_1);
        ans2 = findViewById(R.id.answer_2);
        ans3 = findViewById(R.id.answer_3);
        ans4 = findViewById(R.id.answer_4);
        submitBtn = findViewById(R.id.submit_btn);

        ans1.setOnClickListener(this);
        ans2.setOnClickListener(this);
        ans3.setOnClickListener(this);
        ans4.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        totalNumberofQuestion.setText("Total Number of Question = "+totalQuestion);
        loadNewQuestion();

    }

    @Override
    public void onClick(View view) {
        ans1.setBackgroundColor(Color.WHITE);
        ans2.setBackgroundColor(Color.WHITE);
        ans3.setBackgroundColor(Color.WHITE);
        ans4.setBackgroundColor(Color.WHITE);
        Button clickedButton = (Button) view;
        if (clickedButton.getId() == R.id.submit_btn)
        {

            if (selectedAnswer.equals(Questions.correctAnswer[currentIndex]))
            {
                score++;
            }
            currentIndex++;
            loadNewQuestion();
        }
        else
        {
            //It means options are clicked,,...
            //Here Clicked button text will get and store by selectedAnswer variable
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.GREEN);
        }

    }
    void loadNewQuestion()
    {
        if (currentIndex == totalQuestion)
        {
            finishQuiz();
            return;
        }
        questionBox.setText(Questions.question[currentIndex]);
        ans1.setText(Questions.options[currentIndex][0]);
        ans2.setText(Questions.options[currentIndex][1]);
        ans3.setText(Questions.options[currentIndex][2]);
        ans4.setText(Questions.options[currentIndex][3]);
    }
    void finishQuiz()
    {
        //Mehtod for the Action after the end of QUiz...
        String passStatus = "";
        if (score>totalQuestion*.60)
        {
            passStatus = "Passed !";
        }
        else
        {
            passStatus = "Failed !";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Your total Score of Quiz is "+score+", out of from "
                        +totalQuestion+ " number of Questions")
                .setPositiveButton("Restart", (dialogInterface, i) -> restartQuiz())
                .setCancelable(false)
                .show();
    }
    void restartQuiz()
    {
        score = 0;
        currentIndex = 0;
        loadNewQuestion();
    }
}