package com.example.weatherapitestapp.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.weatherapitestapp.R
import com.example.weatherapitestapp.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding;
    private val viewModel : HomeViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        setContentView(binding.root)
        loadLocationInfo()

        binding.btnGetWeather.setOnClickListener{
            // API 호출
        }
    }


    private fun loadLocationInfo(){
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                launch {
                    viewModel.loadLocationInformation()
                    showLocationInfo()
                }
            }
        }
    }

    private suspend fun showLocationInfo(){
        viewModel.locationInformationStateFlow.collect{
            it?.let {
                Log.d("Location", "${it.ip} ${it.loc} ${it.city}")
            }

        }
    }
}