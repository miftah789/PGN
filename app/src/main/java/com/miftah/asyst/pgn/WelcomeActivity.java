package com.miftah.asyst.pgn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.miftah.asyst.pgn.adapter.AdapterPGN;
import com.miftah.asyst.pgn.model.DataModel;
import com.miftah.asyst.pgn.retrofit.ApiClient;
import com.miftah.asyst.pgn.retrofit.ApiServices;
import com.miftah.asyst.pgn.retrofit.Response.DataResponse;
import com.miftah.asyst.pgn.utility.SessionUtil;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WelcomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterPGN adapterPGN;
    ProgressBar progressBar;
    ArrayList<DataModel> listData = new ArrayList<>();
    boolean isLoading = false;
    SessionUtil sessionUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        recyclerView = findViewById(R.id.recycleview);
        progressBar = findViewById(R.id.progress_bar);

        adapterPGN = new AdapterPGN(this, listData, new AdapterPGN.OnItemClickListener() {
            @Override
            public void onItemClick(DataModel data) {
                Toast.makeText(getApplicationContext(), data.getCustomerName(), Toast.LENGTH_SHORT).show();
            }
        });

        getData();
    }

    public void getData() {

        ApiServices apiServices = ApiClient.newInstance(getApplicationContext()).create(ApiServices.class);
        Call<DataResponse> call = apiServices.getData();

        call.enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                progressBar.setVisibility(View.INVISIBLE);
                if (response.body().getStatus().equalsIgnoreCase("success")) {
                    if (response.body().getData().size() > 0) {
                        listData.addAll(response.body().getData());
                        adapterPGN.notifyDataSetChanged();
                        isLoading = false;
                    }
                }
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.main_exit:
                sessionUtil.savePassword("");
                sessionUtil.saveUsername("");
                Intent intent = new Intent(this, MainActivity.class);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
