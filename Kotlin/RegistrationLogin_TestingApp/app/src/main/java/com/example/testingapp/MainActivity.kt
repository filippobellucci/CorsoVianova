package com.example.testingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {                  //Dichiarazione della classe Main che estende AppCompactActivity
    override fun onCreate(savedInstanceState: Bundle?) {    //Primo metodo chiamato nel ciclo di vita di Activity
        super.onCreate(savedInstanceState)                  //chiamata al super di onCreate
        setContentView(R.layout.activity_main)              //metodo di activity che collega xml e activity

        //DICHIARAZIONE DELLE VIEW
        val usernameET : EditText = findViewById(R.id.username_main)
        val passwordET : EditText = findViewById(R.id.password_main)
        val passConfirmET : EditText = findViewById(R.id.pass_confirm_main)
        val registrationBtn : Button = findViewById(R.id.registrazione_btn_main)
        val registrationMessTV : TextView = findViewById(R.id.registrazione_mess_main)

        //comportamento al click del pulsante 'registrationBtn'
        //viene passato un ogetto che implementa View.OnClickListener
        registrationBtn.setOnClickListener{

            registrationMessTV.visibility = View.INVISIBLE                                  //reset della visibilita' di registrationMessTV

            //INIZIALIZZAZIONI
            val util = RegistrationUtil()                                                   //istanziamento oggetto RegistrationUtil che verifica la correttezza degli input
            val resultUser = util.validateUsername(usernameET.text.toString())              //verifica Username valido
            val resultPass = util.validatePassword(passwordET.text.toString())              //verifica Password valida
            val resultPassConf = util.validatePassConfirm(passwordET.text.toString())

            if(resultUser){                                                                 //controllo della validita' dell'Username
                if (resultPass){                                                            //se Username valido controllo validita' della Password
                    if (passwordET.text.toString() == passConfirmET.text.toString()){       //controllo che la Password sia uguale a PasswordConfirm
                        registrationMessTV.visibility = View.VISIBLE                        //rendo visibile la scritta "Registrazione avvenuta con successo"
                    }else{
                        passConfirmET.error = "Le due password devono coincidere"
                    }
                }else{
                    passwordET.error = "La password deve essere lunga 8-16 caratteri, contenere almeno una lettera maiuscola, una minuscola e un carattere speciale"
                }
            }else{
                usernameET.error = "L'Username inserito e' gia' esistente"
            }

        }

    }
}