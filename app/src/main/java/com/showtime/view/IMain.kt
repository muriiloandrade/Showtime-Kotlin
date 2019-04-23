package com.showtime.view
import com.showtime.model.Series

interface IMain {
    fun showProgress()
    fun hideProgress()
    fun updateView(seriesList: List<Series>)
    fun viewError(msg: String)
}