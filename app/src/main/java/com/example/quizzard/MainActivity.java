package com.example.quizzard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InputStream is = getResources().openRawResource(R.raw.questionbank);
        Scanner scanner = new Scanner(is);

        RecyclerView quizRecycler = findViewById(R.id.quizRecycler);
        List<Item> items = new ArrayList<>();

        while(scanner.hasNextLine()) {
            String[] words = scanner.nextLine().split("\\|");
            String question = words[0];
            String choice1 = words[1];
            String choice2 = words[2];
            String choice3 = words[3];
            String choice4 = words[4];
            String answer = words[5].replace("A##","");
            items.add(new Item(question, choice1, choice2, choice3, choice4, answer));
        }

        quizRecycler.setLayoutManager(new LinearLayoutManager(this));
        quizRecycler.setAdapter(new AdapterClass(getApplicationContext(), items));

        Button submitbtn = findViewById(R.id.submitbtn);
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ResultActivity.class);
                i.putExtra("QuizSize", items.size());
                startActivity(i);
            }
        });
    }
}