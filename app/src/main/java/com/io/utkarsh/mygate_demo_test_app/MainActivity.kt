package com.io.utkarsh.mygate_demo_test_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.io.utkarsh.mygate_demo_test_app.adapter.PostAdapter
import com.io.utkarsh.mygate_demo_test_app.databinding.ActivityMainBinding
import com.io.utkarsh.mygate_demo_test_app.utils.APiState
import com.io.utkarsh.mygate_demo_test_app.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var postAdapter: PostAdapter
    private val mainViewModel:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        loadData()
    }

    //Method to set data in Adapter on the behalf of state.
    // Loading // Success// failure state
    private fun loadData() {
        mainViewModel.getPost()
        lifecycleScope.launchWhenStarted {
            mainViewModel.postStateFlow.collect{
                when(it){
                    is APiState.Loading ->{
                        binding.recyclerView.isVisible = false
                        binding.progressbar.isVisible = true
                    }
                    is APiState.success ->{
                        binding.recyclerView.isVisible = true
                        binding.progressbar.isVisible = false
                        postAdapter.setDate(it.data)
                    }
                    is APiState.failure ->{
                        binding.recyclerView.isVisible = false
                        binding.progressbar.isVisible = false
                        Log.d("main","onCreate: ${it.msg}")

                    }is APiState.Empty ->{

                }
                }
            }
        }

    }
    // Method for Initializing View and other component
    private fun initView() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    // Method for initializing recycler View.
    private fun initRecyclerView() {
        postAdapter = PostAdapter(ArrayList())
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = postAdapter
        }


    }
}