package com.showtime.presenter

import com.showtime.model.Series
import com.showtime.model.OnDataListener
import com.showtime.view.MainActivity

class SeriesPresenter : IPresenter {
    var view: MainActivity? = null
    var model: Series? = null

    constructor(view: MainActivity?) {
        this.view = view
        model = Series()
        view!!.showProgress()
    }

    override fun getDataFromModel() {
        model!!.getSeries(object : OnDataListener {
            override fun onSucess(seriesList: List<Series>){
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