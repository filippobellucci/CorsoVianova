import java.util.Scanner;

class array_while { //entro nella CLASSE
    public static void main(String[] args) {    //entro nel MAIN

        Scanner A = new Scanner(System.in); //creo uno scanner per far scegliere all'utente quanti nomi ed eta' vuole inserire
        System.out.print("Quanti nomi vuoi inserire?: ");
        int Lunghezza_persone = A.nextInt();
        String [] persone = new String[Lunghezza_persone];  //creo array di dimensione "Lunghezza_persone"

        System.out.print("Quante eta' vuoi inserire?: ");
        int Lunghezza_numero = A.nextInt();
        int [] eta = new int[Lunghezza_numero]; //creo array di dimensione "Lunghezza_numero"
        
        boolean Controllo = false;  //controllo del while grande (while MENU)
        int n = 0;  //variabile che controlla il limite di inserimento nella sezione ETA'
        int p = 0;  //variabile che controlla il limite di inserimento nella sezione NOME

        Scanner Richiesta = new Scanner(System.in); //creo lo scanner per la richiesta nel MENU
        Scanner Numero = new Scanner(System.in);    //creo lo scanner per l'inserimento dell' ETA'
        Scanner Nome = new Scanner(System.in);      //creo lo scanner per l'inserimento dell' NOME
        
        while(Controllo == false){  //entro nel MENU

            System.out.print("Vuoi inserire il nome, l'eta' o uscire?: ");
            String Scelta = Richiesta.nextLine();

            if(Scelta.equalsIgnoreCase("eta")){ //entro nella sezione ETA'
                if(n < Lunghezza_numero){
                    System.out.print("Quale numero vuoi inserire?: ");
                    int Scelta2 = Numero.nextInt();
                    eta[n] = Scelta2;
                    n++;
                } else{
                    System.out.println("Limite di inserimento superato!!");
                }
            }   //esco dalla sezione ETA'
            else if(Scelta.equalsIgnoreCase("nome")){   //entro nella sezione NOME
                if(p < Lunghezza_persone){
                    System.out.print("Quale nome vuoi inserire?: ");
                    String Scelta3 = Nome.nextLine();
                    persone[p] = Scelta3;
                    p++;
                } else{
                    System.out.println("Limite di inserimento superato!!");
                }
            }   //esco dalla sezione NOME
            else if(Scelta.equalsIgnoreCase("esci")){   //entro nella sezione ESCI
                Controllo = true;
            }   //esco dalla sezione ESCI
        }   //esco dal MENU  

        boolean Stampatore = false; //controllo del while STAMPATORE
        int Selettore1 = 0; //variabile che controlla il riferimento nell'array PERSONE
        int Selettore2 = 0; //variabile che controlla il riferimento nell'array ETA'
        
        while(Stampatore == false){ //entro nel while STAMPATORE

            System.out.print("Persone --> [ ");
            while(Selettore1 < Lunghezza_persone){
                System.out.print(persone[Selettore1] + " ");
                Selettore1++;
            }
            System.out.print("]");

            System.out.println("");

            System.out.print("Eta' --> [ ");
            while(Selettore2 < Lunghezza_numero){
                System.out.print(eta[Selettore2] + " ");
                Selettore2++;
            }
            System.out.print("]");

            Stampatore = true;

        }   //esco dal while STAMPATORE

    }   //esco dal MAIN

}   //esco dalla CLASSE
