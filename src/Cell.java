class Cell {
    private char symbol;

    public Cell() {
        this.symbol = ' ';
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public boolean isEmpty() {
        return symbol == ' ';
    }
}
