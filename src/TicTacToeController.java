public class TicTacToeController {

    TicTacToeUI UI;

    public TicTacToeController(){
        UI = new TicTacToeUI(this);
    }

    public boolean isValidMove(int square, int player) {
        return false;
    }

    public boolean isGameFinished() {
        return false;
    }



    public static void main(String[] args) {
        TicTacToeController controller = new TicTacToeController();
    }
}
