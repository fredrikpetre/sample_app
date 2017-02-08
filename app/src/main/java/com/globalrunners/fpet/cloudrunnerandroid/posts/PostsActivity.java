package com.globalrunners.fpet.cloudrunnerandroid.posts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.globalrunners.fpet.cloudrunnerandroid.R;
import com.globalrunners.fpet.cloudrunnerandroid.adapter.CardAdapter;
import com.globalrunners.fpet.cloudrunnerandroid.model.Post;
import com.globalrunners.fpet.cloudrunnerandroid.singlepost.SinglePostActivity;

public class PostsActivity extends AppCompatActivity implements PostsView{


    private static final String TAG = "PostsActivity";
    RecyclerView mRecyclerView;
    Button refreshButton;
    CardAdapter mCardAdapter;

    PostsPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mPresenter = new PostsPresenterImpl(this);

        mCardAdapter = new CardAdapter(mPresenter);
        mRecyclerView.setAdapter(mCardAdapter);

        refreshButton = (Button) findViewById(R.id.refresh_button);
        refreshButton.setOnClickListener(this.refreshButtonClickListener);


        mPresenter.fetchPosts();
    }


    private View.OnClickListener refreshButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.d(TAG, "Fetch posts button clicked");
            mPresenter.fetchPosts();
        }
    };



    @Override
    public void addPost(Post post) {
        mCardAdapter.addData(post);
    }

    @Override
    public void showFetchError() {
        Toast.makeText(this, "No posts found", Toast.LENGTH_LONG).show();
    }

    @Override
    public void clearList() {
        mCardAdapter.clear();
    }

    @Override
    public void goToSinglePostActivity(Post post) {

        Log.d(TAG, "TITLE: " + post.getTitle());
        Intent intent = new Intent(this, SinglePostActivity.class);
        intent.putExtra("post", post);
        startActivity(intent);
    }


}
