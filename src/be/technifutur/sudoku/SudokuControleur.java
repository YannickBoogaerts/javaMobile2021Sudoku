package be.technifutur.sudoku;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SudokuControleur {

    private static final String PROMPT = "Ajouter une valeur (lig.col.val) q pour sortir: ";
    private static final String POSITION_ERROR = "Il n'y a pas de case à la position(%s,%s)";
    private static final String VALUE_ERROR = "la valeur (%s) n'est pas valide";
    private static final String INPUT_ERROR = "Le format de l'entrée n'est pas valide";
    private Sudoku model;
    private SudokuVue vue;
    private Pattern pattern = Pattern.compile("(?<lig>[1-9][0-9]*)\\.(?<col>[1-9][0-9]*)\\.(?<val>.)");
    private File file;

    public void setFile(File file) {
        this.file = file;
    }

    public void setModel(Sudoku model) {
        this.model = model;
    }

    public void setVue(SudokuVue vue) {
        this.vue = vue;
    }

    public void start() {
        Scanner scan = getScanner();
        String input;
        String erreur = null;

        input = getInput(scan, null);
        while (!"q".equalsIgnoreCase(input)){
            if ("j".equalsIgnoreCase(input)) {
              model.lock();
            }else {
                Matcher matcher = pattern.matcher(input);
                erreur = null;
                if (matcher.matches()) {
                    int lig = Integer.parseInt(matcher.group("lig")) - 1;
                    int col = Integer.parseInt(matcher.group("col")) - 1;
                    char val = matcher.group("val").charAt(0);
                    val = val== '0'? Sudoku.EMPTY: val;
                    if (!model.isCellValid(lig, col)) {
                        erreur = String.format(POSITION_ERROR, lig + 1, col + 1);
                    } else if (!model.isValueValid(val)) {
                        erreur = String.format(VALUE_ERROR, val);
                    } else {
                            model.addValue(lig, col, val);
                   }

                } else {
                    erreur = INPUT_ERROR;
                }
            }
            input = getInput(scan, erreur);
        }
    }

    private Scanner getScanner() {
        Scanner scanner = null;
        if(this.file !=null){
            try {
                scanner = new Scanner(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }else{
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

    private String getInput(Scanner scan, String error) {
        String input;
        System.out.println("SUDOKU");
        System.out.println(vue.toString());
        if(error!= null){
            System.out.println(error);
        }
        System.out.print(PROMPT);
        input = scan.nextLine();
        return input;
    }
}
