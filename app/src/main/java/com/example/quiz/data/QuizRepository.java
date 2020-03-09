package com.example.quiz.data;

import com.example.quiz.data.local.QuizLocalDataSource;
import com.example.quiz.data.remote.QuizApiClient;

public class QuizRepository {
    private QuizLocalDataSource localDataSource;
    private QuizApiClient remoteDataSource;

    public QuizRepository(QuizLocalDataSource localDataSource, QuizApiClient remoteDataSource){
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }
}
