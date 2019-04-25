package com.showtime.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ProgressBar
import com.showtime.R
import com.showtime.model.Statistics
import kotlinx.android.synthetic.main.activity_user_login.*
import kotlinx.android.synthetic.main.row_statistics_layout.*


class StatisticsActivity : AppCompatActivity() {


    lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.row_statistics_layout)

        val STATISTICS = ArrayList<Statistics>()


        val newStatistics = Statistics()
        newStatistics.mySeries = 17
        newStatistics.seenEpisodes = 171
        newStatistics.watchedTime = 196065
        STATISTICS.add(newStatistics)

        val newStatistics1 = Statistics()
        newStatistics1.mySeries = 13
        newStatistics1.seenEpisodes = 157
        newStatistics1.watchedTime = 89106
        STATISTICS.add(newStatistics1)

        statistic_name.text = "Episodios Assistidos"

        valor.setHint(newStatistics.seenEpisodes)

        statistic_name1.text = "Minhas Séries"
        valor1.setHint(newStatistics.mySeries)


    }


}