package com.seriousgame.richiestesitiinternet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedWriter
import java.io.File
import java.io.FileInputStream
import java.io.FileWriter
import java.io.Writer
import java.nio.channels.FileChannel
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {

    //classe nella quale inserire tutte le richieste da fare (esempio stringRequest) per poterle avviare
    var volleyRequest : RequestQueue? = null

    //funzione per ottenere una stringa tramite StringRequest
    fun getString (URL : String /* URL dal quale prendere le informazioni della pagina */){
        /*
            Utilizzo una variabile di appoggio per gestire la StringRequest.

            StringRequest -> funzione che mi permette di effettuare una richiesta. In questo caso
            sto richiedendo le informzioni di una pagina internet sotto forma di stringa.

            Una StringRequest necessita di diverse informazioni:
                -Metodo della richiesta (tipo di richiesta). In questo caso caso utilizziamo il metodo GET (ricevere informazioni).
                -URL di ddestinazione (a quale pagina faccio richiesta)
                -Response.listener -> risultato della mia richiesta
                -Response.errorlistener -> risultato in caso di errore

            Ogni listener ha bisogno (non necessario) di un TRY & CATCH. Il TRY & CATCH e' uno STATEMENT che mi da determinati risultati
            o eventi in base a cio che accade. Nel TRY effettua l'evento nel caso non ci fossero problemi. Nel CATCH effettua l'evento
            nel caso ci fossero problemi (es. stampare il problema).

        */
        val stringRequest = StringRequest(
            Request.Method.GET,
            URL,
            Response.Listener { response: String ->
                try {
                    Log.d("Response", response)
                }catch (e: JSONException){
                    e.printStackTrace()
                }
            },
        Response.ErrorListener { error : VolleyError? ->
            try {
                Log.d("Error", error.toString())
            }catch (e : JSONException){
                e.printStackTrace()
            }
        })

        //aggiungo lo stringRequest al requestQueue (lista di richieste)
        volleyRequest!!.add(stringRequest)

        //ultima fase -> aggiungere i permessi per accedere alla rete all'interno dell'Android Manifest:
        //<uses-permission android:name="android.permission.INTERNET"/>
    }

    //Parte inerente al file JSON - SALVATAGGIO FILE

    //funzione utilizzata per inserire all'interno di un JSONObject
    fun createJsonData(){
        var json = JSONObject() //variabile di appoggio nel quale inserire il JSONObject

        //variabile di appoggio nella quale viene istanziato l'oggetto proveniente dalla classe User
        val test = User("Filippo", "Bellucci", "Ponsacco", 22)

        //comando per inserire i file all'interno del JSONObject (ha bisogno di un nome e l'argomento)
        json.put("Test information", AddUser(test)) //per salvare le informazioni usiamo una funzione che mi restitusce tutti i valori di user

        //richiamo la funzione creata per salvare il JSONObject
        saveFile(json.toString())
    }

    //funzione utilizzta per creare il file di tipo JSON
    fun createFile() : File{
        val fileName = "myJson" //nome del file
        val pathFile = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS) //percorso dove salvare il file
        if (!pathFile!!.exists()){  //controllo se il percorso esiste
            pathFile.mkdir()    //se non esiste creo il percorso
        }

        //restituisce l einformazioni del file (NOME, ESTENSIONE, PERCORSO DI SALVATAGGIO)
        return File.createTempFile(fileName, ".json", pathFile)
    }

    //funzione utilizzata per salavre il JSONObject all'interno del file creato
    fun saveFile(x : String){   //necessito dell'argomento JSONObject da trasformare in strinag

        //valorizzazione e compilazione della variabile per scrivere informazioni del file
        val output : Writer = BufferedWriter(FileWriter(createFile()))
        output.write(x) //comando per scrivere il JSONObject
        output.close()  //chiusura dell'evento
    }

    //funzione utilizzata per inserire le informazioni dentro il JSONObject
    fun AddUser(x : User) : JSONObject {
        return JSONObject() //restituisce un JSONObject contenente le informazioni della classe User
            .put("Nome", x.nome)
            .put("Cognome", x.cognome)
            .put("Citta'", x.citta)
            .put("Eta'", x.eta)
    }

    //funzione utilizzata per analizzare il JSONObject
    fun parseJson(){
        val jsonObject = JSONObject(readFile()) //appoggio il JSONObject all'interno di una variabile (prende le informazioni dal metodo readFile)

        //istanzio l'oggetto dalla classe User utilizzando la funzione getUser (prendiamo le informazioni dal JSONObject)
        var user = getUser(jsonObject.getJSONObject("Test information"))
        val string = "${user.nome} ${user.cognome} ${user.citta} ${user.eta}"   //inserisco i valori dentro una variabile stringa

        Log.d("JSON", string)   //stampa stringa nel log
    }

    //funzione utilizzata per leggere il file salvato nel dispositivo
    fun readFile() : String {
        val directory = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS).toString() //dichiaro la directory nella quale e' salvato il file
        val file = FileInputStream(directory + "/myJson1722541153780651137.json")   //dichiaro il file da prendere
        var jsonString = "" //inizializzo la variabile di appoggio dove inserire tutte le informazioni necessarie per avviare la lettura del file
        val fileChannel = file.channel  //ricavo il channel (mezzo per interrogare il file) dal file

        /*
            Descrivo il tipo id mappatura - dichiaro informaizioni come:
                -Modo di interazione (es. lettura/scrittura)
                -Riga dalla quale iniziare l'interazione
                -Riga sulla quale finire l'interazione
        */
        val mappa = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size())

        //passare tutta la mappatura all'interno della variabile di tipo stringa (bisogna decodificare tutte le infromazioni necessarie, usando la classe Charset)
        jsonString = Charset.defaultCharset().decode(mappa).toString()

        return jsonString   //ritorno la stringa
    }

    //funzione utilizzata per inserire i valori presi dal JSONObject dentro l'oggetto istanziato
    fun getUser(x : JSONObject): User {
        return User(
            //utilizzo getString per ricavare i valori di ogni campo del JSONObject
            x.getString("Nome"),
            x.getString("Cognome"),
            x.getString("Citta'"),
            x.getInt("Eta'")
        )
    }

    fun getJSONObj (URL : String){
        val jsonRequest = JsonObjectRequest(
            URL,
            Response.Listener { response : JSONObject ->
                try {
                    Log.d("Response", response.toString())
                    var slideShow = response.getJSONObject("slideshow")
                    var author = slideShow.getString("author")
                    Log.d("Author", author)
                }catch (e : JSONException){
                    e.printStackTrace()
                }
            },
            Response.ErrorListener { error: VolleyError? ->
                try {
                    Log.d("Error", error.toString())
                }catch (e : JSONException){
                    e.printStackTrace()
                }
            })
        volleyRequest!!.add(jsonRequest)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        volleyRequest = Volley.newRequestQueue(this)    //istanzazione del volleyRequest

        //getString("https://www.google.com/")    //richiamo il metodo di ottenimento stringa specificando l'URL
        //createJsonData()    //richiamo il metodo per creare un file .json
        //parseJson() //richiamo il metodo per analizzare il JSONObject
        getJSONObj("https://httpbin.org/json")
    }
}
