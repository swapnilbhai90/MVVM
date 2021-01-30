package com.fitrango.presentation.view.login.socialSignup

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.fitrango.R
import com.fitrango.presentation.view.login.mobileLogin.MobileLogin
import com.fitrango.util.DialogUtil
import kotlinx.android.synthetic.main.socialsignup.*

class SocialSignup:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.socialsignup)
        toolbar.setNavigationIcon(ContextCompat.getDrawable(this,R.drawable.ic_back_icon))
        button_next.setOnClickListener {
            startActivity(Intent(this@SocialSignup, MobileLogin::class.java))
        }

        button_next.setOnClickListener {
       /*  DialogUtil.getSuccessfulAcctDialog(SocialSignup@this,"")?.show()*/
         var d= Dialog(SocialSignup@this)
            d.setContentView(R.layout.dialog_account_successful)
            d.show()
        }
    }
}