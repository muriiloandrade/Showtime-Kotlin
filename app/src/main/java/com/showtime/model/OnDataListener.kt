package com.showtime.model

interface OnDataListener {
    fun onSuccess(seriesList: List<Series>)
    fun onFailure(msg: String)
}
