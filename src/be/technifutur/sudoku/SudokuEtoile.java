package be.technifutur.sudoku;

import java.util.Arrays;

public class SudokuEtoile extends AbstractSudoku{

    public SudokuEtoile() {
        super(21,21);
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

    @Override
    protected ValueSet getCarre(int l, int c) {
        return null;
    }

    @Override
    protected ValueSet getColonne(int c) {
        return null;
    }

    @Override
    protected ValueSet getLine(int l) {
        return null;
    }
}
