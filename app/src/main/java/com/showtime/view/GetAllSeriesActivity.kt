package com.showtime.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatImageButton
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import com.showtime.R
import com.showtime.model.Series
import com.showtime.presenter.SeriesPresenter
import kotlinx.android.synthetic.main.activity_getallseries.*


class GetAllSeriesActivity : AppCompatActivity(), IMain {

    var botaoSearch: AppCompatImageButton? = null


    lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_getallseries)

        progressBar = this.progress_bar
        var presenter = SeriesPresenter(this)
        presenter.getDataFromModel()


        botaoSearch = findViewById(R.id.btn_search)

        botaoSearch?.setOnClickListener {
            val clicksearch = Intent(this@GetAllSeriesActivity, SearchActivity::class.java)
            startActivity(clicksearch)
        }
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun updateView(seriesList: List<Series>) {
        var recyclerView: RecyclerView = recycler_view
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setAdapter(applicationContext.let { SeriesAdapter(R.layout.row_layout, seriesList, this) })
    }


    override fun viewError(msg: String) {
        Toast.makeText(this, "" + msg, Toast.LENGTH_SHORT)
    }
}
