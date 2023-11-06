import java.util.Scanner;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Player 1's name: ");
        String player1Name = scanner.nextLine();
        System.out.print("Enter Player 2's name: ");
        String player2Name = scanner.nextLine();

        Player player1 = new Player(player1Name, 'X');
        Player player2 = new Player(player2Name, 'O');
        Board board = new Board();

        Game game = new Game(player1, player2, board);

        System.out.println("Let's start the game!");
        game.play();
    }
}