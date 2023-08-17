public class GameOrchestrator {
  //Public
    public GameOrchestrator() {
        player1 = new Player();
        player2 = new Player();
        board = new Board(6, 7);
    }

  //Private
    private Board board;
    private Player player1;
    private Player player2;
}
