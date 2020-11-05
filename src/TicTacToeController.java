public class TicTacToeController {

    TicTacToeUI UI;
    Game game;

    public TicTacToeController(){
        UI = new TicTacToeUI(this);
        game = new Game();
    }

    public boolean isValidMove(int square, int player) {
        int row = ((square - 1) / 3) + 1;
        int column = square % 3;
        if (column == 0) column = column + 3;
        if(player == 1) {
            return game.receiveInput(row, column, "X");
        }
        else {
            return game.receiveInput(row, column, "O");
        }
    }

    public GameEndTuple isGameFinished() {
        return game.isGameFinished();
    }



    public static void main(String[] args) {
        TicTacToeController controller = new TicTacToeController();
    }
}
