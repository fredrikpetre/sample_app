package com.globalrunners.fpet.cloudrunnerandroid.login;


import android.util.Log;

import com.globalrunners.fpet.cloudrunnerandroid.model.User;

import rx.Subscriber;


public class LoginPresenterImpl implements LoginPresenter{

    private static final String TAG = "LoginPresenter";

    private LoginView mView;
    private LoginInteractor mInteractor;

    public LoginPresenterImpl(LoginView loginView) {
        this.mView = loginView;
        this.mInteractor = new LoginInteractorImpl();
    }


    @Override
    public void validateCredentials(String email, String password) {
        Log.d(TAG, "Validate credentials");

        mView.showProgress();

        //TODO: use real login
        mInteractor.offlineLogin(email, password)
                .subscribe(new Subscriber<User>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.hideProgress();
                        mView.showLoginError();
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(User user) {
                        //TODO: store user data
                        mView.hideProgress();
                        mView.navigateToPosts();
                    }
                });

    }

    @Override
    public void onDestroy() {
        mView = null;
    }
}
