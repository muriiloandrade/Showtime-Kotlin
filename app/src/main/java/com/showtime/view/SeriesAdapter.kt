package com.showtime.view

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.showtime.model.Series
import kotlinx.android.synthetic.main.activity_getallseries.view.*
import kotlinx.android.synthetic.main.row_layout.view.*


open class SeriesAdapter : RecyclerView.Adapter<SeriesAdapter.SeriesViewHolder> {

    var rowLayout: Int = 0
    var series: List<Series>
    var context: Context

    constructor(rowLayout: Int, series: List<Series>, context: Context) : super() {
        this.rowLayout = rowLayout
        this.series = series
        this.context = context
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): SeriesViewHolder {
        val view: View = LayoutInflater.from(p0.context).inflate(rowLayout, p0, false)
        return SeriesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return series.size
    }

    override fun onBindViewHolder(p0: SeriesViewHolder, p1: Int) {
        p0.title.text = series.get(p1).original_name
        p0.description.text = series.get(p1).overview

        Glide.with(context).load("http://image.tmdb.org/t/p/w185//" + series[p1].poster_path).into(p0.seriesPoster)

        p0.layout.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                var intent: Intent = Intent(p0!!.context, SeriesDetails::class.java)
                intent.putExtra("seriesTitle", series[p1].original_name)
                intent.putExtra("seriesOverview", series[p1].overview)
                intent.putExtra("posterImage", series[p1].poster_path)
                p0.context.startActivity(intent)
            }
        })


    }

    open class SeriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.original_name
        var description: TextView = itemView.overview
        var seriesPoster: ImageView = itemView.series_poster
        var layout: LinearLayout = itemView.linear_layout


    }
}