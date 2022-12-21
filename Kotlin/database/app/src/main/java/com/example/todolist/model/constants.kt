package com.example.todolist.model

//CREAZIONE DEL DATABASE

//DATI (NECESSARI) E CARATTERISTICHE DEL NOSTRO DATABASE
val DATABASE_VERSION : Int = 2
val DATABASE_NAME : String = "todo.db"  //deve avere l'estensione db perche' sara' un file
val TABLE_NAME : String = "todo"

//NOMI COLONNE DELLA TABELLA TODODB
val KEY_ID : String = "id"
val KEY_TODO_NAME : String = "todo_name"
val KEY_TODO_DATE : String = "todo_date"