package com.example.kotlinproject.scence.base

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager.GET_SIGNATURES
import android.content.pm.PackageManager.NameNotFoundException
import android.os.Bundle
import android.util.Base64
import android.util.Base64.encodeToString
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewbinding.ViewBinding
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.Objects

abstract class BaseActivity<VB: ViewBinding, VM : BaseViewModel> : AppCompatActivity() {

    protected lateinit var binding: VB
    protected lateinit var viewModel: VM

    protected var screenWidth: Float = 0.0F
    protected var screenHeight: Float = 0.0F

    protected abstract fun getViewBinding(): VB

    protected abstract fun getViewModelClass(): VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = getViewModelClass()
        binding = getViewBinding()
        setContentView(binding.root)

        screenWidth = resources.displayMetrics.widthPixels.toFloat()
        screenHeight = resources.displayMetrics.heightPixels.toFloat()

        //confirmKeyHash()
    }

    fun setStatusBarColor(id: Int) {
        window.statusBarColor = id
    }

    fun getResColor(name: Int): Int = ContextCompat.getColor(this, name)

    fun startActivity(targetClass: Class<*>) {
        val intent = Intent(this, targetClass)
        startActivity(intent)
    }

    fun startActivity(bundle: Bundle, targetClass: Class<*>) {
        val intent = Intent(this, targetClass)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    fun startActivityResult(bundle: Bundle? = null, targetClass: Class<*>) {
        val intent = Intent(this, targetClass)
        bundle?.let {
            intent.putExtras(it)
        }

        this.startActivityForResult(intent, 200)
    }

    fun toastMsg(msg: String) = Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

    fun toastMsg(resMsg: Int) = Toast.makeText(this, resMsg, Toast.LENGTH_SHORT).show()

    fun hideKeyBoard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(Objects.requireNonNull(currentFocus)?.windowToken, 0)
        } catch (e: NullPointerException) {
            Log.e("hideKeyBoard", e.toString())
        }
    }

//    @SuppressLint("PackageManagerGetSignatures")
//    fun confirmKeyHash() {
//        try {
//            val info = packageManager.getPackageInfo(
//                "tw.com.atek.vivant", GET_SIGNATURES
//            )
//            for (signature in info.signatures) {
//                val md: MessageDigest = MessageDigest.getInstance("SHA")
//                md.update(signature.toByteArray())
//                Log.d("message Hash Key:", encodeToString(md.digest(), Base64.DEFAULT))
//            }
//        } catch (e: NameNotFoundException) {
//        } catch (e: NoSuchAlgorithmException) {
//        }
//    }
}