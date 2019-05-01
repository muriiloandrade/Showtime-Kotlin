package com.showtime.model
interface IModel {
    fun getSeries(listener: OnDataListener)
    fun searchSeries(listener: OnDataListener)
}
