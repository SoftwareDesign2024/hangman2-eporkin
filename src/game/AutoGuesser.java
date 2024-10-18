package game;

import java.util.Random;

public class AutoGuesser extends Guesser {
    private Random random;

    public AutoGuesser() {
        this.random = new Random();
    }

    @Override
    public char makeGuess() {
        int index = random.nextInt(lettersLeftToGuess.length());
        char guess = lettersLeftToGuess.charAt(index);
        recordGuess(guess);
        System.out.println("AutoGuesser guessed: " + guess);
        return guess;
    }
}