package com.pil.tp_04.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pil.tp_04.databinding.ActivityMainBinding
import com.pil.tp_04.mvvm.model.MainModel
import com.pil.tp_04.mvvm.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var viewModel: MainViewModel = MainViewModel(MainModel())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.increment.setOnClickListener { viewModel.incrementValue(getInput()) }
        binding.decrement.setOnClickListener { viewModel.decrementValue(getInput()) }
        binding.reset.setOnClickListener { viewModel.resetValue() }

        viewModel.data.observe({lifecycle},::updateUI)
    }

    private fun updateUI(it:MainViewModel.CounterData){
        when(it.state){
            MainViewModel.CounterState.INCREMENT -> {
                binding.counter.text = it.value.toString()
            }

            MainViewModel.CounterState.DECREMENT -> {
                binding.counter.text = it.value.toString()
            }

            MainViewModel.CounterState.RESET -> {
                binding.counter.text = zero_string
                binding.inputCount.text.clear()
            }
        }
    }
    private fun getInput(): Int = binding.inputCount.text.toString().toInt()
    companion object{
        private const val zero_string = "0"
    }
}
