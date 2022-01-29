package com.io.utkarsh.mygate_demo_test_app.utils

import com.io.utkarsh.mygate_demo_test_app.model.Post

sealed interface APiState{
    object Loading: APiState
    class failure (val msg:Throwable):APiState
    class success(val data :List<Post>):APiState
    class Empty:APiState
}