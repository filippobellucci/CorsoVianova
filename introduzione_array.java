
class introduzione_array {
    public static void main(String[] args) {

        String[] persone = {"Filippo", "Andrea", "Luca", "Anna"};   //costruzione array
        System.out.println(persone[0]);    //stampa il riferimento 0 dell'array

        persone[0] = "Gianni";  //modifico il contenuto del riferimento 0 dell'array
        System.out.println(persone[0]); //stampa il nuovo riferimento 0 dell'array
        
        System.out.println(persone.length); //stampa la lunghezza dell'array

    }
}