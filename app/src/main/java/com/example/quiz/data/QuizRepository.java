package com.example.quiz.data;

import com.example.quiz.data.local.HistoryStorage;
import com.example.quiz.data.remote.IQuizApiClient;
import com.example.quiz.data.remote.QuizApiClient;

public class QuizRepository {
    private HistoryStorage localDataSource;
    private QuizApiClient remoteDataSource;

    public QuizRepository(HistoryStorage localDataSource, QuizApiClient remoteDataSource){
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    public void getQuestions(IQuizApiClient.QuestionsCallback callback){
        remoteDataSource.getQuestions(callback);
    }
}
