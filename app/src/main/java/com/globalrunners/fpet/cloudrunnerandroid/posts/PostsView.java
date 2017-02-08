package com.globalrunners.fpet.cloudrunnerandroid.posts;

import com.globalrunners.fpet.cloudrunnerandroid.model.Post;


public interface PostsView {

    void addPost(Post post);

    void showFetchError();

    void clearList();

    void goToSinglePostActivity(Post post);
}
