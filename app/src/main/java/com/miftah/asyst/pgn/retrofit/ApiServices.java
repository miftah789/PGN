package com.miftah.asyst.pgn.retrofit;

import com.miftah.asyst.pgn.retrofit.Response.Data;
import com.miftah.asyst.pgn.retrofit.Response.Request.Login;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiServices {

    @POST("Login/getProfileInfo")
    Call<Login> postLogin();

    @GET("Task/getAllTask")
    Call<Data> getData(@Query("api_key") String apiKey, @Query("customer_name") String customer_name, @Query("customer_address") String customer_address);
}
