package com.showtime.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import com.bumptech.glide.Glide
import com.showtime.R
import com.showtime.model.Series
import com.showtime.presenter.SeriesDetailsPresenter

class SeriesDetails : AppCompatActivity(), IMain {

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun updateView(seriesList: List<Series>) {
    }

    override fun viewError(msg: String) {
        Toast.makeText(this, "" + msg, Toast.LENGTH_SHORT)
    }

    lateinit var progressBar: ProgressBar
    lateinit var detailsPresenter: SeriesDetailsPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.series_details)

        progressBar = progress_bar_details
        detailsPresenter = SeriesDetailsPresenter(this)
        detailsPresenter.getDataFromModel()

        getIncomingIntent()
    }

    private fun getIncomingIntent() {
        if (intent.hasExtra("seriesTitle")
            && intent.hasExtra("seriesDate")
            && intent.hasExtra("seriesOverview")
            && intent.hasExtra("posterImage")) {

            val seriesTitle = intent.getStringExtra("seriesTitle")

            val seriesDate = intent.getStringExtra("seriesDate")

            val seriesOverview = intent.getStringExtra("seriesOverview")

            val posterImage = intent.getStringExtra("posterImage")

            setDetails(posterImage, seriesTitle, seriesDate, seriesOverview)
        }
    }


    private fun setDetails(imageUrl: String, seriesTitle: String, seriesDate: String, seriesOverview: String) {
        val title = series_title_details
        title.text = seriesTitle

        val date = series_date_details
        date.text = seriesDate

        val overview = series_overview_details
        overview.text = seriesOverview


        val image = series_poster_details
        Glide.with(this)
            .load("http://image.tmdb.org/t/p/w185//$imageUrl")
            .into(image)
    }
}