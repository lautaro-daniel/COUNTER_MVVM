package com.pil.tp_04.mvvm.contract

import androidx.lifecycle.LiveData
import com.pil.tp_04.mvvm.viewmodel.CounterViewModel

interface MainContract {
    interface Model {
        var counter: Int
        fun increment(inputValue: Int)
        fun decrement(inputValue: Int)
        fun reset()
    }

    interface ViewModel {
        fun increaseValue(value:Int)
        fun decrementValue(value:Int)
        fun resetValue()
        fun getValue(): LiveData<CounterViewModel.CounterData>
    }
}
