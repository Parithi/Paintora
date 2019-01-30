package com.parithi.paintora.contracts

import android.content.Context
import com.parithi.paintora.models.PaintingData

interface HomeContract{
    interface View {
        fun displayData(data : List<PaintingData>)
    }

    interface Presenter {
        fun prepareData(context: Context)
    }
}