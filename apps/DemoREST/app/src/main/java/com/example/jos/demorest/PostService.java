package com.example.jos.demorest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface PostService {

    String API_ROUTE = "/posts";

    @GET(API_ROUTE)
    Call<List<Post>> getPost();

    @Headers({"Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqb3NkZXNpQGdtYWlsLmNvbUBAIyNAQDE1Mzc5OTA0NTcxNzYiLCJleHAiOjE1NDA1ODI0NTd9.m-VjQqwhWKwOxVTZ_I57iKQsSU9Kncs3YJDFbXfXewN8-Hmv2hIm2f8uMoBd2OAx3pw9jmeum2dDGJxXPSN_0w"})
    @GET("/getUser?userEmail=betosh@gluo.mx")
    Call<List<ResponseUser>> getUser();
}