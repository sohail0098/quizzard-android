package com.example.quizzard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        int quizSize = 0;
        if (extras != null) {
            quizSize = extras.getInt("QuizSize");
        }
        System.out.println("Quiz Size: " + quizSize);
        Button playagainbtn = findViewById(R.id.playagainbtn);

        playagainbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}