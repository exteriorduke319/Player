import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kanye = new Scanner(System.in);

        Player player1 = new Player();
        String playerNameInput;
        int playerXInput;
        int playerYInput;
        int playerZInput;
        int playerHpInput;
        int playerDirectionInput;

        // Player 2 setup
        playerNameInput = InputHelper.getNonZeroLenString(kanye, "Player 2, what is your name?");

        playerXInput = InputHelper.getInt(kanye, "What is your x-coordinate?");

        playerYInput = InputHelper.getInt(kanye, "What is your y-coordinate?");

        playerZInput = InputHelper.getInt(kanye, "What is your z-coordinate?");

        Player player2 = new Player(playerNameInput, playerXInput, playerYInput, playerZInput);

        // Player 3 setup
        playerNameInput = InputHelper.getNonZeroLenString(kanye, "Player 3, what is your name?");

        playerXInput = InputHelper.getInt(kanye, "What is your x-coordinate?");

        playerYInput = InputHelper.getInt(kanye, "What is your y-coordinate?");

        playerZInput = InputHelper.getInt(kanye, "What is your z-coordinate?");

        playerHpInput = InputHelper.getPositiveNonZeroInt(kanye, "What is your hp?");

        playerDirectionInput = InputHelper.getRangedInt(kanye, "What is your direction?  North = 1, South = 2, Up = 3, Down = 4, East = 5, West = 6", 1, 6);

        Player player3 = new Player(playerNameInput, playerXInput, playerYInput, playerZInput, playerHpInput, playerDirectionInput);


        // Gameplay

        System.out.println(player1.toString());
        System.out.println();

        System.out.println(player2.toString());
        System.out.println();

        System.out.println(player3.toString());
        System.out.println();

        // Move
        System.out.println(player3.getName() + " current Y: " + player3.getY());
        player3.move(3, 7);
        System.out.println(player3.getName() + " new Y: " + player3.getY());
        System.out.println();


        // Teleport
        player1.teleport(player2);
        System.out.println(player1.getName() + " teleports to " + player2.getName());
        System.out.println(player1.getName() + "Coordinates: X " + player1.getX() + " Y " + player1.getY() + " Z " + player1.getZ());
        System.out.println();

        // Attack
        player2.attack(player1, 10);
        System.out.println(player2.getName() + " attacks " + player1.getName() + "! 10 damage dealt, " + player1.getName() + "'s hp is now " + player1.getHp() + " and " + player2.getName() + "'s hp is now " + player2.getHp());
        System.out.println();

        // Get Distance
        System.out.println(player3.getName() + " is " + player3.getDistance(player2) + " units away from " + player2.getName());
        System.out.println(player3.getName() + " is " + player3.getDistance(player2.getX(), player2.getY(), player2.getZ()) + " units away from " + player2.getName());
    }
}