package be.technifutur.sudoku;

import java.util.Scanner;

public class SudokuControleur {

    private static final String PROMPT = "Ajouter une valeur (lig.col.val) q pour sortir: ";
    private Sudoku model;
    private SudokuVue vue;

    public void setModel(Sudoku model) {
        this.model = model;
    }

    public void setVue(SudokuVue vue) {
        this.vue = vue;
    }

    public void start() {
        Scanner scan = new Scanner(System.in);
        String input;

        input = getInput(scan);
        while (!"q".equalsIgnoreCase(input)){
            String[] split = input.split("\\.");
            model.addValue(Integer.parseInt(split[0])-1,Integer.parseInt(split[1])-1,split[2].charAt(0));
            input =getInput(scan);
        }
    }

    private String getInput(Scanner scan) {
        String input;
        System.out.println("SUDOKU");
        System.out.println(vue.toString());
        System.out.print(PROMPT);
        input = scan.nextLine();
        return input;
    }
}
