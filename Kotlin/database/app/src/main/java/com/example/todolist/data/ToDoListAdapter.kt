package com.example.todolist.data

import android.app.AlertDialog
import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.model.ToDo
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_row.view.*
import kotlinx.android.synthetic.main.popup.view.*
import kotlinx.android.synthetic.main.popup.view.PopSave
import kotlinx.android.synthetic.main.popup_menu.view.*

//creiamo una classe con lo scopo di poter inserire il relativeLayout di tutte le cardView all'interno del recycleView. Il nostro output sara' una struttura
//come quella del recycleView in cui, all'interno di ogni item, ci saranno dati diversi (presi all'interno del relativeLayout della
// cardView stessa, che a sua volta prende i dati dal database)
class ToDoListAdapter(private var list: ArrayList<ToDo>, private val context: Context): RecyclerView.Adapter<ToDoListAdapter.ViewHolder>() {
    //RecyclerView.Adapter --> estensione che mi permette di utilizzare gli struimenti necessari per riempire una pagina con il layout desiderato
    //ToDoListAdapter.ViewHolder --> luogo da cui prendere le informazioni da inserire all'interno dell'elenco (item0, item1, item2, ecc...)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_row, parent, false)
        return ViewHolder(view)
    }
    //onCreateViewHolder --> funzione che mi permette di identificare il layout da copiare (in questo caso il list_row) e sapere dove inserirlo.
    //Restituisce un valore che dovro' utilizzare in seguito

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindview(list[position])
    }
    //onBindViewHolder --> funzione che mi permette di sapere quale elmento/i prendere (in questo caso il toDoName) e in quale posizione inserirlo/i

    override fun getItemCount(): Int {
        return list.size
    }
    //getItemCount --> funzione che mi permette di contare gli elementi all'interno della lista

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
        var todoList = list
        var toDoName = itemView.findViewById(R.id.listToDoName) as TextView
        var toDoDate = itemView.findViewById(R.id.Date) as TextView
        var editbutton = itemView.findViewById(R.id.update_btn) as Button
        var deletebutton = itemView.findViewById(R.id.delete_btn) as Button

        fun bindview(toDo: ToDo){
            toDoName.text = toDo.toDoName
            toDoDate.text = toDo.date
            editbutton.setOnClickListener(this)
            deletebutton.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            var todoPosition : Int = adapterPosition
            when(p0!!.id){
                deletebutton.id->{
                    Toast.makeText(context, "Deleted", Toast.LENGTH_LONG).show()
                    deleteRow(todoList[todoPosition].id!!)
                    list.removeAt(todoPosition)
                    notifyItemRemoved(todoPosition)
                }
                editbutton.id->{
                    editRow(list[adapterPosition])
                }
            }
        }

        fun deleteRow(id : Int){
            var db : ToDoDatabaseHandler = ToDoDatabaseHandler(context)
            db.deleteToDo(id)
        }

        fun editRow(toDo: ToDo){
            var db : ToDoDatabaseHandler = ToDoDatabaseHandler(context)
            var dialogBuilder : AlertDialog.Builder
            var dialog : AlertDialog?
            var view = LayoutInflater.from(context).inflate(R.layout.popup, null, false)
            var todoName = view.PopEnterToDoList
            var saveButton = view.PopSave
            var menuButton = view.button    //assegna il bottone alla variabile menuButton
            var datappoggio : String? = null

            dialogBuilder = AlertDialog.Builder(context).setView(view)
            dialog = dialogBuilder!!.create()
            dialog.show()

            menuButton.setOnClickListener {
                var dialogBuilder1 : AlertDialog.Builder
                var dialog1 : AlertDialog?
                var view2 = LayoutInflater.from(context).inflate(R.layout.popup_menu, null, false)
                var dataModifica = view2.calendarView2
                var saveButton2 = view2.PopSave1

                dialogBuilder1 = AlertDialog.Builder(context).setView(view2)
                dialog1 = dialogBuilder1!!.create()
                dialog1.show()

                dataModifica.setOnDateChangeListener { calendarView2, year, month, day ->
                    datappoggio = "$day/${month+1}/$year"
                }

                saveButton2.setOnClickListener {
                    dialog1!!.dismiss()
                    notifyItemChanged(adapterPosition, toDo)
                }
            }

            saveButton.setOnClickListener{
                if (!TextUtils.isEmpty(todoName.text.toString())){
                    toDo.toDoName = todoName.text.toString()
                    toDo.date = datappoggio
                    db!!.updateToDo(toDo)
                    dialog!!.dismiss()
                    notifyItemChanged(adapterPosition, toDo)
                }
            }

        }

    }
    //ViewHolder --> classe utilizzata per prendere gli elementi di layout (in questo caso testo del toDoName) ed assegnargli un valore.
    //La funzione bindView la richiamo all'interno di onBindViewHolder per passargli gli argomenti necessari.
}