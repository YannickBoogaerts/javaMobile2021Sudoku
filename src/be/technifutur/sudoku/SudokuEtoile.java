package be.technifutur.sudoku;

import java.util.Arrays;

public class SudokuEtoile extends AbstractSudoku {

    private ValueSet[][] valueSetCarre;
    private ValueSet[][] valueSetColonne;
    private ValueSet[][] valueSetLigne;
    private static int[] firstColonne = {0,12,6,0,12};
    private static int[] firstligne = {0,0,6,12,12};

    public SudokuEtoile() {
        super(21, 21);
    }

    @Override
    public boolean isValueValid(char value) {
        return value >= '1' && value <= '9' || value == EMPTY;
    }

    @Override
    public boolean isCellValid(int line, int column) {
        return isInSudokuNumber(line, column, 0)
                || isInSudokuNumber(line, column, 1)
                || isInSudokuNumber(line, column, 2)
                || isInSudokuNumber(line, column, 3)
                || isInSudokuNumber(line, column, 4);
    }

    @Override
    protected ValueSet[] getZones(int l, int c) {
        int[] number = getSudokuNumber(l,c);
        ValueSet[] result = new ValueSet[number.length == 1 ? 3 : 5];
        if (number.length > 0) {
            result[0] = getLigne(number[0], l);
            result[1] = getColonne(number[0], c);
            result[2] = getCarre(l, c);
        }
        if (number.length > 1) {
            result[3] = getLigne(number[1], l);
            result[4] = getColonne(number[1], c);
        }
        return result;
    }

    private ValueSet getCarre(int ligne, int colonne) {
        if (this.valueSetCarre == null) {
            this.valueSetCarre = new ValueSet[7][7];
            for (int l = 0; l < this.valueSetCarre.length; l++) {
                for (int c = 0; c < this.valueSetCarre[l].length; c++) {
                    this.valueSetCarre[l][c] = new ValueSet();
                }
            }
        }
        return this.valueSetCarre[ligne/3][colonne/3];
    }

    private ValueSet getColonne(int sudokuNumber, int colonne) {
        if (this.valueSetColonne == null) {
            this.valueSetColonne = new ValueSet[5][9];
            for (int l = 0; l < this.valueSetColonne.length; l++) {
                for (int c = 0; c < this.valueSetColonne[l].length; c++) {
                    this.valueSetColonne[l][c] = new ValueSet();
                }
            }

        }
        return this.valueSetColonne[sudokuNumber][colonne-firstColonne[sudokuNumber]];
    }

    private ValueSet getLigne(int sudokuNumber, int ligne) {
        try {
            if (this.valueSetLigne == null) {
                this.valueSetLigne = new ValueSet[5][9];
                for (int l = 0; l < this.valueSetLigne.length; l++) {
                    for (int c = 0; c < this.valueSetLigne[l].length; c++) {
                        this.valueSetLigne[l][c] = new ValueSet();
                    }
                }

            }
            return this.valueSetLigne[sudokuNumber][ligne - firstligne[sudokuNumber]];
        }catch (Exception e) {
            throw e;
        }
    }

    private static int[] getSudokuNumber(int l, int c) {
        int[] number = new int[0];
        if(isInSudokuNumber(l,c,2)){
            if(isInSudokuNumber(l,c,0)){
                number = new int[]{0,2};
            }else if(isInSudokuNumber(l,c,1)){
                number = new int[]{1,2};
            }else if(isInSudokuNumber(l,c,3)){
                number = new int[]{3,2};
            }else if(isInSudokuNumber(l,c,4)){
                number = new int[]{4,2};
            }else{
                number = new int[]{2};
            }
        }else if(isInSudokuNumber(l,c,0)){
            number = new int[]{0};
        }else if(isInSudokuNumber(l,c,1)){
            number = new int[]{1};
        }else if(isInSudokuNumber(l,c,3)){
            number = new int[]{3};
        }else if(isInSudokuNumber(l,c,4)){
            number = new int[]{4};
        }else{
            number = new int[]{};
        }
        return number;
    }

    private static  boolean isInSudokuNumber(int l, int c,int sudokuNumber){

        int x1 = firstligne[sudokuNumber];
        int x2 = firstligne[sudokuNumber]+8;
        int y1 = firstColonne[sudokuNumber];
        int y2 = firstColonne[sudokuNumber]+8;
        return l >= x1 && l <= x2 && c >= y1 && c <= y2;
    }

    public static void main(String[] args) {
        System.out.println(isInSudokuNumber(0,9,4));
        System.out.println(Arrays.toString(getSudokuNumber(0,9)));
    }
}
