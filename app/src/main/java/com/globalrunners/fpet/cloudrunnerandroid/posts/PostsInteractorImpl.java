package com.globalrunners.fpet.cloudrunnerandroid.posts;

import android.util.Log;

import com.globalrunners.fpet.cloudrunnerandroid.model.Post;
import com.globalrunners.fpet.cloudrunnerandroid.service.PostService;
import com.globalrunners.fpet.cloudrunnerandroid.service.ServiceFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class PostsInteractorImpl implements PostsInteractor {
    private final static String TAG = "PostsInteractor";

    private final PostService service = ServiceFactory.createRetrofitService(PostService.class, PostService.SERVICE_ENDPOINT);

    @Override
    public Observable<List<Post>> getPosts() {
        Log.d(TAG, "Fetching posts");
        return service.getPosts()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());

    }

    @Override
    public Observable<Post> getPost(int id) {
        return service.getPost(id)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());

    }

    @Override
    public Observable<String> createPost(Post post) {
        String jsonObject = new Gson().toJson(post);
        System.out.println(jsonObject);
        return service.createPost(new Gson().toJson(post))
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
