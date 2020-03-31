package com.example.quiz.data.local;

import com.example.quiz.model.QuizResult;

public class HistoryStorage {
    private HistoryDao mHistoryDao;

    public HistoryStorage(HistoryDao historyDao) {
        this.mHistoryDao = historyDao;
    }

    void saveQuizResult(QuizResult quizResult) {
        mHistoryDao.insert(quizResult);
    }
}
