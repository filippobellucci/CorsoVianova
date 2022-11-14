import java.util.Scanner;

class Menu_do_while {
    public static void main(String[] args) {

        //DICHIARAZIONI E VALORIZZAZIONI DELLE VARIABILI
        double X = 11;
        double Y = 22;
        double Z = 12.5;
        boolean Uscita = false;    //variabile utilizzata per uscire dal loop in caso si entri nella casistica 'ESCI'
        boolean SecondoLoop = false;

        //CREAZIONE DEL MENU'
        do{

            Scanner Opzione = new Scanner(System.in);    //creo uno scanner per far scegliere l'utente
            System.out.println("Scegli tra Aggiungi, Sottrai, Stampa o Esci");

            String Scelta = Opzione.nextLine();

            if( !(Scelta.equals("Aggiungi")) && !(Scelta.equals("Sottrai")) && !(Scelta.equals("Stampa")) && !(Scelta.equals("Esci")) ){    //controllo per inserimento opzione sbagliata
                System.out.println("opzione errata!! Reinseriscila: ");
            }
            
            if(Scelta.equals("Aggiungi")){  //entro nel caso 'AGGIUNGI'

                Scanner Opzione2 = new Scanner(System.in);  //creo uno scanner per far scegliere all'utente la variabile su cui operare
                System.out.println("Scegli a quale variabile aggiungere tra X, Y o Z");

                while(SecondoLoop != true){    //loop con cui richiedo la seconda scelta fiche' l'utente non ne da una disponibile

                    String Scelta2 = Opzione2.nextLine();

                    if(Scelta2.equals("X")){
                        Scanner Numero = new Scanner(System.in);    //creo uno scanner per far scegliere all'utente quanto aggiungere
                        System.out.println("Quanto vuoi aggiungere?:");
                        double NumeroAggiunto = Numero.nextInt();
                        X = X + NumeroAggiunto;
                        System.out.print("Il risultato e': ");
                        System.out.println(X);
                        SecondoLoop = true;
                    } else if(Scelta2.equals("Y")){
                        Scanner Numero = new Scanner(System.in);    //creo uno scanner per far scegliere all'utente quanto aggiungere
                        System.out.println("Quanto vuoi aggiungere?:");
                        double NumeroAggiunto = Numero.nextInt();
                        Y = Y + NumeroAggiunto;
                        System.out.print("Il risultato e': ");
                        System.out.println(Y);
                        SecondoLoop = true;
                    } else if(Scelta2.equals("Z")){
                        Scanner Numero = new Scanner(System.in);    //creo uno scanner per far scegliere all'utente quanto aggiungere
                        System.out.println("Quanto vuoi aggiungere?:");
                        double NumeroAggiunto = Numero.nextInt();
                        Z = Z + NumeroAggiunto;
                        System.out.print("Il risultato e': ");
                        System.out.println(Z);
                        SecondoLoop = true;
                    } 
                    else{
                        System.out.println("opzione errata!! Reinseriscila: ");
                        Opzione2.reset();
                    }
                }
                SecondoLoop = false;

            }   //esco dal caso 'AGGIUNGI'
            else if(Scelta.equals("Sottrai")){  //entro nel caso 'SOTTRAI'

                Scanner Opzione2 = new Scanner(System.in);  //creo uno scanner per far scegliere all'utente la variabile su cui operare
                System.out.println("Scegli a quale variabile sottrarre tra X, Y o Z");

                while(SecondoLoop != true){    //loop con cui richiedo la seconda scelta fiche' l'utente non ne da una disponibile

                    String Scelta2 = Opzione2.nextLine();

                    if(Scelta2.equals("X")){

                        Scanner Numero = new Scanner(System.in);
                        System.out.println("Quanto vuoi sottrarre?:");  //creo uno scanner per far scegliere all'utente quanto sottrarre
                        double NumeroSottratto = Numero.nextInt();
                        if(NumeroSottratto < X){
                            X = X - NumeroSottratto;
                            System.out.print("Il risultato e': ");
                            System.out.println(X);
                            SecondoLoop = true;
                        } else {
                            System.out.println("Errore!! Numero negativo:");
                            SecondoLoop = true;
                        }
                    } 
                    else if(Scelta2.equals("Y")){
    
                        Scanner Numero = new Scanner(System.in);
                        System.out.println("Quanto vuoi sottrarre?:");  //creo uno scanner per far scegliere all'utente quanto sottrarre
                        double NumeroSottratto = Numero.nextInt();
                        if(NumeroSottratto < Y){
                            Y = Y - NumeroSottratto;
                            System.out.print("Il risultato e': ");
                            System.out.println(Y);
                            SecondoLoop = true;
                        } else {
                            System.out.println("Errore!! Numero negativo:");
                            SecondoLoop = true;
                        }
                    }
                    else if(Scelta2.equals("Z")){
    
                        Scanner Numero = new Scanner(System.in);
                        System.out.println("Quanto vuoi sottrarre?:");  //creo uno scanner per far scegliere all'utente quanto sottrarre
                        double NumeroSottratto = Numero.nextInt();
                        if(NumeroSottratto < Z){
                            Z = Z - NumeroSottratto;
                            System.out.print("Il risultato e': ");
                            System.out.println(Z);
                            SecondoLoop = true;
                        } else {
                            System.out.println("Errore!! Numero negativo:");
                            SecondoLoop = true;
                        }
                    }
                    else{
                        System.out.println("opzione errata!! Reinseriscila: ");
                        Opzione2.reset();
                    }
                }
                SecondoLoop = false;

            }   //esco dal caso 'SOTTRAI'
            else if(Scelta.equals("Stampa")){   //entro nel caso 'STAMPA'

                Scanner Opzione2 = new Scanner(System.in);
                System.out.println("Vuoi stampare una variabile a scelta o tutte?:");   //creo uno scanner per far scegliere all'utente la variabile su cui operare

                while(SecondoLoop != true){    //loop con cui richiedo la seconda scelta fiche' l'utente non ne da una disponibile
                
                    String Scelta2 = Opzione2.nextLine();

                    if(Scelta2.equals("X")){
                        System.out.print("La variabile X e': ");
                        System.out.println(X);
                        SecondoLoop = true;
                    } 
                    else if(Scelta2.equals("Y")){
                        System.out.print("La variabile Y e': ");
                        System.out.println(Y);
                        SecondoLoop = true;
                    } 
                    else if(Scelta2.equals("Z")){
                        System.out.print("La variabile Z e': ");
                        System.out.println(Z);
                        SecondoLoop = true;
                    } 
                    else if(Scelta2.equals("TUTTE")){
                        System.out.print("La variabile X e': ");
                        System.out.println(X);
                        System.out.print("La variabile Y e': ");
                        System.out.println(Y);
                        System.out.print("La variabile Z e': ");
                        System.out.println(Z);
                        SecondoLoop = true;
                    }
                    else{
                        System.out.println("opzione errata!! Reinseriscila: ");
                        Opzione2.reset();
                    }
                }              
                SecondoLoop = false;

            }   //esco dal caso 'STAMPA' 
            else if(Scelta.equals("Esci")){    //entro nel caso 'ESCI'
                System.out.println("Grazie mille");
                Uscita = true;  //la variabile diventa 'true' perche' siamo entrati nel caso 'ESCI'
            }   //esco dal caso 'ESCI' 

        } while(Uscita != true);    //condizione con cui esco dal loop

    }   //esco dal main
}   //esco dalla classe
