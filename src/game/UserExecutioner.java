package game;

public class UserExecutioner extends Executioner {
    public UserExecutioner(String word) {
        super(word);
    }

    @Override
    public boolean processGuess(char guess) {
        if (secretWord.indexOf(guess) >= 0) {
            displayWord.update(guess, secretWord);
            return true;
        }
        return false;
    }
}