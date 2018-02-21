package com.example.manolofernandez.grindrproject.service;

import com.example.manolofernandez.grindrproject.model.QuestionResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by manolofernandez on 1/14/18.
 */

public interface API {
    String BASE_URL = "https://api.stackexchange.com";
    String FORMAT = "json";

    @GET("/2.2/questions?pagesize=20&order=desc&sort=hot&site=stackoverflow")
    Call<QuestionResponse> getTopTwentyHottestQuestions();
}
