import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        int scelta = 9;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("benvenuto nei giochi da terminale in java\n" +
                    "premi 1 per giocare a -indovina il numero-\n" +
                    "premi 2 per giocare -all'impiccato-");
            scelta = scanner.nextInt();
            switch (scelta) {

                case 1:
                    GuessTheNumber.gioca();
                    break;
                case 2:
                    Impiccato impiccato = new Impiccato(6);
                    impiccato.play();
                    break;
                case 3:
                    Impiccato impiccatto = new Impiccato(6);

            }
        }while (scelta!=9);
    }
    
}