import java.util.Scanner;
import java.util.Random;

public class Main {

    public static final String SONNET =
            "Shall I compare thee to a summer's day?\n" +
            "Thou art more lovely and more temperate:\n" +
            "Rough winds do shake the darling buds of May,\n" +
            "And summer's lease hath all too short a date;\n" +
            "Sometime too hot the eye of heaven shines,\n" +
            "And often is his gold complexion dimm'd;\n" +
            "And every fair from fair sometime declines,\n" +
            "By chance or nature's changing course untrimm'd;\n" +
            "But thy eternal summer shall not fade,\n" +
            "Nor lose possession of that fair thou ow'st;\n" +
            "Nor shall death brag thou wander'st in his shade,\n" +
            "When in eternal lines to time thou grow'st:\n" +
            "   So long as men can breathe or eyes can see,\n" +
            "   So long lives this, and this gives life to thee.";

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        String[] words = SONNET.split(" ");
        int correct = 0;
        int incorrect = 0;

        System.out.println("Welcome to the Sonnet Word Guessing Game!");
        System.out.println("Win by getting 3 correct, or lose by getting 3 incorrect.\n");

        while (correct < 3 && incorrect < 3) {
            int randomIndex = rand.nextInt(words.length);
            String word = words[randomIndex];

            System.out.println(buildTruncatedSonnet(words, randomIndex));

            System.out.print("Guess the missing word: ");
            String guess = scanner.nextLine();

            if (isCorrectGuess(guess, word)) {
                correct++;
                System.out.println("\nCorrect! The word was: " + word + "\n");
            } else {
                incorrect++;
                System.out.println("\nIncorrect. The word was actually: " + word + "\n");
            }

            System.out.println("Score - Correct: " + correct + " | Incorrect: " + incorrect + "\n");
        }

        if (correct == 3) {
            System.out.println("Congratulations! You won the game!");
        } else {
            System.out.println("Game Over! Better luck next time.");
        }

        scanner.close();
    }

    public static boolean isCorrectGuess(String guess, String actualWord) {
        if (guess == null || actualWord == null) {
            return false;
        }
        return guess.trim().equalsIgnoreCase(actualWord.trim());
    }

    public static String buildTruncatedSonnet(String[] words, int stopIndex) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stopIndex; i++) {
            sb.append(words[i]).append(" ");
        }
        sb.append("_____\n");
        return sb.toString();
    }
}