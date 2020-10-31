public class GameBoard {
    GameSquare[][] board;
    GameSquare[][] rows;

    public GameBoard() {
        board = new GameSquare[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board[i][j] = new GameSquare("Blank");
            }
        }
        rows = new GameSquare[8][3];
        rows[0] = new GameSquare[]{board[0][0], board[0][1], board[0][2]};
        rows[1] = new GameSquare[]{board[1][0], board[1][1], board[1][2]};
        rows[2] = new GameSquare[]{board[2][0], board[2][1], board[2][2]};
        rows[3] = new GameSquare[]{board[0][0], board[1][0], board[2][0]};
        rows[4] = new GameSquare[]{board[0][1], board[1][1], board[2][1]};
        rows[5] = new GameSquare[]{board[0][2], board[1][2], board[2][2]};
        rows[6] = new GameSquare[]{board[0][0], board[1][1], board[2][2]};
        rows[7] = new GameSquare[]{board[2][0], board[1][1], board[0][2]};
    }
    public String toString() {
        String board = "";
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
               board = board + this.board[i][j].toString();
            }
            board = board + "\n";
        }
        return board;
    }
}
