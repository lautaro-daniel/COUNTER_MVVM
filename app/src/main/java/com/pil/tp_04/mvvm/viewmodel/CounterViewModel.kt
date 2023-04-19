package com.pil.tp_04.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pil.tp_04.mvvm.contract.MainContract

class CounterViewModel(private val model:MainContract.Model): ViewModel(), MainContract.ViewModel {

    private val mutableData: MutableLiveData<CounterData> = MutableLiveData()

    val data: LiveData<CounterData> = mutableData
    override fun increaseValue(value: Int) {
        model.increment(value)
        mutableData.postValue(CounterData(CounterState.INCREMENT, model.counter))
    }

    override fun decrementValue(value: Int) {
        model.decrement(value)
        mutableData.postValue(CounterData(CounterState.DECREMENT, model.counter))
    }

    override fun resetValue() {
        model.reset()
        mutableData.postValue(CounterData(CounterState.RESET, zero_string.toInt()))
    }

    override fun getValue(): LiveData<CounterViewModel.CounterData> {
        return mutableData
    }

    data class CounterData(
        val state : CounterState,
        val value: Int = zero_int
    )

    enum class CounterState {
        INCREMENT,
        DECREMENT,
        RESET
    }

    companion object{
        private const val zero_string = "0"
        private const val zero_int = 0
    }


}