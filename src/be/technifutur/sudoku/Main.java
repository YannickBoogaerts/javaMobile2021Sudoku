package be.technifutur.sudoku;

import be.technifutur.sudoku.*;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        SudokuControleur controleur = new SudokuControleur();
        SudokuVue vue = null;
        System.out.println("Sudoku");

        int choix = getChoix();

        switch (choix) {
            case 1:
                vue = new SudokuVue4X4(new Sudoku4X4());
            case 2:
                vue = new SudokuVue9X9(new Sudoku9X9());
            case 3:
                vue = new SudokuVueEtoile(new SudokuEtoile());
                break;

        }
        controleur.setModel(vue.getSudoku());
        controleur.setVue(vue);
        controleur.start();


    }

    private static int getChoix() {
        Scanner scan = new Scanner(System.in);
        String input;
        int choix = 0;
        do {
            System.out.println(" 1 Sudoku 4 X 4");
            System.out.println(" 2 Sudoku 9 X 9");
            System.out.println(" 3 Sudoku Etoile");
            System.out.print("choix : ");
            input = scan.nextLine();
            if (input.matches("[123]")) {
                choix = Character.getNumericValue(input.charAt(0));
            }
        } while (choix != 1 && choix != 2 && choix != 3);
        return choix;
    }

}
