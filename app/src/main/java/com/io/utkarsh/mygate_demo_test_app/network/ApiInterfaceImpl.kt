package com.io.utkarsh.mygate_demo_test_app.network

import com.io.utkarsh.mygate_demo_test_app.model.Post
import javax.inject.Inject

class ApiInterfaceImpl @Inject constructor( val apiInterface: ApiInterface) {

    suspend fun getPosts() :List<Post> = apiInterface.getpost()
}