package com.example.testingapp

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    //lateinit indica che la variabile verra' successivamente inizializzata
    private lateinit var scenario : ActivityScenario<MainActivity>

    @Before //annotazione necessaria per eseguire questo metodo prima dei test
    fun setup(){
        scenario = ActivityScenario.launch(MainActivity::class.java)
        scenario.moveToState(Lifecycle.State.RESUMED)
    }

    @Test   //annotazione necessaria per eseguire il test
    fun registrationProcessTrue_showText(){                                                  //TEST DI AVVENUTA REGISTRAZIONE
        onView(withId(R.id.username_main)).perform(typeText("Andrea"))          //inserisco l'Username 'Andrea'
        onView(withId(R.id.password_main)).perform(typeText("Password1!"))      //inserisco la Password 'Password1!'
        onView(withId(R.id.pass_confirm_main)).perform(typeText("Password1!"))  //inserisco la PasswordConfirm 'Password1!'
        onView(withId(R.id.pass_confirm_main)).perform(closeSoftKeyboard())                  //si utilizza per chiudere la tastiera in modo da poter premere il bottone
        onView(withId(R.id.registrazione_btn_main)).perform(click())                         //pressione del tasto
        onView(withId(R.id.registrazione_mess_main)).check(matches(isDisplayed()))           //mostro a schermo il messaggio contenuto in 'registrazione_mess_main'
    }

    @Test   //annotazione necessaria per eseguire il test
    fun registrationProcessFalseSameUsernames_showText(){                                    //TEST USERNAME GIA' ESISTENTE
        onView(withId(R.id.username_main)).perform(typeText("Filippo"))         //inserisco l'Username 'Filippo'
        onView(withId(R.id.password_main)).perform(typeText("Password1!"))      //inserisco la Password 'Password1!'
        onView(withId(R.id.pass_confirm_main)).perform(typeText("Password1!"))  //inserisco la PasswordConfirm 'Password1!'
        onView(withId(R.id.pass_confirm_main)).perform(closeSoftKeyboard())                  //si utilizza per chiudere la tastiera in modo da poter premere il bottone
        onView(withId(R.id.registrazione_btn_main)).perform(click())                         //pressione del tasto
        onView(withId(R.id.username_main)).perform(click())                                  //click sull'elemento Username per vedere l'errore
    }

    @Test   //annotazione necessaria per eseguire il test
    fun registrationProcessFalseWrongPass_showText(){                                        //TEST PASSWORD NON CORRETTA
        onView(withId(R.id.username_main)).perform(typeText("Andrea"))          //inserisco l'Username 'Andrea'
        onView(withId(R.id.password_main)).perform(typeText("Pass1!"))          //inserisco la Password 'Pass1!'
        onView(withId(R.id.pass_confirm_main)).perform(typeText("Pass1!"))      //inserisco la PasswordConfirm 'Pass1!'
        onView(withId(R.id.pass_confirm_main)).perform(closeSoftKeyboard())                  //si utilizza per chiudere la tastiera in modo da poter premere il bottone
        onView(withId(R.id.registrazione_btn_main)).perform(click())                         //pressione del tasto
        onView(withId(R.id.password_main)).perform(click())                                  //click sull'elemento Password per vedere l'errore
    }

    @Test   //annotazione necessaria per eseguire il test
    fun registrationProcessFalseDismatchedPass_showText(){                                   //TEST PASSWORD NON CORRISPONDENTI
        onView(withId(R.id.username_main)).perform(typeText("Andrea"))          //inserisco l'Username 'Andrea'
        onView(withId(R.id.password_main)).perform(typeText("Password1!"))      //inserisco la Password 'Password1!'
        onView(withId(R.id.pass_confirm_main)).perform(typeText("Password2!"))  //inserisco la PasswordConfirm 'Password2!'
        onView(withId(R.id.pass_confirm_main)).perform(closeSoftKeyboard())                  //si utilizza per chiudere la tastiera in modo da poter premere il bottone
        onView(withId(R.id.registrazione_btn_main)).perform(click())                         //pressione del tasto
        onView(withId(R.id.pass_confirm_main)).perform(click())                              //click sull'elemento PasswordConfirm per vedere l'errore
    }

}