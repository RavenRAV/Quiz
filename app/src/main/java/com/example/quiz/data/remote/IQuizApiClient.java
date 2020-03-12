package com.example.quiz.data.remote;

import com.example.quiz.model.Question;

import java.util.List;

public interface IQuizApiClient {
    void getQuestions(QuestionsCallback callback);

    interface QuestionsCallback{
        void onSuccess(List<Question>questions);

        void onFailure(Exception e);
    }
}
