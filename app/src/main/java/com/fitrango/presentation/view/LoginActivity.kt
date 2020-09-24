package com.fitrango.presentation.view

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.fitrango.R
import com.fitrango.presentation.di.Injector
import javax.inject.Inject

class LoginActivity: AppCompatActivity() {

    @Inject
    lateinit var factory: LoginViewModelFactory
    private lateinit var movieViewModel: LoginViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(applicationContext,"Login",Toast.LENGTH_SHORT).show()
        Log.e("Activity","Login")
        (application as Injector).createLoginSubComponent().inject(this)
        movieViewModel= ViewModelProvider(this,factory)
            .get(LoginViewModel::class.java)
        movieViewModel.getMovies("swapnil bhai","123","1234","mumbai","afa").observe(this, Observer {
            Log.e("data",it!!.data.message)
        })
    }







}