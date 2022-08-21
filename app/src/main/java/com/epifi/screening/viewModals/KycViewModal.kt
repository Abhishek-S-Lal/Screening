package com.epifi.screening.viewModals

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.ViewModel
import com.epifi.screening.interfaces.KycCallbacks
import com.epifi.screening.modals.KycDetails

class KycViewModel(private val listener: KycCallbacks) : ViewModel() {
    private val userKyc: KycDetails = KycDetails("", 0, 0, 0)

    //create function to set pan after userKyc finish enter text
    val panTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                userKyc.setPan(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Code what you want to show before edit the email box
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Code what you want to show on text Changed in email box

            }

        }


    //create function to set date after userKyc finish enter text
    val dateTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                userKyc.setDate(if(s.toString()!="") s.toString().toInt() else 0)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Code what you want to show before edit the password box

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Code what you want to show on text Changed in password box

            }

        }

    //create function to set month after userKyc finish enter text
    val monthTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                userKyc.setMonth(if(s.toString()!="") s.toString().toInt() else 0)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Code what you want to show before edit the password box

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Code what you want to show on text Changed in password box

            }

        }

    //create function to set year after userKyc finish enter text
    val yearTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                userKyc.setYear(if(s.toString()!="") s.toString().toInt() else 0)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Code what you want to show before edit the password box

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Code what you want to show on text Changed in password box

            }

        }

    fun onNextBtnClicked(v: View) {
        when (userKyc.isDataValid()) {
            0 -> listener.onError("Enter PAN number")
            1 -> listener.onError("Enter valid PAN number")
            2 -> listener.onError("Enter valid Date")
            3 -> listener.onError("Enter valid Month")
            4 -> listener.onError("Enter valid Year")
            else -> {
                listener.onSuccess("Details submitted successfully")
                listener.dismissActivity()
            }
        }
    }

    fun onNoPanBtnClicked(v: View) {
        listener.onSuccess("Okay")
        listener.dismissActivity()
    }

    fun isBtnEnabled(): Boolean {
        return userKyc.isDataValid() == -1
    }

}