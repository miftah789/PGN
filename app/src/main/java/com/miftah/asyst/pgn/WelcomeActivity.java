package com.miftah.asyst.pgn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.miftah.asyst.pgn.retrofit.ApiClient;
import com.miftah.asyst.pgn.retrofit.ApiServices;
import com.miftah.asyst.pgn.retrofit.Response.Data;

import retrofit2.Call;
import retrofit2.Callback;

public class WelcomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        recyclerView = findViewById(R.id.recycleview);
    }

    public void getDataWithRetrofit() {

        ApiServices apiServices = ApiClient.newInstance(getApplicationContext()).create(ApiServices.class);

        Call<Data> call = apiServices.getMovies(Constant.KEY_API, year, pages, sortBy);

        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, retrofit2.Response<MovieResponse> response) {
                progressBar.setVisibility(View.INVISIBLE);
                if (response.body() != null) {
                    if (response.body().getResults().size() > 0) {
                        totalPages = response.body().getTotalPages();
                        pages = response.body().getPage() + 1;
                        listMovie.addAll(response.body().getResults());
                        movieAdapter.notifyDataSetChanged();
                        isLoading = false;
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
