package com.example.sslcertificatepinning;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("data")
    Call<DataResponse> getData();
}

