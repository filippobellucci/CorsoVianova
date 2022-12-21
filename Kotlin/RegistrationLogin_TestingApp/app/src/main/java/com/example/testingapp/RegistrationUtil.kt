package com.example.testingapp

class RegistrationUtil {

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

    val usernames = listOf<String>("Luca", "Paolo", "Filippo")  //mockup per verificare che l'utente sia inserito

    //FUNZIONE UNICA PER USERNAME, PASSWORD E PASSWORD_CONFIRM
    fun validateRegistration(
        username : String,
        password : String,
        passwordConfirm : String
    ) : Boolean {

        val user = username.trim()                  // serve per togliere gli spazi prima e dopo la stringa
        val pass = password.trim()                  // serve per togliere gli spazi prima e dopo la stringa
        val passConf = passwordConfirm.trim()       // serve per togliere gli spazi prima e dopo la stringa
        if(user.isNotBlank() && pass.isNotBlank() && passConf.isNotBlank()){

            if (user.contains(' ')) {          //controllo se ci sono spazi in mezzo all'username
                return false
            }
            if(usernames.contains(user)){           //controllo se c'e' gia' un username uguale nella lista degli usernames
                return false
            }
                                                    //controllo se e' stato inserito un carattere speciale
            if(!pass.contains(Regex("^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\d\\s:])([^\\s]){8,16}\$"))){
                return false
            }
            if (pass != passConf){                  //controllo se password e passwordConfirm sono uguali
                return false
            }

            return true                             //se tutto e' andato a buon fine ritorno TRUE

        }else{
            return false                            //se uno tra username, password e passwordConfirm sono vuoti ritorno FALSO
        }

    }

    fun validateUsername(   //FUNZIONE PER LA CONVALIDA DELL'USERNAME
        username : String
    ) : Boolean {

        val user = username.trim()              /** serve per togliere gli spazi prima e dopo la stringa */
        if(user.isNotBlank()){

            if (user.contains(' ')) {      /** controllo se ci sono spazi in mezzo all'username */
                return false
            }
            if(usernames.contains(user)){       /** controllo se c'e' gia' un username uguale nella lista degli usernames */
                return false
            }
            return true                         /** se tutto e' andato a buon fine ritorno TRUE */
        }else{
            return false                        /** se uno tra username, password e passwordConfirm sono vuoti ritorno FALSO */
        }

    }

    fun validatePassword(   //FUNZIONE PER LA CONVALIDA DELLA PASSOWRD
        password : String
    ) : Boolean {

        val pass = password.trim()              /** serve per togliere gli spazi prima e dopo la stringa */
        if(pass.isNotBlank()){

            if (pass.contains(' ')) {      /** controllo se ci sono spazi in mezzo alla password */
                return false
            }
                                                /** controllo se e' stato inserito un carattere speciale */
            if(!pass.contains(Regex("^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\d\\s:])([^\\s]){8,16}\$"))){
                return false
            }
            return true                         /** se tutto e' andato a buon fine ritorno TRUE */
        }else{
            return false                        /** se uno tra username, password e passwordConfirm sono vuoti ritorno FALSO */
        }

    }

    fun validatePassConfirm(    //FUNZIONE PER LA CONVALIDA DELLA PASSOWRD_CONFIRM
        passwordConfirm : String
    ) : Boolean {

        val passConf = passwordConfirm.trim()   /** serve per togliere gli spazi prima e dopo la stringa */
        if(passConf.isNotBlank()){

            if (passConf.contains(' ')) {  /** controllo se ci sono spazi in mezzo alla passwordConfirm */
                return false
            }
                                                /** controllo se e' stato inserito un carattere speciale */
            if(!passConf.contains(Regex("^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\d\\s:])([^\\s]){8,16}\$"))){
                return false
            }
            return true                         /** se tutto e' andato a buon fine ritorno TRUE */
        }else{
            return false                        /** se uno tra username, password e passwordConfirm sono vuoti ritorno FALSO */
        }

    }

}