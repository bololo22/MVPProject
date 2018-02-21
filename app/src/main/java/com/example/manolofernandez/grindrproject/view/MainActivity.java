package com.example.manolofernandez.grindrproject.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.manolofernandez.grindrproject.R;
import com.example.manolofernandez.grindrproject.model.Item;
import com.example.manolofernandez.grindrproject.presenter.MainActivityPresenter;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity implements MainActivityView {
    QuestionsAdapter questionsAdapter;
    MainActivityPresenter presenter;
    @InjectView(R.id.questionsRecyclerView)
    RecyclerView questionsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = getLayoutInflater().inflate(R.layout.activity_main, null);
        ButterKnife.inject(this, view);
        setContentView(view);

        presenter = new MainActivityPresenter(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.getQuestionsList();
    }

    @Override
    public void showQuestionsList(List<Item> itemList) {
        questionsAdapter = new QuestionsAdapter(this, itemList);
        questionsRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        questionsRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        questionsRecyclerView.setAdapter(questionsAdapter);
    }

    @Override
    public void showCallFailed() {
        Toast.makeText(this, "Call FAILED", Toast.LENGTH_LONG);
    }
}
