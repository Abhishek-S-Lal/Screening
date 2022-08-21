package com.epifi.screening.interfaces

interface KycCallbacks {
    fun onSuccess(message: String)
    fun onError(message: String)
    fun dismissActivity()
}