package com.heinminlatt.padcx_assignmenttravelapp.views.viewholder

import android.view.TouchDelegate
import android.view.View
import com.bumptech.glide.Glide
import com.heinminlatt.padcx_assignmenttravelapp.data.VOS.CountryVO
import com.heinminlatt.padcx_assignmenttravelapp.data.VOS.ToursVO
import com.heinminlatt.padcx_assignmenttravelapp.delegate.ToursItemDelegate
import kotlinx.android.synthetic.main.country_list_items.view.*
import kotlinx.android.synthetic.main.tour_list_items.view.*

class PopularTourViewHolder(itemView : View,delegate: ToursItemDelegate) : BaseViewHolder<CountryVO>(itemView) {
    override fun bindData(data: CountryVO) {

        mData=data
        Glide.with(itemView.context)
            .load(data.photo?.get(0))
            .into(itemView.iv_popular_tour)

        itemView.txt_country_title.text=data.name
        itemView.rating.text= data.averageRating.toString()

    }

    init {
        itemView.setOnClickListener {
            mData?.let {
                it.photo?.get(0)?.let { it1 -> delegate.onTouchTourItem(it.name, it1) }
            }
        }
    }


}