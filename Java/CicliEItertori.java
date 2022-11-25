
class CicliEIteratori {
    public static void main(String[] args) {

        //DICHIARAZIONI E VALORIZZAZIONI DELLE VARIABILI
        boolean A = true;
        int Variabile = 0;

        //OPERAZIONI
        //  while(CONDIZIONE){BLOCCO DI CODICE} ---> Struttura del while
        //  do{BLOCCO DI CODICE} while(CONDIZIONE) ---> Struttura del do-while

        while(A == true){

            Variabile++;
            System.out.println(Variabile);

            if(A != false && Variabile == 5){
                A = false;
            }
        }

        int Variabile2 = 0;
        do{
            Variabile2++;
            System.out.println(Variabile2);
        } while (Variabile2 < 5);

    }
}