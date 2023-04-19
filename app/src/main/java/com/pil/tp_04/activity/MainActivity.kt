package com.pil.tp_04.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pil.tp_04.databinding.ActivityMainBinding
import com.pil.tp_04.mvvm.model.MainModel
import com.pil.tp_04.mvvm.viewmodel.CounterViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var viewModel: CounterViewModel = CounterViewModel(MainModel())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.increment.setOnClickListener { viewModel.increaseValue(getInput()) }
        binding.decrement.setOnClickListener { viewModel.decrementValue(getInput()) }
        binding.reset.setOnClickListener { viewModel.resetValue() }

        viewModel.data.observe({lifecycle},::updateUI)
    }

    private fun updateUI(it:CounterViewModel.CounterData){
        when(it.state){
            CounterViewModel.CounterState.INCREMENT -> {
                binding.counter.text = it.value.toString()
            }

            CounterViewModel.CounterState.DECREMENT -> {
                binding.counter.text = it.value.toString()
            }

            CounterViewModel.CounterState.RESET -> {
                binding.inputCount.text.clear()
            }
        }
    }

    private fun getInput(): Int = binding.inputCount.text.toString().toInt()
}
