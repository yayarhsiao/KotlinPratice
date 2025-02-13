package com.example.kotlinproject.scence.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.kotlinproject.manager.api.ApiService
import com.example.kotlinproject.entity.CityResponse
import com.example.kotlinproject.scence.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel : BaseViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    val resultToast: MutableLiveData<String> = MutableLiveData()
    val resultCityInfo: MutableLiveData<List<CityResponse>> = MutableLiveData()

    fun getAllCoffeeShop() {
        val disposable = ApiService.Api.getAllCoffeeShop()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response:  List<CityResponse>->
                resultCityInfo.value = response
            }, { throwable: Throwable ->
                Log.e("getAllCoffeeShop", throwable.toString())
            })
        compositeDisposable.add(disposable)
    }

    fun getCityCoffeeShop(city:String) {
        if (city == "") {
            resultToast.value = "城市資訊請勿空白"
            return
        }

        val disposable = ApiService.Api.getCityCoffeeShop(city)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response:  List<CityResponse>->
                resultCityInfo.value = response
            }, { throwable: Throwable ->
                Log.e("getCityCoffeeShop", throwable.toString())
            })
        compositeDisposable.add(disposable)
    }
}