package be.technifutur.sudoku;

public class Sudoku4X4 implements Sudoku {

    private char[][] date;

    @Override
    public void addValue(int line, int column, char value) {
        if (isCellValid(line, column) && isValueValid(value)) {
            this.date[line][column] = value;
        }
    }

    @Override
    public char getValue(int line, int column) {
        char value = EMPTY;
        if (isCellValid(line, column)) {
            value = this.date[line][column];
        }
        return value;
    }

    @Override
    public boolean isValueValid(char value) {
        return value >= '1' && value <= '4';
    }

    @Override
    public boolean isCellValid(int line, int column) {
        return line >= 0 && line < 4 && column >= 0 && column < 4;
    }
}
