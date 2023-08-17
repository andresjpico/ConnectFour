public class Board {
  //Public
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

  //Private
    private void setRow(int row) {
        this.row = row;
    }

    private void setCol(int col) {
        this.col = col;
    }

    private int row;
    private int col;
}
