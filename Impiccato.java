import java.util.Scanner;

public class Impiccato {
    private String[] parole = {
            "prateria", "pargolo", "partizione", "gelato", "troglodita",
            "dinamite", "nitroglicerina", "demone", "posacenere", "barbone",
            "pirateria", "programmazione", "computer", "aiuole", "parsimonia",
            "droga", "sardina", "brodaglia", "testimone", "aquilone", "peluria"
    };

    private String parolaDaIndovinare;
    private String input;
    private StringBuilder parolaIndovinata;

    public Impiccato(int tentativiRimasti) {
        this.tentativiRimasti = tentativiRimasti;
    }

    public int getTentativiRimasti() {
        return tentativiRimasti;
    }

    public void setTentativiRimasti(int tentativiRimasti) {
        this.tentativiRimasti = tentativiRimasti;
    }

    private int tentativiRimasti, modalitaGioco, difficolta;
    private boolean modalitaFacile, multiOppureNo;
    Scanner scanner = new Scanner(System.in);

    private void inizializzaGioco() {
        tentativiRimasti = 6;
        if (modalitaFacile) {
            parolaIndovinata = new StringBuilder(Character.toString(parolaDaIndovinare.charAt(0)));
            for (int i = 1; i < parolaDaIndovinare.length() - 1; i++) {
                parolaIndovinata.append("_");
            }
            parolaIndovinata.append(parolaDaIndovinare.charAt(parolaDaIndovinare.length() - 1));
        } else {
            parolaIndovinata = new StringBuilder("_".repeat(parolaDaIndovinare.length()));
        }
    }

    private String selezionaParolaCasuale() {
        int indice = (int) (Math.random() * parole.length);
        return parole[indice];
    }

    public void play() {
        System.out.println("Gioco dell'Impiccato");
        System.out.println("1. Giocatore singolo");
        System.out.println("2. Due Giocatori");
        System.out.print("Seleziona una modalità di gioco: ");
        modalitaGioco = scanner.nextInt();
        switch (modalitaGioco) {
            case 1 -> {
                System.out.println("Modalità giocatore singolo");
                parolaDaIndovinare = selezionaParolaCasuale();
                System.out.println("Seleziona la difficoltà:");
                System.out.println("1. Difficile (Indovina l'intera parola)");
                System.out.println("2. Facile (avrai iniziale e finale scoperte)");
                System.out.print("Inserisci il livello di difficoltà: ");
                difficolta = scanner.nextInt();
                modalitaFacile = (difficolta == 2);
                giocatoreSingolo(multiOppureNo);
            }
            case 2 -> {
                System.out.println("Modalità Multigiocatore");
                System.out.println("Seleziona la difficoltà:");
                System.out.println("1. Difficile (Indovina l'intera parola)");
                System.out.println("2. Facile (avrai iniziale e finale scoperte)");
                System.out.print("Inserisci il livello di difficoltà: ");
                difficolta = scanner.nextInt();
                modalitaFacile = (difficolta == 2);
                multiGiocatore(multiOppureNo);
            }
            default -> System.out.println("Modalità di gioco non valida!");
        }
    }

    public void giocatoreSingolo(boolean multiOppureNo) {
        this.multiOppureNo = multiOppureNo;
        inizializzaGioco();
        while (tentativiRimasti > 0 && parolaIndovinata.indexOf("_") != -1) {
            disegnaImpiccato();
            System.out.println("Parola da indovinare: " + parolaIndovinata);
            System.out.print("Inserisci una lettera o la parola completa: ");
            input = scanner.next();
            if (input.length() == 1) {
                char lettera = input.charAt(0);
                indovina(lettera);
            } else {
                if (input.equals(parolaDaIndovinare)) {
                    parolaIndovinata = new StringBuilder(parolaDaIndovinare);
                } else {
                    System.out.println("Parola non corretta!");
                    tentativiRimasti--;
                }
            }
        }
        fineGioco();
    }

