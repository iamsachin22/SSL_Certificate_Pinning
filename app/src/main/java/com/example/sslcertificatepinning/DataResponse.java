package com.example.sslcertificatepinning;

import com.google.gson.annotations.SerializedName;

public class DataResponse {
    @SerializedName("data")
    private String data;

    public String getData() {
        return data;
    }
}

