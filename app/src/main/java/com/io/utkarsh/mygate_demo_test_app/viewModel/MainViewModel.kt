package com.io.utkarsh.mygate_demo_test_app.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.io.utkarsh.mygate_demo_test_app.repository.MainRepository
import com.io.utkarsh.mygate_demo_test_app.utils.APiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
    @Inject constructor(private val mainRepository: MainRepository)
    : ViewModel() {

    private val postMutableStateFlow:MutableStateFlow<APiState> =
            MutableStateFlow(APiState.Empty())
    val postStateFlow : StateFlow<APiState> = postMutableStateFlow

    //Function for calling Api to collect Data on the behalf of state
    fun getPost () = viewModelScope.launch {
        postMutableStateFlow.value = APiState.Loading
        mainRepository.getPost()
            .catch { e ->
                run {
                    postMutableStateFlow.value = APiState.failure(e)
                }
            }.collect {
                data -> postMutableStateFlow.value = APiState.success(data)
            }
    }
}