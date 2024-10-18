package game;

import util.ConsoleReader;

public class UserGuesser extends Guesser {
    @Override
    public char makeGuess() {
        while (true) {
            String input = ConsoleReader.promptString("Make a guess: ");
            if (input.length() == 1 && Character.isAlphabetic(input.charAt(0))) {
                char guess = input.toLowerCase().charAt(0);
                if (lettersLeftToGuess.indexOf("" + guess) >= 0) {
                    recordGuess(guess);
                    return guess;
                } else {
                    System.out.println("You've already guessed that letter. Try again.");
                }
            } else {
                System.out.println("Please enter a single letter...");
            }
        }
    }
}