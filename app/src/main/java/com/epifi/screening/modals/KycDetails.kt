package com.epifi.screening.modals

import android.text.TextUtils
import androidx.databinding.BaseObservable
import java.util.regex.Pattern

class KycDetails(private var pan: String, private var date: Int, private var month: Int, private var year: Int) : BaseObservable() {
    fun isDataValid(): Int {
        val pattern: Pattern = Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]{1}")
//        [A-Z]{5} - match five literals which can be A to Z
//        [0-9]{4} - followed by 4 numbers 0 to 9
//        [A-Z]{1} - followed by one literal which can A to Z
        return if (TextUtils.isEmpty(getPan().trim()))
            0 //pan field empty
        else if (!pattern.matcher(getPan().trim()).matches())
            1 //pan format not valid=
        else if (getDate() <= 0 || getDate() > 31)
            2 // date not valid
        else if (getMonth() <= 0 || getMonth() > 12)
            3 // month not valid
        else if (getYear() < 1900 || getYear() > 2022)
            4 // year not valid
        else
            -1
    }

    private fun getPan(): String {
        return pan
    }

    private fun getDate(): Int {
        return date
    }

    private fun getMonth(): Int {
        return month
    }

    private fun getYear(): Int {
        return year
    }

    fun setPan(pan: String) {
        this.pan = pan
    }

    fun setDate(date: Int) {
        this.date = date
    }

    fun setMonth(month: Int) {
        this.month = month
    }

    fun setYear(year: Int) {
        this.year = year
    }

}