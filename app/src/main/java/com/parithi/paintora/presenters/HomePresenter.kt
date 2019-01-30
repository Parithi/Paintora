package com.parithi.paintora.presenters

import android.content.Context
import com.parithi.paintora.contracts.HomeContract
import com.parithi.paintora.models.PaintingData
import com.parithi.paintora.repository.Repository

class HomePresenter(var view : HomeContract.View, var repo : Repository) : HomeContract.Presenter {

    lateinit var data : List<PaintingData>

    override fun prepareData(context : Context){
        data = repo.providePaintingData(context)
        view.displayData(data)
    }


}