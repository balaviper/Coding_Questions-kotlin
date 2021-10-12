package com.example.assesment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import kotlin.math.pow
import android.text.Editable

import android.text.TextWatcher
import androidx.core.widget.doOnTextChanged
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dec = DecimalFormat("#.00")

        val loan = findViewById<EditText>(R.id.loanamt)
        val loanseek = findViewById<SeekBar>(R.id.loanseek)
        seekBarChange(loan, loanseek, 100000.0)

        val intrest = findViewById<EditText>(R.id.intrest)
        val intrestseek = findViewById<SeekBar>(R.id.intrestseek)
        seekBarChange(intrest, intrestseek, 0.20)


        val tensure = findViewById<EditText>(R.id.tenure)
        val tensureseek = findViewById<SeekBar>(R.id.tenureseek)
        seekBarChange(tensure, tensureseek, 0.30)

        val result = findViewById<TextView>(R.id.result)

        loan.doOnTextChanged { text, start, before, count ->
            if (text.isNullOrBlank() || intrest.text.isNullOrBlank() || tensure.text.isNullOrBlank()) {
                result.text = "0.0"


            } else {
                var ans: Double = emiCal(
                    loan.text.toString().toDouble(),
                    intrest.text.toString().toDouble(),
                    tensure.text.toString().toDouble()
                )
                result.text = "Emi = ${dec.format(ans)}"
            }

        }

        intrest.doOnTextChanged { text, start, before, count ->
            if (text.isNullOrBlank() || loan.text.isNullOrBlank() || tensure.text.isNullOrBlank()) {
                result.text = "0.0"


            } else {
                var ans: Double = emiCal(
                    loan.text.toString().toDouble(),
                    intrest.text.toString().toDouble(),
                    tensure.text.toString().toDouble()
                )
                result.text = "Emi = ${dec.format(ans)}"
            }

        }

        tensure.doOnTextChanged { text, start, before, count ->
            if (text.isNullOrBlank() || intrest.text.isNullOrBlank() || loan.text.isNullOrBlank()) {
                result.text = "0.0"


            } else {
                var ans: Double = emiCal(
                    loan.text.toString().toDouble(),
                    intrest.text.toString().toDouble(),
                    tensure.text.toString().toDouble()
                )
                result.text = "Emi = ${dec.format(ans)}"
            }

        }


    }

    private fun seekBarChange(s: TextView, seek: SeekBar, value: Double) {
        val dec = DecimalFormat("#.00")
        seek?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(
                seek: SeekBar,
                progress: Int, fromUser: Boolean
            ) {
                s.text = dec.format(progress * value)
//

            }

            override fun onStartTrackingTouch(seek: SeekBar) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })
    }

    fun emiCal(
        p: Double,
        r: Double,
        t: Double
    ): Double {
        var r = r
        var t = t
        val emi: Double
        r = r / (12 * 100) // one month interest
        t = t * 12 // one month period
        emi = (p * r * Math.pow((1 + r).toDouble(), t.toDouble()).toDouble()
                / (Math.pow((1 + r).toDouble(), t.toDouble()) - 1).toDouble())
        return emi
    }
//    private fun emiCal(princilal: Double, intrest: Double, years: Double): Double {
//
//        val emi = princilal * intrest * ((1 + intrest).pow(years) / ((1 + intrest).pow(years)) - 1)
//        Log.i("emi", "$emi")
//        return emi
//    }
}