
import java.util.Scanner;   //importo la classe Scanner dalla libreria util di java

class interazione_con_utente {
    public static void main(String[] args) {

        //DICHIARAZIONI 
        Scanner NOME = new Scanner(System.in);  
        // Creazione di un nuovo scanner di nome "NOME". 
        // System.in specifica che il risultato dovra' arrivare dal terminale (quindi dall'utente).
        
        System.out.println("Inscrisci il tuo nome:");   //Richiesta del nome all'utente.

        //VALORIZZAZIONI
        String TuoNome = NOME.nextLine();   // Lettura dell'input dell'utente (Nome dell'utente)
        String TuoCognome = NOME.nextLine();    // Lettura dell'input dell'utente (Cognome dell'utente)

        // nextLine prende la prossima Stringa inserita dall'utente nel terminale e la inserisce dentro lo scanner NOME.
        // Il tutto successivamente viene inserito all'interno della variabile String TuoNome.
        // Non posso inserire due tipi diversi di dato all'interno di un singolo scanner.
    
        System.out.println("Il tuo nome e': " + TuoNome + " " + TuoCognome);    // Visualizzazione dell'output all'utente

    }   // Chiusura del main

}   // Chiusura della classe