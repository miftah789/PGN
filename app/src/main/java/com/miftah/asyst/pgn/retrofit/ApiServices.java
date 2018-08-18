package com.miftah.asyst.pgn.retrofit;

import com.miftah.asyst.pgn.retrofit.Request.LoginRequest;
import com.miftah.asyst.pgn.retrofit.Response.DataResponse;
import com.miftah.asyst.pgn.retrofit.Response.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiServices {

    @POST("Login/getProfileInfo")
    Call<LoginResponse> getLogin(@Body LoginRequest loginRequest);

    @GET("Task/getAllTask")
    Call<DataResponse> getData();
}
