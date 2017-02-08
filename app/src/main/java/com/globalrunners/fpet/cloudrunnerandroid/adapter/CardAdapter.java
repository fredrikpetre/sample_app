package com.globalrunners.fpet.cloudrunnerandroid.adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.globalrunners.fpet.cloudrunnerandroid.R;
import com.globalrunners.fpet.cloudrunnerandroid.model.Post;
import com.globalrunners.fpet.cloudrunnerandroid.posts.PostsPresenter;
import com.globalrunners.fpet.cloudrunnerandroid.singlepost.SinglePostActivity;


import java.util.ArrayList;
import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    private List<Post> mItems;
    private PostsPresenter mPresenter;

    public CardAdapter(PostsPresenter presenter) {
        super();
        mItems = new ArrayList<>();
        mPresenter = presenter;
    }

    public void addData(Post post) {
        mItems.add(post);
        notifyDataSetChanged();
    }

    public void clear() {
        mItems.clear();
        notifyDataSetChanged();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Post post = mItems.get(position);
        holder.title.setText(post.getTitle());
        holder.text.setText(post.getText());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.onItemClicked(post);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView text;

        ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.card_title);
            text = (TextView) itemView.findViewById(R.id.card_text);
        }
    }
}
