package com.globalrunners.fpet.cloudrunnerandroid.login;

import com.globalrunners.fpet.cloudrunnerandroid.model.User;
import com.globalrunners.fpet.cloudrunnerandroid.service.LoginService;
import com.globalrunners.fpet.cloudrunnerandroid.service.ServiceFactory;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class LoginInteractorImpl implements LoginInteractor {

    private final LoginService service = ServiceFactory.createRetrofitService(LoginService.class, LoginService.SERVICE_ENDPOINT);

    @Override
    public Observable<User> login(String username, String password) {
        return service.login(username, password)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<User> offlineLogin(String username, String password) {
        return Observable.just(new User("Bob", "password123", "f7ba4eb0-edfa-11e6-bc64-92361f002671"));
    }
}
