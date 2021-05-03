package be.technifutur.sudoku;

public class Cell {

    private char value = Sudoku.EMPTY;
    private boolean disponible = true;
    private ValueSet[] zones; // ensemble des valeurs qui sont présentes actuellement dans une zone de la cellule

    public void setZones(ValueSet[] zones) {
        this.zones = zones;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        if (!disponible) {
            // erreur cellule verrouillée
        } else if (value == Sudoku.EMPTY) {
            this.removeValue();
        } else if (this.value != value) {
            int num = Character.getNumericValue(value);
            if (valueValid(num)) {
                if (!isEmpty()) {
                    this.removeValue();
                }
                addZone(num);
                this.value = value;
            } else {
                // erreur de doublon
                System.out.println("erreur de doublon");
            }
        }
    }

    private void addZone(int num) {
        for (ValueSet z : zones) {
            z.add(num);
        }
    }

    private boolean valueValid(int num) {
        boolean valid = true;
        int pos = 0;
        while (pos < zones.length && valid) {
            valid &= ! zones[pos].contains(num);
            pos++;
        }
        return valid;
    }

    public void removeValue() {
        if (disponible && !isEmpty()) {
            removeZone(Character.getNumericValue(value));
            this.value = Sudoku.EMPTY;
        }
    }

    private void removeZone(int num) {
        for (ValueSet z : zones) {
            z.remove(num);
        }
    }

    public boolean isEmpty() {
        return value == Sudoku.EMPTY;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
