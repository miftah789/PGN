package com.miftah.asyst.pgn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.miftah.asyst.pgn.model.LoginModel;
import com.miftah.asyst.pgn.retrofit.ApiClient;
import com.miftah.asyst.pgn.retrofit.ApiServices;
import com.miftah.asyst.pgn.retrofit.Request.LoginRequest;
import com.miftah.asyst.pgn.retrofit.Response.LoginResponse;
import com.miftah.asyst.pgn.utility.SessionUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etUsername, etPassword;
    Button btnLogin;

    LoginModel loginModel = new LoginModel();
    String username, password;
    SessionUtil sessionUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessionUtil = new SessionUtil(this);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);

        saveLogin();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                if (TextUtils.isEmpty(etUsername.getText())) {
                    etUsername.setError("Input Username");
                } else if (TextUtils.isEmpty(etPassword.getText())) {
                    etUsername.setError("Input Password");
                } else {
                    requestLogin();
                }
                break;
        }
    }

    public void requestLogin() {

        LoginRequest loginRequest = new LoginRequest();
        final LoginModel login = new LoginModel();
        username = etUsername.getText().toString();
        password = etPassword.getText().toString();
        loginRequest.setMethod("getProfileInfo");
        login.setUsername(username);
        login.setPassword(password);
        loginRequest.setParam(login);

        ApiServices apiServices = ApiClient.newInstance(getApplicationContext()).create(ApiServices.class);
        Call<LoginResponse> call = apiServices.getLogin(loginRequest);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.body().getStatus().equalsIgnoreCase("success")) {
                    Toast.makeText(getApplicationContext(), "hello " + username, Toast.LENGTH_SHORT).show();
                    sessionUtil.saveUsername(username);
                    sessionUtil.savePassword(password);
                    Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Username/Password Salah", Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }

    private void saveLogin() {
        if (!sessionUtil.loadUsername().equalsIgnoreCase("")) {
            Toast.makeText(getApplicationContext(), "hello " + sessionUtil.loadUsername(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
