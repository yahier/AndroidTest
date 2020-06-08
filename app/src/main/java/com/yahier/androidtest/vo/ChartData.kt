package com.yahier.androidtest.vo

/**
 * 图表数据
 */
data class ChartData(var type: Int = 0,
                     var date: String,
                     var value: Int = 0) {
    companion object {
        val typeInfected = 1
        val typeDied = 2
        val typeSecured = 3
    }
}