package com.io.utkarsh.mygate_demo_test_app.network

import com.io.utkarsh.mygate_demo_test_app.model.Post
import retrofit2.http.GET

interface ApiInterface {

    @GET("posts")
    suspend fun getpost():List<Post>
}