package com.fitrango.presentation.view.login.mobileLogin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fitrango.R

import com.fitrango.presentation.view.login.socialSignup.SocialSignup
import kotlinx.android.synthetic.main.include_mobile_number.*
import kotlinx.android.synthetic.main.mobile_login_layout.*

class MobileLogin: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mobile_login_layout)
        button_next.setOnClickListener {
            if(checkEnterMobileNumberView()){
                vs_login.showNext()
                Toast.makeText(applicationContext,"true",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext,"false",Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@MobileLogin, SocialSignup::class.java))

            }

        }
    }

   private fun checkEnterMobileNumberView(): Boolean {
       return vs_login.currentView==layout_mobile_number
    }
}