    public void inserisciParola() {
        String parolina = scanner.next();
        parolaDaIndovinare = parolina.toLowerCase();
        parolaIndovinata = new StringBuilder("_".repeat(parolaDaIndovinare.length()));
    }

    public void multiGiocatore(boolean multiOppureNo) {
        this.multiOppureNo = multiOppureNo;
        System.out.println("Giocatore 1, inserisci la parola da indovinare.");
        inserisciParola();
        inizializzaGioco();
        while (tentativiRimasti > 0 && parolaIndovinata.indexOf("_") != -1) {
            disegnaImpiccato();
            System.out.println("Parola da indovinare: " + parolaIndovinata);
            System.out.print("Giocatore 2, inserisci una lettera o la parola completa: ");
            input = scanner.next();
            if (input.length() == 1) {
                char lettera = input.charAt(0);
                indovina(lettera);
            } else {
                if (input.equals(parolaDaIndovinare)) {
                    parolaIndovinata = new StringBuilder(parolaDaIndovinare);
                } else {
                    System.out.println("Parola non corretta!");
                    tentativiRimasti--;
                }
            }
        }
        fineGioco();
    }

    private void indovina(char lettera) {
        boolean indovinato = false;
        for (int i = 0; i < parolaDaIndovinare.length(); i++) {
            if (Character.toLowerCase(parolaDaIndovinare.charAt(i)) == Character.toLowerCase(lettera)) {
                parolaIndovinata.setCharAt(i, parolaDaIndovinare.charAt(i));
                indovinato = true;
            }
        }
        if (!indovinato) {
            tentativiRimasti--;
            disegnaImpiccato();
        }
    }
    public void disegnaImpiccato()  {

        System.out.println("Tentativi rimasti: " + tentativiRimasti);
        if (tentativiRimasti == 6) {
            System.out.println("  ______________");
            System.out.println(" ||            |");
            System.out.println(" ||");
            System.out.println(" ||");
            System.out.println(" ||");
            System.out.println(" ||");
            System.out.println("_||____________");
        } else if (tentativiRimasti == 5) {
            System.out.println(" ______________");
            System.out.println(" ||            |");
            System.out.println(" ||            O");
            System.out.println(" ||");
            System.out.println(" ||");
            System.out.println(" ||");
            System.out.println("_||____________");
        } else if (tentativiRimasti == 4) {
            System.out.println(" ______________");
            System.out.println(" ||            |");
            System.out.println(" ||            O");
            System.out.println(" ||            |");
            System.out.println(" ||");
            System.out.println(" ||");
            System.out.println("_||____________");
        } else if (tentativiRimasti == 3) {
            System.out.println(" _______________");
            System.out.println(" ||            |");
            System.out.println(" ||            O");
            System.out.println(" ||           /|");
            System.out.println(" ||");
            System.out.println(" ||");
            System.out.println("_||____________");
        } else if (tentativiRimasti == 2) {
            System.out.println("  ____________");
            System.out.println(" ||            |");
            System.out.println(" ||            O");
            System.out.println(" ||           /|\\");
            System.out.println(" ||");
            System.out.println(" ||");
            System.out.println("_||____________");
        } else if (tentativiRimasti == 1) {
            System.out.println("  ______________");
            System.out.println(" ||            |");
            System.out.println(" ||            O");
            System.out.println(" ||           /|\\");
            System.out.println(" ||           /");
            System.out.println(" ||");
            System.out.println("_||____________");
        } else {
            System.out.println("  ______________");
            System.out.println(" ||            |");
            System.out.println(" ||            O");
            System.out.println(" ||           /|\\");
            System.out.println(" ||           / \\");
            System.out.println(" ||");
            System.out.println("_||____________");
        }
    }
    private void fineGioco() {
        if (tentativiRimasti > 0) {
            System.out.println("Congratulazioni! Hai indovinato la parola: " + parolaIndovinata);
        } else {
            System.out.println("Fine del gioco! La parola era: " + parolaDaIndovinare);
        }
    }
}
