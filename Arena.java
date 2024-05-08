import java.util.Scanner;

// Creating an Arena class that will simulate the fight between two players.
public class Arena {
    private Player player1;
    private Player player2;
    
    // Constructor that initializes the two players.
    public Arena(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    // Method that simulates the fight between the two players.
    public void fight(){
        Player attacker = player1.getHealth() <= player2.getHealth() ? player1 : player2;
        Player defender = attacker == player1 ? player2 : player1;

        while (player1.isAlive() && player2.isAlive()) {
            System.out.print("Player " + attacker.getPid()+ "'s"+ " health is " + attacker.getHealth() + "\t");
            System.out.println("Player " + defender.getPid()+ "'s" + " health is " + defender.getHealth());
            System.out.println(" ");
            
            int attackDamage = attacker.rollAttack();
            defender.defend(attackDamage);

            // Swap roles
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }
        // Declare the winner
        Player winner = player1.isAlive() ? player1 : player2;
        System.out.println(" ");
        System.out.println("Winner is Player " + winner.getPid() + " with health: " + winner.getHealth());
    }

    // Method that takes the input from the user and creates a player object.
    private static Player getPlayerInput(Scanner sc, int playerNumber) {
        Player player = null;
        while (player == null) {
            try {
                System.out.print("Give the Health, Strength and Attack of Player " + playerNumber + " (space separated): ");
                int health = sc.nextInt();
                int strength = sc.nextInt();
                int attack = sc.nextInt();
                if (health <= 0 || strength <= 0 || attack <= 0) {
                    System.out.println("Invalid input. Please enter positive integers only.");
                    continue;
                }
                player = new Player(health, strength, attack);
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter integers only.");
                sc.nextLine(); // This clears the input buffer
            }
        }
        return player;
    }

    // Method defines the players and creates an Arena object.
    public static Arena menu() {
        Scanner sc = new Scanner(System.in);
        Player p1 = getPlayerInput(sc, 1);
        Player p2 = getPlayerInput(sc, 2);
        Arena arena = new Arena(p1, p2); 
        return arena;
    }

    // Main method that creates an Arena object and calls the fight method.
    public static void main(String[] args) {
        Arena playground = menu();
        playground.fight();
    }
}
