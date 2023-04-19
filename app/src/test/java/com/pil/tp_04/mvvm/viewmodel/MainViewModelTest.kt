package com.pil.tp_04.mvvm.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.pil.tp_04.mvvm.contract.MainContract
import com.pil.tp_04.mvvm.model.MainModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class MainViewModelTest {

    @get:Rule
    var rule : TestRule = InstantTaskExecutorRule()


    private lateinit var viewmodel: MainContract.ViewModel

    @Before
    fun setup() {
        viewmodel = MainViewModel(MainModel())
    }

    @Test
    fun `if I enter five should increment by five`(){
        viewmodel.incrementValue(FIVE)
        assertEquals(FIVE, viewmodel.getValue().value?.value)
        assertEquals(MainViewModel.CounterState.INCREMENT, viewmodel.getValue().value?.state)
    }

    @Test
    fun `if I enter seven should decrement by seven`(){
        viewmodel.incrementValue(SEVEN)
        viewmodel.decrementValue(SEVEN)
        assertEquals(ZERO, viewmodel.getValue().value?.value)
        assertEquals(MainViewModel.CounterState.DECREMENT, viewmodel.getValue().value?.state)
    }

    @Test
    fun `if I press reset button should be zero`(){
        viewmodel.incrementValue(FIVE)
        viewmodel.incrementValue(SEVEN)
        viewmodel.resetValue()
        assertEquals(ZERO, viewmodel.getValue().value?.value)
        assertEquals(MainViewModel.CounterState.RESET, viewmodel.getValue().value?.state)
    }

    companion object {
        private const val ZERO = 0
        private const val FIVE = 5
        private const val SEVEN = 7
    }
}
