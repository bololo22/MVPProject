package com.example.manolofernandez.grindrproject.view;

import com.example.manolofernandez.grindrproject.model.Item;

import java.util.List;

/**
 * Created by manolofernandez on 1/14/18.
 */

public interface MainActivityView {
    void showQuestionsList(List<Item> itemList);
    void showCallFailed();
}
