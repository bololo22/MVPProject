package com.example.manolofernandez.grindrproject.view;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.manolofernandez.grindrproject.R;
import com.example.manolofernandez.grindrproject.model.Item;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by manolofernandez on 1/14/18.
 */

public class QuestionsAdapter extends RecyclerView.Adapter<QuestionsAdapter.ViewHolder> {
    private List<Item> itemList;
    private Context context;

    public QuestionsAdapter(Activity context, List<Item> data) {
        this.itemList = data;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.questions_adapter_item, parent, false);
        return new QuestionsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item item = itemList.get(position);

        holder.textItemTitle.setText(item.getTitle());
        Picasso.with(context).load(item.getOwner().getProfileImage()).resize(100, 100).into(holder.imageItemView);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.textItemTitle)
        TextView textItemTitle;
        @InjectView(R.id.imageItemView)
        ImageView imageItemView;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.inject(this, v);
        }
    }
}
