package com.example.sslcertificatepinning;

import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "https://api.github.com/";
    private static final String CERTIFICATE_SHA256 = "sha256/r/mIkG3eEpVdm+u/ko/cwxzOMo1bk4TyHIlByibiA5E=";

    private static Retrofit retrofit;

    public static Retrofit getClient() {
        if (retrofit == null) {
            // Create CertificatePinner instance
            CertificatePinner certificatePinner = new CertificatePinner.Builder()
                    .add("api.github.com", CERTIFICATE_SHA256)
                    .build();

            // Create OkHttpClient with certificate pinning
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .certificatePinner(certificatePinner)
                    .build();

            // Create Retrofit instance
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

