package be.technifutur.sudoku;

import java.util.Arrays;

public abstract class AbstractSudoku implements Sudoku {

    private Cell[][] data;

    public AbstractSudoku(int nbLine, int nbColumn) {
        data = new Cell[nbLine][nbColumn];
        for (int l = 0; l < nbLine; l++) {
            for (int c = 0; c < nbColumn; c++) {
                data[l][c] = new Cell();
                data[l][c].setZones(getZones(l,c));
            }
        }

    }

    protected abstract ValueSet[] getZones(int l, int c);

    @Override
    public void addValue(int line, int column, char value) {
        if (this.isCellValid(line, column) && isValueValid(value)) {
            if(value == EMPTY){
                this.data[line][column].removeValue();
            }else {
                this.data[line][column].setValue(value);
            }
        }
    }

    @Override
    public char getValue(int line, int column) {
        char value = EMPTY;
        if (isCellValid(line, column)) {
            value = this.data[line][column].getValue();
        }
        return value;
    }

    @Override
    public void lock() {
        for (int l = 0; l < data.length; l++) {
            for (int c = 0; c < data[l].length; c++) {

                if (this.data[l][c].isEmpty()) {
                    data[l][c].setDisponible(false);
                }
            }
        }
    }
}
