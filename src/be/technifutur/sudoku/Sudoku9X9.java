package be.technifutur.sudoku;

import java.util.Arrays;

public class Sudoku9X9 implements Sudoku {

    private char[][] data;

    public Sudoku9X9(){
        data = new char[9][9];
        for(int l=0; l< 9; l++){
            Arrays.fill(data[l],EMPTY);
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
        return value >= '1' && value <= '9'|| value == EMPTY;
    }

    @Override
    public boolean isCellValid(int line, int column) {
        return line >= 0 && line < 9 && column >= 0 && column < 9;
    }
}
