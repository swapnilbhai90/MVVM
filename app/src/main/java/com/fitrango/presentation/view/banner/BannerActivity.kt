package com.fitrango.presentation.view.banner

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.fitrango.R
import com.fitrango.presentation.view.login.LoginActivity
import com.fitrango.views.viewpagerdotsindicator.DotsIndicator
import kotlinx.android.synthetic.main.banner_activity.*
import timber.log.Timber

class BannerActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var dots_indicator: DotsIndicator
    private lateinit var bannerAdapter: BannerViewPagerAdapter
    private lateinit var viewPager2: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.banner_activity)
        setBannerViewpager()
        button_next.setOnClickListener(this)
    }

    private fun setBannerViewpager() {
        viewPager2 = findViewById<ViewPager2>(R.id.viewPagerBanner)
        dots_indicator = findViewById<DotsIndicator>(R.id.dots_indicator)
        bannerAdapter = BannerViewPagerAdapter(applicationContext)
        viewPager2.adapter = bannerAdapter
        dots_indicator.setViewPager2(viewPager2)

    }

    override fun onClick(view: View?) {

        if (view != null) {
            when(view.id)
            {
                R.id.button_next,R.id.button_skip->
                    openLogin()
                else->
                    Timber.e("")
            }
        }

    }

    private fun openLogin() {
        startActivity(Intent(this@BannerActivity, LoginActivity::class.java))
        this.finish()
    }
}