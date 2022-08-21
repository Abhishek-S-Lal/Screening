package com.epifi.screening.viewModals

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.epifi.screening.interfaces.KycCallbacks

class KycViewModalFactory (private val listener: KycCallbacks): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel>create(modelClass: Class<T>): T {
        return KycViewModel(listener) as T
    }
}