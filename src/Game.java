
public class Game {
    GameBoard board;
    int turn;
    AI AI;

    public Game() {
        board = new GameBoard();
        turn = 0;
        AI = new AI(board);
    }

    public GameEndTuple isGameFinished() {
        // Check for completed winning rows
        for(GameSquare[] row : board.rows) {
            if(row[0].equals(row[1]) && row[0].equals(row[2])) {
                if(row[0].value == GameSquare.Value.X) {
                   return new GameEndTuple(true, "X");
                }
                else if(row[0].value == GameSquare.Value.O){
                    return new GameEndTuple(true, "O");
                }
            }
        }
        // Check if board has no more blank squares
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.board[i][j].value == GameSquare.Value.BLANK) {
                return new GameEndTuple(false, "");
                }
            }
        }
        // If there are no blank squares and no winner it is a tie
        return new GameEndTuple(true, "Tie");
    }

    public boolean receiveInput(int row, int column, String OX) {
            if (row > 3 || row < 1 || column > 3 || column < 1) {
                return false;
            }
            else if (board.board[row - 1][column - 1].value != GameSquare.Value.BLANK) {
                return false;
            }
            else {
                board.board[row - 1][column - 1].setValue(OX);
                return true;
            }
    }
}
