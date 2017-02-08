package com.globalrunners.fpet.cloudrunnerandroid.login;

import com.globalrunners.fpet.cloudrunnerandroid.model.User;

import rx.Observable;

/**
 * Created by fpet on 08/02/2017.
 */

public interface LoginInteractor {

    Observable<User> login(String username, String password);

    Observable<User> offlineLogin(String username, String password);
}
