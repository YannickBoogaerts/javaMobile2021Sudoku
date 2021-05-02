package be.technifutur.sudoku;

public class Cell {

    private char value = Sudoku.EMPTY;
    private boolean disponible = true;
    private ValueSet ligne;  // ensemble des valeurs qui sont présentes actuellement sur la ligne de la cellule
    private ValueSet colonne;// ensemble des valeurs qui sont présentes actuellement sur la colonne de la cellule
    private ValueSet carre;  // ensemble des valeurs qui sont présentes actuellement dans le carré de la cellule

    public void setLigne(ValueSet ligne) {
        this.ligne = ligne;
    }

    public void setColonne(ValueSet colonne) {
        this.colonne = colonne;
    }

    public void setCarre(ValueSet carre) {
        this.carre = carre;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        if (disponible){
            // erreur cellule verouillée
        }else if(value == Sudoku.EMPTY) {
            this.removeValue();
        }else if(this.value != value) {
            int num = Character.getNumericValue(value);
            if (valueValid(num)) {
                if(! isEmpty()) {
                    removeZone(num);
                }
                addZone(num);
                this.value = value;
            }else{
                // erreur de doublon
            }
        }
    }

    private void addZone(int num) {
        ligne.add(num);
        colonne.add(num);
        carre.add(num);
    }

    private void removeZone(int num) {
        ligne.remove(num);
        colonne.remove(num);
        carre.remove(num);
    }

    private boolean valueValid(int num) {
        return !ligne.contains(num) &&
                !colonne.contains(num) &&
                !carre.contains(num);
    }

    public void removeValue() {
        if (disponible && ! isEmpty()) {
            removeZone(Character.getNumericValue(value));
            this.value = Sudoku.EMPTY;
        }
    }

    public boolean isEmpty() {
        return value == Sudoku.EMPTY;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
