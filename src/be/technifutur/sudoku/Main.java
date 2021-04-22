package be.technifutur.sudoku;

public class Main {

    public static void main(String[] args) {
        System.out.println("Sudoku");


        Sudoku4X4 model = new Sudoku4X4();
        SudokuVue4X4 vue = new SudokuVue4X4();
        SudokuControleur controleur = new SudokuControleur();

        vue.setSudoku(model);
        controleur.setModel(model);
        controleur.setVue(vue);

        controleur.start();




       // TestSudoku4x4();
        //TestSudokuEtoile();
    }

    private static void TestSudokuEtoile() {
        SudokuEtoile model = new SudokuEtoile();
        SudokuVueEtoile vue = new SudokuVueEtoile();
        vue.setSudoku(model);
        System.out.println(vue.toString());

        setValue(vue,0,0,'9');
        setValue(vue,0,9,'9');
        setValue(vue,0,11,'9');
        setValue(vue,5,9,'9');
        setValue(vue,5,11,'9');
        setValue(vue,9,0,'9');
        setValue(vue,11,0,'9');
        setValue(vue,9,5,'9');
        setValue(vue,11,5,'9');
        setValue(vue,20,20,'9');

    }

    private static void TestSudoku4x4() {
        Sudoku4X4 model = new Sudoku4X4();
        SudokuVue4X4 vue = new SudokuVue4X4();
        vue.setSudoku(model);
        setValue(vue,0,0,'2');
        setValue(vue,-1,0,'2');
        setValue(vue,4,0,'2');
        setValue(vue,3,0,'8');
        setValue(vue,3,0,'1');
        setValue(vue,20,20,'9');
    }

    private static void setValue(SudokuVue vue, int line, int column, char val) {
        Sudoku model = vue.getSudoku();
        model.addValue(line,column,val);
        System.out.print(vue.toString());
        if(! model.isCellValid(line,column)){
            System.out.printf( "position(%s,%s) hors sudoku%n",line,column);
           // System.out.print(String.format("position(%s,%s) hors sudoku%n",line,column));
        }else if(!model.isValueValid(val)){
            System.out.printf("valeur (%s) non valide%n",val);

        }else{
            //System.out.printf("ajout de la valeur %s à la position (%s,%s)%n",new Object[]{val,line,column});
            System.out.printf("ajout de la valeur %s à la position (%s,%s)%n",val,line,column);
        }
    }

}
