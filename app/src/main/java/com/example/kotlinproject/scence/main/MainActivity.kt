package com.example.kotlinproject.scence.main

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinproject.OnRecycleViewClickListener
import com.example.kotlinproject.databinding.ActivityMainBinding
import com.example.kotlinproject.entity.CityResponse
import com.example.kotlinproject.scence.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
    override fun getViewModelClass(): MainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        SetOnClick()
        SetObserver()
    }

    private fun SetOnClick() {
        binding.btnCity.setOnClickListener {
            viewModel.getCityCoffeeShop(binding.txtCity.text.toString())
        }

        binding.btnAll.setOnClickListener {
            viewModel.getAllCoffeeShop()
        }
    }

    private fun SetObserver() {
        viewModel.resultToast.observe(this, Observer { toast ->
            toastMsg(toast)
        })

        viewModel.resultCityInfo.observe(this, Observer { info ->
            initRecycleView(info)
        })
    }

    private fun initRecycleView(data: List<CityResponse>) {
        var mainListAdapter = MainListAdapter(this, data)
        binding.viewInfo.layoutManager = LinearLayoutManager(this)
        binding.viewInfo.adapter = mainListAdapter
    }
}