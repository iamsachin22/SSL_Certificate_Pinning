package com.example.sslcertificatepinning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<DataResponse> call = apiService.getData();
        call.enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                if (response.isSuccessful()) {
                    DataResponse data = response.body();
                    // Process the response data
                    Log.d("MainActivity", "Data: " + data.getData());
                } else {
                    // Handle error
                    Log.e("MainActivity", "Error: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                // Handle failure
                Log.e("MainActivity", "Failure: " + t.getMessage());
            }
        });
    }
}