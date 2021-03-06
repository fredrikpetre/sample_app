package com.globalrunners.fpet.cloudrunnerandroid.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.globalrunners.fpet.cloudrunnerandroid.R;
import com.globalrunners.fpet.cloudrunnerandroid.posts.PostsActivity;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private static final String TAG = "LoginActivity";

    private EditText mEmail;
    private EditText mPassword;

    private Button mLoginButton;

    private ProgressBar mProgressBar;

    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();

        mPresenter = new LoginPresenterImpl(this);
    }

    private void initViews() {
        mEmail = (EditText) findViewById(R.id.input_email_field);
        mPassword = (EditText) findViewById(R.id.input_password_field);

        mLoginButton = (Button) findViewById(R.id.button_login);
        mLoginButton.setOnClickListener(this.loginButtonClickListener);

        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);

    }

    @Override
    protected void onDestroy() {
        mPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        Log.d(TAG, "Show progress bar");
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        Log.d(TAG, "Hide progress bar");
        mProgressBar.setVisibility(View.GONE);

    }

    @Override
    public void showLoginError() {
        Log.d(TAG, "Error logging in");
        Toast.makeText(this, R.string.login_error, Toast.LENGTH_LONG).show();

    }

    @Override
    public void navigateToPosts() {
        Log.d(TAG, "Navigate to home activity called");
        startActivity(new Intent(this, PostsActivity.class));
        finish();
    }

    private View.OnClickListener loginButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.d(TAG, "Login button clicked");
            mPresenter.validateCredentials(mEmail.getText().toString(), mPassword.getText().toString());
        }
    };
}
