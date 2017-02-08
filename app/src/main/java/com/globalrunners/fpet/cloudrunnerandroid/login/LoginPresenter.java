package com.globalrunners.fpet.cloudrunnerandroid.login;


public interface LoginPresenter {

    void validateCredentials(String email, String password);

    void onDestroy();
}
