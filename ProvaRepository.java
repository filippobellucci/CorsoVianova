
class ProvaRepository {
    public static void main(String[] args){

        //INIZIALIZZAZIONE VARIABILI
        char b;
        double N1;
        double N2;
        double N3;

        //VALORIZZAZIONE VARIABILI
        b = 'b';
        N3 = b;
        N1 = 123.34;
        N2 = 1;

        //NUOVE VARIABILI
        double Somma;
        double Risultato;
        boolean Bool1 = true;
        boolean Bool2 = false;
        boolean Evviva;

        //OPERAZIONI
        Somma = N1 + N2 + N3;
        Risultato = Somma / 3;
        Evviva = (Bool1 == !Bool2);

        //STAMPATORI
        System.out.println(N3);
        System.out.println(N1);
        System.out.println(N2);
        System.out.print(Risultato);
        System.out.println(" ---> Risultato Somma e Divisione per 3");
        System.out.print(Evviva);
        System.out.println(" ---> evviva!!");

    }
}
