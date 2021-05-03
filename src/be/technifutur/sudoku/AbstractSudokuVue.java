package be.technifutur.sudoku;

public abstract class AbstractSudokuVue implements SudokuVue {

    public abstract Sudoku getSudoku();

    public String toString() {
        Character[] tab = new Character[getCellNumber()];
                Sudoku sudo = getSudoku();
        int pos = 0;
        int maxLine = getMaxLine();
        int maxColumn = getMaxColumn();
        for (int line = 0; line < maxLine; line++) {
            for (int column = 0; column < maxColumn; column++) {
                if(sudo.isCellValid(line,column)) {
                    char value = sudo.getValue(line, column);
                    if (value == Sudoku.EMPTY) {
                        tab[pos] = '.';
                    } else {
                        tab[pos] = value;
                    }
                    pos++;
                }else{
                    //System.out.println("l:"+line+" c:"+column);
                }
            }
        }
        return String.format(getGrille(), (Object[]) tab);
    }

    protected abstract String getGrille();

    protected abstract int getMaxColumn();

    protected abstract int getMaxLine();

    protected abstract int getCellNumber();
}
