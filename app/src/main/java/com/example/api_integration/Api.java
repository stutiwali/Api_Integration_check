package com.example.api_integration;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("all")
    Call<List<PostPojo>> getPosts();

}

