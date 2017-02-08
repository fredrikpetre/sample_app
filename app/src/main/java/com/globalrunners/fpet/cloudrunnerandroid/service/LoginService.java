package com.globalrunners.fpet.cloudrunnerandroid.service;

import com.globalrunners.fpet.cloudrunnerandroid.model.User;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;


public interface LoginService {

    String SERVICE_ENDPOINT = "http://url.com";

    @POST("/login")
    Observable<User> login(@Body String user, @Body String password);

}
