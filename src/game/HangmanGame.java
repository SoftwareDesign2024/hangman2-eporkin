package game;

import util.ConsoleReader;
import util.DisplayWord;
import util.HangmanDictionary;


/**
 * This class represents the traditional word-guessing game Hangman
 * that plays interactively with the user.
 *
 * @author Robert C. Duvall
 * @author Shannon Duvall
 */
public class HangmanGame {
	private Guesser guesser;
    private Executioner executioner;
    private int numGuessesLeft;

    public HangmanGame(Guesser guesser, Executioner executioner, int numGuesses) {
        this.guesser = guesser;
        this.executioner = executioner;
        this.numGuessesLeft = numGuesses;
    }

    public void play() {
        boolean gameOver = false;

        while (!gameOver) {
            printStatus();

            char guess = guesser.makeGuess();
            boolean correct = executioner.processGuess(guess);

            if (!correct) {
                numGuessesLeft--;
            }

            if (executioner.isWordGuessed()) {
                System.out.println("YOU WIN!!!");
                gameOver = true;
            } else if (numGuessesLeft == 0) {
                System.out.println("YOU ARE HUNG!!!");
                gameOver = true;
            }
        }
        System.out.println("The secret word was: " + executioner.getSecretWord());
    }

    private void printStatus() {
        System.out.println(executioner.getDisplayWord());
        System.out.println("# misses left = " + numGuessesLeft);
        System.out.println("letters not yet guessed = " + guesser.getRemainingLetters());
        System.out.println();
    }
}
