package com.heinminlatt.padcx_assignmenttravelapp.fragements


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.heinminlatt.padcx_assignmenttravelapp.R
import com.heinminlatt.padcx_assignmenttravelapp.activities.DetailActivity
import com.heinminlatt.padcx_assignmenttravelapp.adapter.PopularTourListAdapter
import com.heinminlatt.padcx_assignmenttravelapp.adapter.TourListAdapter
import com.heinminlatt.padcx_assignmenttravelapp.data.Model.ToursModel
import com.heinminlatt.padcx_assignmenttravelapp.data.Model.ToursModelImpl
import com.heinminlatt.padcx_assignmenttravelapp.delegate.ToursItemDelegate
import kotlinx.android.synthetic.main.fragment_main.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

 private val mToursModel : ToursModel=ToursModelImpl
 private lateinit var mTourListAdapter: TourListAdapter
 private lateinit var mPopularTourListAdapter: PopularTourListAdapter



/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment(),ToursItemDelegate {




    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        requestCountryData()
        requestPopularData()
        setUpSwipeRefresh()
        setUpTourRecyclerView()
        setUpPopularRecyclerView()

    }

    private fun setUpTourRecyclerView(){
        mTourListAdapter= TourListAdapter(this)
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        //val gridLayoutManager = GridLayoutManager(this,2)
        recycler_country.layoutManager=linearLayoutManager
        recycler_country.adapter= mTourListAdapter


    }

    private fun setUpPopularRecyclerView(){
        mPopularTourListAdapter= PopularTourListAdapter(this)
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        recycler_popular.layoutManager=linearLayoutManager
        recycler_popular.adapter= mPopularTourListAdapter
    }
    private fun setUpSwipeRefresh(){
        swipeRefreshLayout.setOnRefreshListener {
            requestCountryData()
            requestPopularData()
        }
    }
    private fun requestCountryData(){
        swipeRefreshLayout.isRefreshing=true
        hideTextView()
        mToursModel.getAllTours(
            onSuccess = {
                showTextView()
                swipeRefreshLayout.isRefreshing=false
                mTourListAdapter.setNewData(it.countrry.toMutableList())
            },
            onFailure = {
                val newMessage=it
            }
        )
    }

    private fun requestPopularData(){
        swipeRefreshLayout.isRefreshing=true
        hideTextView()
        mToursModel.getAllTours(
            onSuccess = {
                showTextView()
                swipeRefreshLayout.isRefreshing=false
                mPopularTourListAdapter.setNewData(it.popular_tours.toMutableList())
            },
            onFailure = {
                val newMessage=it
            }
        )
    }

    private fun showTextView(){
      tv_country.visibility=View.VISIBLE
        tv_popular_tour.visibility=View.VISIBLE
        tv_find_best_tour.visibility=View.VISIBLE
    }
    private fun hideTextView(){
        tv_country.visibility=View.GONE
        tv_popular_tour.visibility=View.GONE
        tv_find_best_tour.visibility=View.GONE
    }

    override fun onTouchTourItem(toursName: String,photoUrl : String) {
           startActivity(context?.let { DetailActivity.newIntent(it,toursName,photoUrl) })
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}
