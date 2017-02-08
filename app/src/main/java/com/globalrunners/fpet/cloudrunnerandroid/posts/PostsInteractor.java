package com.globalrunners.fpet.cloudrunnerandroid.posts;


import com.globalrunners.fpet.cloudrunnerandroid.model.Post;

import java.util.List;

import rx.Observable;

public interface PostsInteractor {

    Observable<List<Post>> getPosts();

    Observable<Post> getPost(int id);

    Observable<String> createPost(Post post);
}
