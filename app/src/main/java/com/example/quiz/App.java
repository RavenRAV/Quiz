package com.example.quiz;

import android.app.Application;

import com.example.quiz.data.QuizRepository;
import com.example.quiz.data.local.QuizLocalDataSource;
import com.example.quiz.data.remote.QuizApiClient;

public class App extends Application {
    public static QuizRepository quizRepository;

    @Override
    public void onCreate() {
        super.onCreate();
        quizRepository = new QuizRepository(
                new QuizLocalDataSource(),
                new QuizApiClient());
    }
}
