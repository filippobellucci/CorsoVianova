package com.example.pesosuipianetichecklist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val mercuryGravity = 0.37716615698
    private val venusGravity = 0.90417940876
    private val marsGravity = 0.37818552497
    private val jupiterGravity = 2.52701325178
    private val saturnGravity = 0.91335372069
    private val uranusGravity = 0.88583078491

    var result: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Mercury.setOnClickListener(this)
        Venus.setOnClickListener(this)
        Mars.setOnClickListener(this)
        Jupiter.setOnClickListener(this)
        Saturn.setOnClickListener(this)
        Uranus.setOnClickListener(this)
    }

    private fun TwoDecimalDigits (x : Double) : Double{
        var a = (x*100).toInt()
        var b : Double = (a.toDouble()/100)
        return b
    }

    private fun weightCalculation(x: Double, checkbox: CheckBox){

        when (checkbox.id) {
            R.id.Mercury -> {
                result = x*mercuryGravity
                numero.text = TwoDecimalDigits(result).toString()
                numero.visibility = View.VISIBLE
            }
            R.id.Venus -> {
                result = x*venusGravity
                numero.text = TwoDecimalDigits(result).toString()
                numero.visibility = View.VISIBLE
            }
            R.id.Mars -> {
                result = x*marsGravity
                numero.text = TwoDecimalDigits(result).toString()
                numero.visibility = View.VISIBLE
            }
            R.id.Jupiter -> {
                result = x*jupiterGravity
                numero.text = TwoDecimalDigits(result).toString()
                numero.visibility = View.VISIBLE
            }
            R.id.Saturn -> {
                result = x*saturnGravity
                numero.text = TwoDecimalDigits(result).toString()
                numero.visibility = View.VISIBLE
            }
            R.id.Uranus -> {
                result = x*uranusGravity
                numero.text = TwoDecimalDigits(result).toString()
                numero.visibility = View.VISIBLE
            }
        }
    }


    override fun onClick(v: View?) {
        v as CheckBox
        var isChecked: Boolean = v.isChecked
        var weight : Double

        if (peso_utente.text.toString().equals("")){
            Toast.makeText(this, "You must enter your weight first", Toast.LENGTH_LONG).show()
            Mercury.isChecked = false
            Venus.isChecked = false
            Mars.isChecked = false
            Jupiter.isChecked = false
            Saturn.isChecked = false
            Uranus.isChecked = false
        }else{
            weight = peso_utente.text.toString().toDouble()
            when (v.id) {
                R.id.Mercury -> if(isChecked && peso_utente.text.toString() != ""){
                    titolo_main2.text = "MERCURY"
                    titolo_main2.visibility = View.VISIBLE
                    weightCalculation(weight, v)
                    Venus.isChecked = false
                    Mars.isChecked = false
                    Jupiter.isChecked = false
                    Saturn.isChecked = false
                    Uranus.isChecked = false
                }
                R.id.Venus -> if(isChecked && peso_utente.text.toString() != ""){
                    titolo_main2.text = "VENUS"
                    titolo_main2.visibility = View.VISIBLE
                    weightCalculation(weight, v)
                    Mercury.isChecked = false
                    Mars.isChecked = false
                    Jupiter.isChecked = false
                    Saturn.isChecked = false
                    Uranus.isChecked = false
                }
                R.id.Mars -> if(isChecked && peso_utente.text.toString() != ""){
                    titolo_main2.text = "MARS"
                    titolo_main2.visibility = View.VISIBLE
                    weightCalculation(weight, v)
                    Mercury.isChecked = false
                    Venus.isChecked = false
                    Jupiter.isChecked = false
                    Saturn.isChecked = false
                    Uranus.isChecked = false
                }
                R.id.Jupiter -> if(isChecked && peso_utente.text.toString() != ""){
                    titolo_main2.text = "JUPITER"
                    titolo_main2.visibility = View.VISIBLE
                    weightCalculation(weight, v)
                    Mercury.isChecked = false
                    Venus.isChecked = false
                    Mars.isChecked = false
                    Saturn.isChecked = false
                    Uranus.isChecked = false
                }
                R.id.Saturn -> if(isChecked && peso_utente.text.toString() != ""){
                    titolo_main2.text = "SATURN"
                    titolo_main2.visibility = View.VISIBLE
                    weightCalculation(weight, v)
                    Mercury.isChecked = false
                    Venus.isChecked = false
                    Mars.isChecked = false
                    Jupiter.isChecked = false
                    Uranus.isChecked = false
                }
                R.id.Uranus -> if(isChecked && peso_utente.text.toString() != ""){
                    titolo_main2.text = "URANUS"
                    titolo_main2.visibility = View.VISIBLE
                    weightCalculation(weight, v)
                    Mercury.isChecked = false
                    Venus.isChecked = false
                    Mars.isChecked = false
                    Jupiter.isChecked = false
                    Saturn.isChecked = false
                }
            }
        }
    }

}