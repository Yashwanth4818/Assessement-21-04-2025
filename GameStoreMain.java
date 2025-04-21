package assessment;

import java.util.Scanner;

public class GameStoreMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GameStore game = new GameStore();

        while (true) {
            game.displayMenu();
            int choice = sc.nextInt();

            if (choice == 6) {
                game.exit();
                break;
            }

            if (choice < 1 || choice > 6) {
                System.out.println("Invalid input. Please try again.");
                continue;
            }

            game.choicePreffered(choice);
        }

        sc.close();
    }
}
