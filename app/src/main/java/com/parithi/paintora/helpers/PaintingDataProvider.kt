package com.parithi.paintora.helpers

import android.content.Context
import com.parithi.paintora.models.PaintingData

interface PaintingDataProvider {
    fun providePaintingData(application : Context) : List<PaintingData>
}