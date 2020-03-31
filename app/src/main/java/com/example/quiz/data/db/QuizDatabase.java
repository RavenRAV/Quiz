package com.example.quiz.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.quiz.data.local.HistoryDao;
import com.example.quiz.model.QuizResult;

@Database(
        entities = {QuizResult.class},
        version = 1,
        exportSchema = false
)
public abstract class QuizDatabase extends RoomDatabase {
    public abstract HistoryDao historyDao();
}
