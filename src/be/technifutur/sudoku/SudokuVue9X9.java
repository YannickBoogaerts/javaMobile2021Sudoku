package be.technifutur.sudoku;


public class SudokuVue9X9 extends AbstractSudokuVue implements SudokuVue {
    private static final String grille;

    static {
        grille = new StringBuilder()
                .append("+-------+-------+-------+\n")
                .append("| . . . | . . . | . . . |\n")
                .append("| . . . | . . . | . . . |\n")
                .append("+-------+-------+-------+\n")
                .append("| . . . | . . . | . . . |\n")
                .append("| . . . | . . . | . . . |\n")
                .append("+-------+-------+-------+\n")
                .append("| . . . | . . . | . . . |\n")
                .append("| . . . | . . . | . . . |\n")
                .append("+-------+-------+-------+\n")
                .toString()
                .replace(".", "%s");
    }


    private Sudoku9X9 sudo;

    public SudokuVue9X9(Sudoku9X9 sudoku9X9) {
        this.sudo = sudoku9X9;
    }

    @Override
    public Sudoku getSudoku() {
        return sudo;
    }

    public void setSudoku(Sudoku9X9 param) {
        this.sudo = param;
    }

    @Override
    protected String getGrille() {
        return grille;
    }

    @Override
    protected int getMaxColumn() {
        return 9;
    }

    @Override
    protected int getMaxLine() {
        return 9;
    }

    @Override
    protected int getCellNumber() {
        return 9*9;
    }

}
