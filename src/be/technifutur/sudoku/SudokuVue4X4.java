package be.technifutur.sudoku;

public class SudokuVue4X4 implements SudokuVue {

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

    @Override
    public Sudoku getSudoku() {
        return sudo;
    }

    public void setSudoku(Sudoku4X4 param) {
        this.sudo = param;
    }

    public String toString() {
        Character[] tab = new Character[16];
        int pos = 0;
        for (int line = 0; line < 4; line++) {
            for (int column = 0; column < 4; column++) {
                char value = sudo.getValue(line, column);
                if (value == Sudoku.EMPTY) {
                    tab[pos] = '.';
                } else {
                    tab[pos] = value;
                }
                pos++;
            }
        }
        return String.format(grille, (Object[]) tab);
    }
}
