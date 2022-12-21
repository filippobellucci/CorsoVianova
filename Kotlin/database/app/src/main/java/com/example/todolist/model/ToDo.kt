package com.example.todolist.model

//classe dalla quale istanzio gli oggetti (id dell'evento, nome dell'evento, data di inserimento, ecc...)
class ToDo() {
    var id : Int? = null
    var toDoName : String? = null
    var date : String? = null

    //costruttore che posso richiamare per istanziare
    constructor(id : Int, toDoName: String, date: String): this(){
        this.id = id
        this.toDoName = toDoName
        this.date = date
    }
}