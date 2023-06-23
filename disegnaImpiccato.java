public class disegnaImpiccato {
    public void disegnaImpiccato (int tentativiRimasti) {
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
}