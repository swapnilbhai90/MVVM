package com.fitrango.presentation.view.banner

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.fitrango.R
import com.fitrango.databinding.BannerItemBinding

class BannerViewPagerAdapter(private var context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val applicationBinding = BannerItemBinding.inflate(layoutInflater, parent, false)
        return OptionalAlertsViewHolder(applicationBinding)
    }

    class OptionalAlertsViewHolder(var item_banner: BannerItemBinding) :
        RecyclerView.ViewHolder(item_banner.root) {

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {


        when(position){

            0->
                (holder as OptionalAlertsViewHolder).item_banner.bannerImage.setImageDrawable(
                    ContextCompat.getDrawable(context, R.drawable.ic_banner_one))

            1->
                (holder as OptionalAlertsViewHolder).item_banner.bannerImage.setImageDrawable(
                    ContextCompat.getDrawable(context, R.drawable.ic_banner_two))

            2->
                (holder as OptionalAlertsViewHolder).item_banner.bannerImage.setImageDrawable(
                    ContextCompat.getDrawable(context, R.drawable.ic_banner_three))

            else  ->
                (holder as OptionalAlertsViewHolder).item_banner.bannerImage.setImageDrawable(
                    ContextCompat.getDrawable(context, R.drawable.ic_banner_one))

        }
    }

    override fun getItemCount(): Int {
       return  3
    }




}