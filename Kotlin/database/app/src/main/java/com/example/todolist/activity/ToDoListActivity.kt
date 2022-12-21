package com.example.todolist.activity

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.data.ToDoDatabaseHandler
import com.example.todolist.data.ToDoListAdapter
import com.example.todolist.model.ToDo
import kotlinx.android.synthetic.main.activity_to_do_list.*
import kotlinx.android.synthetic.main.popup.view.*
import kotlinx.android.synthetic.main.popup_menu.view.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.io.Writer

class ToDoListActivity : AppCompatActivity() {

    private var adapter : ToDoListAdapter? = null   //variabile di appoggio per richiamare la classe ToDoListAdapter
    private var toDoListItem : ArrayList<ToDo>? = null  //lista nella quale registro il ToDoList in senso contrario
    private var toDoList : ArrayList<ToDo>? = null  //variabile di appoggio in cui inserisco tutte le righe del mio database
    private var layoutManager : RecyclerView.LayoutManager? = null  //entita' che gestisce e organizza gli elementi che nascono dalla list_row (passano prima dall'adattatore)

    private var dialogBuilder : AlertDialog.Builder? = null //da informazioni di come deve essere il popup
    private var dialog : AlertDialog? = null    //serve per decidere se visualizzare il popup o eliminarlo

    var dbHandler : ToDoDatabaseHandler? = null
    var json = JSONObject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do_list)

        toDoListItem = ArrayList<ToDo>()
        adapter = ToDoListAdapter(toDoListItem!!, this) //inizializzo la variabile adapter inserendo il valore della classe ToDoListAdapter
        toDoList = ArrayList<ToDo>()
        layoutManager = LinearLayoutManager(this)   //inizializzo layoutManager con un layout verticale

        recycleViewId.layoutManager = layoutManager //associamo il layoutManager che abbiamo creato con il layoutManager del recycleViewId
        recycleViewId.adapter = adapter //associamo l'adapter che abbiamo creato con l'adapter del recycleViewId


        dbHandler = ToDoDatabaseHandler(this)

        toDoList = dbHandler!!.readAllToDo()
        toDoList!!.reverse()

        for(t in toDoList!!.iterator()){
            val toDo = ToDo()
            toDo.toDoName = t.toDoName
            toDo.id = t.id
            toDo.date = t.date

            //Log.d("Lista", t.toDoName.toString())

            toDoListItem!!.add(toDo)
        }

        json.put("LISTA TODO", addTodo(toDoListItem!!))
        saveFile(json.toString())

        var appoggioTodo = getTodo(json, 0)
        Log.d("PROVA", appoggioTodo.id.toString() + ", " + appoggioTodo.toDoName + ", " + appoggioTodo.date)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_menu, menu) //fa apparire l'elemento creato all'interno della schermata (tasto menu)

        return true //l'elemento deve esistere sempre, percio' ritorno true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.add_menu_button){
            createPopupDialog()
            Log.d("item clicked", "item clicked")
        }
        return super.onOptionsItemSelected(item)    //restituisce quale elemento abbiamo selezionato
    }

    fun createPopupDialog(){
        var view = layoutInflater.inflate(R.layout.popup, null)
        var todoName = view.PopEnterToDoList
        var saveButton = view.PopSave
        var menuButton = view.button
        var todo = ToDo()

        dialogBuilder = AlertDialog.Builder(this).setView(view)
        dialog = dialogBuilder!!.create()
        dialog!!.show()

        menuButton.setOnClickListener {
            var dialogBuilder1 : AlertDialog.Builder
            var dialog1 : AlertDialog?
            var view2 = LayoutInflater.from(this).inflate(R.layout.popup_menu, null, false)
            var dataModifica = view2.calendarView2
            var saveButton2 = view2.PopSave1

            dialogBuilder1 = AlertDialog.Builder(this).setView(view2)
            dialog1 = dialogBuilder1!!.create()
            dialog1.show()

            dataModifica.setOnDateChangeListener { calendarView2, year, month, day ->
                todo.date = "$day/${month+1}/$year"
            }

            saveButton2.setOnClickListener {
                dialog1!!.dismiss()
            }
        }

        saveButton.setOnClickListener {
            if (!TextUtils.isEmpty(todoName.text)){
                todo.toDoName = todoName.text.toString()
                dbHandler!!.createToDo(todo)
                dialog!!.dismiss()
                startActivity(Intent(this, ToDoListActivity::class.java))
                finish()
            }
        }
    }

    fun CreaFile() : File {
        val nomeFile = "myJSON"
        val percorsoFile = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)

        if(!percorsoFile!!.exists()){
            percorsoFile.mkdir()
        }
        return File.createTempFile(nomeFile, ".json", percorsoFile)
    }

    fun saveFile (x : String){
        val output : Writer
        output = BufferedWriter(FileWriter(CreaFile()))
        output.write(x)
        output.close()
    }

    fun addTodo (x : ArrayList<ToDo>) : JSONArray{
        var toDoJSON = JSONArray()
        x.forEach {
            toDoJSON.put(JSONArray()
                .put(it.id)
                .put(it.toDoName)
                .put(it.date))
        }
        return toDoJSON
    }

    fun getTodo (x : JSONObject, y: Int) : ToDo{
        var toDOSupport = ToDo()
        var appoggio = x.getJSONArray("LISTA TODO")

        var array1 = appoggio.getJSONArray(y)
        var id = array1.get(0).toString()
        var name = array1.get(1).toString()
        var date = array1.get(2).toString()

        toDOSupport.id = id.toInt()
        toDOSupport.toDoName = name
        toDOSupport.date = date

        return toDOSupport
    }


}