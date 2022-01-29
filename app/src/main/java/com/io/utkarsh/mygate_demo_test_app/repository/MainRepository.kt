package com.io.utkarsh.mygate_demo_test_app.repository

import com.io.utkarsh.mygate_demo_test_app.model.Post
import com.io.utkarsh.mygate_demo_test_app.network.ApiInterfaceImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MainRepository
@Inject
constructor(private val apiInterfaceImpl: ApiInterfaceImpl) {

    fun getPost():Flow<List<Post>> = flow {
        emit(apiInterfaceImpl.getPosts())
    }.flowOn(Dispatchers.IO)
}