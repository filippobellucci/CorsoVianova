package com.example.todolist.activity

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import com.example.todolist.R
import com.example.todolist.data.ToDoDatabaseHandler
import com.example.todolist.model.ToDo
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.popup_menu.*
import kotlinx.android.synthetic.main.popup_menu.view.*


class MainActivity : AppCompatActivity() {

    var dbHandler: ToDoDatabaseHandler? = null  //dichiaro la  variabile di appoggio per la gestione del database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var toDo = ToDo()
        dbHandler = ToDoDatabaseHandler(this)   //inizializzo variabile di appoggio per la gestione del database

        if(dbHandler!!.readAllToDo().size > 0){
            startActivity(Intent(this, ToDoListActivity::class.java))
        }

        button3.setOnClickListener {
            var dialogBuilder1 : AlertDialog.Builder
            var dialog1 : AlertDialog?
            var view2 = LayoutInflater.from(this).inflate(R.layout.popup_menu, null, false)
            var dataModifica = view2.calendarView2
            var saveButton2 = view2.PopSave1

            dialogBuilder1 = AlertDialog.Builder(this).setView(view2)
            dialog1 = dialogBuilder1!!.create()
            dialog1.show()

            dataModifica.setOnDateChangeListener { calendarView2, year, month, day ->
                toDo.date = "$day/${month+1}/$year"
            }

            saveButton2.setOnClickListener {
                dialog1!!.dismiss()
            }
        }

        Save.setOnClickListener {
            if (!TextUtils.isEmpty(enterToDoList.text)){
                toDo.toDoName = enterToDoList.text.toString()
                if (toDo.date == null){
                    toDo.date = " "
                }
                saveToDb(toDo)
                startActivity(Intent(this, ToDoListActivity::class.java))   //comando utilizzato per passare ad un altra activity
            }else{
                Toast.makeText(this, "Inserisci prima una task!", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun saveToDb(toDo: ToDo){
        dbHandler!!.createToDo(toDo)
    }
}