package com.jpgames.tiptime

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jpgames.tiptime.databinding.ActivityMainBinding
import kotlin.math.round
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculate.setOnClickListener { if (binding.costOfServiceEditText.text!!.isNotEmpty()) {calculateTip()} }
    }

    private fun calculateTip() {
        var cost = binding.costOfServiceEditText.text.toString().toDouble()
        cost *= when {
            binding.optionTwentyPercent.isChecked -> {
                .2
            }
            binding.optionEighteenPercent.isChecked -> {
                .18
            }
            else -> {
                .15
            }
        }
        cost = when {
            binding.roundUpSwitch.isChecked -> round(cost)
            else -> (cost * 100).roundToInt() / 100.0
        }
        binding.tipScore.text = resources.getString(R.string.your_tip_equals)+cost
    }
}