import java.util.ArrayList;
import java.util.Scanner;

class oggetto_array {   //entro nella CLASSE 
    public static void main(String[] args){    //entro nel MAIN

        ArrayList <String> Nomi = new ArrayList<String>();  //creo l'OGGETTO ArrayList NOMI
        ArrayList <Integer> Eta = new ArrayList<Integer>(); //creo l'OGGETTO ArrayList ETA'
        
        boolean Controllo = false;
        Scanner Richiesta = new Scanner(System.in); //creo lo scanner per la richiesta nel MENU
        Scanner Numero = new Scanner(System.in);    //creo lo scanner per l'inserimento dell' ETA'  
        Scanner Nome = new Scanner(System.in);      //creo lo scanner per l'inserimento dell' NOME
        
        while(Controllo == false){  //entro nel MENU

            System.out.print("Vuoi inserire il nome, l'eta', stampare o uscire?: ");
            String Scelta = Richiesta.nextLine();   //chiedo all'utente che scelta fare

            if(Scelta.equalsIgnoreCase("nome")){    //entro nel caso NOMI
                System.out.print("Che nome vuoi inserire?: ");
                Nomi.add(Nome.nextLine());
            }   //esco dal caso NOMI
            else if(Scelta.equalsIgnoreCase("eta")){    //entro nel caso ETA'
                System.out.print("Che numero vuoi inserire?: ");
                Eta.add(Numero.nextInt());
            }   //esco dal caso ETA'
            else if(Scelta.equalsIgnoreCase("stampa")){ //entro nel caso STAMPA
                System.out.print("L'array NOMI e': ");
                System.out.println(Nomi);
                System.out.print("L'array ETA' e': ");
                System.out.println(Eta);
            }   //esco dal caso STAMPA
            else if(Scelta.equalsIgnoreCase("esci")){   //entro nel caso ESCI
                Controllo = true;
            }   //esco dal caso ESCI
            else {  //entro nel caso ERRORE
                System.out.print("Errore di inserimento!! Riprova");
            }   //esco dal caso ERRORE 

        }   //esco dal MENU
    
    }   //esco dal MAIN
    
}   //esco dalla CLASSE
