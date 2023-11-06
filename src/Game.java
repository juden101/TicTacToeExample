import java.util.Scanner;
import java.util.Random;
class Game {
    private Player player1;
    private Player player2;
    private Board board;
    private Player currentPlayer;

    public Game(Player player1, Player player2, Board board) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = board; // Initialize the board
        determineStartingPlayer();
    }

    public void determineStartingPlayer() {
        Random random = new Random();
        int randomNumber = random.nextInt(2); // Generates a random number 0 or 1

        if (randomNumber == 0) {
            currentPlayer = player1;
        } else {
            currentPlayer = player2;
        }

        System.out.println(currentPlayer.getName() + " will start the game.");
    }

    public void play() {
        while (true) {
            board.displayBoard();
            int[] move = getPlayerMove();
            int row = move[0];
            int col = move[1];

            if (board.isCellEmpty(row, col)) {
                board.setCell(row, col, currentPlayer.getSymbol());
                if (checkWin(currentPlayer.getSymbol())) {
                    board.displayBoard();
                    System.out.println(currentPlayer.getName() + " wins!");
                    break;
                } else if (board.isFull()) {
                    board.displayBoard();
                    System.out.println("It's a draw!");
                    break;
                } else {
                    currentPlayer = (currentPlayer == player1) ? player2 : player1;
                }
            } else {
                System.out.println("That cell is already occupied. Try again.");
            }
        }
    }

    private int[] getPlayerMove() {
        Scanner scanner = new Scanner(System.in);
        int[] move = new int[2];
        System.out.print(currentPlayer.getName() + ", enter your move (row and column): ");
        move[0] = scanner.nextInt();
        move[1] = scanner.nextInt();
        return move;
    }

    public boolean checkWin(char symbol) {
        return board.checkHorizontal(symbol) ||
                board.checkVertical(symbol) ||
                board.checkDiagonal(symbol);
    }



    // ... (other methods as before)

}

