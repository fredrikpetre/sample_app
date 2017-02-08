package com.globalrunners.fpet.cloudrunnerandroid.service;


import com.globalrunners.fpet.cloudrunnerandroid.model.Post;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface PostService {
    String SERVICE_ENDPOINT = "https://vast-journey-76539.herokuapp.com";

    @GET("/post")
    Observable<List<Post>> getPosts();

    @GET("/post/{id}")
    Observable<Post> getPost(@Path("id") int id);




}
