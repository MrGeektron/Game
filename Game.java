import java.util.Scanner;

public class Game {
    GameBoard board;
    int turn;
    AI AI;
    String player1;
    String player2;

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

    public void takeTurn() {
        if(turn == 0) {
            receiveInput();
            System.out.println(board);
            turn = 1;
        } else {
            AI.AIMove();
            System.out.println(board);
            turn = 0;
        }
    }

    public void receiveInput() {
        Scanner keyboard = new Scanner(System.in);
        do {
            System.out.println("Please input coordinates for your move (row column) with space separating each.");
            System.out.println(board);
            int row = keyboard.nextInt();
            int column = keyboard.nextInt();
            if (row > 3 || row < 1 || column > 3 || column < 1) {
                System.out.println("Invalid input. Out of bounds. Please try again.");
            }
            else if (board.board[row - 1][column - 1].value != GameSquare.Value.BLANK) {
                System.out.println("Invalid input. Square already filled. Please try again.");
            }
            else {
                board.board[row - 1][column - 1].setValue("X");
                break;
            }
        } while(true);
    }

    public static void main (String[] args) {
        Game game = new Game();
        // While game not finished
        while(!game.isGameFinished()) {
            game.takeTurn();
        }
    }
}
