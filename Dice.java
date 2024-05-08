import java.util.Random;

// Creating a Dice class with a static method roll that returns a random number between 1 and 6.
public class Dice {
    private static Random random = new Random();

    // Method that returns a random number between 1 and 6.
    public static int roll() {
        return random.nextInt(6) + 1;
    }
}