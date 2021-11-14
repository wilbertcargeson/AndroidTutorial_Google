package com.example.tipcalculator

import android.icu.text.NumberFormat
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.example.tipcalculator.databinding.ActivityMainBinding
import com.google.android.material.switchmaterial.SwitchMaterial
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener{
            calculateTip()
        }

    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun calculateTip(){

        val cost = binding.plainTextInput.text.toString().toDouble()

        var tip = cost * when(binding.tipOptions.checkedRadioButtonId){
            R.id.option1 -> 0.2
            R.id.option2 -> 0.18
            else -> 0.15
        }

        val willRoundUp : Boolean = binding.roundTipSwitch.isChecked

        if (willRoundUp){
            tip = ceil(tip)
        }

        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipAmount.text = getString(R.string.tip_amount, formattedTip)





    }
}