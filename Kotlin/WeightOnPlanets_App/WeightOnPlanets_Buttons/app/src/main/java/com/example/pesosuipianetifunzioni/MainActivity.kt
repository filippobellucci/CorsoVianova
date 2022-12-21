package com.example.pesosuipianetifunzioni

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var planet : String? = null
    private var calculation_result : Double = 0.0

    private fun buttonFunction (){
        Mercury.setOnClickListener {
            planet = "Mercury"
            titolo_main2.text = "MERCURY"
            titolo_main2.visibility = View.VISIBLE
        }

        Venus.setOnClickListener {
            planet = "Venus"
            titolo_main2.text = "VENUS"
            titolo_main2.visibility = View.VISIBLE
        }

        Mars.setOnClickListener {
            planet = "Mars"
            titolo_main2.text = "MARS"
            titolo_main2.visibility = View.VISIBLE
        }

        Jupiter.setOnClickListener {
            planet = "Jupiter"
            titolo_main2.text = "JUPITER"
            titolo_main2.visibility = View.VISIBLE
        }

        Saturn.setOnClickListener {
            planet = "Saturn"
            titolo_main2.text = "SATURN"
            titolo_main2.visibility = View.VISIBLE
        }

        Uranus.setOnClickListener {
            planet = "Uranus"
            titolo_main2.text = "URANUS"
            titolo_main2.visibility = View.VISIBLE
        }

    }

    private fun TwoDecimalDigits (x : Double) : Double{
        var a = (x*100).toInt()
        var b : Double = (a.toDouble()/100)
        return b
    }

    private fun weightCalculation (x : Double) : Double{
        when(planet){
            "Mercury" ->{
                calculation_result = x * (3.7/9.81)
            }
            "Venus" ->{
                calculation_result = x * (8.87/9.81)
            }
            "Mars" ->{
                calculation_result = x * (3.71/9.81)
            }
            "Jupiter" ->{
                calculation_result = x * (24.79/9.81)
            }
            "Saturn" ->{
                calculation_result = x * (8.96/9.81)
            }
            "Uranus" ->{
                calculation_result = x * (8.69/9.81)
            }
            else -> {
                calculation_result = 0.0
            }
        }
        return calculation_result
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonFunction()

        invio.setOnClickListener {

            val weight_value = peso_utente.text.toString()
            if (planet.equals("") || weight_value.equals("")){
                Toast.makeText(this, "You have not entered the weight or you have not chosen the planet", Toast.LENGTH_LONG).show()
            }
            else{
                val userWeight = weight_value.toDouble()
                weightCalculation(userWeight)
            }

            var weight_result : Double = TwoDecimalDigits(calculation_result)
            numero.text = weight_result.toString()
            numero.visibility = View.VISIBLE

        }

    }

}