package com.fitrango.presentation.view.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.fitrango.R
import com.fitrango.presentation.view.login.LoginActivity
import javax.inject.Inject


class SplashActivity : AppCompatActivity() {

   // lateinit var splashViewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        //splashViewModel=ViewModelProvider(this, splash_Factory).get(splashViewModel::class.java)
        callNextScreenAfterDelay()
    }

    private fun callNextScreenAfterDelay() {
        Handler().postDelayed(Runnable { /* Create an Intent that will start the Menu-Activity. */
            var mainIntent = Intent(this@SplashActivity, LoginActivity::class.java)
            startActivity(mainIntent)
            this.finish()
        }, 3000)
    }
}