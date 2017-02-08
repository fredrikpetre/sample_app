package com.globalrunners.fpet.cloudrunnerandroid.posts;


import com.globalrunners.fpet.cloudrunnerandroid.model.Post;

public interface PostsPresenter {

    void fetchPosts();

    void onItemClicked(Post post);

    void onDestroy();
}
