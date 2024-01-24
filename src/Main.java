public class Main {
    public static void main(String[] args) {
        /*
            Requirements
            1. How many players? Two players red and yellow
            2. How many grids? c (columns) x r (rows)
            3. How many pieces do you need to win?
                Need to connect N (i.e. 4) pieces horizontally, vertically, or diagonally
            4. Target score can be provided and first client who reaches it wins the game
         */

        /*
            Classes

            // Keeps state about the game
            GameOrchestrator (Controller)
                - Keeps target score
                - Keeps player 1 and player 2
                - Keeps board
                - PlayRound()
                - StartGame()

            // Keeps basic information about player
            Player
                - Name
                - Color

            // Manages board and board-specific operations
            Board
                - Constructor takes board dimensions
                - CheckWin(int row, int col)
                - PlaceChip(int col)
                - Board is made of enum (red, yellow, null)
                - PrintBoard()
         */

        /*
            SOLID
            1. Single Responsibility
            2. Open-Closed
            3. Liskov
            4. Interface Segregation
            5. Dependency Inversion
         */
        GameOrchestrator connectN = new GameOrchestrator(6, 7, 3, 4);
        connectN.play();
    }
}