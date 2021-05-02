package be.technifutur.sudoku;

import java.util.Arrays;

public class Sudoku4X4 extends AbstractSudoku {
    private ValueSet[] ligne;
    private ValueSet[] carre;
    private ValueSet[] colonne;

    public Sudoku4X4() {
        super(4, 4);
    }

    private void init() {
        if(ligne==null) {  // lazy création
            ligne = new ValueSet[4];
            carre = new ValueSet[4];
            colonne = new ValueSet[4];
            for (int i = 0; i < 4; i++) {
                ligne[i] = new ValueSet();
                colonne[i] = new ValueSet();
                carre[i] = new ValueSet();
            }
        }
    }

    @Override
    public boolean isValueValid(char value) {
        int numericValue = Character.getNumericValue(value);
        return numericValue >= 1 && numericValue <= 4 || value == EMPTY;
    }

    @Override
    public boolean isCellValid(int line, int column) {
        return line >= 0 && line < 4 && column >= 0 && column < 4;
    }

    @Override
    protected ValueSet getCarre(int l, int c) {
        init();
        return carre[l/2*2+c/2];
    }

    @Override
    protected ValueSet getColonne(int c) {
        init();
        return colonne[c];
    }

    @Override
    protected ValueSet getLine(int l) {
        init();
        return ligne[l];
    }

}
