package com.parithi.paintora.repository

import android.content.Context
import com.parithi.paintora.helpers.PaintingDataProvider
import com.parithi.paintora.models.PaintingData

class Repository(var dataProvider : PaintingDataProvider) {

    fun providePaintingData(context : Context) : List<PaintingData>{
        return dataProvider.providePaintingData(context)
    }

}