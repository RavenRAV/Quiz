package com.example.quiz.quiz.recycler;


import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class QuizViewHolder extends RecyclerView.ViewHolder {

    public QuizViewHolder(@NonNull View itemView) {
        super(itemView);
    }
    interface Listener {
        void onAnswerClick(int selectedAnswerPosition);
    }
}
