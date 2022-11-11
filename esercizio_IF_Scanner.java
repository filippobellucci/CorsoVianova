import java.util.Scanner;

class esercizio_IF_Scanner {
    public static void main(String[] args){

        //DICHIARAZIONI DELLE VARIABILI
        int Numero1;
        int Numero2;
        int Numero3;

        //VALORIZZAZIONE DELLE VARIABILI
        Numero1 = 3;
        Numero2 = 13;
        Numero3 = 13;

        //OPERAZIONI SEMPARATI DI IF
        
        if (Numero1 == Numero2){
            System.out.println("Il numero e' UGUALE");
        }
        else{
            System.out.println("Il numero e' DIVERSO");
        }   // chiusura F numero 1

        if (Numero2 == Numero3){
            System.out.println("Il numero e' UGUALE");
        }
        else{
            System.out.println("Il numero e' DIVERSO");
        }   // chiusura F numero 2

        if (Numero3 == Numero1){
            System.out.println("Il numero e' UGUALE");
        }
        else{
            System.out.println("Il numero e' DIVERSO");
        }   // chiusura F numero 3

        //OPERAZIONI CON IF A CASCATA (si ipotizzana la conoscienza delle variabili in ingresso tramite dei test)
        if(Numero2 == Numero3){
            if(Numero3 > Numero1){
                if(Numero1 < Numero2){
                    System.out.println("Numero2 uguale a Numero3 ma diverso del Numero1");
                }
                else{
                    System.out.println("Numero2 uguale a Numero3 ma diverso del Numero1");
                }
            }
            else{
                System.out.println("Numero3 uguale a Numero2 ma diverso del Numero1");  
            }   
        }   
        else{
            if(Numero3 == Numero1){
                System.out.println("Numero3 diverso da Numero2 ma uguale a Numero1");
            }
            else{
                System.out.println("Numero3 diverso da Numero2 e diverso da Numero1");
            }
        }

        System.out.println("--------------------------------");
        
        //-------------------------------------------------------------------------------------------------------------//

        //DICHIARAZIONE E VALORIZZAZIONI
        Scanner Test = new Scanner(System.in);  //Scanner dove metto il numero 1, 2 o 3
        System.out.println("Inscrisci 1,2 o 3:");
         
        int Numero = Test.nextInt();

        if(Numero == 1){
            System.out.println("Sei dentro il numero 1");
        }   //fine IF della casistica 1
        else if(Numero == 2){
            System.out.println("Sei dentro il numero 2");
        }   //fine IF della casistica 2
        else{
            System.out.println("Sei dentro il numero 3");
        }   //fine IF della casistica 3

        System.out.println("--------------------------------");

        Scanner Stringa1 = new Scanner(System.in);  //Creo uno SCANNER dove mettero' le stringhe "NOME" e "COGNOME"
        System.out.println("Inscrisci il tuo NOME: ");
        String NOME = Stringa1.nextLine();  //l'utente inserisce il NOME

        System.out.println("Inscrisci il tuo COGNOME: ");
        String COGNOME = Stringa1.nextLine();   //l'utente inserisce il COGNOME

        Scanner Intero1 = new Scanner(System.in);   //Creo uno SCANNER dove mettero' l'int "ETA'"
        System.out.println("Inscrisci la tua ETA': ");
        int ETA = Intero1.nextInt();    //l'utente inserisce l'ETA'

        System.out.println("Questo e' il tuo profilo: " + NOME + " " + COGNOME + " " + ETA);

    }   //chiusura main
    
}   //chiusura classe
