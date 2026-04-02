import java.util.*;

public class WordGuessGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] words = {"java", "program", "computer", "game", "keyboard"};
        Random rand = new Random();

        String word = words[rand.nextInt(words.length)];
        char[] guessed = new char[word.length()];
        Arrays.fill(guessed, '_');

        int attempts = 6;
        boolean won = false;

        System.out.println("🎮 Welcome to Word Guess Game!");

        while (attempts > 0) {
            System.out.print("Word: ");
            for (char c : guessed) {
                System.out.print(c + " ");
            }

            System.out.print("\nEnter a letter: ");
            char letter = sc.next().charAt(0);

            boolean found = false;

            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == letter) {
                    guessed[i] = letter;
                    found = true;
                }
            }

            if (!found) {
                attempts--;
                System.out.println("❌ Wrong guess! Attempts left: " + attempts);
            } else {
                System.out.println("✅ Correct!");
            }

            if (String.valueOf(guessed).equals(word)) {
                won = true;
                break;
            }
        }

        if (won) {
            System.out.println("🎉 You Won! Word was: " + word);
        } else {
            System.out.println("😢 You Lost! Word was: " + word);
        }

        sc.close();
    }
}