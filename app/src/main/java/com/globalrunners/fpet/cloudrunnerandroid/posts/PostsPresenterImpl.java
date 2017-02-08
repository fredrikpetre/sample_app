package com.globalrunners.fpet.cloudrunnerandroid.posts;


import android.util.Log;

import com.globalrunners.fpet.cloudrunnerandroid.model.Post;

import java.util.List;

import rx.Subscriber;

public class PostsPresenterImpl implements PostsPresenter {

    private static final String TAG = "PostsPresenter";

    private PostsView mView;
    private PostsInteractor mPostsInteractor;

    public PostsPresenterImpl(PostsView view) {

        this.mView = view;
        this.mPostsInteractor = new PostsInteractorImpl();
    }


    @Override
    public void fetchPosts() {
        mView.clearList();
        mPostsInteractor.getPosts().subscribe(new Subscriber<List<Post>>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "Posts fetch completed");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, e.getMessage());
                mView.showFetchError();
            }

            @Override
            public void onNext(List<Post> posts) {
                Log.d(TAG, "Successfully fetched posts");

                for(Post post : posts) {
                    mView.addPost(post);
                }
            }
        });
    }

    @Override
    public void onItemClicked(Post post) {
        mPostsInteractor.getPost(post.getId()).subscribe(new Subscriber<Post>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                mView.showFetchError();
            }

            @Override
            public void onNext(Post post) {
                mView.goToSinglePostActivity(post);
            }
        });
    }

    @Override
    public void onDestroy() {
        this.mView = null;
    }


}
