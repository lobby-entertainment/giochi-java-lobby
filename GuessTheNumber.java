import java.util.Random;
import java.util.Scanner;
import java.util.*;
import java.util.*;

public class GuessTheNumber {
    private static final int MAX_NUMBER = 100;
    private static final List<String> WORDS_DICTIONARY = Arrays.asList(
            "cane", "scemo", "idiota", "incompetente", "stupido", "coglione", "hai la 104", "vergogna", "pirletta", "per dincibacco"
    );

    public static void gioca() {
        int guessLimit = 5;
        int randomNumber = generateRandomNumber();
        int limit = 21;
        List<String> guessedWords = new ArrayList<>();

        System.out.println("Benvenuto a 'Indovina il numero'!");
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Inserisci un numero minore di 20:");
            limit = scanner.nextInt();
        } while (limit > 20);

        guessLimit = limit;
        System.out.println("Ho generato un numero compreso tra 1 e 100. Hai " + guessLimit + " tentativi per indovinarlo.");

        for (int i = 0; i < guessLimit; i++) {
            System.out.print("Tentativo " + (i + 1) + ": ");
            int guess = scanner.nextInt();

            if (guess == randomNumber) {
                String randomWord = getRandomWord();
                guessedWords.add(randomWord);
                System.out.println("Congratulazioni! Hai indovinato il numero. Alla fine non sei " + randomWord);
                return;
            } else if (guess < randomNumber) {
                String randomWord = getRandomWord();
                guessedWords.add(randomWord);
                System.out.println(randomWord + " Il numero è troppo basso. Prova di nuovo.");
            } else {
                String randomWord = getRandomWord();
                guessedWords.add(randomWord);
                System.out.println("Troppo alto. Prova di nuovo. " + randomWord + " Hai sbagliato.");
            }

            int attemptsLeft = guessLimit - (i + 1);
            if (attemptsLeft > 0) {
                String randomWord = getRandomWord();
                guessedWords.add(randomWord);
                System.out.println("Hai ancora " + attemptsLeft + " tentativi. " + randomWord);
            }
        }

        String randomWord = getRandomWord();
        guessedWords.add(randomWord);
        System.out.println("Hai esaurito tutti i tentativi. Il numero era " + randomNumber + ". Hai perso! " + randomWord);
    }

    private static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_NUMBER) + 1;
    }

    public static String getRandomWord() {
        Random random = new Random();
        int index = random.nextInt(WORDS_DICTIONARY.size());
        return WORDS_DICTIONARY.get(index);
    }
}
