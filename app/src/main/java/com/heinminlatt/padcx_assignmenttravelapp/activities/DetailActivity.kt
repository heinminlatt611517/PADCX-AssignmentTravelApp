package com.heinminlatt.padcx_assignmenttravelapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.heinminlatt.padcx_assignmenttravelapp.R
import com.heinminlatt.padcx_assignmenttravelapp.adapter.PopularTourListAdapter
import com.heinminlatt.padcx_assignmenttravelapp.adapter.TourListAdapter
import com.heinminlatt.padcx_assignmenttravelapp.data.Model.ToursModel
import com.heinminlatt.padcx_assignmenttravelapp.data.Model.ToursModelImpl
import com.heinminlatt.padcx_assignmenttravelapp.delegate.ToursItemDelegate
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.detail_middle_layout.*
import kotlinx.android.synthetic.main.fragment_main.*

class DetailActivity : BaseActivity(),ToursItemDelegate{
    override fun onTouchTourItem(toursName: String,photoUrl : String) {

    }


    companion object{

        const val TOURS_NAME_EXTRA="Tours Name Extra"
        const val PHOTO_URL_EXTRA="Photo Url Extra"

        fun newIntent(context: Context,toursName : String,photoUrl: String) : Intent{
            val intent=Intent(context,DetailActivity::class.java)
            intent.putExtra(TOURS_NAME_EXTRA,toursName)
            intent.putExtra(PHOTO_URL_EXTRA,photoUrl)
            return intent
        }
    }

    private val mToursModel: ToursModel=ToursModelImpl
    private lateinit var mTourListAdapter: TourListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setUpRecyclerView()
        requestData()
//        setUpSwipeRereshLayout()

        iv_detail_back.setOnClickListener {
            finish()
        }

        val toursName = intent.getStringExtra(TOURS_NAME_EXTRA)
        val tours=mToursModel.getToursByName(toursName)
        val photoUrl=intent.getStringExtra(PHOTO_URL_EXTRA)

        Glide.with(this)
            .load(photoUrl)
            .into(iv_detail)

        tv_country_title.text=tours.name
        tv_country_location.text=tours.location
        tv_detail_dec.text=tours.description

        tv_booking.text= tours.scoreAndreview?.get(0)?.name
        tv_hotel.text= tours.scoreAndreview?.get(1)?.name

        tv_booking_dec.text="Base on "+tours.scoreAndreview?.get(0)?.totleReview+" reviews"
        tv_booking_date.text= tours.scoreAndreview?.get(0)?.score.toString()+"/"+tours.scoreAndreview?.get(0)?.max_score.toString()

        tv_hotel_dec.text="Base on "+tours.scoreAndreview?.get(1)?.totleReview+" reviews"
        tv_hotel_date.text= tours.scoreAndreview?.get(1)?.score.toString()+"/"+tours.scoreAndreview?.get(1)?.max_score.toString()

        tv_ratingNo.text=tours.averageRating.toString()
        rating.rating= tours.averageRating

    }

    private fun setUpSwipeRereshLayout(){

    }
    private fun setUpRecyclerView(){
        mTourListAdapter= TourListAdapter(this)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)

        rec_detail.layoutManager=linearLayoutManager
        rec_detail.adapter=mTourListAdapter

    }
    private fun hideLayout(){
        lContainer.visibility=View.GONE
    }
    private fun showLayout(){
        lContainer.visibility=View.VISIBLE
    }
    private fun requestData(){
        mToursModel.getAllTours(
            onSuccess = {
                mTourListAdapter.setNewData(it.countrry.toMutableList())
            },
            onFailure = {
                val mMessage=it
            }
        )
    }
}
