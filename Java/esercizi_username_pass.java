import java.util.Scanner;
import java.util.ArrayList;

class esercizi_username_pass {
    public static void main(String[] args) {

        boolean Controllo = false;  //booleano di controllo primo WHILE
        boolean Conferma = false;   //booleano di controllo secondo WHILE
        Scanner scan = new Scanner(System.in);
        String Username = "";
        String Password = "";

        while(Controllo == false){

            Conferma = false;
            System.out.print("Inserisci l'username: ");
            Username = scan.nextLine(); //chiedo all'utente l'username

            System.out.print("Inserisci la password: ");
            Password = scan.nextLine(); //chiedo all'utente la password

            if((Username.equals("")) || (Password.equals(""))){
                System.out.println("non hai inserito uno dei due campi!!"); //controllo se uno dei due campi e' vuoto
            }
            else{
                
                while(Conferma == false){
                    
                    System.out.print("Sei sicuro dei dati? Digita [Y] o [N]: ");
                    String Sicuro = scan.nextLine();    //chiedo all'utente se e' sicuro dell'username e della password

                    if(Sicuro.equals("Y")){ //se sicuro esco da tutti e due i cicli
                        Conferma = true;
                        Controllo = true;
                    }
                    else if (Sicuro.equals("N")){   //se non e' sicuro torno all'inserimento di username e password
                        Conferma = true;
                    }
                    else {  //se sbagli rimane nel ciclo dell "SI" o "NO"
                        System.out.println("Devi scegliere tra Y o N");
                    }

                }   

            }

        }

        boolean Controllo1 = false;
        
        ArrayList <String> STRINGA = new ArrayList<String>();   //creo array STRINGA
        ArrayList <Integer> NUMERO = new ArrayList<Integer>();  //creo array NUMERO
        
        while(Controllo1 == false){  
            
            Scanner N = new Scanner(System.in);
            System.out.print("Vuoi aggiungere una stringa, aggiungere un numero, modificare, rimuovere, stampare o uscire?: ");
            String Scelta = scan.nextLine();    //faccio scegliere tra una delle opzioni

            if(Scelta.equalsIgnoreCase("stringa")){    
                System.out.print("Che stringa vuoi inserire?: ");
                STRINGA.add(scan.nextLine());   //inserisco stringa
            }   
            else if(Scelta.equalsIgnoreCase("numero")){    
                System.out.print("Che numero vuoi inserire?: ");
                NUMERO.add(N.nextInt());    //inserisco numero
            }  
            else if(Scelta.equalsIgnoreCase("modifica")){
                System.out.print("L'array STRINGA e': ");
                System.out.println(STRINGA);    //stampo STRINGA per mostrarlo all'utente
                System.out.print("L'array NUMERO e': ");
                System.out.println(NUMERO);     //stampo NUMERO per mostrarlo all'utente
                System.out.print("Cosa vuoi modificare (STRINGA o NUMERO)?: ");
                String O = scan.nextLine();     //faccio scegliere cosa modificare
                if(O.equalsIgnoreCase("stringa")){
                    Scanner P = new Scanner(System.in);
                    Scanner I = new Scanner(System.in);
                    System.out.print("Quale punto vuoi modificare?: ");
                    int Riferimento = P.nextInt();  //scelta del punto da modificare
                    System.out.print("Cosa vuoi mettere?: ");
                    String Modifica = I.nextLine(); //scelta del nuovo elemento da inserire
                    STRINGA.set(Riferimento, Modifica); //effettiva modifica
                    
                }
                else if(O.equalsIgnoreCase("numero")){
                    Scanner P = new Scanner(System.in);
                    Scanner I = new Scanner(System.in);
                    System.out.print("Quale punto vuoi modificare?: "); 
                    int Riferimento2 = P.nextInt(); //scelta del punto da modificare
                    System.out.print("Cosa vuoi mettere?: ");
                    int Modifica2 = I.nextInt();    //scelta del nuovo elemento da inserire
                    NUMERO.set(Riferimento2, Modifica2);    //effettiva modifica
                }
                else{
                    System.out.println("DEVI SCEGLIERE TRA STRINGA O NUMERO!!");
                }
            } 
            else if(Scelta.equalsIgnoreCase("rimuovi")){
                System.out.print("L'array STRINGA e': ");
                System.out.println(STRINGA);
                System.out.print("L'array NUMERO e': ");
                System.out.println(NUMERO);
                System.out.print("Cosa vuoi rimuovere (STRINGA o NUMERO)?: ");
                String L = scan.nextLine();
                if(L.equalsIgnoreCase("stringa")){
                    Scanner P = new Scanner(System.in);
                    System.out.print("Quale punto vuoi rimuovere?: ");
                    int Riferimento3 = P.nextInt(); //scelta del punto da rimuovere
                    STRINGA.remove(Riferimento3);   //effettiva rimozione
                }
                else if(L.equalsIgnoreCase("numero")){
                    Scanner I = new Scanner(System.in);
                    System.out.print("Quale punto vuoi rimuovere?: ");
                    int Riferimento3 = I.nextInt(); //scelta del punto da rimuovere
                    NUMERO.remove(Riferimento3);    //effettiva rimozione
                }
            }
            else if(Scelta.equalsIgnoreCase("stampa")){ 
                System.out.print("L'array STRINGA e': ");
                System.out.println(STRINGA);    //stampa STRINGA
                System.out.print("L'array NUMERO e': ");
                System.out.println(NUMERO);     //stampa NUMERO
            }   
            else if(Scelta.equalsIgnoreCase("esci")){   
                System.out.print("L'array STRINGA e': ");
                System.out.println(STRINGA);
                System.out.print("Confermi? [Y] o [N] ? ");
                String Accettazione = scan.nextLine();  //conferma del nuovo output

                boolean A = false;
                boolean B = false;

                while(A == false){
                    if(Accettazione.equals("Y")){
                        System.out.print("Inserisci la password per confermare: ");
                        String AccettazionePassword = scan.nextLine();

                        if(AccettazionePassword.equals(Password)){      //confronto delle password
                            System.out.println("SALVATO");
                            System.out.print("L'array NUMERO e': ");
                            System.out.println(NUMERO);
                            System.out.print("Confermi? [Y] o [N] ? ");
                            String Accettazione2 = scan.nextLine();     //richiesta di conferma dell' array STRINGA

                            while(B == false){
                                if(Accettazione2.equals("Y")){
                                    System.out.print("Inserisci la password per confermare: ");
                                    String AccettazionePassword2 = scan.nextLine(); //richiesta di conferma dell' array NUMERO
            
                                    if(AccettazionePassword2.equals(Password)){
                                        System.out.print("SALVATO");
                                        B = true;   //esco dal ciclo
                                    }
                                    else{
                                        System.out.print("Password ERRATA riprovare!!");    //caso password errata
                                    }
            
                                }
                                else if(Accettazione2.equals("N")){
                                    NUMERO.clear(); //cancello solo NUMERO perche' STRINGA e' stato salvato
                                    System.out.print("SALVATA SOLO STRINGA!!");
                                    B = true;   //esco dal ciclo
                                }
            
                            }
                            A = true;   //esco dal ciclo ESCI
                            Controllo1 = true;  //esco dal MENU
                        }
                        else{
                            System.out.print("Password ERRATA riprovare!!");
                        }

                    }
                    else if(Accettazione.equals("N")){  //caso negativo "SUBITO"
                        STRINGA.clear();    //cancello STRINGA
                        NUMERO.clear();     //cancello NUMERO
                        System.out.print("NESSUN DATO SALVATO!!");
                        A = true;   //esco dal ciclo ESCI
                        Controllo1 = true;  //esco dal ciclo MENU
                    }
                    else{
                        System.out.print("DEVI SCEGLIERE 'Y' o 'N'!!");
                    }

                }
                
            }   
            else {  
                System.out.println("Errore di inserimento!! Riprova");
            }   
        
        }   

    }
    
}
