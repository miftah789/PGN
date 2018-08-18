package com.miftah.asyst.pgn.retrofit.Response;

import com.miftah.asyst.pgn.model.DataModel;

import java.util.ArrayList;

public class DataResponse {

    String status;
    String message;
    ArrayList<DataModel> data;

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

    public ArrayList<DataModel> getData() {
        return data;
    }

    public void setData(ArrayList<DataModel> data) {
        this.data = data;
    }
}
