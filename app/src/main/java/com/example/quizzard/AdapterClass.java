package com.example.quizzard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<ViewHolderClass> {

    Context context;
    List<Item> items;
    public AdapterClass(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderClass(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderClass holder, int position) {
        Item item = items.get(position);
        holder.isBinding = true;
        holder.quizQuestion.setText(item.getQuestion());
        holder.choice1.setText(item.getChoice1());
        holder.choice2.setText(item.getChoice2());
        holder.choice3.setText(item.getChoice3());
        holder.choice4.setText(item.getChoice4());
        holder.radioGroup.setTag(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
