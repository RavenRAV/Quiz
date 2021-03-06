package com.example.quiz.data.remote;

import com.example.quiz.core.CoreCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class QuizApiClient implements IQuizApiClient{

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://opentdb.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private QuizApi client = retrofit.create(QuizApi.class);

    @Override
    public void getQuestions(final QuestionsCallback callback){
        Call<QuestionsResponse> call = client.getQuestions(5, null, "any");

        call.enqueue(new CoreCallback<QuestionsResponse>() {
            @Override
            public void onSuccess(QuestionsResponse result) {
                callback.onSuccess(result.getResults());
            }

            @Override
            public void onFailure(Exception e) {
                callback.onFailure(e);
            }
        });

//        call.enqueue(new Callback<QuestionsResponse>() {
//            @Override
//            public void onResponse(Call<QuestionsResponse> call, Response<QuestionsResponse> response) {
//                if(response.isSuccessful()){
//                    if(response.body() != null){
//                        callback.onSuccess(response.body().getResults());
//                    }else {
//                        callback.onFailure(new Exception("Body is empty"));
//                    }
//                }else {
//                    callback.onFailure(new Exception("Response error: "+ response.code()));
//                }
//            }
//
//            @Override
//            public void onFailure(Call<QuestionsResponse> call, Throwable t) {
//                callback.onFailure(new Exception(t));
//            }
//        });
    }


    private interface QuizApi{
        @GET("/api.php")
        Call<QuestionsResponse>getQuestions(
                @Query("amount") int amount,
                @Query("category")Integer category,
                @Query("difficulty")String difficulty


        );

    @GET("/api_category.php")
    Call<QuestionsResponse>categoryLookup();

    @GET("/api_count.php")
        Call<QuestionsResponse>categoryQuestionCountLookup(
                @Query("category")Integer categoryId
    );

    @GET("/api_count_global.php")
        Call<QuestionsResponse>globalQuestionCountLookup();

    }
}
