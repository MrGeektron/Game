public class AI {
    GameBoard board;

    public AI(GameBoard board) {
        this.board = board;
    }

    public void AIMove() {
        boolean stop = checkWinMove();
        if(!stop) {
            stop = checkBlockMove();
        }
        if(!stop) {
            stop = checkAIFork();
        }
        if(!stop) {
            stop = checkPlayerFork();
        }
        if(!stop) {
            stop = checkCenter();
        }
        if(!stop) {
            stop = checkOppositeCorner();
        }
        if(!stop) {
            stop = checkCorner();
        }
        if(!stop) {
            checkSide();
        }
    }

    private boolean checkBlockWinMove(GameSquare.Value value, String newValue) {
        for(GameSquare[] row : board.rows) {
            if(row[0].value == value) {
                if(row[1].value == value) {
                    if(row[2].value == GameSquare.Value.BLANK) {
                        row[2].setValue(newValue);
                        return true;
                    }
                }
                else if(row[2].value == value) {
                    if(row[1].value == GameSquare.Value.BLANK) {
                        row[1].setValue(newValue);
                        return true;
                    }
                }
            }
            else if(row[1].value == value && row[2].value == value) {
                if(row[0].value == GameSquare.Value.BLANK) {
                    row[0].setValue(newValue);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkWinMove() {
        return checkBlockWinMove(GameSquare.Value.O, "O");
    }

    private boolean checkBlockMove() {
        return checkBlockWinMove(GameSquare.Value.X, "O");
    }

    private boolean checkFork(GameSquare.Value value, String newValue) {
        if(board.board[0][1] == board.board[1][2] && board.board[0][1].value == value && board.board[0][2].value == GameSquare.Value.BLANK) {
            board.board[0][2].setValue(newValue);
            return true;
        }
        if(board.board[0][1] == board.board[1][0] && board.board[0][1].value == value && board.board[0][0].value == GameSquare.Value.BLANK) {
            board.board[0][0].setValue(newValue);
            return true;
        }
        if(board.board[1][0] == board.board[2][1] && board.board[1][0].value == value && board.board[2][0].value == GameSquare.Value.BLANK) {
            board.board[2][0].setValue(newValue);
            return true;
        }
        if(board.board[2][1] == board.board[1][2] && board.board[2][1].value == value && board.board[2][2].value == GameSquare.Value.BLANK) {
            board.board[2][2].setValue(newValue);
            return true;
        }
        return false;
    }

    private boolean checkAIFork() {
        return checkFork(GameSquare.Value.O, "O");
    }

    private boolean checkPlayerFork() {
        return checkFork(GameSquare.Value.X, "X");
    }

    private boolean checkCenter() {
        if(board.board[1][1].value == GameSquare.Value.BLANK) {
            board.board[1][1].setValue("O");
            return true;
        }
        return false;
    }

    private boolean checkOppositeCorner() {
        if(board.board[0][0].value == GameSquare.Value.X && board.board[2][2].value == GameSquare.Value.BLANK) {
            board.board[2][2].setValue("O");
            return true;
        }
        if(board.board[2][2].value == GameSquare.Value.X && board.board[0][0].value == GameSquare.Value.BLANK) {
            board.board[0][0].setValue("O");
            return true;
        }
        if(board.board[0][2].value == GameSquare.Value.X && board.board[2][0].value == GameSquare.Value.BLANK) {
            board.board[2][0].setValue("O");
            return true;
        }
        if(board.board[2][0].value == GameSquare.Value.X && board.board[0][2].value == GameSquare.Value.BLANK) {
            board.board[0][2].setValue("O");
            return true;
        }
        return false;
    }

    private boolean checkCorner() {
        if(board.board[0][0].value == GameSquare.Value.BLANK) {
            board.board[0][0].setValue("O");
            return true;
        }
        if(board.board[2][0].value == GameSquare.Value.BLANK) {
            board.board[2][0].setValue("O");
            return true;
        }
        if(board.board[0][2].value == GameSquare.Value.BLANK) {
            board.board[0][2].setValue("O");
            return true;
        }
        if(board.board[2][2].value == GameSquare.Value.BLANK) {
            board.board[2][2].setValue("O");
            return true;
        }
        return false;
    }

    private void checkSide() {
        if(board.board[0][1].value == GameSquare.Value.BLANK) {
            board.board[0][1].setValue("O");
        }
        if(board.board[1][2].value == GameSquare.Value.BLANK) {
            board.board[1][2].setValue("O");
        }
        if(board.board[2][1].value == GameSquare.Value.BLANK) {
            board.board[2][1].setValue("O");
        }
        if(board.board[1][0].value == GameSquare.Value.BLANK) {
            board.board[1][0].setValue("O");
        }
    }
}
