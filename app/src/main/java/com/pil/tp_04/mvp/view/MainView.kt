package com.pil.tp_04.mvp.view

import com.pil.tp_04.activity.MainActivity
import com.pil.tp_04.databinding.ActivityMainBinding
import com.pil.tp_04.mvp.contract.MainContract
import com.pil.tp_04.mvp.view.base.ActivityView

class MainView(activity: MainActivity) : MainContract.View, ActivityView(activity) {

    private var binding: ActivityMainBinding = ActivityMainBinding.inflate(activity.layoutInflater)

    //hola
    init {
        activity.setContentView(binding.root)
    }

    override fun onIncrementButtonPressed(onClick: () -> Unit) {
        binding.increment.setOnClickListener { onClick() }
    }

    override fun onDecrementButtonPressed(onClick: () -> Unit) {
        binding.decrement.setOnClickListener { onClick() }
    }

    override fun onResetButtonPressed(onClick: () -> Unit) {
        binding.reset.setOnClickListener { onClick() }
    }

    override fun clear() {
        binding.inputCount.text.clear()
    }

    override fun getInputValue(): String = binding.inputCount.text.toString()

    override fun showCounter(counter: String) {
        binding.counter.text = counter
    }
}
