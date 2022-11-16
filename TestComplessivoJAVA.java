import java.util.Scanner;
import java.util.ArrayList;

class TestComplessivoJAVA {
    public static void main(String[] args){

        boolean ControlloDati = false;
        boolean Conferma = false;
        boolean A = false;
        boolean B = false;
        Scanner str = new Scanner(System.in);  //scanner per inserimento da terminale del'utente
        Scanner integ = new Scanner(System.in);
        String UsernamePresente = "";           //Username in memoria                           
        String PasswordPresente = "";           //Password in memoria
        String UsernameConfronto = "";          //Username inserito dall'utente
        String PasswordConfronto = "";          //Password inserito dall'utente
        boolean ControlloFinale = false;
        boolean ControlloMenu = false;
        int BUDGET = 0;
        String Iscrizione;

        ArrayList <String> ListaCibo = new ArrayList<String>();                                                 
        ArrayList <Integer> ListaPrezzi = new ArrayList<Integer>();        
        ArrayList <String> ListaCiboUtente = new ArrayList<String>();      
        ArrayList <Integer> ListaPrezziUtente = new ArrayList<Integer>();   

        while(ControlloFinale == false){

            while(ControlloDati == false){  //inizio MENU di LOGIN

                Iscrizione = "";
                ControlloDati = false;
                Conferma = false;
                A = false;
                B = false;
                System.out.println("--------- MENU LOGIN ---------");
                System.out.print("Sei iscritto? [YES] o [NO] ");
                Iscrizione = str.nextLine();    //chiedo se sono iscritto o no
    
                if(Iscrizione.equalsIgnoreCase("YES")){ //caso iscrizione VERA
    
                    while(A == false){  //ciclo che fa inserire Username e Password e controlla se e' uguale a quella GIA' PRESENTE
    
                        System.out.print("Inserisci l'username: ");
                        UsernameConfronto = str.nextLine(); 
    
                        System.out.print("Inserisci la password: ");
                        PasswordConfronto = str.nextLine(); 
    
                        if((UsernameConfronto.equals(UsernamePresente)) && (PasswordConfronto.equals(PasswordPresente))){
                            System.out.println("I dati inseriti sono CORRETTI");
                            A = true;
                            ControlloDati = true;
                        }
                        else if((UsernameConfronto.equals("ADMIN")) && (PasswordConfronto.equals("ADMIN"))){    //controllo in caso di inserimento ADMIN
                            System.out.println("I dati inseriti sono CORRETTI");
                            A = true;
                            ControlloDati = true;
                        }
                        else {
                            System.out.println("I dati inseriti sono NON SONO CORRETTI, RIPROVA!!");
                        }
    
                    }   
    
                }   //fine caso iscrizione VERA
                else if (Iscrizione.equalsIgnoreCase("NO")){    //inizio caso iscrizione FALSA
    
                    while(B == false){
    
                        System.out.print("Inserisci l'username: ");
                        UsernamePresente = str.nextLine(); //chiedo all'utente l'username
            
                        System.out.print("Inserisci la password: ");
                        PasswordPresente = str.nextLine(); //chiedo all'utente la password
            
                        if((UsernamePresente.equals("")) || (PasswordPresente.equals(""))){
                            System.out.println("non hai inserito uno dei due campi!!"); //controllo se uno dei due campi e' vuoto
                        }
                        else{
                            
                            while(Conferma == false){
                                
                                System.out.print("Sei sicuro dei dati? Digita [YES] o [NO]: ");
                                String Sicuro = str.nextLine();    //chiedo all'utente se e' sicuro dell'username e della password
            
                                if(Sicuro.equalsIgnoreCase("YES")){ //se sicuro esco da tutti e due i cicli
                                    B = true;
                                    Conferma = true;
                                    ControlloDati = true;
                                }
                                else if (Sicuro.equalsIgnoreCase("NO")){   //se non e' sicuro torno all'inserimento di username e password
                                    Conferma = true;
                                }
                                else {  //se sbagli rimane nel ciclo dell "SI" o "NO"
                                    System.out.println("Devi scegliere tra Y o N");
                                }
            
                            }   
            
                        }
            
                    }
    
                }   //fine caso iscrizione FALSA
                else {
                    System.out.println("Devi scegliere tra YES o NO!!");    //messaggio di errore inserimento
                }   
    
            }   //fine MENU di LOGIN
            
            int SommaPrezzi = 0;
    
            if(!(UsernamePresente.equals("ADMIN")) && !(PasswordPresente.equals("ADMIN"))){
                Scanner Q = new Scanner(System.in);
                System.out.print("Scegli il tuo BUDGET: ");
                BUDGET = Q.nextInt();   //inserimento BUDGET
            }
    
            System.out.println("--------- MENU OPZIONI ---------");

            ControlloMenu = false;

            while(ControlloMenu == false){  //entro nel MENU OPZIONI

                if(!(UsernamePresente.equals("ADMIN")) && !(PasswordPresente.equals("ADMIN"))){ //inizo caso UTENTE NORMALE

                System.out.print("Scegli tra 'Visualizza Lista Cibo', 'Carrello e Paga', 'Esci': [ListaCibo] [Paga] [Esci] ");
                String SceltaMenuUtente = str.nextLine();  //scelta OPZIONE 

                if(SceltaMenuUtente.equalsIgnoreCase("ListaCibo")){

                    System.out.println("--------- LISTA CIBI ---------");
                    for(int i = 0; i < ListaPrezzi.size() ; i++){

                        System.out.print("Nome Cibo: ");
                        System.out.print(ListaCibo.get(i));
                        System.out.print(" " + "Prezzo: ");
                        System.out.println(ListaPrezzi.get(i));

                    }

                    Scanner Cibo = new Scanner(System.in);
                    Scanner M = new Scanner(System.in);
                    boolean Selezione = false;

                    while(Selezione == false){

                        System.out.print("Vuoi selezionare un cibo?: [YES] [NO] ");
                        String ContinuoSelezione = M.nextLine();

                        if(ContinuoSelezione.equalsIgnoreCase("YES")){
                            System.out.print("Scegli un numero da 1 a x: ");
                            int Riferimento = Cibo.nextInt();
                            Riferimento = Riferimento - 1;

                            ListaCiboUtente.add(ListaCibo.get(Riferimento));
                            ListaPrezziUtente.add(ListaPrezzi.get(Riferimento));
                            System.out.println("Cibo SALVATO!");
                            continue;
                        }
                        else if(ContinuoSelezione.equalsIgnoreCase("NO")){
                            Selezione = true;
                        }
                        else {
                            System.out.println("Devi scegliere tra YES o NO!! Riprova");
                        }

                    }

                }
                else if(SceltaMenuUtente.equalsIgnoreCase("Paga")){

                    System.out.println("Questo e' il tuo carrello: ");
                    for(int i = 0; i < ListaPrezziUtente.size(); i++){

                        System.out.print("Nome Cibo: ");
                        System.out.print(ListaCiboUtente.get(i));
                        System.out.print(" " + "Prezzo: ");
                        System.out.print(ListaPrezziUtente.get(i));
                        System.out.print("");

                    }

                    Boolean I = false;

                    while(I == false){

                        System.out.print("Vuoi PAGARE?: [YES] [NO] ");
                        String P = str.nextLine();

                        if(P.equalsIgnoreCase("YES")){
                            for(int i = 0; i < ListaPrezziUtente.size(); i++){
                                SommaPrezzi = SommaPrezzi + ListaPrezziUtente.get(i);
                            }
                            if(SommaPrezzi < BUDGET){

                                boolean Z = false;

                                while(Z == false){
                                    System.out.print("Inserisci la Password: ");
                                    String Pass = str.nextLine();

                                    if(Pass.equals(PasswordPresente)){
                                        System.out.println("HAI PAGATO");
                                        System.out.print("Nuovo BUDGET = ");
                                        BUDGET = BUDGET - SommaPrezzi;
                                        System.out.println(BUDGET);
                                        ListaCiboUtente.clear();
                                        ListaPrezziUtente.clear();
                                        Z = true;
                                        I = true;
                                    }
                                    else {
                                        System.out.println("Password sbagliata!! Riprova");
                                    }
                                }
                            }
                            else{
                                System.out.print("NON HAI ABBASTANZA SOLDI!! Vuoi AGGIUNGERLI?: [YES] [NO]");
                                String AggiuntaDiSoldi = str.nextLine();

                                if(AggiuntaDiSoldi.equalsIgnoreCase("YES")){
                                    int S = integ.nextInt();
                                    System.out.print("Nuovo BUDGET = ");
                                    BUDGET = BUDGET + S;
                                    System.out.println(BUDGET);
                                    I = true;
                                }
                                else if(AggiuntaDiSoldi.equalsIgnoreCase("NO")){
                                    I = true;
                                }
                                else{
                                    System.out.println("Devi scegliere tra YES o NO!! Riprova");
                                }
                                
                            }
                        }
                        else if(P.equalsIgnoreCase("NO")){
                            ListaCiboUtente.clear();
                            ListaPrezziUtente.clear();
                            I = true;
                        }
                        else{
                            System.out.println("Devi scegliere tra YES o NO!! Riprova");
                        }

                    }

                }
                else if(SceltaMenuUtente.equalsIgnoreCase("Esci")){

                    for(int i = 0; i < ListaPrezziUtente.size(); i++){
                        System.out.print("Nome Cibo: ");
                        System.out.print(ListaCiboUtente.get(i));
                        System.out.print("Prezzo: ");
                        System.out.print(ListaPrezziUtente.get(i));
                    }
                    System.out.println("");
                    System.out.print("Totale Conto: ");
                    System.out.println(SommaPrezzi);
                    ListaCiboUtente.clear();
                    ListaPrezziUtente.clear();
                    ControlloMenu = true;

                }

            }   //fine caso UTENTE NORMALE
                else{   //inizio caso ADMIN

                    Scanner F = new Scanner(System.in);
                    System.out.print("Scegli tra 'Visualizza Lista Cibo', 'Modifica Lista Cibo', 'Aggiungi Lista Cibo', 'Carrello e Paga', 'Esci': [ListaCibo] [Modifica] [Aggiungi] [Paga] [Esci] ");
                    String SceltaMenuUtente = F.nextLine(); 

                    if(SceltaMenuUtente.equalsIgnoreCase("ListaCibo")){

                        System.out.println("--------- LISTA CIBI ---------");
                        for(int i = 0; i < ListaPrezzi.size() ; i++){

                            System.out.print("Nome Cibo: ");
                            System.out.print(ListaCibo.get(i));
                            System.out.print(" " + "Prezzo: ");
                            System.out.println(ListaPrezzi.get(i));

                        }

                        Scanner Cibo = new Scanner(System.in);
                        Scanner M = new Scanner(System.in);
                        boolean Selezione = false;

                        while(Selezione == false){

                        System.out.print("Vuoi selezionare un cibo?: [YES] [NO] ");
                        String ContinuoSelezione = M.nextLine();

                            if(ContinuoSelezione.equalsIgnoreCase("YES")){
                                System.out.print("Scegli un numero da 1 a x: ");
                                int Riferimento = Cibo.nextInt();
                                Riferimento = Riferimento - 1;

                                ListaCiboUtente.add(ListaCibo.get(Riferimento));
                                ListaPrezziUtente.add(ListaPrezzi.get(Riferimento));
                                System.out.println("Cibo SALVATO!");
                                continue;
                            }
                            else if(ContinuoSelezione.equalsIgnoreCase("NO")){
                                Selezione = true;
                            }
                            else {
                                System.out.println("Devi scegliere tra YES o NO!! Riprova");
                            }

                        }

                    }
                    else if(SceltaMenuUtente.equalsIgnoreCase("Aggiungi")){
                        System.out.print("Cosa vuoi Aggiungere?: ");
                        String AggiuntaLista = str.nextLine();
                        System.out.print("Inserisci il suo prezzo?: ");
                        int PrezzoAggiuntaLista = integ.nextInt();
                    
                        ListaCibo.add(AggiuntaLista);
                        ListaPrezzi.add(PrezzoAggiuntaLista);
                        System.out.println("AGGIUNTO con successo");
                    }
                    else if(SceltaMenuUtente.equalsIgnoreCase("Modifica")){
                        System.out.print("Cosa vuoi Modificare?: ");
                        String ModificaLista = str.nextLine();
                        System.out.print("Inserisci il prezzo dell'oggetto modificato?: ");
                        int PrezzoModificaLista = integ.nextInt();
                        System.out.print("Inserisci il riferimento da sostituire?: ");
                        int RiferimentoModifica = integ.nextInt();
                        RiferimentoModifica = RiferimentoModifica - 1;

                        ListaCibo.set(RiferimentoModifica, ModificaLista);
                        ListaPrezzi.set(RiferimentoModifica, PrezzoModificaLista);

                        System.out.println("MODIFICA AVVENUTA!!");
                    }
                    else if(SceltaMenuUtente.equalsIgnoreCase("Paga")){

                        System.out.println("Questo e' il tuo carrello: ");
                        for(int i = 0; i < ListaPrezziUtente.size(); i++){

                            System.out.print("Nome Cibo: ");
                            System.out.print(ListaCiboUtente.get(i));
                            System.out.print(" " + "Prezzo: ");
                            System.out.println(ListaPrezziUtente.get(i));

                        }

                        Boolean I = false;

                        while(I == false){

                            System.out.print("Vuoi PAGARE?: [YES] [NO] ");
                            String P = str.nextLine();

                            if(P.equalsIgnoreCase("YES")){
                                System.out.println("NULLA E' DOVUTO!!");
                                ListaCiboUtente.clear();
                                ListaPrezziUtente.clear();
                                I = true;
                            }
                            else if(P.equalsIgnoreCase("NO")){
                                System.out.println("TORNO AL MENU");
                                ListaCiboUtente.clear();
                                ListaPrezziUtente.clear();
                                I = true;
                            }
                            else{
                                System.out.println("Devi scegliere tra YES o NO!! Riprova");
                            }

                        }

                    }
                    else if(SceltaMenuUtente.equalsIgnoreCase("Esci")){

                        for(int i = 0; i < ListaPrezziUtente.size(); i++){
                            System.out.print("Nome Cibo: ");
                            System.out.print(ListaCiboUtente.get(i));
                            System.out.print(" " + "Prezzo: ");
                            System.out.print(ListaPrezziUtente.get(i));
                            System.out.println("");

                        }  
                        
                        System.out.println("NON PAGHI NIENTE ");
                        ListaCiboUtente.clear();
                        ListaPrezziUtente.clear();
                        ControlloMenu = true;

                    }   
                    
                }   //fine caso ADMIN

                ControlloDati = false;
            
            }   //fine MENU OPZIONI

        }

    }
}