package com.heinminlatt.padcx_assignmenttravelapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.heinminlatt.padcx_assignmenttravelapp.R
import com.heinminlatt.padcx_assignmenttravelapp.data.VOS.CountryVO
import com.heinminlatt.padcx_assignmenttravelapp.data.VOS.ToursVO
import com.heinminlatt.padcx_assignmenttravelapp.delegate.ToursItemDelegate
import com.heinminlatt.padcx_assignmenttravelapp.views.viewholder.BaseTourViewHolder
import com.heinminlatt.padcx_assignmenttravelapp.views.viewholder.BaseViewHolder
import com.heinminlatt.padcx_assignmenttravelapp.views.viewholder.PopularTourViewHolder
import com.heinminlatt.padcx_assignmenttravelapp.views.viewholder.TourViewHolder

class PopularTourListAdapter(delegate: ToursItemDelegate) : BaseRecyclerAdapter<BaseViewHolder<CountryVO>,CountryVO>() {

    val mDelegate : ToursItemDelegate=delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<CountryVO> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tour_list_items,parent,false)
        return PopularTourViewHolder(view,mDelegate)
    }
}