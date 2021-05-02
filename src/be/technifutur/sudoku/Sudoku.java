package be.technifutur.sudoku;


public interface Sudoku {

    public static final char EMPTY =' ';

    void addValue(int line, int column, char value);

    char getValue(int line, int column);

    boolean isValueValid(char value);

    boolean isCellValid(int line, int column);

    void lock();
}
