package com.example.assesment4

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    private val _data = MutableLiveData<ArrayList<ItemData>>()
    val data: LiveData<ArrayList<ItemData>> = _data

    private val _text = MutableLiveData<String>()
    val text: LiveData<String> = _text
    private val _date = MutableLiveData<String>()
    val date: LiveData<String> = _date
    private val _price = MutableLiveData<String>()
    val price: LiveData<String> = _price

    fun editText(str: String, dt: String, price: Int) {
        _text.value = str
        _date.value = dt
        _price.value = price.toString()
        _data.value?.add(ItemData(text.value,date.value,date.value))
    }
}