package com.parithi.paintora

import android.support.test.InstrumentationRegistry
import com.parithi.paintora.helpers.PaintingDataProvider
import com.parithi.paintora.helpers.PaintingDataProvider_Local
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class PaintingDataProvider_LocalTest {

    @Test
    fun providePaintingData() {
        val appContext = InstrumentationRegistry.getTargetContext()
        var paintingDataProvider : PaintingDataProvider = PaintingDataProvider_Local()
        assertNotNull(paintingDataProvider)
        assertEquals(16,paintingDataProvider.providePaintingData(appContext).size)
    }

}