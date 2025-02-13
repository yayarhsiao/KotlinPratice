package com.example.kotlinproject.scence.base

import androidx.lifecycle.ViewModel
import com.google.gson.annotations.SerializedName

open class BaseViewModel : ViewModel() {

    enum class Status{
        @SerializedName("200")
        SUCCESS,
        @SerializedName("201")
        CREATED,
        @SerializedName("400")
        BAD_REQUEST,
        @SerializedName("401")
        UNAUTHORIZED,
        @SerializedName("403")
        FORBIDDEN,
        @SerializedName("404")
        NOT_FOUND,
        @SerializedName("407")
        EMAIL_INVALID,
        @SerializedName("409")
        CONFLICT,
        @SerializedName("410")
        GONE,
        @SerializedName("500")
        FAILURE
    }
}