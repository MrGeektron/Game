public class GameEndTuple {
    private boolean end;
    private String winner;

    public GameEndTuple(boolean end, String winner) {
        this.end = end;
        this.winner = winner;
    }

    public boolean getEnd() {
        return end;
    }

    public String getWinner() {
        return winner;
    }
}
