package com.globalrunners.fpet.cloudrunnerandroid.login;

import com.globalrunners.fpet.cloudrunnerandroid.model.User;

import rx.Observable;


public interface LoginInteractor {

    Observable<User> login(String username, String password);

    Observable<User> offlineLogin(String username, String password);
}
