package game;

import util.DisplayWord;
import util.HangmanDictionary;

public class AutoExecutioner extends Executioner {
    private HangmanDictionary dictionary;

    public AutoExecutioner(HangmanDictionary dictionary, int wordLength) {
        super(dictionary.getRandomWord(wordLength));
        this.dictionary = dictionary;
    }

    @Override
    public boolean processGuess(char guess) {
        // Change the secret word if possible to avoid revealing any correct letters
        if (secretWord.indexOf(guess) >= 0) {
            // Generate a new word without the guessed letter
            String newWord = dictionary.getRandomWord(secretWord.length());
            while (newWord.contains("" + guess)) {
                newWord = dictionary.getRandomWord(secretWord.length());
            }
            secretWord = newWord.toLowerCase();
            displayWord = new DisplayWord(secretWord);  // Reset displayWord for new word
            return false;  // The guess is no longer correct
        }
        return false;
    }
}
