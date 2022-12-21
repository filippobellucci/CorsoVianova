package com.example.todolist.data

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.todolist.model.*

class ToDoDatabaseHandler(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        var CREATE_TODO_TABLE = "CREATE TABLE $TABLE_NAME ($KEY_ID INTEGER PRIMARY KEY, $KEY_TODO_NAME TEXT, $KEY_TODO_DATE TEXT)"
        //la PRIMARY KEY viene aggiornata automaticamente in quanto primaria
        db?.execSQL(CREATE_TODO_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    //CRUD - Create, Read, Update, Delete
    fun createToDo(toDo: ToDo){
        val db : SQLiteDatabase = writableDatabase      //sto dicendo che posso scrivere una nuova riga, modificandolo

        var values : ContentValues = ContentValues()    //creo un contenitore in cui inseriro' tutti i valori di cui necessito
        values.put(KEY_TODO_NAME, toDo.toDoName)        //inserisco nella colonna KEY_TODO_NAME il valore di toDoName della classe toDoClass
        values.put(KEY_TODO_DATE, toDo.date)

        db.insert(TABLE_NAME, null, values) //inserisce i valori che abbiamo messo in values all'interno del database

        Log.d("DATI INSERITI", "SUCCESS")   //test
        db.close()
    }

    @SuppressLint("Range")  //ignora il warning dell'index delle colonne (in caso non ci fossero colonne, restituirebbe -1 e darebbe errore)
    fun readToDo(id : Int): ToDo{
        val db : SQLiteDatabase = readableDatabase

        //INTERFACCIA CHE FORNISCE UN ACCESSO AL DATABASE

        /*

        CURSOR = INTERFACCIA CHE FORNISCE UN ACCESSO AD UN DATABASE
        db.query (DOMANDA VERSO IL NOSTRO DATABASE) -> RICHIERDE DETERMINATI ARGOMENTI

            * primo argomento (STRINGA) -> NOME DELLA TABELLA DENTRO IL DATABASE
            * secondo argomento (ARRAY DI STRINGHE) -> INSERIAMO LE COLONNE CHE VOLGIAMO ALAIZZARE (NULL=TUTTE LE COLONNE)
            * terzo argomento (STRINGA) -> ID DELLA RIGA CHE BOLFIO ANALIZZARE  (CON IL COMANDO "=?" PESCO L'ARGOMENTO DELLA MIA FUNZIONE ES: READATODO(ARGOMENTO)
            * quarto argomento (ARRAY DI STRINGHE) -> MI FACCIO RETITUIRE TUTTI GLI ELEMENTI RICHIESTI (COLONNE) DALL'ID SELEZIONATO
            * quinto argomento (STRINGA) -> UN FILTRO CHE MI DICHIARA COME RAGGRUPPARE LE RICHE (NON NECESSARIO PUO' ESSERE NULL)
            * sesto argomento (STRINGA) -> RICHIEDO QUALE GRUPPO DI RIGHE (SE SONO RAGGIUPPATE) PRENDERE (NON NECESSARIO, PUO' ESSERE NULL)
            * settimo argomento (STRINGA) -> COME ORDINARE LE RIGHE, SE NULL HO L'ORGDINE DI DEFAULT
            * ottavo argomento (STRINGA) -> IMPOSTARE IL LIMITE DELLE RIGHE DA RESTITUIRCI

        */

        var cursor : Cursor = db.query(TABLE_NAME, arrayOf(KEY_ID, KEY_TODO_NAME), KEY_ID + "=?", arrayOf(id.toString()), null, null, null)

        cursor.moveToFirst()    //sposta il cursore alla prima riga del database

        var toDo = ToDo()
        toDo.toDoName = cursor.getString(cursor.getColumnIndex(KEY_TODO_NAME))
        toDo.date = cursor.getString(cursor.getColumnIndex(KEY_TODO_DATE))
        return toDo
    }

    @SuppressLint("Range")
    fun readAllToDo(): ArrayList<ToDo>{
        var db : SQLiteDatabase = readableDatabase
        var list : ArrayList<ToDo> = ArrayList()
        var selectall = "SELECT * FROM $TABLE_NAME"
        var cursor : Cursor = db.rawQuery(selectall, null)

        if(cursor.moveToFirst()){
            do {
                var todo = ToDo()
                todo.id = cursor.getInt(cursor.getColumnIndex(KEY_ID))
                todo.toDoName = cursor.getString(cursor.getColumnIndex(KEY_TODO_NAME))
                todo.date = cursor.getString(cursor.getColumnIndex(KEY_TODO_DATE))
                list.add(todo)
            }while (cursor.moveToNext())
        }
        return list
    }

    fun updateToDo (toDo: ToDo): Int{
        val db : SQLiteDatabase = writableDatabase
        var values : ContentValues = ContentValues()    //creo un contenitore in cui inseriro' tutti i valori di cui necessito
        values.put(KEY_TODO_NAME, toDo.toDoName)
        values.put(KEY_TODO_DATE, toDo.date)

        /*

        UPDATE = AGGIORNA UNA RIGA DEL DATABASE (HA BISOGNO DI 4 ARGOMENTI)

            * primo argomento --> Nome dell atabella che voglio modificare
            * secondo argomento --> Valori che voglio aggiornare
            * terzo argomento --> Quale riga prendere in considerazione (riga da aggiornare)
            * quarto argomento --> Elementi che verranno sostituiti dai nuovi valori

        */

        return db.update(TABLE_NAME, values, KEY_ID + "=?", arrayOf(toDo.id.toString()))
    }

    fun deleteToDo (id : Int){
        val db : SQLiteDatabase = writableDatabase

        /*

        DELETE = ELIMINA UNA RIGA DEL DATABASE (HA BISOGNO DI 3 ARGOMENTI)

            * primo argomento --> Nome dell atabella che voglio modificare
            * secondo argomento --> Quale riga prendere in considerazione (riga da eliminare)
            * terzo argomento --> Elementi che verranno eliminati

        */

        db.delete(TABLE_NAME, KEY_ID + "=?", arrayOf(id.toString()))
        db.close()
    }


}