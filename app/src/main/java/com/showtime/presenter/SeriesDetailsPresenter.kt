package com.showtime.presenter

import com.showtime.model.Series
import com.showtime.model.OnDataListener
import com.showtime.view.SeriesDetails

class SeriesDetailsPresenter : IPresenter {
    var model: Series
    var view: SeriesDetails

    constructor(view: SeriesDetails) {
        this.view = view
        model = Series("", 0, 0, "", "", "", "", "")
        view.showProgress()
    }

    override fun getDataFromModel() {
        model.getSeries(object: OnDataListener {
            override fun onSuccess(seriesList: List<Series>){
                view.hideProgress()
                view.updateView(seriesList)
            }

            override fun onFailure(msg: String){
                view.hideProgress()
                view.viewError(msg)
            }
        })
    }
}