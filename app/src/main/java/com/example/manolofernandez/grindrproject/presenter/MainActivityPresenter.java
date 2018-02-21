package com.example.manolofernandez.grindrproject.presenter;

import com.example.manolofernandez.grindrproject.model.Item;
import com.example.manolofernandez.grindrproject.model.QuestionResponse;
import com.example.manolofernandez.grindrproject.service.API;
import com.example.manolofernandez.grindrproject.view.MainActivityView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by manolofernandez on 1/14/18.
 */

public class MainActivityPresenter implements Presenter{
    private API serviceCall;
    private MainActivityView mainActivityView;
    private List<Item> itemList;

    public MainActivityPresenter(MainActivityView mainActivityView){
        this.mainActivityView = mainActivityView;
    }

    @Override
    public void getQuestionsList() {
        createStackoverflowAPI();

        Call<QuestionResponse> responseCall = serviceCall.getTopTwentyHottestQuestions();

        responseCall.enqueue(new Callback<QuestionResponse>() {
            @Override
            public void onResponse(Call<QuestionResponse> call, Response<QuestionResponse> response) {
                if(response != null && response.body() != null) {
                    itemList = response.body().getItems();
                    mainActivityView.showQuestionsList(itemList);
                }else{
                }
            }

            @Override
            public void onFailure(Call<QuestionResponse> call, Throwable t) {
                mainActivityView.showCallFailed();
            }
        });
    }

    private void createStackoverflowAPI() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        serviceCall = retrofit.create(API.class);
    }
}
