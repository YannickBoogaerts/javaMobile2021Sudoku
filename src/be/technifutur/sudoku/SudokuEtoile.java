package be.technifutur.sudoku;

import java.util.Arrays;

public class SudokuEtoile implements Sudoku {

    private char[][] data;

    public SudokuEtoile() {
        data = new char[21][21];
        for (int l = 0; l < 21; l++) {
            Arrays.fill(data[l], EMPTY);
        }
    }

    @Override
    public void addValue(int line, int column, char value) {
        if (isCellValid(line, column) && isValueValid(value)) {
            this.data[line][column] = value;
        }
    }

    @Override
    public char getValue(int line, int column) {
        char value = EMPTY;
        if (isCellValid(line, column)) {
            value = this.data[line][column];
        }
        return value;
    }

    @Override
    public boolean isValueValid(char value) {
        return value >= '1' && value <= '9' || value == EMPTY;
    }

    @Override
    public boolean isCellValid(int line, int column) {
        return in(line, column, 0, 0, 20, 20)
                && !in(line, column, 0, 9, 5, 11)
                && !in(line, column, 9, 0, 11, 5)
                && !in(line, column, 9, 15, 11, 20)
                && !in(line, column, 15, 9, 20, 11);
    }

    private static boolean in(int x, int y, int x1, int y1, int x2, int y2) {
        return x >= x1 && x <= x2 && y >= y1 && y <= y2;
    }
}
