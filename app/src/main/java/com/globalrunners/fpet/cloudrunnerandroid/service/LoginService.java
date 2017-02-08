package com.globalrunners.fpet.cloudrunnerandroid.service;

import com.globalrunners.fpet.cloudrunnerandroid.model.User;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;


public interface LoginService {

    String SERVICE_ENDPOINT = "https://vast-journey-76539.herokuapp.com";

    @GET("/login")
    Observable<User> login(@Query("username") String username, @Query("password") String password);

}
