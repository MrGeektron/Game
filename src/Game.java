
public class Game {
    GameBoard board;
    int turn;
    AI AI;

    public Game() {
        board = new GameBoard();
        turn = 0;
        AI = new AI(board);
    }

    public boolean isGameFinished() {
        boolean finished = true;
        // Check if board has no more blank squares
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.board[i][j].value == GameSquare.Value.BLANK) {
                    finished = false;
                }
            }
        }
        if(finished) {
            System.out.println("Game Tied");
            return true;
        }
        // Check for completed winning rows
        for(GameSquare[] row : board.rows) {
            if(row[0].equals(row[1]) && row[0].equals(row[2])) {
                finished = true;
                if(row[0].value == GameSquare.Value.X) {
                    System.out.println("Player Wins");
                }
                else if(row[0].value == GameSquare.Value.O){
                    System.out.println("AI Wins");
                }
                break;
            }
        }
        return finished;
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

    public static void main (String[] args) {
        Game game = new Game();
        // While game not finished
        while(!game.isGameFinished()) {
            game.takeTurn();
        }
    }
}
