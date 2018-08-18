package com.miftah.asyst.pgn.retrofit.Request;

import com.google.gson.annotations.SerializedName;
import com.miftah.asyst.pgn.model.LoginModel;

public class LoginRequest {

    @SerializedName("method")
    String method;
    @SerializedName("param")
    LoginModel param;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public LoginModel getParam() {
        return param;
    }

    public void setParam(LoginModel param) {
        this.param = param;
    }
}
