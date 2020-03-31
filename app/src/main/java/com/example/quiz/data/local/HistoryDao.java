package com.example.quiz.data.local;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.quiz.model.QuizResult;

import java.util.List;

public interface HistoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(QuizResult quizResult);

    @Query("SELECT * FROM quiz_result WHERE id=:id")
    QuizResult get(int id);

    @Delete
    void delete(QuizResult quizResult);

    @Query("SELECT * FROM quiz_result")
    LiveData<List<QuizResult>> getAll();
}
