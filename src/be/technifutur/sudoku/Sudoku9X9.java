package be.technifutur.sudoku;

import java.util.Arrays;

public class Sudoku9X9 extends AbstractSudoku{

    public Sudoku9X9(){
        super(9,9);
    }

    @Override
    public boolean isValueValid(char value) {
        return value >= '1' && value <= '9'|| value == EMPTY;
    }

    @Override
    public boolean isCellValid(int line, int column) {
        return line >= 0 && line < 9 && column >= 0 && column < 9;
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
