public class GameSquare {
    public enum Value { X, O, BLANK}
    Value value;
    public GameSquare(String value) {
        setValue(value);
    }

    public void setValue(String value) {
        if (value.equals("X")) {
            this.value = Value.X;
        }
        else if (value.equals("O")) {
            this.value = Value.O;
        }
        else if (value.equals("Blank")) {
            this.value = Value.BLANK;
        }
    }

    @Override
    public String toString() {
        if(value == Value.X) {
            return "|X|";
        }
        else if (value == Value.O) {
            return "|O|";
        }
        else {
            return "| |";
        }
    }

    @Override
    public boolean equals(Object o) {
        if(this.value == ((GameSquare) o).value && this.value != Value.BLANK) {
            return true;
        }
        else {
            return false;
        }
    }
}
