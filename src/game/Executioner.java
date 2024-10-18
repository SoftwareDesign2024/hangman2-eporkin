package game;

import util.DisplayWord;

public abstract class Executioner {
    protected String secretWord;
    protected DisplayWord displayWord;

    public Executioner(String word) {
        this.secretWord = word.toLowerCase();
        this.displayWord = new DisplayWord(secretWord);
    }

    public abstract boolean processGuess(char guess);

    public boolean isWordGuessed() {
        return displayWord.equals(secretWord);
    }

    public String getDisplayWord() {
        return displayWord.toString();
    }

    public String getSecretWord() {
        return secretWord;
    }
}