package com.showtime.presenter

import com.showtime.model.OnDataListener
import com.showtime.model.Series
import com.showtime.view.SearchSeriesActivity

class SeriesSearchPresenter : IPresenter {

    var model: Series? = null
    var view: SearchSeriesActivity? = null

    constructor(view: SearchSeriesActivity) {
        this.view = view
        model = Series("", 0.0, 0, "", "", "", "", "")
        view?.showProgress()
    }

    override fun getDataFromModel() {
        model?.searchSeries(object : OnDataListener {
            override fun onSuccess(seriesList: List<Series>) {
                view?.hideProgress()
                view?.updateView(seriesList)
            }

            override fun onFailure(msg: String) {
                view?.hideProgress()
                view?.viewError(msg)
            }
        })
    }

}