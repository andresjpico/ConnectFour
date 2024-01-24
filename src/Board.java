public class Board {
  //Public
    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        board = new int[rows][cols];
        initializeBoard();
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int[][] getBoard() {
        return board;
    }

    public void initializeBoard() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                board[row][col] = GridColor.EMPTY.ordinal();
            }
        }
    }

    public void printBoard() {
        System.out.print("\nBoard state:\n");
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    public int placeChip(int col, GridColor color) {
        if (!isColValid(col)) {
            return -1;
        }

        for (int r = rows - 1; r >= 0; r--) {
            if (board[r][col] == GridColor.EMPTY.ordinal()) {
                board[r][col] = color.ordinal();
                return r;
            }
        }
        return -1;
    }

    public boolean checkWin(int row, int col, int connectN, GridColor color) {
        // Check vertical
        int count = 0;
        for (int r = 0; r < rows; r++) {
            if (board[r][col] == color.ordinal()) {
                count++;
            } else {
                count = 0;
            }
            if (count == connectN) {
                return true;
            }
        }

        // Check horizontal
        count = 0;
        for (int c = 0; c < cols; c++) {
            if (board[row][c] == color.ordinal()) {
                count++;
            } else {
                count = 0;
            }
            if (count == connectN) {
                return true;
            }
        }

        // Check diagonal
        count = 0;
        for (int r = 0; r < rows; r++) {
            int c = row + col - r;
            if (isColValid(c) && board[r][c] == color.ordinal()) {
                count++;
            } else {
                count = 0;
            }
            if (count == connectN) {
                return true;
            }
        }

        // Check anti-diagonal
        count = 0;
        for (int r = 0; r < rows; r++) {
            int c = col - row + r;
            if (isColValid(c) && board[r][c] == color.ordinal()) {
                count++;
            } else {
                count = 0;
            }
            if (count == connectN) {
                return true;
            }
        }
        return false;
    }

  //Private
    private boolean isRowValid(int row) {
        return row >= 0 && row < rows;
    }

    private boolean isColValid(int col) {
        return col >= 0 && col < cols;
    }

    private int rows;
    private int cols;
    private int[][] board;
}
