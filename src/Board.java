class Board {
    private Cell[][] board;
    private int size = 3;

    public Board() {
        board = new Cell[size][size];
        initializeBoard();
    }

    public void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    public void displayBoard() {
        System.out.println("-------------");
        for (int i = 0; i < size; i++) {
            System.out.print("| ");
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j].getSymbol() + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    public boolean isCellEmpty(int row, int col) {
        return board[row][col].isEmpty();
    }

    public char getCell(int row, int col) {
        return board[row][col].getSymbol();
    }

    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void setCell(int row, int col, char symbol) {
        board[row][col].setSymbol(symbol);
    }

    public boolean checkHorizontal(char symbol) {
        for (int row = 0; row < size; row++) {
            if (checkRow(row, symbol)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkVertical(char symbol) {
        for (int col = 0; col < size; col++) {
            if (checkColumn(col, symbol)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDiagonal(char symbol) {
        return checkMainDiagonal(symbol) || checkAntiDiagonal(symbol);
    }

    private boolean checkRow(int row, char symbol) {
        for (int col = 0; col < size; col++) {
            if (getCell(row, col) != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean checkColumn(int col, char symbol) {
        for (int row = 0; row < size; row++) {
            if (getCell(row, col) != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean checkMainDiagonal(char symbol) {
        for (int i = 0; i < size; i++) {
            if (getCell(i, i) != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean checkAntiDiagonal(char symbol) {
        for (int i = 0; i < size; i++) {
            if (getCell(i, size - 1 - i) != symbol) {
                return false;
            }
        }
        return true;
    }
}
