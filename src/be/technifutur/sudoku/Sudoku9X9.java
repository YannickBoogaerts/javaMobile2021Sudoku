package be.technifutur.sudoku;

import java.util.Arrays;

public class Sudoku9X9 extends AbstractSudoku{
    private ValueSet[] ligne;
    private ValueSet[] carre;
    private ValueSet[] colonne;

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
    protected ValueSet[] getZones(int l, int c) {
        init();
        return new ValueSet[]{ligne[l], colonne[c], carre[l / 3 * 2 + c / 3]};
    }
    private void init() {
        if (ligne == null) {  // lazy création
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
}
