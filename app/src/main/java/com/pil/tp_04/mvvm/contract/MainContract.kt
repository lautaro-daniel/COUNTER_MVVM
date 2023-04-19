package com.pil.tp_04.mvvm.contract

import androidx.lifecycle.LiveData
import com.pil.tp_04.mvvm.viewmodel.MainViewModel

interface MainContract {
    interface Model {
        var counter: Int
        fun increment(inputValue: Int)
        fun decrement(inputValue: Int)
        fun reset()
    }

    interface ViewModel {
        fun incrementValue(value:Int)
        fun decrementValue(value:Int)
        fun resetValue()
        fun getValue(): LiveData<MainViewModel.CounterData>
    }
}
