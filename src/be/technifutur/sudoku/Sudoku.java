package be.technifutur.sudoku;


public interface Sudoku {

    char EMPTY =' ';

    void addValue(int line, int column, char value);

    void getValue(int line, int column);

    boolean isValueValid(char value);

    boolean isCellValid(int line, int column);
}
