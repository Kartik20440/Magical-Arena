// Creating a Player class that will store the details about the players in the game.
public class Player {
    static int ID = 1;
    private int pid;
    private int health;
    private int strength;
    private int attack;
    
    // Constructor that initializes the player with health, strength, and attack values.
    public Player(int health, int strength, int attack) {
        this.pid = Player.ID;
        Player.ID++;
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }

    // Getters for the player's ID
    public int getPid() {
        return pid;
    }

    // Method that rolls the dice and returns the attack value. 
    public int rollAttack() {
        int die = Dice.roll();
        System.out.println("Player " + this.pid + " rolled a " + die);
        return attack*die;
    }

    // Method that calculates the defense value and updates the health of the player.
    public void defend(int attackDamage){
        int die = Dice.roll();
        System.out.println("Player " + this.pid + " rolled a " + die);
        int defense = strength * die;
        int damageTaken = Math.max(0, attackDamage - defense);
        health -= damageTaken;
        System.out.print("Attack Value is: " + attackDamage);
        System.out.print("\tDefense Value is: " + defense);
        System.out.println("\tNew Health after attack is " + this.health);
    }

    // Method that checks if the player is alive.
    public boolean isAlive() {
        return health > 0;
    }

    // Getter for the player's health.
    public int getHealth() {
        return health;
    }

}
