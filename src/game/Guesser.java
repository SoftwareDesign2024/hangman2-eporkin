package game;

public abstract class Guesser {
    protected StringBuilder lettersLeftToGuess;

    public Guesser() {
        lettersLeftToGuess = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
    }

    // Method to generate a guess (to be implemented by subclasses)
    public abstract char makeGuess();

    protected void recordGuess(char guess) {
        lettersLeftToGuess.deleteCharAt(lettersLeftToGuess.indexOf("" + guess));
    }

    public String getRemainingLetters() {
        return lettersLeftToGuess.toString();
    }
}