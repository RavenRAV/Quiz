package com.example.quiz;

import android.app.Application;

import androidx.room.Room;

import com.example.quiz.data.QuizRepository;
import com.example.quiz.data.db.QuizDatabase;
import com.example.quiz.data.local.HistoryStorage;
import com.example.quiz.data.remote.QuizApiClient;

public class App extends Application {
    public static QuizDatabase quizDatabase;
    public static QuizRepository quizRepository;

    @Override
    public void onCreate() {
        super.onCreate();
        quizRepository = new QuizRepository(
                new HistoryStorage(quizDatabase.historyDao()),
                new QuizApiClient());

        quizDatabase = Room.databaseBuilder(
                this,
                QuizDatabase.class,
                "quiz"
        ).fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }
}
