package be.technifutur.sudoku;

public class SudokuVue4X4 extends AbstractSudokuVue implements SudokuVue {

    private static final String grille;

    static {
        grille = new StringBuilder()
                .append("+-----+-----+\n")
                .append("| . . | . . |\n")
                .append("| . . | . . |\n")
                .append("+-----+-----+\n")
                .append("| . . | . . |\n")
                .append("| . . | . . |\n")
                .append("+-----+-----+\n")
                .toString()
                .replace(".", "%s");
    }


    private Sudoku4X4 sudo;

    public SudokuVue4X4(Sudoku4X4 sudoku4X4) {
        this.sudo = sudoku4X4;
    }

    @Override
    public Sudoku getSudoku() {
        return sudo;
    }

    public void setSudoku(Sudoku4X4 param) {
        this.sudo = param;
    }

    @Override
    protected String getGrille() {
        return grille;
    }

    @Override
    protected int getMaxColumn() {
        return 4;
    }

    @Override
    protected int getMaxLine() {
        return 4;
    }

    @Override
    protected int getCellNumber() {
        return 16;
    }
}
