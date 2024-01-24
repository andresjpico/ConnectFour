import java.util.HashMap;
import java.util.Scanner;

enum GridColor {
    EMPTY,
    YELLOW,
    RED
}

public class GameOrchestrator {
  //Public
    public GameOrchestrator(int rows, int cols, int targetScore, int connectN) {
        redPlayer = new Player(GridColor.RED, "Red");
        yellowPlayer = new Player(GridColor.YELLOW, "Yellow");
        board = new Board(rows, cols);
        this.targetScore = targetScore;
        this.connectN = connectN;
        this.playerScoreMap = new HashMap<Player, Integer>();
        input = new Scanner(System.in);
    }

    public void play() {
        playerScoreMap.clear();
        playerScoreMap.put(redPlayer, 0);
        playerScoreMap.put(yellowPlayer, 0);

        for (int round = 1;
            playerScoreMap.get(redPlayer) != targetScore && playerScoreMap.get(yellowPlayer) != targetScore;
            round++) {
            board.initializeBoard();
            playRound();
            System.out.print(
                "\nRound " + round +
                "\nRed: " + playerScoreMap.get(redPlayer) +
                "\nYellow: " + playerScoreMap.get(yellowPlayer)
            );
        }
        System.out.print(
            "\n\nGame over!" +
            "\nRed: " + playerScoreMap.get(redPlayer) +
            "\nYellow: " + playerScoreMap.get(yellowPlayer) +
            "\n\n"
        );
    }

    //Private
    private void playRound() {
        boolean roundEnded = false;
        boolean redPlaying = true;
        while (!roundEnded) {
            Player player = (redPlaying) ? redPlayer : yellowPlayer;
            System.out.print(
                    "\n\n" + player.getName() +
                    "'s turn. Please select choose a column between 0 and " +
                    (board.getCols() - 1) + "\n"
            );
            int col = input.nextInt();
            int row = board.placeChip(col, player.getColor());
            board.printBoard();
            if (board.checkWin(row, col, connectN, player.getColor())) {
                playerScoreMap.put(player, playerScoreMap.get(player) + 1);
                roundEnded = true;
            }
            redPlaying = !redPlaying;
        }
    }

    private Board board;
    private Player redPlayer;
    private Player yellowPlayer;
    private int targetScore;
    private int connectN;
    private HashMap<Player, Integer> playerScoreMap;
    private Scanner input;
}
