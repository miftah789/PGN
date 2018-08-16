package com.miftah.asyst.pgn.retrofit.Response;

import com.miftah.asyst.pgn.model.LoginModel;

public class Data {

    String status;
    String message;
    LoginModel param;

    public Data(String status, String message, LoginModel param) {
        this.status = status;
        this.message = message;
        this.param = param;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LoginModel getParam() {
        return param;
    }

    public void setParam(LoginModel param) {
        this.param = param;
    }
}
