package com.parithi.paintora.helpers

import android.content.Context
import com.parithi.paintora.models.PaintingData

class PaintingDataProvider_Local : PaintingDataProvider {

    override fun providePaintingData(application: Context): List<PaintingData> {
        val paintingDataList = mutableListOf<PaintingData>()

        application.assets.open("paintings.txt").bufferedReader().useLines { lines ->
            lines.forEach {
                paintingDataList.add(createPaintingObject(it))
            }
        }

        return paintingDataList.toList()
    }

    private fun createPaintingObject(paintingDataValue: String): PaintingData {
        val paintingString = paintingDataValue
        val paintingStringArray = paintingString.split(",")

        val paintingData = PaintingData(
            paintingStringArray[0],
            paintingStringArray[1],
            paintingStringArray[2].toInt(),
            paintingStringArray[3].toInt(),
            paintingStringArray[4]
        )

        return paintingData
    }
}