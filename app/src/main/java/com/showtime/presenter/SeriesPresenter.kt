package com.showtime.presenter

import com.showtime.model.Series
import com.showtime.model.OnDataListener
import com.showtime.view.GetAllSeriesActivity

class SeriesPresenter : IPresenter {
    var view: GetAllSeriesActivity? = null
    var model: Series? = null

    constructor(view: GetAllSeriesActivity?) {
        this.view = view
        model = Series("", 0, 0, "", "", "", "", "")
        view!!.showProgress()
    }

    override fun getDataFromModel() {
        model!!.getSeries(object : OnDataListener {
            override fun onSuccess(seriesList: List<Series>){
                view!!.hideProgress()
                view!!.updateView(seriesList)
            }

            override fun onFailure(msg: String){
                view!!.hideProgress()
                view!!.viewError(msg)
            }
        })
    }
}