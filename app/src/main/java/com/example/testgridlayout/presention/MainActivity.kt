package com.example.testgridlayout.presention

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.testgridlayout.R
import com.example.testgridlayout.deleteMe.MockTestData
import com.example.testgridlayout.domain.model.GiphyImages
import com.example.testgridlayout.presention.recycler.RecyclerAdapter
import com.google.android.material.snackbar.Snackbar
import timber.log.Timber
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener {
    private lateinit var mSwipeRefreshLayout : SwipeRefreshLayout
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var lst: HashMap<String, String>
    private lateinit var url: String
    val data: MockTestData = MockTestData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        mRecyclerView = findViewById(R.id.rvImageList)
        mSwipeRefreshLayout = findViewById(R.id.srPullToRefresh)

        mRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        mRecyclerView.adapter = RecyclerAdapter(data.all as ArrayList<GiphyImages>)

    }

    override fun onRefresh() {
        refresh()
    }

    private fun refresh() {
        mRecyclerView.adapter?.notifyDataSetChanged()
        mSwipeRefreshLayout.isRefreshing = false
    }
}