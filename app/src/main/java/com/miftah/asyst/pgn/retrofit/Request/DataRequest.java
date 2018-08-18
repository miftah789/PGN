package com.miftah.asyst.pgn.retrofit.Request;

import com.miftah.asyst.pgn.model.UserModel;

public class DataRequest {

    String method;
    UserModel param;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public UserModel getParam() {
        return param;
    }

    public void setParam(UserModel param) {
        this.param = param;
    }
}
