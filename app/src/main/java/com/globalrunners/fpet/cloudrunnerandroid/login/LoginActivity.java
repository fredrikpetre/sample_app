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

    private static final String LOGIN_ERROR = "Wrong email or password";
    private static final String TAG = "Login Activity";

    private EditText email;
    private EditText password;

    private Button loginButton;

    private ProgressBar progressBar;

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText)findViewById(R.id.input_email_field);
        password = (EditText)findViewById(R.id.input_password_field);

        loginButton = (Button)findViewById(R.id.button_login);
        loginButton.setOnClickListener(this.loginButtonClickListener);

        progressBar = (ProgressBar)findViewById(R.id.progress_bar);

        presenter = new LoginPresenterImpl(this);

    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        Log.d(TAG, "Show progress bar");
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        Log.d(TAG, "Hide progress bar");
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void showLoginError() {
        Log.d(TAG, "Error logging in");
        Toast.makeText(this, LOGIN_ERROR, Toast.LENGTH_LONG).show();

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
            presenter.validateCredentials(email.getText().toString(), password.getText().toString());
        }
    };
}
