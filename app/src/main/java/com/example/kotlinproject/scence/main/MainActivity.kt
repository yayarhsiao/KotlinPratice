package com.example.kotlinproject.scence.main

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinproject.databinding.ActivityMainBinding
import com.example.kotlinproject.scence.base.BaseActivity
import com.example.kotlinproject.scence.adapter.info.InfoAdapter

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    private val mainViewModel: MainViewModel = MainViewModel()
    private lateinit var mainBinding: ActivityMainBinding
    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
    override fun getViewModelClass(): MainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        SetOnClick()
        SetObserver()
    }

    private fun SetOnClick() {
        mainBinding.btnCity.setOnClickListener {
            mainViewModel.getCityCoffeeShop(mainBinding.txtCity.text.toString())
        }

        mainBinding.btnAll.setOnClickListener {
            mainViewModel.getAllCoffeeShop()
        }
    }

    private fun SetObserver() {
        mainViewModel.resultToast.observe(this, Observer { toast ->
            toastMsg(toast)
        })

        mainViewModel.resultCityInfo.observe(this, Observer { info ->
            val infoAdapter = InfoAdapter(info)
            mainBinding.viewInfo.adapter = infoAdapter
        })
    }
}