package com.example.quizzard;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderClass extends RecyclerView.ViewHolder {

    TextView quizQuestion;
    RadioButton choice1, choice2, choice3, choice4;
    RadioGroup radioGroup;
    boolean isBinding;
    public ViewHolderClass(@NonNull View itemView) {
        super(itemView);

        quizQuestion = itemView.findViewById(R.id.itemviewQuestion);
        choice1 = itemView.findViewById(R.id.answer1);
        choice2 = itemView.findViewById(R.id.answer2);
        choice3 = itemView.findViewById(R.id.answer3);
        choice4 = itemView.findViewById(R.id.answer4);
        radioGroup = itemView.findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int position = getAdapterPosition();
                RadioButton radioButton = (RadioButton) group.findViewById(checkedId);
                if (!isBinding) {

                }
            }
        });
    }
}
