import util.HangmanDictionary;
import game.HangmanGame;
import game.Guesser;
import game.Executioner;
import game.UserGuesser;
import game.AutoGuesser;
import game.UserExecutioner;
import game.AutoExecutioner;

public class Main {
    public static void main(String[] args) {
        // Create a HangmanDictionary
        HangmanDictionary dictionary = new HangmanDictionary(null);

        // Example 1: UserGuesser + HonestExecutioner
        Guesser userGuesser = new UserGuesser();
        Executioner userExecutioner = new UserExecutioner(dictionary.getRandomWord(5));
        HangmanGame game1 = new HangmanGame(userGuesser, userExecutioner, 6);
        System.out.println("Starting User vs. Honest Executioner Game:");
        game1.play();

        // Example 2: AutoGuesser + CheatingExecutioner
        Guesser autoGuesser = new AutoGuesser();
        Executioner autoExecutioner = new AutoExecutioner(dictionary, 5);
        HangmanGame game2 = new HangmanGame(autoGuesser, autoExecutioner, 6);
        System.out.println("\nStarting AutoGuesser vs. Cheating Executioner Game:");
        game2.play();
    }
}
