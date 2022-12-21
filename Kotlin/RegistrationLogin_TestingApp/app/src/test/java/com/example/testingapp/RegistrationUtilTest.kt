package com.example.testingapp

import androidx.lifecycle.Lifecycle
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class RegistrationUtilTest {

    /**
     * La registrazione non va a buon fine se...
     * ...username e' vuoto
     * ...password e' vuoto
     * ...passwordConfirm e' vuoto
     * ...password e passwordConfirm non corrispondono
     * ...se username e' gia' usato
     * ...se username contiene degli spazi interni
     * ...se password non contiene 8 caratteri
     * ...se password non contiene una lettera maiuscola
     * ...se password non contiene una lettera minuscola
     * ...se password non contiene un carattere speciale
     * ...se password non contiene un numero
     *
     * La registrazione va a buon fine se...
     * ...username, password e passwordConfirm sono corretti
     */

    //lateinit indica che la variabile verra' successivamente inizializzata
    private lateinit var ru : RegistrationUtil  //la variabile ru e' di tipo RegistrationUtil

    @Before //annotazione necessaria per eseguire questo metodo prima dei test
    fun setup(){
        ru = RegistrationUtil()
    }

    @Test   //annotazione necessaria per eseguire il test
    fun validateRegistration_usernameVuoto_returnFalse() {  //TEST USERNAME VUOTO
        val result = ru.validateRegistration(
            username = "",
            password = "Password1!",
            passwordConfirm = "Password1!"
        )
        assertThat(result).isFalse()
    }

    @Test   //annotazione necessaria per eseguire il test
    fun validateRegistration_passwordVuoto_returnFalse() {  //TEST PASSWORD VUOTO
        val result = ru.validateRegistration(
            username = "Filippo",
            password = "",
            passwordConfirm = "Password1!"
        )
        assertThat(result).isFalse()
    }

    @Test   //annotazione necessaria per eseguire il test
    fun validateRegistration_passwordConfirmVuoto_returnFalse() {   //TEST PASSWORD_CONFIRM VUOTO
        val result = ru.validateRegistration(
            username = "Filippo",
            password = "Password1!",
            passwordConfirm = ""
        )
        assertThat(result).isFalse()
    }

    @Test   //annotazione necessaria per eseguire il test
    fun validateRegistration_PaaswordNonCorrispondenti_returnFalse() {  //TEST PASSWORD NON CORRISPONDENTI
        val result = ru.validateRegistration(
            username = "Filippo",
            password = "Password1!",
            passwordConfirm = "Password2!"
        )
        assertThat(result).isFalse()
    }

    @Test   //annotazione necessaria per eseguire il test
    fun validateRegistration_UsernameUsato_returnFalse() {  //TEST USERNAME GIA' USATO
        val result = ru.validateRegistration(
            username = "Filippo",
            password = "Password1!",
            passwordConfirm = "Password1!"
        )
        assertThat(result).isFalse()
    }

    @Test   //annotazione necessaria per eseguire il test
    fun validateRegistration_UsernameSpaziInterni_returnFalse() {   //TEST USERNAME CON SPAZI INTERNI
        val result = ru.validateRegistration(
            username = "Fil ippo",
            password = "Password1!",
            passwordConfirm = "Password1!"
        )
        assertThat(result).isFalse()
    }

    @Test   //annotazione necessaria per eseguire il test
    fun validateRegistration_Meno8Caratteri_returnFalse() { //TEST PASSWORD CON MENO DI 8 CARATTERI
        val result = ru.validateRegistration(
            username = "Filippo",
            password = "Pass1!",
            passwordConfirm = "Pass1!"
        )
        assertThat(result).isFalse()
    }

    @Test   //annotazione necessaria per eseguire il test
    fun validateRegistration_PasswordNoLetteraMaiuscola_returnFalse() { //TEST PASSWORD SENZA LETTERA MAIUSCOLA
        val result = ru.validateRegistration(
            username = "Filippo",
            password = "password1!",
            passwordConfirm = "password1!"
        )
        assertThat(result).isFalse()
    }

    @Test   //annotazione necessaria per eseguire il test
    fun validateRegistration_PasswordNoLetteraMinuscola_returnFalse() { //TEST PASSWORD SENZA LETTERA MINUSCOLA
        val result = ru.validateRegistration(
            username = "Filippo",
            password = "PASSWORD1!",
            passwordConfirm = "PASSWORD1!"
        )
        assertThat(result).isFalse()
    }

    @Test   //annotazione necessaria per eseguire il test
    fun validateRegistration_PasswordNoCarattereSpeciale_returnFalse() {    //TEST PASSWORD SENZA CARATTERE SPECIALE
        val result = ru.validateRegistration(
            username = "Filippo",
            password = "Password1",
            passwordConfirm = "Password1"
        )
        assertThat(result).isFalse()
    }

    @Test   //annotazione necessaria per eseguire il test
    fun validateRegistration_PasswordNoNumero_returnFalse() {   //TEST PASSWORD SENZA NUMERO
        val result = ru.validateRegistration(
            username = "Filippo",
            password = "Password!",
            passwordConfirm = "Password!"
        )
        assertThat(result).isFalse()
    }

    @Test   //annotazione necessaria per eseguire il test
    fun validateRegistration_ParametriCorretti_returnTrue() {   //TEST AVVENUTA REGISTRAZIONE
        val result = ru.validateRegistration(
            username = "Andrea",
            password = "Password1!",
            passwordConfirm = "Password1!"
        )
        assertThat(result).isTrue()
    }

}